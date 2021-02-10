package interfazHabitacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.LayoutStyle.ComponentPlacement;

import conectarBBDD.ConectarHabitacion;
import habitaciones.*;
import interfazMenu.InicioDirector;
import validaciones.Validaciones;

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
	private ConectarHabitacion conectar = new ConectarHabitacion();
	private JRadioButton normal = new JRadioButton("Normal");
	private JRadioButton Super = new JRadioButton("Super");
	private JRadioButton deluxe = new JRadioButton("Deluxe");
	
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
		
		
		buttonGroup.add(normal);
		
		buttonGroup.add(Super);
		
		buttonGroup.add(deluxe);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo de habitacion");
		
		JLabel lblNewLabel_5 = new JLabel("Agregar Habitacion");
		
		JButton agregar = new JButton("Aceptar");
		agregar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				while(num.getText().equals("") || !Validaciones.validarNumero(num.getText())) {
					num.setText(JOptionPane.showInputDialog("Ingrese un numero"));
				}
				while(piso.getText().equals("") || !Validaciones.validarNumero(piso.getText())) {
					piso.setText(JOptionPane.showInputDialog("Ingrese el piso"));
				}
				while(capacidad.getText().equals("") || !Validaciones.validarNumero(capacidad.getText())) {
					capacidad.setText(JOptionPane.showInputDialog("Ingrese la capacidad"));
				}
				while(precio.getText().equals("") ||  !Validaciones.validarNumero(precio.getText())) {
					precio.setText(JOptionPane.showInputDialog("Ingrese un precio"));
				}
					
				crearHabitacion();
				
				limpiarCampos();
				
				JOptionPane.showMessageDialog(frmAgregarHabitacio, "Se agrego correctamente");
			}
		});
		
		JButton borrar = new JButton("Limpiar");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				limpiarCampos();
			}
		});
		
		JButton volver = new JButton("Volver");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				InicioDirector.main(null);
				frmAgregarHabitacio.dispose();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(217)
					.addComponent(lblNewLabel_5)
					.addContainerGap(208, Short.MAX_VALUE))
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
						.addComponent(borrar)
						.addComponent(volver))
					.addGap(26))
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
							.addComponent(lblNewLabel_4))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(Super)
								.addComponent(agregar))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(normal)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(deluxe))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(borrar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(volver)))))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmAgregarHabitacio.getContentPane().setLayout(groupLayout);
	}
	
	
	public void crearHabitacion() {
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
	}
	
	public void limpiarCampos() {
		capacidad.setText("");
		piso.setText("");
		num.setText("");
		precio.setText("");
	}
}
