package interfazLogin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import conectarBBDD.ConectarLogin;
import interfazMenu.InicioDirector;
import interfazMenu.InicioRecepcionista;

import javax.swing.JPasswordField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Login {

	private JFrame frmLogin;
	private JTextField usuario;
	private JPasswordField contraseña;
	//private JLabel mensajeError;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 525, 286);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JButton ingresar = new JButton("Ingresar");
		ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConectarLogin con = new ConectarLogin();
				String cargo = con.usuarioContraseñaDelLogin(usuario.getText(), contraseña.getText());
				if(cargo.equals("director general")){
					InicioDirector.main(null);
					frmLogin.dispose();
				}
				else {
					if(cargo.equals("recepcionista")) {
						InicioRecepcionista.main(null);
						frmLogin.dispose();
					}else {
						JOptionPane.showMessageDialog(ingresar, "Credenciales invalidas");
						usuario.setText("");
						contraseña.setText("");						
					}
				}
			}
		});
		ingresar.setBounds(410, 213, 89, 23);
		panel.add(ingresar);
		
		usuario = new JTextField();
		usuario.setBounds(177, 108, 128, 20);
		panel.add(usuario);
		usuario.setColumns(10);
		
		contraseña = new JPasswordField();
		contraseña.setBounds(177, 149, 128, 20);
		panel.add(contraseña);
		GroupLayout groupLayout = new GroupLayout(frmLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(56, 111, 76, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(56, 152, 76, 14);
		panel.add(lblNewLabel_1);
		frmLogin.getContentPane().setLayout(groupLayout);
	}
}
