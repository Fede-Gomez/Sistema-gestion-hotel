package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;

public class Inicio {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(10, 11, 122, 465);
		frame.getContentPane().add(panelBotones);
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
				frame.dispose();
			}
		});
		cerrarSession.setBounds(10, 415, 103, 23);
		panelBotones.add(cerrarSession);		
		
		JPanel panelProducto = new JPanel();
		panelProducto.setBounds(132, 311, 632, 46);
		frame.getContentPane().add(panelProducto);
		panelProducto.setLayout(null);
		panelProducto.setVisible(false);
		
		JButton agregarProducto = new JButton("Agregar producto");
		agregarProducto.setBounds(10, 11, 117, 23);
		panelProducto.add(agregarProducto);
		
		JButton mostrarProducto = new JButton("Mostrar productos");
		mostrarProducto.setBounds(171, 11, 121, 23);
		panelProducto.add(mostrarProducto);
		
		JButton eliminarProducto = new JButton("Eliminar producto");
		eliminarProducto.setBounds(501, 11, 131, 23);
		panelProducto.add(eliminarProducto);
		
		JButton modificarProducto = new JButton("Modificar producto");
		modificarProducto.setBounds(329, 11, 133, 23);
		panelProducto.add(modificarProducto);
		
		JPanel panelEmpleados = new JPanel();
		panelEmpleados.setBounds(130, 113, 634, 46);
		frame.getContentPane().add(panelEmpleados);
		panelEmpleados.setBackground(new Color(0, 204, 153));
		panelEmpleados.setLayout(null);
		panelEmpleados.setVisible(false);
		
		JButton agregarEmpleado = new JButton("Agregar empleado");
		agregarEmpleado.setBounds(10, 11, 121, 23);
		panelEmpleados.add(agregarEmpleado);
		
		JButton mostrarEmpleado = new JButton("Mostrar empleados");
		mostrarEmpleado.setBounds(172, 11, 123, 23);
		panelEmpleados.add(mostrarEmpleado);
		
		JButton eliminarEmpleado = new JButton("Eliminar empleado");
		eliminarEmpleado.setBounds(511, 11, 123, 23);
		panelEmpleados.add(eliminarEmpleado);
		
		JButton modificarEmpleado = new JButton("Modificar empleado");
		modificarEmpleado.setBounds(334, 11, 133, 23);
		panelEmpleados.add(modificarEmpleado);
		
		JPanel panelHabitaciones = new JPanel();
		panelHabitaciones.setBounds(130, 11, 634, 46);
		frame.getContentPane().add(panelHabitaciones);
		panelHabitaciones.setBackground(new Color(153, 0, 102));
		panelHabitaciones.setVisible(false);
		
		JButton listarHabitacion = new JButton("Mostrar habitaciones");
		listarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarHabitaciones.main(null);
				frame.dispose();
			}
		});
		listarHabitacion.setBounds(173, 11, 133, 23);
		
		
		JButton eliminarHabitacion = new JButton("Eliminar Habitacion");
		eliminarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EliminarHabitacion.main(null);
				frame.dispose();
			}
		});
		eliminarHabitacion.setBounds(511, 11, 123, 23);
		panelHabitaciones.setLayout(null);
		panelHabitaciones.add(listarHabitacion);
		panelHabitaciones.add(eliminarHabitacion);
		
		JButton agregarHabitacion = new JButton("Agregar habitacion");
		agregarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarHabitacion.main(null);
				frame.dispose();
			}
		});
		agregarHabitacion.setBounds(10, 11, 123, 23);
		panelHabitaciones.add(agregarHabitacion);
		
		JButton modificarHabitacion = new JButton("Modificar habitacion");
		modificarHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarHabitacion.main(null);
				frame.dispose();
			}
		});
		modificarHabitacion.setBounds(333, 11, 130, 23);
		panelHabitaciones.add(modificarHabitacion);
		
		JPanel panelCliente = new JPanel();
		panelCliente.setBounds(130, 207, 634, 46);
		frame.getContentPane().add(panelCliente);
		panelCliente.setLayout(null);
		panelCliente.setVisible(false);
		
		JButton agregarCliente = new JButton("Agregar Cliente");
		agregarCliente.setBounds(10, 11, 117, 23);
		panelCliente.add(agregarCliente);
		
		JButton mostrarCliente = new JButton("Mostrar clientes");
		mostrarCliente.setBounds(171, 11, 124, 23);
		panelCliente.add(mostrarCliente);
		
		JButton eliminarCliente = new JButton("Eliminar cliente");
		eliminarCliente.setBounds(510, 11, 124, 23);
		panelCliente.add(eliminarCliente);
		
		JButton modificarCliente = new JButton("Modificar Cliente");
		modificarCliente.setBounds(332, 11, 132, 23);
		panelCliente.add(modificarCliente);
		
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
