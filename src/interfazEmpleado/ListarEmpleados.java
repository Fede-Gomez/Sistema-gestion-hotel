package interfazEmpleado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.ConectarEmpleado;
import interfazMenu.InicioDirector;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListarEmpleados {

	private JFrame frmMostrarEmpleados;
	private JTable table;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField sueldo;
	private JTextField cargo;
	private JTextField usuario;
	private ConectarEmpleado conectar = new ConectarEmpleado();
	private JTextField legajo;
	private JTextField dni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarEmpleados window = new ListarEmpleados();
					window.frmMostrarEmpleados.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarEmpleados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMostrarEmpleados = new JFrame();
		frmMostrarEmpleados.setTitle("Mostrar empleados");
		frmMostrarEmpleados.setBounds(100, 100, 926, 395);
		frmMostrarEmpleados.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMostrarEmpleados.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(33, 109, 70, 14);
		frmMostrarEmpleados.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(33, 137, 46, 14);
		frmMostrarEmpleados.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sueldo");
		lblNewLabel_2.setBounds(33, 188, 46, 14);
		frmMostrarEmpleados.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setBounds(33, 219, 46, 14);
		frmMostrarEmpleados.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Usuario");
		lblNewLabel_4.setBounds(33, 250, 46, 14);
		frmMostrarEmpleados.getContentPane().add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 48, 656, 231);
		frmMostrarEmpleados.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Legajo", "Nombre", "Apellido", "DNI", "Cargo", "Sueldo", "Usuario"
			}
		));
		scrollPane.setViewportView(table);
		
		nombre = new JTextField();
		nombre.setBounds(113, 106, 86, 20);
		frmMostrarEmpleados.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(113, 134, 86, 20);
		frmMostrarEmpleados.getContentPane().add(apellido);
		apellido.setColumns(10);
		
		sueldo = new JTextField();
		sueldo.setBounds(113, 185, 86, 20);
		frmMostrarEmpleados.getContentPane().add(sueldo);
		sueldo.setColumns(10);
		
		cargo = new JTextField();
		cargo.setBounds(113, 216, 86, 20);
		frmMostrarEmpleados.getContentPane().add(cargo);
		cargo.setColumns(10);
		
		usuario = new JTextField();
		usuario.setBounds(113, 247, 86, 20);
		frmMostrarEmpleados.getContentPane().add(usuario);
		usuario.setColumns(10);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioDirector.main(null);
				frmMostrarEmpleados.dispose();
			}
		});
		btnNewButton.setBounds(701, 322, 89, 23);
		frmMostrarEmpleados.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mostrar empleado");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpiar la tabla para que este vacia				
				while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				
					buscarEmpleado();
			}
		});
		btnNewButton_1.setBounds(78, 322, 158, 23);
		frmMostrarEmpleados.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Mostrar todos los empleados");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				mostrarTodosEmpleados();
			}
		});
		btnNewButton_2.setBounds(335, 322, 220, 23);
		frmMostrarEmpleados.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("Legajo");
		lblNewLabel_5.setBounds(33, 81, 70, 14);
		frmMostrarEmpleados.getContentPane().add(lblNewLabel_5);
		
		legajo = new JTextField();
		legajo.setBounds(113, 78, 86, 20);
		frmMostrarEmpleados.getContentPane().add(legajo);
		legajo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Dni");
		lblNewLabel_6.setBounds(33, 162, 46, 14);
		frmMostrarEmpleados.getContentPane().add(lblNewLabel_6);
		
		dni = new JTextField();
		dni.setBounds(113, 159, 86, 20);
		frmMostrarEmpleados.getContentPane().add(dni);
		dni.setColumns(10);
	}
	
	public void mostrarTodosEmpleados() {
		
		ArrayList<String> empleados = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 
		int cont = 0;
		
		empleados = conectar.listarEmpleados();


/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
Cada vez que se agrege una nueva columna a la bbdd -> agregar una nueva linea:		columna[(sigiente num)] = empleados.get(cont++).toString();
* */					
		while( cont < empleados.size()) {

			columna[0] = empleados.get(cont++).toString();
			columna[1] = empleados.get(cont++).toString();
			columna[2] = empleados.get(cont++).toString();
			columna[3] = empleados.get(cont++).toString();
			columna[4] = empleados.get(cont++).toString();
			columna[5] = empleados.get(cont++).toString();
			columna[6] = empleados.get(cont++).toString();
			
			((DefaultTableModel) table.getModel()).addRow(columna);
			

		}
	
}
	
	public void buscarEmpleado() {
		
		
		ArrayList<String> empleado = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 
		
		
		
		empleado = conectar.mostrarEmpleado(legajo.getText(),nombre.getText(), apellido.getText(), dni.getText(), sueldo.getText(),cargo.getText(),usuario.getText());
		

/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
Cada vez que se agrege una nueva columna a la bbdd -> agregar una nueva linea:		columna[(sigiente num)] = empleados.get(cont++).toString();
* */					
		
		
		for(int cont = 0; cont < empleado.size(); cont++) {
			columna[cont] = empleado.get(cont).toString();
		}
		((DefaultTableModel) table.getModel()).addRow(columna);	

	}
	
}
