package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.Conectar;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModificarHabitacion {

	private JFrame frmModificarHabitacion;
	private JTextField criterioNumero;
	private JTable table;
	private JTextField pisoNuevo;
	private JTextField capacidadNueva;
	private JTextField precioNuevo;
	private Conectar conectar = new Conectar();
	private final ButtonGroup buttonGroupDisponible = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarHabitacion window = new ModificarHabitacion();
					window.frmModificarHabitacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificarHabitacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificarHabitacion = new JFrame();
		frmModificarHabitacion.setTitle("Modificar habitacion");
		frmModificarHabitacion.setResizable(false);
		frmModificarHabitacion.setBounds(100, 100, 695, 407);
		frmModificarHabitacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmModificarHabitacion.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(42, 52, 76, 14);
		
		criterioNumero = new JTextField();
		criterioNumero.setBounds(128, 49, 86, 20);
		criterioNumero.setColumns(10);
		
		JButton buscar = new JButton("Buscar habitacion");
		buscar.setBounds(386, 48, 170, 23);
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
				
				habitaciones = conectar.buscarHabitacionNumero(criterioNumero.getText());

				
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 89, 596, 95);
		
		JLabel lblNewLabel_2 = new JLabel("Piso");
		lblNewLabel_2.setBounds(52, 226, 37, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad");
		lblNewLabel_3.setBounds(52, 267, 76, 14);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setBounds(339, 223, 66, 14);
		
		JLabel lblNewLabel_6 = new JLabel("Disponible");
		lblNewLabel_6.setBounds(339, 268, 76, 14);
		
		pisoNuevo = new JTextField();
		pisoNuevo.setBounds(128, 223, 86, 20);
		pisoNuevo.setColumns(10);
		
		capacidadNueva = new JTextField();
		capacidadNueva.setBounds(128, 264, 86, 20);
		capacidadNueva.setColumns(10);
		
		precioNuevo = new JTextField();
		precioNuevo.setBounds(405, 220, 86, 20);
		precioNuevo.setColumns(10);
		
		JRadioButton disponibleSi = new JRadioButton("Si");
		disponibleSi.setBounds(405, 264, 49, 23);
		buttonGroupDisponible.add(disponibleSi);
		
		JRadioButton disponibleNo = new JRadioButton("No");
		disponibleNo.setBounds(456, 264, 49, 23);
		buttonGroupDisponible.add(disponibleNo);
		
		JButton modificar = new JButton("Modificar");
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String disponible = null;
//un peqeño if que pide que se muestre la habitacion qe se qiere modificar (puede pasar que este correcto y no haga falta modificarla)				

				if(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					
					if(disponibleSi.isSelected()) {
						disponible = disponibleSi.getText();
					}else{
						if(disponibleNo.isSelected()) {
							disponible = disponibleNo.getText();
						}
					}				
				
					conectar.modificarHabitacion(criterioNumero.getText(), pisoNuevo.getText(), capacidadNueva.getText(), precioNuevo.getText(), disponible);
				}

				criterioNumero.setText("");;
				pisoNuevo.setText("");
				capacidadNueva.setText("");
				precioNuevo.setText("");
			}
		});
		modificar.setBounds(239, 326, 102, 31);
		
		JButton volver = new JButton("Volver");
		volver.setBounds(552, 330, 86, 23);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Piso", "Capacidad", "Precio", "Tipo", "Disponible"
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(criterioNumero);
		panel.add(buscar);
		panel.add(lblNewLabel_2);
		panel.add(lblNewLabel_3);
		panel.add(pisoNuevo);
		panel.add(capacidadNueva);
		panel.add(lblNewLabel_6);
		panel.add(disponibleSi);
		panel.add(disponibleNo);
		panel.add(lblNewLabel_4);
		panel.add(precioNuevo);
		panel.add(modificar);
		panel.add(volver);
		panel.add(scrollPane);
		frmModificarHabitacion.getContentPane().setLayout(groupLayout);
	}
}
