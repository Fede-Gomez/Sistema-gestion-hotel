package interfazCliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import clientes.Cliente;
import conectarBBDD.ConectarCliente;
import interfaz.Inicio;
import validaciones.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCliente {

	private JFrame frmAgregarCliente;
	private JTextField dni;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField direccion;
	private JTextField email;
	private JTextField celular;
	private ConectarCliente conectar = new ConectarCliente();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCliente window = new AgregarCliente();
					window.frmAgregarCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarCliente = new JFrame();
		frmAgregarCliente.setTitle("Agregar cliente");
		frmAgregarCliente.setBounds(100, 100, 422, 496);
		frmAgregarCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarCliente.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dni");
		lblNewLabel.setBounds(79, 81, 81, 14);
		frmAgregarCliente.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(79, 122, 81, 14);
		frmAgregarCliente.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(79, 162, 81, 14);
		frmAgregarCliente.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Direccion");
		lblNewLabel_3.setBounds(79, 199, 81, 14);
		frmAgregarCliente.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(79, 238, 81, 14);
		frmAgregarCliente.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Celular");
		lblNewLabel_5.setBounds(79, 282, 81, 14);
		frmAgregarCliente.getContentPane().add(lblNewLabel_5);
		
		dni = new JTextField();
		dni.setBounds(201, 78, 113, 20);
		frmAgregarCliente.getContentPane().add(dni);
		dni.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(201, 119, 113, 20);
		frmAgregarCliente.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(201, 159, 113, 20);
		frmAgregarCliente.getContentPane().add(apellido);
		apellido.setColumns(10);
		
		direccion = new JTextField();
		direccion.setBounds(201, 196, 113, 20);
		frmAgregarCliente.getContentPane().add(direccion);
		direccion.setColumns(10);
		
		email = new JTextField();
		email.setBounds(201, 235, 113, 20);
		frmAgregarCliente.getContentPane().add(email);
		email.setColumns(10);
		
		celular = new JTextField();
		celular.setBounds(201, 279, 113, 20);
		frmAgregarCliente.getContentPane().add(celular);
		celular.setColumns(10);
		
		JButton agregar = new JButton("Agregar cliente");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				while(dni.getText().equals("") || !Validaciones.valirdarDNI(dni.getText())) {
					dni.setText(JOptionPane.showInputDialog("Ingrese un dni de 8 digitos"));
				}		
				
				while(nombre.getText().equals("") || !Validaciones.validarNombreYApellido(nombre.getText())) {
					nombre.setText(JOptionPane.showInputDialog("Ingrese un nombre"));
				}
	
				while(apellido.getText().equals("") || !Validaciones.validarNombreYApellido(apellido.getText())) {
					apellido.setText(JOptionPane.showInputDialog("Ingrese un apellido"));
				}
				while(direccion.getText().equals("") || !Validaciones.validarDireccion(direccion.getText())) {
					direccion.setText(JOptionPane.showInputDialog("Ingrese una direccion (sino tiene numero, poner un 0 )"));
				}

				while(email.getText().equals("") || !Validaciones.validarEmail(email.getText())) {
					email.setText(JOptionPane.showInputDialog("Ingrese un email valido  (ejemplo@ejemplo.com)"));
				}
				while(celular.getText().equals("") || !Validaciones.validarCelular(celular.getText())) {
					celular.setText(JOptionPane.showInputDialog("Ingrese un celular ( 11 + 8 digitos )"));
				}	
				agregarCliente();
				limpiarCampos();
			}
		});
		agregar.setBounds(52, 335, 133, 23);
		frmAgregarCliente.getContentPane().add(agregar);
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		limpiar.setBounds(227, 335, 133, 23);
		frmAgregarCliente.getContentPane().add(limpiar);
		
		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.main(null);
				frmAgregarCliente.dispose();
			}
		});
		volver.setBounds(165, 407, 89, 23);
		frmAgregarCliente.getContentPane().add(volver);
	}
	
	public void limpiarCampos() {
		nombre.setText("");
		apellido.setText("");
		dni.setText("");
		direccion.setText("");
		email.setText("");
		celular.setText("");
	}
	
	public void agregarCliente() {
		//int dni, int celular, String nombre, String apellido, String email, String direccion
		Cliente nuevoCliente = new Cliente( Integer.parseInt(dni.getText()), Integer.parseInt(celular.getText()), nombre.getText(), apellido.getText(), email.getText(), direccion.getText() );
		
		conectar.agregarCliente(nuevoCliente);
	}
}
