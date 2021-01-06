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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListarHabitaciones {

	private JFrame frame;
	private JTable table;
	private JTextField numero;
	private JTextField piso;
	private JTextField capacidad;
	private JTextField precio;
	private Conectar conectar = new Conectar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarHabitaciones window = new ListarHabitaciones();
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
	public ListarHabitaciones() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 836, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 800, 251);
		
		
		JComboBox tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] {"Normal", "Super", "Deluxe"}));
		tipo.setBounds(485, 65, 69, 22);
		panel.add(tipo);

		
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
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable table = new JTable(modelo);
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
		lblNewLabel_4.setBounds(418, 69, 46, 14);
		panel.add(lblNewLabel_4);
		
		capacidad = new JTextField();
		capacidad.setBounds(93, 95, 86, 20);
		panel.add(capacidad);
		capacidad.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(296, 95, 86, 20);
		panel.add(precio);
		precio.setColumns(10);
		
		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.main(null);
				frame.dispose();
			}
		});
		volver.setBounds(721, 420, 89, 23);
		panel.add(volver);
		frame.getContentPane().setLayout(groupLayout);
		
		JButton listarTodas = new JButton("Mostrar todas");
		listarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
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
		});
		listarTodas.setBounds(650, 98, 117, 23);
	
		
		JButton buscar = new JButton("Buscar habitacion");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//limpiar la tabla para que este vacia					
				while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
				
				ArrayList<String> habitaciones = new ArrayList<String>();
				int numCols = table.getModel().getColumnCount();
				Object [] columna = new Object[numCols]; 
				int cont = 0;
				
				if(!numero.getText().equals("")) {
					habitaciones = conectar.buscarHabitacionNumero(numero.getText());
				}else {
					if(!piso.getText().equals("")) {
						habitaciones = conectar.buscarHabitacionPiso(piso.getText());
					}else {
						if(!capacidad.getText().equals("")) {
							habitaciones = conectar.buscarHabitacionCapacidad(capacidad.getText());
						}else {
							if(!precio.getText().equals("")) {
								habitaciones = conectar.buscarHabitacionPrecio(precio.getText());
							}else {
								switch(tipo.getSelectedItem().toString()) {
									case "Normal": habitaciones = conectar.buscarHabitacionTipo("Normal"); break;
									case "Super": habitaciones = conectar.buscarHabitacionTipo("Super");break;
									case "Deluxe": habitaciones = conectar.buscarHabitacionTipo("Deluxe");break;
									default: ;
								}
							}
						}
					}
				}


				
				
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
		});
		buscar.setBounds(650, 33, 117, 23);
		
		panel.add(scrollPane);
		panel.add(listarTodas);
		panel.add(buscar);
		panel.add(lblNewLabel);
		panel.add(lblNewLabel_1);
		panel.add(numero);
		panel.add(piso);
		panel.add(lblNewLabel_2);

	}
}
