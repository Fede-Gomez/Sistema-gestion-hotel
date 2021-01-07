package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import personal.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

import conectarBBDD.Conectar;

public class AgregarEmpleado {

	private JFrame frmAgregarEmpleado;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField dni;
	private JTextField sueldo;
	private JTextField usuario;
	private JTextField contraseña;
	private Conectar conectar = new Conectar();
	private Empleado empleado;
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
		lblNewLabel_3.setBounds(112, 199, 46, 14);
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
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.main(null);
				frmAgregarEmpleado.dispose();
			}
		});
		btnNewButton_2.setBounds(356, 290, 113, 23);
		frmAgregarEmpleado.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(219, 158, 132, 96);
		frmAgregarEmpleado.getContentPane().add(scrollPane);
		
		JList list = new JList();
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
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre.setText("");
				apellido.setText("");
				dni.setText("");
				list.clearSelection();
				sueldo.setText("");
				usuario.setText("");
				contraseña.setText("");
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				while(nombre.getText().equals("")) {
					nombre.setText(JOptionPane.showInputDialog("Ingrese un nombre"));
				}
				while(apellido.getText().equals("")) {
					apellido.setText(JOptionPane.showInputDialog("Ingrese un apellido"));
				}
				while(dni.getText().equals("") && dni.getText().length() != 8) {
					dni.setText(JOptionPane.showInputDialog("Ingrese un DNI con 8 digitos"));
				}
				while(sueldo.getText().equals("")) {
					sueldo.setText(JOptionPane.showInputDialog("Ingrese un sueldo"));
				}
				while(usuario.getText().equals("")) {
					usuario.setText(JOptionPane.showInputDialog("Ingrese un usuario"));
				}
				while(contraseña.getText().equals("")) {
					contraseña.setText(JOptionPane.showInputDialog("Ingrese un contraseña"));
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
				empleado = new DirectorGeneral(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Director general", usuario.getText(), contraseña.getText());
				break;
			}
					
			case 1: {
					empleado = new Barman(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Barman", usuario.getText(), contraseña.getText()); 
					break;
			}
					
			case 2: {
					empleado = new Camarero(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Camarero", usuario.getText(), contraseña.getText()); 
					break;
			}
		
			case 3:{
					empleado = new Cocinero(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Cocinero", usuario.getText(), contraseña.getText()); 
					break;
			}
		
			case 4:{
					empleado = new AuxiliarCocina(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Auxiliar de cocina", usuario.getText(), contraseña.getText()); 
					break;
			}
			
			case 5:{
					empleado = new Conserje(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Conserje", usuario.getText(), contraseña.getText()); 
					break;
			}
			
			case 6:{
					empleado = new Mantenimiento(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Mantenimiento", usuario.getText(), contraseña.getText()); 
					break;
			}
			
			case 7:{
					empleado = new Recepcionista(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Recepcionista", usuario.getText(), contraseña.getText()); 
					break;
			}
			
			case 8:{
					empleado = new Seguridad(nombre.getText(),apellido.getText(),Integer.parseInt(dni.getText()),Double.parseDouble(sueldo.getText()), "Seguridad", usuario.getText(), contraseña.getText()); 
					break;
			}
			default:

		}
		
		conectar.agregarEmpleado(empleado);
	}
}


