package interfazEmpleado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import conectarBBDD.ConectarEmpleado;
import interfazMenu.InicioDirector;
import personal.Empleado;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarEmpleado {

	private JFrame frmModificarEmpleado;
	private JTextField nombreCriterio;
	private JTextField apellidoCriterio;
	private JTextField dniCriterio;
	private JTextField sueldoCriterio;
	private JTextField usuarioCriterio;
	private JTextField legajoCriterio;
	private JTextField nombreNuevo;
	private JTextField apellidoNuevo;
	private JTextField dniNuevo;
	private JTextField sueldoNuevo;
	private JTextField nombreUsuarioNuevo;
	private ConectarEmpleado conectar = new ConectarEmpleado();
	private JTable table;
	private JList listModificar = new JList();
	private JList listCriterio = new JList();
	private Empleado empleadoSeleccionado = new Empleado();
	private Empleado empleadoModificar = new Empleado();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarEmpleado window = new ModificarEmpleado();
					window.frmModificarEmpleado.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModificarEmpleado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmModificarEmpleado = new JFrame();
		frmModificarEmpleado.setResizable(false);
		frmModificarEmpleado.setTitle("Modificar empleado");
		frmModificarEmpleado.setBounds(100, 100, 914, 508);
		frmModificarEmpleado.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmModificarEmpleado.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 908, 479);
		frmModificarEmpleado.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(40, 97, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(40, 125, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DNI");
		lblNewLabel_2.setBounds(40, 153, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cargo");
		lblNewLabel_3.setBounds(40, 239, 46, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sueldo");
		lblNewLabel_4.setBounds(40, 181, 46, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Usuario");
		lblNewLabel_5.setBounds(40, 209, 46, 14);
		panel.add(lblNewLabel_5);
		
		nombreCriterio = new JTextField();
		nombreCriterio.setBounds(135, 94, 86, 20);
		panel.add(nombreCriterio);
		nombreCriterio.setColumns(10);
		
		apellidoCriterio = new JTextField();
		apellidoCriterio.setBounds(135, 122, 86, 20);
		panel.add(apellidoCriterio);
		apellidoCriterio.setColumns(10);
		
		dniCriterio = new JTextField();
		dniCriterio.setBounds(135, 150, 86, 20);
		panel.add(dniCriterio);
		dniCriterio.setColumns(10);
		
		sueldoCriterio = new JTextField();
		sueldoCriterio.setBounds(135, 178, 86, 20);
		panel.add(sueldoCriterio);
		sueldoCriterio.setColumns(10);
		
		usuarioCriterio = new JTextField();
		usuarioCriterio.setBounds(135, 206, 86, 20);
		panel.add(usuarioCriterio);
		usuarioCriterio.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(253, 61, 645, 193);
		panel.add(scrollPane);
		
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
				"Legajo", "Nombre", "Apellido", "Dni", "Cargo", "Sueldo", "Usuario"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton buscar = new JButton("Buscar empleado");
		
		buscar.setBounds(253, 263, 165, 23);
		panel.add(buscar);
		
	
		
		JLabel lblNewLabel_6 = new JLabel("Legajo");
		lblNewLabel_6.setBounds(40, 66, 46, 14);
		panel.add(lblNewLabel_6);
		
		legajoCriterio = new JTextField();
		legajoCriterio.setBounds(135, 63, 86, 20);
		panel.add(legajoCriterio);
		legajoCriterio.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre nuevo");
		lblNewLabel_8.setBounds(197, 349, 86, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Apellido nuevo");
		lblNewLabel_9.setBounds(197, 379, 86, 14);
		panel.add(lblNewLabel_9);
		
		nombreNuevo = new JTextField();
		nombreNuevo.setBounds(309, 346, 86, 20);
		panel.add(nombreNuevo);
		nombreNuevo.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("DNI nuevo");
		lblNewLabel_10.setBounds(197, 409, 86, 14);
		panel.add(lblNewLabel_10);
		
		apellidoNuevo = new JTextField();
		apellidoNuevo.setBounds(309, 376, 86, 20);
		panel.add(apellidoNuevo);
		apellidoNuevo.setColumns(10);
		
		dniNuevo = new JTextField();
		dniNuevo.setBounds(309, 406, 86, 20);
		panel.add(dniNuevo);
		dniNuevo.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Cargo nuevo");
		lblNewLabel_11.setBounds(422, 409, 78, 14);
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Sueldo nuevo");
		lblNewLabel_12.setBounds(422, 349, 123, 14);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Nombre usuario nuevo");
		lblNewLabel_13.setBounds(422, 379, 123, 14);
		panel.add(lblNewLabel_13);
		
		sueldoNuevo = new JTextField();
		sueldoNuevo.setBounds(567, 346, 136, 20);
		panel.add(sueldoNuevo);
		sueldoNuevo.setColumns(10);
		
		nombreUsuarioNuevo = new JTextField();
		nombreUsuarioNuevo.setBounds(567, 376, 136, 20);
		panel.add(nombreUsuarioNuevo);
		nombreUsuarioNuevo.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(567, 409, 136, 49);
		panel.add(scrollPane_1);
		

		listModificar.setModel(new AbstractListModel() {
			String[] values = new String[] {"Director general", "Barman", "Camarero", "Cocinero", "Auxiliar de cocina", "Conserje", "Mantenimiento", "Recepcionista", "Seguridad"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(listModificar);
		
		JButton btnNewButton = new JButton("Confirmar cambios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(table.getSelectedRow() != -1) {
					modificarEmpleado();
				}
				else {
					JOptionPane.showMessageDialog(frmModificarEmpleado, "Seleccione un empleado");
				}
			}
		});
		btnNewButton.setBounds(729, 359, 159, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar cambios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				limpiarCambios();
			}
		});
		btnNewButton_1.setBounds(729, 399, 159, 23);
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioDirector.main(null);
				frmModificarEmpleado.dispose();
			}
		});
		btnNewButton_2.setBounds(729, 435, 159, 23);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(104, 239, 139, 88);
		panel.add(scrollPane_2);
		
		
		listCriterio.setModel(new AbstractListModel() {
			String[] values = new String[] {"Director general", "Barman", "Camarero", "Cocinero", "Auxiliar de cocina", "Conserje", "Mantenimiento", "Recepcionista", "Seguridad"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_2.setViewportView(listCriterio);
		
		JButton limpiarBusqueda = new JButton("Limpiar busqueda");
		limpiarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				limpiarBusqueda();
			}
		});
		
		
		limpiarBusqueda.setBounds(752, 265, 136, 23);
		panel.add(limpiarBusqueda);
		
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while(((DefaultTableModel) table.getModel()).getRowCount() != 0) {
					((DefaultTableModel) table.getModel()).removeRow(0);
				}
					buscarEmpleado();
				
			}
		});
	}
	
