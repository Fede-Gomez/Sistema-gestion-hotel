package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.LayoutStyle.ComponentPlacement;

import conectarBBDD.Conectar;
import habitaciones.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarHabitacion {
	private JFrame frmAgregarHabitacio;
	private JTextField num;
	private JTextField piso;
	private JTextField capacidad;
	private JTextField precio;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Conectar conectar = new Conectar();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarHabitacion window = new AgregarHabitacion();
					window.frmAgregarHabitacio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarHabitacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarHabitacio = new JFrame();
		frmAgregarHabitacio.setTitle("Agregar Habitacion");
		frmAgregarHabitacio.setBounds(100, 100, 533, 366);
		frmAgregarHabitacio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmAgregarHabitacio.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("Capacidad");
		
		JLabel lblNewLabel_1 = new JLabel("Numero");
		
		JLabel lblNewLabel_2 = new JLabel("Piso");
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		
		num = new JTextField();
		num.setColumns(10);
		
		piso = new JTextField();
		piso.setColumns(10);
		
		capacidad = new JTextField();
		capacidad.setColumns(10);
		
		precio = new JTextField();
		precio.setColumns(10);
		
		JRadioButton normal = new JRadioButton("Normal");
		buttonGroup.add(normal);
		
		JRadioButton Super = new JRadioButton("Super");
		buttonGroup.add(Super);
		
		JRadioButton deluxe = new JRadioButton("Deluxe");
		buttonGroup.add(deluxe);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de habitacion");
		
		JLabel lblNewLabel_5 = new JLabel("Agregar Habitacion");
		
		JButton agregar = new JButton("Aceptar");
		agregar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				int capaci = Integer.parseInt(capacidad.getText());
				int floor = Integer.parseInt(piso.getText());
				int numero = Integer.parseInt(num.getText());
				double cash = Double.parseDouble(precio.getText());
				
				if(normal.isSelected()) {
					habitacionNormal habitacion = new habitacionNormal(capaci, floor, numero, cash);											
					conectar.crearHabitacion(habitacion);			
				}else {
					if(Super.isSelected()) {
						habitacionSuper habitacion = new habitacionSuper(capaci, floor, numero, cash);					
						conectar.crearHabitacion(habitacion);			
					}
					else {
						habitacionDeluxe habitacion = new habitacionDeluxe(capaci, floor, numero, cash);						
						conectar.crearHabitacion(habitacion);
					}
				}


				Inicio.main(null);
				frmAgregarHabitacio.dispose();


				
			}
		});
		
		JButton borrar = new JButton("Limpiar");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(217)
					.addComponent(lblNewLabel_5)
					.addContainerGap(254, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_3))
							.addGap(45)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(precio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(capacidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(piso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(deluxe)
								.addComponent(Super)
								.addComponent(normal))))
					.addPreferredGap(ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(agregar)
						.addComponent(borrar))
					.addGap(44))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_5)
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(piso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(capacidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(precio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(agregar))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(borrar))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(Super)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(normal)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(deluxe)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmAgregarHabitacio.getContentPane().setLayout(groupLayout);
	}
}
