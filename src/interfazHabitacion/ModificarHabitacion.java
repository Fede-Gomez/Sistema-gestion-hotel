package interfazHabitacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.ConectarHabitacion;


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
	private ConectarHabitacion conectar = new ConectarHabitacion();
	private final ButtonGroup buttonGroupModificar = new ButtonGroup();
	private JTextField criterioPiso;
	private JTextField criterioCapacidad;
	private JTextField criterioPrecio;
	private final ButtonGroup buttonGroupCriterioDisponible = new ButtonGroup();
	private JRadioButton disponibleSi = new JRadioButton("Si");		
	private JRadioButton disponibleNo = new JRadioButton("No");
	private final ButtonGroup buttonGroupCriterioTipo = new ButtonGroup();
	private String tipoHabitacionCriterio;
	private String disponibleCriterio;
	private JRadioButton criterioNormal = new JRadioButton("Normal");
	private JRadioButton criterioSuper = new JRadioButton("Super");
	private JRadioButton criterioDeluxe = new JRadioButton("Deluxe");
	private JRadioButton criterioDisponibleNo = new JRadioButton("No");		
	private JRadioButton criterioDisponibleSi = new JRadioButton("Si");
	private String disponible;
	private JTextField numeroHabitacionModificar;
	
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
		frmModificarHabitacion.setBounds(100, 100, 934, 569);
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
		criterioNumero.setBounds(143, 49, 86, 20);
		criterioNumero.setColumns(10);
		
		JButton buscar = new JButton("Ver habitacion");
		buscar.setBounds(279, 282, 163, 23);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			buscarHabitacion();
			
		}
			
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 45, 639, 226);
		
		JLabel lblNewLabel_2 = new JLabel("Piso");
		lblNewLabel_2.setBounds(159, 410, 37, 14);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad");
		lblNewLabel_3.setBounds(153, 448, 76, 14);
		
		JLabel lblNewLabel_4 = new JLabel("Precio");
		lblNewLabel_4.setBounds(159, 481, 66, 14);
		
		JLabel lblNewLabel_6 = new JLabel("Disponible");
		lblNewLabel_6.setBounds(366, 448, 76, 14);
		
		pisoNuevo = new JTextField();
		pisoNuevo.setBounds(255, 407, 86, 20);
		pisoNuevo.setColumns(10);
		
		capacidadNueva = new JTextField();
		capacidadNueva.setBounds(255, 445, 86, 20);
		capacidadNueva.setColumns(10);
		
		precioNuevo = new JTextField();
		precioNuevo.setBounds(256, 478, 86, 20);
		precioNuevo.setColumns(10);
		

		disponibleSi.setBounds(440, 425, 49, 23);
		buttonGroupModificar.add(disponibleSi);

		disponibleNo.setBounds(440, 469, 49, 23);
		buttonGroupModificar.add(disponibleNo);
		
		JButton modificar = new JButton("Modificar");
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numeroHabitacionModificar.getText().equals("")) {
					JOptionPane.showMessageDialog(frmModificarHabitacion, "Indique numero para poder modificar");
				}
				else {
					modificarHabitacion();					
				}

			}
		});
		modificar.setBounds(563, 410, 145, 23);
		
		JButton volver = new JButton("Volver");
		volver.setBounds(773, 506, 145, 23);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Piso");
		lblNewLabel_1.setBounds(42, 94, 46, 14);
		panel.add(lblNewLabel_1);
		
		criterioPiso = new JTextField();
		criterioPiso.setBounds(143, 91, 86, 20);
		panel.add(criterioPiso);
		criterioPiso.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Capacidad");
		lblNewLabel_5.setBounds(42, 131, 76, 14);
		panel.add(lblNewLabel_5);
		
		criterioCapacidad = new JTextField();
		criterioCapacidad.setBounds(143, 128, 86, 20);
		panel.add(criterioCapacidad);
		criterioCapacidad.setColumns(10);
		
		criterioPrecio = new JTextField();
		criterioPrecio.setBounds(143, 162, 86, 20);
		panel.add(criterioPrecio);
		criterioPrecio.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Precio");
		lblNewLabel_7.setBounds(42, 165, 46, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Disponible");
		lblNewLabel_8.setBounds(42, 279, 76, 14);
		panel.add(lblNewLabel_8);

		buttonGroupCriterioDisponible.add(criterioDisponibleSi);
		criterioDisponibleSi.setBounds(124, 275, 46, 23);
		panel.add(criterioDisponibleSi);
		

		buttonGroupCriterioDisponible.add(criterioDisponibleNo);
		criterioDisponibleNo.setBounds(183, 276, 46, 20);
		panel.add(criterioDisponibleNo);
		
		JButton btnNewButton = new JButton("Limpiar busqueda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criterioNumero.setText("");
				criterioPiso.setText("");
				criterioCapacidad.setText("");
				criterioPrecio.setText("");
				
			}
		});
		btnNewButton.setBounds(755, 282, 163, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar cambios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pisoNuevo.setText("");
				capacidadNueva.setText("");
				precioNuevo.setText("");
			}
		});
		btnNewButton_1.setBounds(563, 477, 145, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Tipo");
		lblNewLabel_9.setBounds(115, 204, 46, 14);
		panel.add(lblNewLabel_9);
		
		buttonGroupCriterioTipo.add(criterioDeluxe);
		criterioDeluxe.setBounds(181, 229, 66, 23);
		panel.add(criterioDeluxe);
		
		buttonGroupCriterioTipo.add(criterioSuper);
		criterioSuper.setBounds(115, 229, 66, 23);
		panel.add(criterioSuper);
		
		
		buttonGroupCriterioTipo.add(criterioNormal);
		criterioNormal.setBounds(42, 229, 66, 23);
		panel.add(criterioNormal);
		
		JLabel lblNewLabel_10 = new JLabel("Numero de habitacion a modificar");
		lblNewLabel_10.setBounds(207, 367, 196, 14);
		panel.add(lblNewLabel_10);
		
		numeroHabitacionModificar = new JTextField();
		numeroHabitacionModificar.setBounds(425, 364, 86, 20);
		panel.add(numeroHabitacionModificar);
		numeroHabitacionModificar.setColumns(10);
		frmModificarHabitacion.getContentPane().setLayout(groupLayout);
	}
	
	public void buscarHabitacion() {
		//limpiar la tabla para que este vacia					
		while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
		
		ArrayList<String> habitaciones = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 
		int cont = 0;
		
		if(criterioNormal.isSelected()) {
			tipoHabitacionCriterio = criterioNormal.getText();		
		}else {
			if(criterioSuper.isSelected()) {
				tipoHabitacionCriterio = criterioSuper.getText();		
			}
			else {
				if(criterioDeluxe.isSelected()) {
					tipoHabitacionCriterio = criterioDeluxe.getText();		
				}
				else {
					tipoHabitacionCriterio = "";
				}
			}
		}
		
		if(criterioDisponibleSi.isSelected()) {
			disponibleCriterio = criterioDisponibleSi.getText();
		}else {
			if(criterioDisponibleNo.isSelected()) {
				disponibleCriterio = criterioDisponibleNo.getText();
			}else{
				disponibleCriterio = "";
			}
		}
		
		habitaciones = conectar.buscarHabitacion(criterioNumero.getText(),criterioPiso.getText(),criterioCapacidad.getText(),criterioPrecio.getText(), tipoHabitacionCriterio, disponibleCriterio);

		
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
	
	public void modificarHabitacion() {
	
		
		//un peqeño if que pide que se muestre la habitacion qe se qiere modificar (puede pasar que este correcto y no haga falta modificarla)				

						if(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
							
							if(disponibleSi.isSelected()) {
								disponible = disponibleSi.getText();
							}else{
								if(disponibleNo.isSelected()) {
									disponible = disponibleNo.getText();
								}
								else {
									disponible = "";
								}
							}				
								
							
								conectar.modificarHabitacion(numeroHabitacionModificar.getText(), pisoNuevo.getText(), capacidadNueva.getText(), precioNuevo.getText(), disponible);																
							



						}

						
											
		
	}
	
	
}
