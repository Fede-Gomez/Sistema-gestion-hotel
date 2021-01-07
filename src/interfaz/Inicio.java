package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Inicio {

	private JFrame frmInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.setTitle("Inicio");
		frmInicio.setResizable(false);
		frmInicio.setBounds(100, 100, 914, 526);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(10, 11, 122, 465);
		panelBotones.setLayout(null);
		
		JButton habitacion = new JButton("Habitacion");
		habitacion.setBounds(10, 11, 103, 23);
		panelBotones.add(habitacion);
		
		JButton empleados = new JButton("Empleados");
		empleados.setBounds(10, 110, 103, 23);
		panelBotones.add(empleados);
		
		JButton cliente = new JButton("Cliente");
		cliente.setBounds(10, 211, 103, 23);
		panelBotones.add(cliente);
		
		JButton productos = new JButton("Productos");
		productos.setBounds(10, 313, 103, 23);
		panelBotones.add(productos);
		
		JButton cerrarSession = new JButton("Cerrar Session");
		cerrarSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frmInicio.dispose();
			}
		});
		cerrarSession.setBounds(10, 415, 103, 23);
		panelBotones.add(cerrarSession);		
		
		JPanel panelProducto = new JPanel();
		panelProducto.setBounds(132, 311, 756, 46);
		panelProducto.setBackground(Color.LIGHT_GRAY);
		panelProducto.setLayout(null);
		panelProducto.setVisible(false);
		
		JButton agregarProducto = new JButton("Agregar producto");
		agregarProducto.setBounds(23, 11, 155, 23);
		panelProducto.add(agregarProducto);
		
		JButton mostrarProducto = new JButton("Mostrar productos");
		mostrarProducto.setBounds(207, 11, 163, 23);
		panelProducto.add(mostrarProducto);
		
		JButton eliminarProducto = new JButton("Eliminar producto");
		eliminarProducto.setBounds(591, 11, 155, 23);
		panelProducto.add(eliminarProducto);
		
		JButton modificarProducto = new JButton("Modificar producto");
		modificarProducto.setBounds(401, 11, 163, 23);
		panelProducto.add(modificarProducto);
		
		JPanel panelEmpleados = new JPanel();
		panelEmpleados.setBounds(130, 113, 758, 46);
		panelEmpleados.setBackground(new Color(0, 204, 153));
		panelEmpleados.setLayout(null);
		panelEmpleados.setVisible(false);
		
		JButton agregarEmpleado = new JButton("Agregar empleado");
		agregarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarEmpleado.main(null);
				frmInicio.dispose();
			}
		});
		agregarEmpleado.setBounds(21, 11, 159, 23);
		panelEmpleados.add(agregarEmpleado);
		
		JButton mostrarEmpleado = new JButton("Mostrar empleados");
		mostrarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarEmpleados.main(null);
				frmInicio.dispose();
			}
		});
		mostrarEmpleado.setBounds(204, 11, 166, 23);
		panelEmpleados.add(mostrarEmpleado);
		
		JButton eliminarEmpleado = new JButton("Eliminar empleado");
		eliminarEmpleado.setBounds(589, 11, 159, 23);
		panelEmpleados.add(eliminarEmpleado);
		
		JButton modificarEmpleado = new JButton("Modificar empleado");
		modificarEmpleado.setBounds(399, 11, 166, 23);
		panelEmpleados.add(modificarEmpleado);
		
		JPanel panelHabitaciones = new JPanel();
		panelHabitaciones.setBounds(130, 11, 758, 46);
		panelHabitaciones.setBackground(new Color(153, 0, 102));
		panelHabitaciones.setVisible(false);
		
		JButton listarHabitacion = new JButton("Mostrar habitaciones");
		listarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarHabitaciones.main(null);
				frmInicio.dispose();
			}
		});
		listarHabitacion.setBounds(202, 11, 166, 23);
		
		
		JButton eliminarHabitacion = new JButton("Eliminar Habitacion");
		eliminarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EliminarHabitacion.main(null);
				frmInicio.dispose();
			}
		});
		eliminarHabitacion.setBounds(590, 11, 158, 23);
		panelHabitaciones.setLayout(null);
		panelHabitaciones.add(listarHabitacion);
		panelHabitaciones.add(eliminarHabitacion);
		
		JButton agregarHabitacion = new JButton("Agregar habitacion");
		agregarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHabitacion.main(null);
				frmInicio.dispose();
			}
		});
		agregarHabitacion.setBounds(21, 11, 158, 23);
		panelHabitaciones.add(agregarHabitacion);
		
		JButton modificarHabitacion = new JButton("Modificar habitacion");
		modificarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarHabitacion.main(null);
				frmInicio.dispose();
			}
		});
		modificarHabitacion.setBounds(398, 11, 166, 23);
		panelHabitaciones.add(modificarHabitacion);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBounds(130, 207, 758, 46);
		panelCliente.setBackground(Color.CYAN);
		panelCliente.setForeground(UIManager.getColor("Button.background"));
		panelCliente.setLayout(null);
		panelCliente.setVisible(false);
		
		JButton agregarCliente = new JButton("Agregar Cliente");
		agregarCliente.setBounds(23, 11, 158, 23);
		panelCliente.add(agregarCliente);
		
		JButton mostrarCliente = new JButton("Mostrar clientes");
		mostrarCliente.setBounds(203, 11, 167, 23);
		panelCliente.add(mostrarCliente);
		
		JButton eliminarCliente = new JButton("Eliminar cliente");
		eliminarCliente.setBounds(590, 11, 158, 23);
		panelCliente.add(eliminarCliente);
		
		JButton modificarCliente = new JButton("Modificar Cliente");
		modificarCliente.setBounds(400, 11, 167, 23);
		panelCliente.add(modificarCliente);
		frmInicio.getContentPane().setLayout(null);
		frmInicio.getContentPane().add(panelHabitaciones);
		frmInicio.getContentPane().add(panelEmpleados);
		frmInicio.getContentPane().add(panelCliente);
		frmInicio.getContentPane().add(panelProducto);
		frmInicio.getContentPane().add(panelBotones);
		
		empleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEmpleados.setVisible(true);	
				panelHabitaciones.setVisible(false);	
				panelCliente.setVisible(false);
				panelProducto.setVisible(false);
			}
		});
		
		habitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelHabitaciones.setVisible(true);	
				panelEmpleados.setVisible(false);	
				panelCliente.setVisible(false);
				panelProducto.setVisible(false);
			}
		});
		
		cliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEmpleados.setVisible(false);	
				panelHabitaciones.setVisible(false);	
				panelCliente.setVisible(true);
				panelProducto.setVisible(false);
			}
		});
		productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEmpleados.setVisible(false);	
				panelHabitaciones.setVisible(false);	
				panelCliente.setVisible(false);
				panelProducto.setVisible(true);
			}
		});
	}
}
