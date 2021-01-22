package interfazCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clientes.Cliente;
import conectarBBDD.ConectarCliente;
import interfazMenu.InicioDirector;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EliminarCliente {

	private JFrame frmEliminarCliente;
	private JTable table;
	private JTextField id;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField celular;
	private JTextField email;
	private JTextField direccion;
	private ConectarCliente conectar = new ConectarCliente();
	private Cliente clienteEliminar = new Cliente();
	private Cliente clienteSeleccionado = new Cliente();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarCliente window = new EliminarCliente();
					window.frmEliminarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EliminarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEliminarCliente = new JFrame();
		frmEliminarCliente.setTitle("Eliminar cliente");
		frmEliminarCliente.setBounds(100, 100, 588, 488);
		frmEliminarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmEliminarCliente.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(48, 14, 86, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(48, 39, 86, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(48, 64, 86, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dni");
		lblNewLabel_3.setBounds(48, 89, 86, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Celular");
		lblNewLabel_4.setBounds(48, 116, 86, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(48, 141, 86, 14);
		panel.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 552, 208);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					int seleccion = table.getSelectedRow();
					clienteSeleccionado.setId(Integer.parseInt(table.getValueAt(seleccion, 0).toString()));
					clienteSeleccionado.setNombre(table.getValueAt(seleccion, 1).toString());
					clienteSeleccionado.setApellido(table.getValueAt(seleccion, 2).toString());
					clienteSeleccionado.setDni(Integer.parseInt(table.getValueAt(seleccion, 3).toString()));
					clienteSeleccionado.setCelular(Integer.parseInt(table.getValueAt(seleccion, 4).toString()));
					clienteSeleccionado.setEmail(table.getValueAt(seleccion, 5).toString());
					clienteSeleccionado.setDireccion(table.getValueAt(seleccion, 6).toString());
					
					clienteEliminar = conectar.buscarCliente(clienteSeleccionado);

				}catch(Exception f) {
					f.printStackTrace();
				}
			
			
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Apellido", "Dni", "Celular", "Email", "Direccion"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setPreferredWidth(132);
		table.getColumnModel().getColumn(5).setPreferredWidth(220);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		id = new JTextField();
		id.setBounds(144, 11, 135, 20);
		panel.add(id);
		id.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(144, 36, 135, 20);
		panel.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(144, 61, 135, 20);
		panel.add(apellido);
		apellido.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(144, 86, 135, 20);
		panel.add(dni);
		dni.setColumns(10);
		
		celular = new JTextField();
		celular.setBounds(144, 113, 135, 20);
		panel.add(celular);
		celular.setColumns(10);
		
		email = new JTextField();
		email.setBounds(144, 138, 135, 20);
		panel.add(email);
		email.setColumns(10);
		
		JButton btnNewButton = new JButton("Eliminar cliente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectedRow() != -1) {
					eliminarCliente();
				}
				else {
					JOptionPane.showMessageDialog(frmEliminarCliente, "Seleccione un cliente");
				}
			}
		});
		btnNewButton.setBounds(390, 54, 139, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar campos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNewButton_1.setBounds(390, 104, 139, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioDirector.main(null);
				frmEliminarCliente.dispose();
			}
		});
		btnNewButton_2.setBounds(390, 156, 139, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("Direccion");
		lblNewLabel_6.setBounds(48, 166, 46, 14);
		panel.add(lblNewLabel_6);
		
		direccion = new JTextField();
		direccion.setBounds(144, 163, 135, 20);
		panel.add(direccion);
		direccion.setColumns(10);
		
		JButton buscar = new JButton("Buscar cliente");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				
				mostrarCliente();
			}
		});
		buscar.setBounds(91, 196, 148, 23);
		panel.add(buscar);
		frmEliminarCliente.getContentPane().setLayout(groupLayout);
	}
	
	public void limpiarCampos() {
		nombre.setText("");
		id.setText("");
		apellido.setText("");
		email.setText("");
		direccion.setText("");
		celular.setText("");
		table.clearSelection();
	}
	
	public void mostrarCliente() {
		ArrayList<String> cliente = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 

		
		
		
		
		cliente = conectar.mostrarCliente(id.getText(), nombre.getText(), apellido.getText(), dni.getText(), celular.getText(),email.getText(), direccion.getText());
		

/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
Cada vez que se agrege una nueva columna a la bbdd -> agregar una nueva linea:		columna[(sigiente num)] = empleados.get(cont++).toString();
* */					
		
		for(int cont = 0; cont < cliente.size(); cont++) {
			columna[cont] = cliente.get(cont).toString();
		}
		((DefaultTableModel) table.getModel()).addRow(columna);			
	}
	
	public void eliminarCliente() {
		
		conectar.eliminarCliente(clienteEliminar);
		table.clearSelection();
	}
	
}
