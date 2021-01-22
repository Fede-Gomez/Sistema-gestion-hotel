package interfazRecepcionista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.ConectarReservas;
import interfazMenu.InicioRecepcionista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class mostrarReservas {

	private JFrame frmMostrarReservas;
	private JTextField dni;
	private JTextField numReserva;
	private JTextField nombre;
	private JTable table;
	private ConectarReservas conectarReservas = new ConectarReservas(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mostrarReservas window = new mostrarReservas();
					window.frmMostrarReservas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mostrarReservas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMostrarReservas = new JFrame();
		frmMostrarReservas.setTitle("Mostrar reservas");
		frmMostrarReservas.setBounds(100, 100, 691, 367);
		frmMostrarReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMostrarReservas.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 675, 328);
		frmMostrarReservas.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Documento cliente");
		lblNewLabel.setBounds(31, 56, 141, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero reserva");
		lblNewLabel_1.setBounds(31, 104, 141, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre cliente");
		lblNewLabel_2.setBounds(31, 145, 141, 14);
		panel.add(lblNewLabel_2);
		
		dni = new JTextField();
		dni.setBounds(182, 50, 163, 20);
		panel.add(dni);
		dni.setColumns(10);
		
		numReserva = new JTextField();
		numReserva.setBounds(182, 98, 163, 20);
		panel.add(numReserva);
		numReserva.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(182, 139, 163, 20);
		panel.add(nombre);
		nombre.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 655, 147);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Num Reserva", "Documento", "Nombre", "Num habitacion", "Tipo", "Precio", "Fecha ingreso", "Fecha egreso"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(73);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioRecepcionista.main(null);
				frmMostrarReservas.dispose();
			}
		});
		salir.setBounds(576, 141, 89, 23);
		panel.add(salir);
		
		JButton buscar = new JButton("Buscar reserva");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarReservas();
			}
		});
		buscar.setBounds(404, 56, 136, 23);
		panel.add(buscar);
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos();
			}
		});
		limpiar.setBounds(404, 119, 136, 23);
		panel.add(limpiar);
	}
	
	public void limpiarCampos() {
		nombre.setText("");
		numReserva.setText("");
		dni.setText("");
	}
	
	public void buscarReservas() {
		
		ArrayList<String> reservas = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 
		reservas = conectarReservas.buscarReserva(numReserva.getText(), nombre.getText(), dni.getText());


/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
Cada vez que se agrege una nueva columna a la bbdd -> agregar una nueva linea:		columna[(sigiente num)] = empleados.get(cont++).toString();
* */					
			for(int cont = 0; cont < reservas.size(); cont++) {
				columna[cont] = reservas.get(cont).toString();
			}
			((DefaultTableModel) table.getModel()).addRow(columna);				
		
	}
	
}
