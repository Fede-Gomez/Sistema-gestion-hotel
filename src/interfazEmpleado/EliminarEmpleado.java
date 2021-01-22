package interfazEmpleado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.ConectarEmpleado;
import interfazMenu.InicioDirector;
import personal.Empleado;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EliminarEmpleado {

	private JFrame frmEliminarEmpleado;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField sueldo;
	private JTextField usuario;
	private ConectarEmpleado conectar = new ConectarEmpleado();
	private JTable table;
	private JList list = new JList();
	private JTextField legajo;
	private String empleadoSeleccionado ;
	private Empleado empleadoEliminar = new Empleado();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarEmpleado window = new EliminarEmpleado();
					window.frmEliminarEmpleado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EliminarEmpleado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEliminarEmpleado = new JFrame();
		frmEliminarEmpleado.setTitle("Eliminar empleado");
		frmEliminarEmpleado.setResizable(false);
		frmEliminarEmpleado.setBounds(100, 100, 900, 437);
		frmEliminarEmpleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliminarEmpleado.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 894, 398);
		frmEliminarEmpleado.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(47, 87, 75, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(47, 115, 75, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dni");
		lblNewLabel_2.setBounds(47, 140, 75, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setBounds(48, 250, 75, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sueldo");
		lblNewLabel_4.setBounds(47, 165, 75, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setBounds(47, 190, 75, 14);
		panel.add(lblNewLabel_5);
		
		nombre = new JTextField();
		nombre.setBounds(140, 84, 123, 20);
		panel.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(140, 112, 123, 20);
		panel.add(apellido);
		apellido.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(140, 137, 123, 20);
		panel.add(dni);
		dni.setColumns(10);
		
		sueldo = new JTextField();
		sueldo.setBounds(140, 162, 123, 20);
		panel.add(sueldo);
		sueldo.setColumns(10);
		
		usuario = new JTextField();
		usuario.setBounds(140, 187, 123, 20);
		panel.add(usuario);
		usuario.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(141, 218, 122, 80);
		panel.add(scrollPane);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(274, 48, 610, 250);
		panel.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionarEmpleadoEnLaTabla();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Legajo", "Nombre", "Apellido", "Dni", "Cargo", "Sueldo", "Usuario"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		scrollPane_1.setViewportView(table);
		
		JButton buscar = new JButton("Buscar empleado");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpiar la tabla para que este vacia				
				while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				buscarEmpleado();
			}
		});
		buscar.setBounds(457, 342, 137, 23);
		panel.add(buscar);
		
		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				InicioDirector.main(null);
				frmEliminarEmpleado.dispose();
			}
		});
		volver.setBounds(771, 375, 123, 23);
		panel.add(volver);
		
		JButton eliminar = new JButton("Eliminar empleado");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(table.getSelectedRow() != -1) {
					eliminarEmpleado();
				}
				else {
					JOptionPane.showMessageDialog(frmEliminarEmpleado, "Seleccione un empleado");
				}
			}
		});
		eliminar.setBounds(219, 342, 133, 23);
		panel.add(eliminar);
		
		JLabel lblNewLabel_6 = new JLabel("Legajo");
		lblNewLabel_6.setBounds(47, 55, 75, 14);
		panel.add(lblNewLabel_6);
		
		
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Director general", "Barman", "Camarero", "Cocinero", "Auxiliar de cocina", "Conserje", "Mantenimiento", "Recepcionista", "Seguridad"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		legajo = new JTextField();
		legajo.setBounds(140, 53, 123, 20);
		panel.add(legajo);
		legajo.setColumns(10);
	}
	
	
	public void buscarEmpleado() {
		
		
		ArrayList<String> empleado = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 
		
		
		String cargo;
		switch(list.getSelectedIndex()) {
		
		case 0: cargo = "director general"; break;
		case 1: cargo = "barman"; break;
		case 2: cargo = "cocinero"; break;
		case 3: cargo = "auxiliar cocina"; break;
		case 4: cargo = "conserje"; break;
		case 5: cargo = "mantenimiento"; break;
		case 6: cargo = "recepcionista"; break;
		case 7: cargo = "seguridad"; break;
		default: cargo = ""; break;
		}
		
		empleado = conectar.mostrarEmpleado(legajo.getText(),nombre.getText(), apellido.getText(), dni.getText(), sueldo.getText(),cargo,usuario.getText());
		

/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
Cada vez que se agrege una nueva columna a la bbdd -> agregar una nueva linea:		columna[(sigiente num)] = empleados.get(cont++).toString();
* */					
		
		
		for(int cont = 0; cont < empleado.size(); cont++) {
			columna[cont] = empleado.get(cont).toString();
		}
		((DefaultTableModel) table.getModel()).addRow(columna);	
	}
	
	public void eliminarEmpleado() {
			
		int decision = JOptionPane.showConfirmDialog(frmEliminarEmpleado, "Esta seguro que es este?");
		if(decision == 0) {
			conectar.eliminarEmpleado(empleadoSeleccionado);					
			((DefaultTableModel) table.getModel()).removeRow(0);
			limpiarCampos();
		}
		
	}
	
	public void seleccionarEmpleadoEnLaTabla() {
		try{
			int seleccion = table.getSelectedRow();
			empleadoSeleccionado = table.getValueAt(seleccion, 0).toString();
		}catch(Exception f) {
			f.printStackTrace();
		}

	}
	
	public void limpiarCampos() {
		nombre.setText("");
		apellido.setText("");
		dni.setText("");
		sueldo.setText("");
		usuario.setText("");
		legajo.setText("");
		table.clearSelection();
		list.clearSelection();
	}
}
