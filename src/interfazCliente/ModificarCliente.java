package interfazCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clientes.Cliente;
import conectarBBDD.ConectarCliente;
import interfazMenu.InicioDirector;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarCliente {

	private JFrame frmModificarCliente;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField celular;
	private JTextField email;
	private JTextField direccion;
	private JTable table;
	private JTextField nombreNuevo;
	private JTextField apellidoNuevo;
	private JTextField dniNuevo;
	private JTextField celularNuevo;
	private JTextField emailNuevo;
	private JTextField direccionNuevo;
	private ConectarCliente conectar = new ConectarCliente();
	private Cliente clienteModificar = new Cliente();
	private Cliente clienteSeleccionado = new Cliente();
	private JTextField id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCliente window = new ModificarCliente();
					window.frmModificarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificarCliente = new JFrame();
		frmModificarCliente.setTitle("Modificar cliente");
		frmModificarCliente.setBounds(100, 100, 1139, 440);
		frmModificarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificarCliente.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1123, 401);
		frmModificarCliente.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 74, 78, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(10, 99, 78, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(10, 124, 78, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Celular");
		lblNewLabel_3.setBounds(10, 149, 78, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(10, 174, 78, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion");
		lblNewLabel_5.setBounds(10, 199, 78, 14);
		panel.add(lblNewLabel_5);
		
		nombre = new JTextField();
		nombre.setBounds(98, 71, 117, 20);
		panel.add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(98, 96, 117, 20);
		panel.add(apellido);
		apellido.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(98, 121, 117, 20);
		panel.add(dni);
		dni.setColumns(10);
		
		celular = new JTextField();
		celular.setBounds(98, 146, 117, 20);
		panel.add(celular);
		celular.setColumns(10);
		
		email = new JTextField();
		email.setBounds(98, 171, 117, 20);
		panel.add(email);
		email.setColumns(10);
		
		direccion = new JTextField();
		direccion.setBounds(98, 196, 117, 20);
		panel.add(direccion);
		direccion.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(281, 44, 842, 147);
		panel.add(scrollPane);
		
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
				"Id", "Nombre", "Apellido", "Dni", "Celular", "Email", "Direccion"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton limpiarBusqueda = new JButton("Limpiar");
		limpiarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarBusqueda();
			}
		});
		limpiarBusqueda.setBounds(67, 229, 89, 23);
		panel.add(limpiarBusqueda);
		
		JButton buscarCliente = new JButton("Buscar cliente");
		buscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				buscarCliente();
			}
		});
		buscarCliente.setBounds(281, 199, 124, 23);
		panel.add(buscarCliente);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre");
		lblNewLabel_6.setBounds(126, 279, 89, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Apellido");
		lblNewLabel_7.setBounds(126, 304, 89, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("DNI");
		lblNewLabel_8.setBounds(126, 329, 89, 14);
		panel.add(lblNewLabel_8);
		
		nombreNuevo = new JTextField();
		nombreNuevo.setBounds(225, 276, 86, 20);
		panel.add(nombreNuevo);
		nombreNuevo.setColumns(10);
		
		apellidoNuevo = new JTextField();
		apellidoNuevo.setBounds(225, 301, 86, 20);
		panel.add(apellidoNuevo);
		apellidoNuevo.setColumns(10);
		
		dniNuevo = new JTextField();
		dniNuevo.setBounds(225, 326, 86, 20);
		panel.add(dniNuevo);
		dniNuevo.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Celular");
		lblNewLabel_9.setBounds(351, 279, 93, 14);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Email");
		lblNewLabel_10.setBounds(351, 304, 93, 14);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Direccion");
		lblNewLabel_11.setBounds(351, 329, 93, 14);
		panel.add(lblNewLabel_11);
		
		id = new JTextField();
		id.setBounds(98, 46, 117, 20);
		panel.add(id);
		id.setColumns(10);
		
		celularNuevo = new JTextField();
		celularNuevo.setBounds(454, 276, 86, 20);
		panel.add(celularNuevo);
		celularNuevo.setColumns(10);
		
		emailNuevo = new JTextField();
		emailNuevo.setBounds(454, 301, 86, 20);
		panel.add(emailNuevo);
		emailNuevo.setColumns(10);
		
		direccionNuevo = new JTextField();
		direccionNuevo.setBounds(454, 326, 86, 20);
		panel.add(direccionNuevo);
		direccionNuevo.setColumns(10);
		
		JButton confirmarCambios = new JButton("Confirmar cambios");
		confirmarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow() != -1) {
					modificarCliente();
				}
				else {
					JOptionPane.showMessageDialog(frmModificarCliente, "Seleccione un cliente");
				}
			}
		});
		confirmarCambios.setBounds(598, 300, 134, 23);
		panel.add(confirmarCambios);
		
		JButton limpiarCambios = new JButton("Limpiar cambios");
		limpiarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			limpiarCambios();
			}
		});
		limpiarCambios.setBounds(775, 300, 134, 23);
		panel.add(limpiarCambios);
		
		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioDirector.main(null);
				frmModificarCliente.dispose();
			}
		});
		volver.setBounds(1024, 367, 89, 23);
		panel.add(volver);
		
		JLabel lblNewLabel_12 = new JLabel("Id");
		lblNewLabel_12.setBounds(10, 51, 78, 14);
		panel.add(lblNewLabel_12);
		
		
	}

	public void limpiarBusqueda() {
		nombre.setText("");
		apellido.setText("");
		dni.setText("");
		celular.setText("");
		email.setText("");
		direccion.setText("");
	}
	public void limpiarCambios() {
		nombreNuevo.setText("");
		apellidoNuevo.setText("");
		dniNuevo.setText("");
		celularNuevo.setText("");
		emailNuevo.setText("");
		direccionNuevo.setText("");
		table.clearSelection();
	}
	
	public void buscarCliente() {
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
	
	public void modificarCliente() {
		
		conectar.modificarCliente(clienteModificar.getId(),nombreNuevo.getText(),apellidoNuevo.getText(), dniNuevo.getText(),celularNuevo.getText(),emailNuevo.getText(), direccionNuevo.getText());
				
	}
	
	public void seleccionarEmpleadoEnLaTabla() {
		try{
			int seleccion = table.getSelectedRow();
			clienteSeleccionado.setId(Integer.parseInt(table.getValueAt(seleccion, 0).toString()));
			clienteSeleccionado.setNombre(table.getValueAt(seleccion, 1).toString());
			clienteSeleccionado.setApellido(table.getValueAt(seleccion, 2).toString());
			clienteSeleccionado.setDni(Integer.parseInt(table.getValueAt(seleccion, 3).toString()));
			clienteSeleccionado.setCelular(Integer.parseInt(table.getValueAt(seleccion, 4).toString()));
			clienteSeleccionado.setEmail(table.getValueAt(seleccion, 5).toString());
			clienteSeleccionado.setDireccion(table.getValueAt(seleccion, 6).toString());
			
			clienteModificar = conectar.buscarCliente(clienteSeleccionado);

		}catch(Exception f) {
			f.printStackTrace();
		}

	}
	

}
