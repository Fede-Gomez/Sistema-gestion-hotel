package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.Conectar;


import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ListarHabitaciones {

	private JFrame frmMostrarHabitaciones;
	DefaultTableModel modelo = new DefaultTableModel();
	private JTable table= new JTable(modelo);
	private String tipoHabitacion;
	private JTextField numero;
	private JTextField piso;
	private JTextField capacidad;
	private JTextField precio;
	private Conectar conectar = new Conectar();
	private final ButtonGroup tipoHabiacion = new ButtonGroup();
	private String disponible;
	private JRadioButton disponibleSi = new JRadioButton("Si");
	private JRadioButton disponibleNo = new JRadioButton("No");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarHabitaciones window = new ListarHabitaciones();
					window.frmMostrarHabitaciones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListarHabitaciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMostrarHabitaciones = new JFrame();
		frmMostrarHabitaciones.setTitle("Mostrar habitaciones");
		frmMostrarHabitaciones.setBounds(100, 100, 836, 493);
		frmMostrarHabitaciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmMostrarHabitaciones.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
		);
		
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(29, 37, 46, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Piso");
		lblNewLabel_1.setBounds(232, 37, 46, 14);
		
		numero = new JTextField();
		numero.setBounds(93, 34, 86, 20);
		numero.setColumns(10);
		
		piso = new JTextField();
		piso.setBounds(296, 34, 86, 20);
		piso.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Capacidad");
		lblNewLabel_2.setBounds(29, 98, 86, 14);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 175, 800, 268);
		
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Piso", "Capacidad", "Precio", "Tipo", "Disponible"
			}
		));
		
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(232, 98, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo");
		lblNewLabel_4.setBounds(398, 65, 46, 14);
		panel.add(lblNewLabel_4);
		
		capacidad = new JTextField();
		capacidad.setBounds(93, 95, 86, 20);
		panel.add(capacidad);
		capacidad.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(296, 95, 86, 20);
		panel.add(precio);
		precio.setColumns(10);
		
		
		JRadioButton normal = new JRadioButton("Normal");
		tipoHabiacion.add(normal);
		normal.setBounds(430, 28, 76, 23);
		panel.add(normal);
		
		JRadioButton Super = new JRadioButton("Super");
		tipoHabiacion.add(Super);
		Super.setBounds(430, 61, 76, 23);
		panel.add(Super);
		
		JRadioButton deluxe = new JRadioButton("Deluxe");
		tipoHabiacion.add(deluxe);
		deluxe.setBounds(430, 94, 76, 23);
		panel.add(deluxe);
		
		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.main(null);
				frmMostrarHabitaciones.dispose();
			}
		});
		volver.setBounds(650, 141, 117, 23);
		panel.add(volver);
		frmMostrarHabitaciones.getContentPane().setLayout(groupLayout);
		
		JButton listarTodas = new JButton("Mostrar todas");
		listarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarHabitaciones();
			}
		});

		listarTodas.setBounds(650, 107, 117, 23);
	
		
		JButton buscar = new JButton("Buscar habitacion");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
				
				if(normal.isSelected()) {
					tipoHabitacion = normal.getText();
				}else {
					if(Super.isSelected()) {
						tipoHabitacion = Super.getText();
					}
					else {
						if(deluxe.isSelected())
							tipoHabitacion = deluxe.getText();
						else {
							tipoHabitacion = "";
						}
					}
				}
				
				if(disponibleSi.isSelected()) {
					disponible = disponibleSi.getText();
				}else {
					if(disponibleNo.isSelected()) {
						disponible = disponibleNo.getText();
					}
					else {
						disponible = "";
					}
				}
				
				buscarHabitacionEspecificada();
		
			}
		});
		buscar.setBounds(650, 28, 117, 23);
		
		panel.add(scrollPane);
		panel.add(listarTodas);
		panel.add(buscar);
		panel.add(lblNewLabel);
		panel.add(lblNewLabel_1);
		panel.add(numero);
		panel.add(piso);
		panel.add(lblNewLabel_2);
		
		JButton limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//numero.getText(), piso.getText(), capacidad.getText(), precio.getText(), tipoHabitacion
				
				numero.setText("");
				piso.setText("");
				capacidad.setText("");
				precio.setText("");
				tipoHabitacion = null;
			}
		});
		limpiar.setBounds(650, 67, 117, 23);
		panel.add(limpiar);
		
		JLabel lblNewLabel_5 = new JLabel("Disponible");
		lblNewLabel_5.setBounds(512, 32, 86, 14);
		panel.add(lblNewLabel_5);
		
		
		disponibleSi.setBounds(522, 61, 109, 23);
		panel.add(disponibleSi);
		
		disponibleNo.setBounds(522, 94, 109, 23);
		panel.add(disponibleNo);
	
	
		

	}
	
	public void listarHabitaciones() {
		//limpiar la tabla para que este vacia					
		while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		


			ArrayList<String> habitaciones = new ArrayList<String>();
			int numCols = table.getModel().getColumnCount();
			Object [] columna = new Object[numCols]; 
			int cont = 0;
			
			habitaciones = conectar.listarHabitaciones();


/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
* */					
			while( cont < habitaciones.size()) {

				columna[0] = habitaciones.get(cont++).toString();
				columna[1] = habitaciones.get(cont++).toString();
				columna[2] = habitaciones.get(cont++).toString();
				columna[3] = habitaciones.get(cont++).toString();
				columna[4] = habitaciones.get(cont++).toString();
				columna[5] = habitaciones.get(cont++).toString();
				((DefaultTableModel) table.getModel()).addRow(columna);
				

			}
		
	}
	
	
	public void buscarHabitacionEspecificada() {
		//limpiar la tabla para que este vacia
		while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		
		
		ArrayList<String> habitacion = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		
		Object [] columna = new Object[numCols]; 
		int cont = 0;
		
		
		
		habitacion = conectar.buscarHabitacion(numero.getText(), precio.getText(),capacidad.getText(), piso.getText(),  tipoHabitacion,disponible);
		
		
		while( cont < habitacion.size()) {

			columna[0] = habitacion.get(cont++).toString();
			columna[1] = habitacion.get(cont++).toString();
			columna[2] = habitacion.get(cont++).toString();
			columna[3] = habitacion.get(cont++).toString();
			columna[4] = habitacion.get(cont++).toString();
			columna[5] = habitacion.get(cont++).toString();
			((DefaultTableModel) table.getModel()).addRow(columna);


		}
	}
}