public void buscarEmpleado() {
		
	
	String cargo;
	
	switch(listCriterio.getSelectedIndex()) {
	
	case 0: cargo = "director general"; break;
	case 1: cargo = "barman"; break;
	case 2: cargo = "cocinero"; break;
	case 3: cargo = "auxiliar cocina"; break;
	case 4: cargo = "conserje"; break;
	case 5: cargo = "mantenimiento"; break;
	case 6: cargo = "recepcionista"; break;
	case 7: cargo = "seguridad"; break;
	default: cargo = ""; break;
	}
		
		ArrayList<String> empleado = new ArrayList<String>();
		int numCols = table.getModel().getColumnCount();
		Object [] columna = new Object[numCols]; 
		
		
		
		empleado = conectar.mostrarEmpleado(legajoCriterio.getText(),nombreCriterio.getText(), apellidoCriterio.getText(),dniCriterio.getText(), sueldoCriterio.getText(),cargo,usuarioCriterio.getText());



/*
agrega agrega cada dato rescatado de la bbdd y luego lo agrega a la tabla de la interfaz con la ultima linea
Cada vez que se agrege una nueva columna a la bbdd -> agregar una nueva linea:		columna[(sigiente num)] = empleados.get(cont++).toString();
* */					
		
		for(int cont = 0, a = 0; cont < empleado.size(); cont++ , a++) {
			if(a == numCols) {
				a = 0;
			}
			columna[a] = empleado.get(cont).toString();
		}
		((DefaultTableModel) table.getModel()).addRow(columna);
		
		

	}
	
	public void modificarEmpleado() {
		String cargo;
		
		switch(listModificar.getSelectedIndex()) {
		
		case 1: cargo = "director general"; break;
		case 2: cargo = "barman"; break;
		case 3: cargo = "cocinero"; break;
		case 4: cargo = "auxiliar cocina"; break;
		case 5: cargo = "conserje"; break;
		case 6: cargo = "mantenimiento"; break;
		case 7: cargo = "recepcionista"; break;
		case 8: cargo = "seguridad"; break;
		default: cargo = ""; break;
		}
		
		conectar.modificarEmpleado(empleadoModificar.getLegajo(), nombreNuevo.getText(), apellidoNuevo.getText(), dniNuevo.getText(), sueldoNuevo.getText(),nombreUsuarioNuevo.getText(),cargo);
		JOptionPane.showMessageDialog(frmModificarEmpleado, "Cambios confirmados");
		limpiarBusqueda();
		limpiarCambios();
	}

	public void limpiarBusqueda() {
		nombreCriterio.setText("");
		apellidoCriterio.setText("");
		dniCriterio.setText("");
		listCriterio.clearSelection();
		sueldoCriterio.setText("");
		usuarioCriterio.setText("");
		legajoCriterio.setText("");
	}
	public void limpiarCambios() {
		nombreNuevo.setText("");
		apellidoNuevo.setText("");
		dniNuevo.setText("");
		sueldoNuevo.setText("");
		nombreUsuarioNuevo.setText("");
		listModificar.clearSelection();
	}
	
	public void seleccionarEmpleadoEnLaTabla() {
		try{
			int seleccion = table.getSelectedRow();
			empleadoSeleccionado.setLegajo(Integer.parseInt(table.getValueAt(seleccion, 0).toString()));
			empleadoSeleccionado.setNombre(table.getValueAt(seleccion, 1).toString());
			empleadoSeleccionado.setApellido(table.getValueAt(seleccion, 2).toString());
			empleadoSeleccionado.setDNI(Integer.parseInt(table.getValueAt(seleccion, 3).toString()));
			empleadoSeleccionado.setCargo(table.getValueAt(seleccion, 4).toString());
			empleadoSeleccionado.setSueldo(Double.parseDouble(table.getValueAt(seleccion, 5).toString()));
			empleadoSeleccionado.setUsuario(table.getValueAt(seleccion, 6).toString());
			
			empleadoModificar = conectar.buscarEmpleado(empleadoSeleccionado);

		}catch(Exception f) {
			f.printStackTrace();
		}

	}
}
