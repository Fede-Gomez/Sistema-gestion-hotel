package interfazRecepcionista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import clientes.Cliente;
import conectarBBDD.ConectarCliente;
import conectarBBDD.ConectarHabitacion;
import conectarBBDD.ConectarReservas;
import habitaciones.habitacion;
import interfazMenu.InicioRecepcionista;

import java.util.Date;

import java.util.Calendar;

public class Reservas {

	private JFrame frmReservarHabitacion;
	private JTextField numero;
	private JTextField piso;
	private JTextField tipoHabitacion;
	private JTextField precio;
	private JTextField estado;
	private ConectarHabitacion conectarHabitacion = new ConectarHabitacion();
	private ConectarReservas conectarReserva = new ConectarReservas();
	private ConectarCliente conectarCliente = new ConectarCliente();
	private JDateChooser fechaEgreso = new JDateChooser();
	private JDateChooser fechaIngreso = new JDateChooser();
	private habitacion habitacionBuscada = new habitacion();
	private Cliente clienteBuscado = new Cliente();
	private JTextField dni;
	private JTextField nombreCliente;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservas window = new Reservas();
					window.frmReservarHabitacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reservas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReservarHabitacion = new JFrame();
		frmReservarHabitacion.setTitle("Reservar habitacion");
		frmReservarHabitacion.setBounds(100, 100, 521, 463);
		frmReservarHabitacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReservarHabitacion.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 505, 424);
		frmReservarHabitacion.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(25, 45, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Piso");
		lblNewLabel_1.setBounds(25, 100, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo de habitacion");
		lblNewLabel_2.setBounds(284, 100, 129, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(25, 139, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setBounds(284, 139, 80, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha ingreso");
		lblNewLabel_5.setBounds(25, 196, 80, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha egreso");
		lblNewLabel_6.setBounds(256, 196, 80, 14);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reservarHabitacion();
			}
		});
		btnNewButton.setBounds(19, 386, 122, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		btnNewButton_1.setBounds(194, 386, 122, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioRecepcionista.main(null);
				frmReservarHabitacion.dispose();
			}
		});
		btnNewButton_2.setBounds(362, 386, 122, 23);
		panel.add(btnNewButton_2);
		
		JButton buscarNumero = new JButton("");
		buscarNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarHabitacion();
			}
		});
		buscarNumero.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/search_find_lupa_21889.png")));
		buscarNumero.setBounds(250, 31, 70, 41);
		panel.add(buscarNumero);
		
		numero = new JTextField();
		numero.setBounds(160, 45, 80, 20);
		panel.add(numero);
		numero.setColumns(10);
		
		piso = new JTextField();
		piso.setBounds(160, 97, 86, 20);
		panel.add(piso);
		piso.setColumns(10);
		
		tipoHabitacion = new JTextField();
		tipoHabitacion.setBounds(398, 97, 86, 20);
		panel.add(tipoHabitacion);
		tipoHabitacion.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(160, 136, 86, 20);
		panel.add(precio);
		precio.setColumns(10);
		
		estado = new JTextField();
		estado.setBounds(398, 136, 86, 20);
		panel.add(estado);
		estado.setColumns(10);
		
		
		
		
		
		fechaIngreso.setBounds(115, 196, 122, 20);
		panel.add(fechaIngreso);
		
		
		fechaEgreso.setBounds(334, 196, 122, 20);
		panel.add(fechaEgreso);
		
		JLabel lblNewLabel_7 = new JLabel("Documento cliente");
		lblNewLabel_7.setBounds(25, 286, 109, 14);
		panel.add(lblNewLabel_7);
		
		dni = new JTextField();
		dni.setBounds(167, 283, 108, 20);
		panel.add(dni);
		dni.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre");
		lblNewLabel_8.setBounds(25, 332, 80, 14);
		panel.add(lblNewLabel_8);
		
		nombreCliente = new JTextField();
		nombreCliente.setBounds(167, 329, 108, 20);
		panel.add(nombreCliente);
		nombreCliente.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCliente();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Reservas.class.getResource("/imagenes/search_find_lupa_21889.png")));
		btnNewButton_3.setBounds(284, 268, 70, 41);
		panel.add(btnNewButton_3);
		
		
	}
	
	public void buscarHabitacion() {
		
		
		
		habitacionBuscada = conectarHabitacion.buscarHabitacionNumero(numero.getText());
		
		if(conectarHabitacion.buscarHabitacionNumero(numero.getText()).getNumero() == 0) {
			JOptionPane.showMessageDialog(frmReservarHabitacion, "Habitacion inexistente");
			limpiarCampos();
		}
		else {
			piso.setText(Integer.toString(habitacionBuscada.getPiso()));
			tipoHabitacion.setText(habitacionBuscada.getTipoDeHabitacion());
			precio.setText(Double.toString(habitacionBuscada.getPrecio()));
			estado.setText(habitacionBuscada.getDisponible());			
		}
		
		
	}
	
	public void buscarCliente() {
		
		clienteBuscado = conectarCliente.buscarClienteDoc(dni.getText());
		
		if(conectarCliente.buscarClienteDoc(dni.getText()).getDni() == 0) {
			JOptionPane.showMessageDialog(frmReservarHabitacion, "Cliente inexistente");
			limpiarCampos();
		}
		else {
			nombreCliente.setText(clienteBuscado.getNombre());
		}
	}
	
	public void limpiarCampos() {
		numero.setText("");
		piso.setText("");
		precio.setText("");
		tipoHabitacion.setText("");
		estado.setText("");
	}

	
	public void reservarHabitacion() {
		
		Date dateIng = fechaIngreso.getDate();
		Date dateEgr = fechaEgreso.getDate();

		if(dateIng == null || dateEgr == null) {
			JOptionPane.showMessageDialog(frmReservarHabitacion, "Indique fechas de ingreso y egreso");
		}else {
			if (comprobarFechas()) {
				
				long dI = dateIng.getTime();
				java.sql.Date fecha_ingreso = new java.sql.Date(dI);
				

				long dE = dateEgr.getTime();
				java.sql.Date fecha_egreso = new java.sql.Date(dE);
				
				conectarReserva.reservarHabitacion(clienteBuscado,habitacionBuscada,fecha_ingreso,fecha_egreso);
			}

		}
		
	
		
		
		
	}
	
	
	public boolean comprobarFechas() {
		int diaFechaIngreso = fechaIngreso.getCalendar().get(fechaIngreso.getCalendar().DAY_OF_MONTH);
		int mesFechaIngreso = fechaIngreso.getCalendar().get(fechaIngreso.getCalendar().MONTH);
		int añoFechaIngreso = fechaIngreso.getCalendar().get(fechaIngreso.getCalendar().YEAR);
		
		int diaFechaEgreso = fechaEgreso.getCalendar().get(fechaEgreso.getCalendar().DAY_OF_MONTH);
		int mesFechaEgreso = fechaEgreso.getCalendar().get(fechaEgreso.getCalendar().MONTH);
		int añoFechaEgreso = fechaEgreso.getCalendar().get(fechaEgreso.getCalendar().YEAR);
		
		int diaActual = Calendar.getInstance().get(Calendar.getInstance().DAY_OF_MONTH);
		int mesActual = Calendar.getInstance().get(Calendar.getInstance().MONTH);
		int añoActual = Calendar.getInstance().get(Calendar.getInstance().YEAR);
	
		if(añoFechaIngreso < añoActual) {
			JOptionPane.showMessageDialog(frmReservarHabitacion, "El año de ingreso debe ser mayor al actual");
			return false;
		}else {
			if(mesFechaIngreso < mesActual) {
				JOptionPane.showMessageDialog(frmReservarHabitacion, "El mes de ingreso debe ser mayor al actual");		
				return false;
			}else {
				if(diaFechaIngreso < diaActual && mesFechaIngreso == mesActual ) {
					JOptionPane.showMessageDialog(frmReservarHabitacion, "El dia de ingreso debe ser mayor al actual");
					return false;
				}
			}
		}

		if(añoFechaEgreso < añoFechaIngreso ) {
			JOptionPane.showMessageDialog(frmReservarHabitacion, "El año de egreso debe ser mayor al ingreso");
			return false;
		}else {
			if(mesFechaEgreso < mesFechaIngreso) {
				JOptionPane.showMessageDialog(frmReservarHabitacion, "El mes de egreso debe ser mayor al ingreso");
				return false;
			}else {
				if(diaFechaEgreso < diaFechaIngreso && mesFechaIngreso == mesActual ) {
					JOptionPane.showMessageDialog(frmReservarHabitacion, "El dia de egreso debe ser mayor al ingreso");
					return false;
				}
			}
		}
		
		return true;
	}
}
