package interfazCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.ConectarCliente;
import interfaz.Inicio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ListarClientes {

	private JFrame frmMostrarClientes;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField celular;
	private JTextField email;
	private JTextField direccion;
	private JTable table;
	private ConectarCliente conectar = new ConectarCliente();
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarClientes window = new ListarClientes();
					window.frmMostrarClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMostrarClientes = new JFrame();
		frmMostrarClientes.setTitle("Mostrar clientes");
		frmMostrarClientes.setBounds(100, 100, 1164, 375);
		frmMostrarClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(52, 59, 71, 14);
		panel.add(lblNewLabel);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(52, 84, 71, 14);
		panel.add(lblApellido);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(52, 109, 71, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Celular");
		lblNewLabel_2.setBounds(52, 134, 71, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(52, 159, 71, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion");
		lblNewLabel_4.setBounds(52, 184, 71, 14);
		panel.add(lblNewLabel_4);
		
		nombre = new JTextField();
		nombre.setBounds(136, 56, 86, 20);
		panel.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(136, 81, 86, 20);
		panel.add(apellido);
		apellido.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(136, 106, 86, 20);
		panel.add(dni);
		dni.setColumns(10);
		
		celular = new JTextField();
		celular.setBounds(136, 131, 86, 20);
		panel.add(celular);
		celular.setColumns(10);
		
		email = new JTextField();
		email.setBounds(136, 156, 86, 20);
		panel.add(email);
		email.setColumns(10);
		
		direccion = new JTextField();
		direccion.setBounds(136, 181, 86, 20);
		panel.add(direccion);
		direccion.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(290, 25, 848, 228);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Apellido", "Dni", "Celular", "Email", "Direccion"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(225);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		JButton mostrar = new JButton("Mostrar cliente");
		mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//limpiar la tabla para que este vacia				
				while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				
				mostrarCliente();
			}
		});
		mostrar.setBounds(10, 261, 126, 23);
		panel.add(mostrar);
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		limpiar.setBounds(75, 209, 126, 23);
		panel.add(limpiar);
		
		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.main(null);
				frmMostrarClientes.dispose();
			}
		});
		volver.setBounds(730, 302, 89, 23);
		panel.add(volver);
		
		JButton btnNewButton = new JButton("Mostrar todos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				mostrarClientes();
			}
		});
		btnNewButton.setBounds(154, 261, 126, 23);
		panel.add(btnNewButton);
		GroupLayout groupLayout = new GroupLayout(frmMostrarClientes.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_5 = new JLabel("Id");
		lblNewLabel_5.setBounds(52, 34, 46, 14);
		panel.add(lblNewLabel_5);
		
		id = new JTextField();
		id.setBounds(136, 29, 86, 20);
		panel.add(id);
		id.setColumns(10);
		frmMostrarClientes.getContentPane().setLayout(groupLayout);
	}
	
	public void limpiarCampos() {
		id.setText("");
		nombre.setText("");
		apellido.setText("");
		dni.setText("");
		celular.setText("");
		email.setText("");
		direccion.setText("");
		table.clearSelection();
	}
	
	public void mostrarCliente() {
		
		ArrayList<String> cliente = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 

		int cont = 0;						//comienza en 1 porqe no debe mostrar el id del cliente
		
		
		
		cliente = conectar.mostrarCliente(id.getText(), nombre.getText(), apellido.getText(), dni.getText(), celular.getText(),email.getText(), direccion.getText());
		

/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
Cada vez que se agrege una nueva columna a la bbdd -> agregar una nueva linea:		columna[(sigiente num)] = empleados.get(cont++).toString();
* */					
		while( cont < cliente.size()) {

			columna[0] = cliente.get(cont++).toString();
			columna[1] = cliente.get(cont++).toString();
			columna[2] = cliente.get(cont++).toString();
			columna[3] = cliente.get(cont++).toString();
			columna[4] = cliente.get(cont++).toString();
			columna[5] = cliente.get(cont++).toString();
			columna[6] = cliente.get(cont++).toString();
			((DefaultTableModel) table.getModel()).addRow(columna);
			

		}
		
	}
	
	public void mostrarClientes() {
		ArrayList<String> cliente = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 
		int cont = 0;
		
		
		
		cliente = conectar.listarClientes(nombre.getText(), apellido.getText(), dni.getText(), celular.getText(),email.getText(), direccion.getText());
		

/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
Cada vez que se agrege una nueva columna a la bbdd -> agregar una nueva linea:		columna[(sigiente num)] = empleados.get(cont++).toString();
* */					
		while( cont < cliente.size()) {

			columna[0] = cliente.get(cont++).toString();
			columna[1] = cliente.get(cont++).toString();
			columna[2] = cliente.get(cont++).toString();
			columna[3] = cliente.get(cont++).toString();
			columna[4] = cliente.get(cont++).toString();
			columna[5] = cliente.get(cont++).toString();
			columna[6] = cliente.get(cont++).toString();
			((DefaultTableModel) table.getModel()).addRow(columna);
			

		}
	}
}
