package interfazMenu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import interfazHabitacion.ListarHabitaciones;
import interfazLogin.Login;
import interfazRecepcionista.*;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InicioRecepcionista {

	private JFrame frmMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioRecepcionista window = new InicioRecepcionista();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioRecepcionista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.setTitle("Menu");
		frmMenu.setBounds(100, 100, 563, 417);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frmMenu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
		);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Habitaciones disponibles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarHabitaciones.main(null);
				frmMenu.dispose();
			}
		});
		btnNewButton.setBounds(81, 90, 192, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reservas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservas.main(null);
				frmMenu.dispose();
			}
		});
		btnNewButton_1.setBounds(81, 156, 192, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Mostrar reservas");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarReservas.main(null);
				frmMenu.dispose();
			}
		});
		btnNewButton_2.setBounds(81, 221, 192, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cerrar sesion");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				frmMenu.dispose();
				
			}
		});
		btnNewButton_3.setBounds(412, 344, 125, 23);
		panel.add(btnNewButton_3);
		frmMenu.getContentPane().setLayout(groupLayout);
	}
}
