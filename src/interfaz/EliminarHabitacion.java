package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.Conectar;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EliminarHabitacion {

	private JFrame frmEliminarHabitacion;
	private JTable table;
	private JTextField num;
	private Conectar conectar = new Conectar();

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
		frmEliminarHabitacion.setBounds(100, 100, 574, 320);
		frmEliminarHabitacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmEliminarHabitacion.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				int decision = JOptionPane.showConfirmDialog(frmEliminarHabitacion, "Estas seguro?");
				System.out.println(decision);
				if(decision == 0) {
					conectar.eliminarHabitacion(num.getText());					
					((DefaultTableModel) table.getModel()).removeRow(0);
				}

				
			}
		});
		
		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio.main(null);
				frmEliminarHabitacion.dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Numero");
		
		num = new JTextField();
		num.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
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
				
				habitaciones = conectar.buscarHabitacionNumero(num.getText());

				
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(139)
					.addComponent(eliminar)
					.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
					.addComponent(volver)
					.addGap(137))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel)
					.addGap(53)
					.addComponent(num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
					.addComponent(buscar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(120))
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(buscar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(volver)
						.addComponent(eliminar))
					.addGap(31))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Numero", "Piso", "Capacidad", "Precio", "Tipo", "Disponible"
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		frmEliminarHabitacion.getContentPane().setLayout(groupLayout);
	}
}
