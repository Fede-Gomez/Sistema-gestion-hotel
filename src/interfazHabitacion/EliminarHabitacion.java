package interfazHabitacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.ConectarHabitacion;
import interfaz.Inicio;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EliminarHabitacion {

	private JFrame frmEliminarHabitacion;
	private JTable table;
	private JTextField numero;
	private ConectarHabitacion conectar = new ConectarHabitacion();
	private JTextField capacidad;
	private JTextField piso;
	private JTextField precio;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private final ButtonGroup buttonGroupDisponible = new ButtonGroup();
	private JRadioButton normal = new JRadioButton("Normal");
	private JRadioButton Super = new JRadioButton("Super");
	private JRadioButton deluxe = new JRadioButton("Deluxe");
	private JRadioButton disponibleSi = new JRadioButton("Si");
	private JRadioButton disponibleNo = new JRadioButton("No");
	private String tipoHabitacion;
	private String disponible;
	private String habitacionSeleccionado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarHabitacion window = new EliminarHabitacion();
					window.frmEliminarHabitacion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EliminarHabitacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEliminarHabitacion = new JFrame();
		frmEliminarHabitacion.setTitle("Eliminar Habitacion");
		frmEliminarHabitacion.setBounds(100, 100, 574, 560);
		frmEliminarHabitacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmEliminarHabitacion.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 281, Short.MAX_VALUE)
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 228, 538, 228);
		
		JButton eliminar = new JButton("Eliminar habitacion");
		eliminar.setBounds(105, 487, 154, 23);
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				eliminarHabitacion();
				
			}
		});
		
		JButton volver = new JButton("Volver");
		volver.setBounds(347, 487, 121, 23);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.main(null);
				frmEliminarHabitacion.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(31, 55, 69, 14);
		
		numero = new JTextField();
		numero.setBounds(121, 52, 86, 20);
		numero.setColumns(10);
		
		JButton buscar = new JButton("Buscar habitacion");
		buscar.setBounds(299, 173, 189, 44);
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
				
			buscarHabitacion();
			limpiarCampos(); 
				
			
			
		}
	});
		
		JLabel lblNewLabel_2 = new JLabel("Capacidad");
		lblNewLabel_2.setBounds(31, 98, 86, 14);
		
		capacidad = new JTextField();
		capacidad.setBounds(121, 95, 86, 20);
		capacidad.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(31, 173, 69, 14);
		
		JLabel lblNewLabel_1 = new JLabel("Piso");
		lblNewLabel_1.setBounds(31, 138, 69, 14);
		
		piso = new JTextField();
		piso.setBounds(121, 135, 86, 20);
		piso.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(121, 170, 86, 20);
		precio.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				seleccionarEmpleadoEnLaTabla();
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Piso", "Capacidad", "Precio", "Tipo", "Disponible"
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(null);
		panel.add(lblNewLabel_3);
		panel.add(lblNewLabel_1);
		panel.add(piso);
		panel.add(precio);
		panel.add(lblNewLabel_2);
		panel.add(capacidad);
		panel.add(lblNewLabel);
		panel.add(numero);
		panel.add(buscar);
		panel.add(eliminar);
		panel.add(volver);
		panel.add(scrollPane);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo");
		lblNewLabel_4.setBounds(267, 92, 46, 14);
		panel.add(lblNewLabel_4);
		
		
		buttonGroupTipo.add(normal);
		normal.setBounds(299, 55, 76, 23);
		panel.add(normal);
		
		buttonGroupTipo.add(Super);
		Super.setBounds(299, 88, 76, 23);
		panel.add(Super);
		
		buttonGroupTipo.add(deluxe);
		deluxe.setBounds(299, 121, 76, 23);
		panel.add(deluxe);
		
		JLabel lblNewLabel_5 = new JLabel("Disponible");
		lblNewLabel_5.setBounds(402, 55, 86, 14);
		panel.add(lblNewLabel_5);
		
		buttonGroupDisponible.add(disponibleSi);
		disponibleSi.setBounds(412, 84, 109, 23);
		panel.add(disponibleSi);
		
		buttonGroupDisponible.add(disponibleNo);
		disponibleNo.setBounds(412, 117, 109, 23);
		panel.add(disponibleNo);
		frmEliminarHabitacion.getContentPane().setLayout(groupLayout);
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
		
		habitaciones = conectar.buscarHabitacion(numero.getText(),precio.getText(), capacidad.getText(), piso.getText(), tipoHabitacion, disponible);
//String numero, String precio, String capacidad, String piso, String tipo, String disponible
		
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
	
	public void eliminarHabitacion() {
		
		
		if(table.getSelectedRow() != -1) {
			int decision = JOptionPane.showConfirmDialog(frmEliminarHabitacion, "Estas seguro?");
			if(decision == 0) {
				conectar.eliminarHabitacion(habitacionSeleccionado);					
				((DefaultTableModel) table.getModel()).removeRow(0);
			}

		}
		else {
			JOptionPane.showMessageDialog(frmEliminarHabitacion, "Indique numero para poder eliminarla");
		}
		


	}
		


	public void seleccionarEmpleadoEnLaTabla() {
		try{
			int seleccion = table.getSelectedRow();
			habitacionSeleccionado = table.getValueAt(seleccion, 0).toString();
			
		}catch(Exception f) {
			f.printStackTrace();
		}

	}
	
	public void limpiarCampos() {
		numero.setText("");
		capacidad.setText("");
		piso.setText("");
		precio.setText("");
		tipoHabitacion = "";
		disponible = "";
	}
}
