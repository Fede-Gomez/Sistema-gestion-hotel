package interfazEmpleado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import personal.*;
import validaciones.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

import conectarBBDD.ConectarEmpleado;
import interfazMenu.InicioDirector;

public class AgregarEmpleado {

	private JFrame frmAgregarEmpleado;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField sueldo;
	private JTextField usuario;
	private JTextField contraseña;
	private ConectarEmpleado conectar = new ConectarEmpleado();
	private Empleado empleado;
	private JTextField legajo;
	private JList list = new JList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarEmpleado window = new AgregarEmpleado();
					window.frmAgregarEmpleado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarEmpleado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarEmpleado = new JFrame();
		frmAgregarEmpleado.setTitle("Agregar empleados");
		frmAgregarEmpleado.setResizable(false);
		frmAgregarEmpleado.setBounds(100, 100, 524, 380);
		frmAgregarEmpleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarEmpleado.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(32, 27, 46, 14);
		frmAgregarEmpleado.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(265, 27, 46, 14);
		frmAgregarEmpleado.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(32, 66, 46, 14);
		frmAgregarEmpleado.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setBounds(225, 220, 46, 14);
		frmAgregarEmpleado.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sueldo");
		lblNewLabel_4.setBounds(265, 66, 46, 14);
		frmAgregarEmpleado.getContentPane().add(lblNewLabel_4);
		
		nombre = new JTextField();
		nombre.setBounds(107, 24, 104, 20);
		frmAgregarEmpleado.getContentPane().add(nombre);
		nombre.setColumns(10);
		
		apellido = new JTextField();
		apellido.setBounds(333, 24, 104, 20);
		frmAgregarEmpleado.getContentPane().add(apellido);
		apellido.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(107, 63, 104, 20);
		frmAgregarEmpleado.getContentPane().add(dni);
		dni.setColumns(10);
		
		sueldo = new JTextField();
		sueldo.setBounds(333, 63, 104, 20);
		frmAgregarEmpleado.getContentPane().add(sueldo);
		sueldo.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(32, 290, 113, 23);
		frmAgregarEmpleado.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.setBounds(190, 290, 113, 23);
		frmAgregarEmpleado.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.setBounds(356, 290, 113, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioDirector.main(null);
				frmAgregarEmpleado.dispose();
			}
		});
		frmAgregarEmpleado.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(303, 165, 132, 96);
		frmAgregarEmpleado.getContentPane().add(scrollPane);
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Director general", "Barman", "Camarero", "Cocinero", "Auxiliar de cocina", "Conserje", "Mantenimiento", "Recepcionista", "Seguridad"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setBounds(32, 107, 46, 14);
		frmAgregarEmpleado.getContentPane().add(lblNewLabel_5);
		
		usuario = new JTextField();
		usuario.setBounds(107, 104, 104, 20);
		frmAgregarEmpleado.getContentPane().add(usuario);
		usuario.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Contrase\u00F1a");
		lblNewLabel_6.setBounds(265, 107, 66, 14);
		frmAgregarEmpleado.getContentPane().add(lblNewLabel_6);
		
		contraseña = new JTextField();
		contraseña.setBounds(333, 104, 104, 20);
		frmAgregarEmpleado.getContentPane().add(contraseña);
		contraseña.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Legajo");
		lblNewLabel_7.setBounds(32, 146, 46, 14);
		frmAgregarEmpleado.getContentPane().add(lblNewLabel_7);
		
		legajo = new JTextField();
		legajo.setBounds(107, 143, 104, 20);
		frmAgregarEmpleado.getContentPane().add(legajo);
		legajo.setColumns(10);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				while(nombre.getText().equals("") || !Validaciones.validarNombreYApellido(nombre.getText())) {
					nombre.setText(JOptionPane.showInputDialog("Ingrese un nombre"));
				}
				while(apellido.getText().equals("") || !Validaciones.validarNombreYApellido(nombre.getText())) {
					apellido.setText(JOptionPane.showInputDialog("Ingrese un apellido"));
				}
				while(dni.getText().equals("") || !Validaciones.valirdarDNI(dni.getText())) {
					dni.setText(JOptionPane.showInputDialog("Ingrese un DNI con 8 digitos"));
				}
				while(sueldo.getText().equals("") || !Validaciones.validarNumero(sueldo.getText())) {
					sueldo.setText(JOptionPane.showInputDialog("Ingrese un sueldo"));
				}
				while(usuario.getText().equals("")) {
					usuario.setText(JOptionPane.showInputDialog("Ingrese un usuario"));
				}
				while(contraseña.getText().equals("")) {
					contraseña.setText(JOptionPane.showInputDialog("Ingrese una contraseña"));
				}
				while(legajo.getText().equals("")) {
					legajo.setText(JOptionPane.showInputDialog("Ingrese numero de legajo"));
				}
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(frmAgregarEmpleado, "Ingrese un cargo");
				}
				if(!list.isSelectionEmpty())
					agregarEmpleadoBBDD(list.getSelectedIndex());
			}
		});
		

	}


	private void agregarEmpleadoBBDD(int cargo) {
		/*dependiendo de que cargo eligio, se creara determinada clase*/
		
		switch(cargo) {
				
			case 0: {
				empleado = new DirectorGeneral(Integer.parseInt(legajo.getText()),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "director general", usuario.getText(), contraseña.getText());
				break;
			}
					
			case 1: {
					empleado = new Barman(Integer.parseInt(legajo.getText()),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "barman", usuario.getText(), contraseña.getText());
					break;
			}
					
			case 2: {
					empleado = new Camarero(Integer.parseInt(legajo.getText()),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "camarero", usuario.getText(), contraseña.getText());
					break;
			}
		
			case 3:{
					empleado = new Cocinero(Integer.parseInt(legajo.getText()),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "cocinero", usuario.getText(), contraseña.getText());
					break;
			}
		
			case 4:{
					empleado = new AuxiliarCocina(Integer.parseInt(legajo.getText()),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "auxiliar cocina", usuario.getText(), contraseña.getText()); 
					break;
			}
			
			case 5:{
					empleado = new Conserje(Integer.parseInt(legajo.getText()),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "concerje", usuario.getText(), contraseña.getText());
					break;
			}
			
			case 6:{
					empleado = new Mantenimiento(Integer.parseInt(legajo.getText()),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "mantenimiento", usuario.getText(), contraseña.getText()); 
					break;
			}
			
			case 7:{
					empleado = new Recepcionista((Integer.parseInt(legajo.getText())),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "recepcionista", usuario.getText(), contraseña.getText()); 
					break;
			}
			
			case 8:{
					empleado = new Seguridad(Integer.parseInt(legajo.getText()),nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()) , "seguridad", usuario.getText(), contraseña.getText());
					break;
			}
			default:

		}
		
		conectar.agregarEmpleado(empleado);
	}
	
	
	public void limpiarCampos() {
		nombre.setText("");
		apellido.setText("");
		dni.setText("");
		list.clearSelection();
		sueldo.setText("");
		usuario.setText("");
		contraseña.setText("");
	}
	
}


