package conectarBBDD;

import java.sql.*;
import java.util.*;

import habitaciones.*;
import personal.Empleado;

public class Conectar {
	
	private Connection conectar;
	private Statement statement;
	private ResultSet resultset;
	
	
	public boolean usuarioContraseñaDelLogin(String usuario, String pass) {
	
		try {
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			resultset = statement.executeQuery("select * from sistemahotel.empleado;");
			
			while(resultset.next()) {
				if(resultset.getString("usuario").equals(usuario) && resultset.getString("contraseña").equals(pass)) {
					return true;
				}
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	
	public void crearHabitacion( habitacionNormal habitacion) {
		
		try {
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "INSERT INTO sistemahotel.habitacion (numero, piso, capacidad, precio, tipo, disponible) VALUES ('" + habitacion.getNumero() + "','" + habitacion.getPiso() + "','" + habitacion.getCapacidad() + "','" + habitacion.getPrecio() + "','" + habitacion.getTipoDeHabitacion()+ "','Si')";
			
			statement.executeUpdate(instruccionSQL);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearHabitacion( habitacionDeluxe habitacion) {
		
		try {
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "insert into habitacion (numero, piso, capacidad, precio, tipo) values ('" + habitacion.getNumero() + "','" + habitacion.getPiso() + "','" + habitacion.getCapacidad() + "','" + habitacion.getPrecio() + "','" + habitacion.getTipoDeHabitacion()+ "')";
			
			statement.executeUpdate(instruccionSQL);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void crearHabitacion( habitacionSuper habitacion) {

	
	try {
		
		conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
		
		statement = conectar.createStatement();
		
		String instruccionSQL = "insert into habitacion (numero, piso, capacidad, precio, tipo) values ('" + habitacion.getNumero() + "','" + habitacion.getPiso() + "','" + habitacion.getCapacidad() + "','" + habitacion.getPrecio() + "','" + habitacion.getTipoDeHabitacion()+ "')";
		
		statement.executeUpdate(instruccionSQL);
			
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
	
	
	public ArrayList<String> listarHabitaciones() {
		try {
			
			ArrayList<String> habitaciones = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.habitacion";
			
			resultset = statement.executeQuery(instruccionSQL);
			
			while(resultset.next()) {
				habitaciones.add(resultset.getString("numero"));
				habitaciones.add(resultset.getString("piso"));
				habitaciones.add(resultset.getString("capacidad"));
				habitaciones.add(resultset.getString("precio"));
				habitaciones.add(resultset.getString("tipo"));
				habitaciones.add(resultset.getString("disponible"));
			}
				
				
				
				return habitaciones;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public ArrayList<String> buscarHabitacionNumero(String num) {
		try {
			
			ArrayList<String> habitaciones = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.habitacion where numero='" + num + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
				habitaciones.add(resultset.getString("numero"));
				habitaciones.add(resultset.getString("piso"));
				habitaciones.add(resultset.getString("capacidad"));
				habitaciones.add(resultset.getString("precio"));
				habitaciones.add(resultset.getString("tipo"));
				habitaciones.add(resultset.getString("disponible"));
			}
				
				
				
				return habitaciones;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> buscarHabitacionPrecio(String precio) {
		try {
			
			ArrayList<String> habitaciones = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.habitacion where precio='" + precio + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
				habitaciones.add(resultset.getString("numero"));
				habitaciones.add(resultset.getString("piso"));
				habitaciones.add(resultset.getString("capacidad"));
				habitaciones.add(resultset.getString("precio"));
				habitaciones.add(resultset.getString("tipo"));
				habitaciones.add(resultset.getString("disponible"));
			}
				
				
				
				return habitaciones;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> buscarHabitacionCapacidad(String capacidad) {
		try {
			
			ArrayList<String> habitaciones = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.habitacion where capacidad='" + capacidad + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
				habitaciones.add(resultset.getString("numero"));
				habitaciones.add(resultset.getString("piso"));
				habitaciones.add(resultset.getString("capacidad"));
				habitaciones.add(resultset.getString("precio"));
				habitaciones.add(resultset.getString("tipo"));
				habitaciones.add(resultset.getString("disponible"));
			}
				
				
				
				return habitaciones;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> buscarHabitacionPiso(String piso) {
		try {
			
			ArrayList<String> habitaciones = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.habitacion where piso='" + piso + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
				habitaciones.add(resultset.getString("numero"));
				habitaciones.add(resultset.getString("piso"));
				habitaciones.add(resultset.getString("capacidad"));
				habitaciones.add(resultset.getString("precio"));
				habitaciones.add(resultset.getString("tipo"));
				habitaciones.add(resultset.getString("disponible"));
			}
				
				
				
				return habitaciones;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<String> buscarHabitacionTipo(String tipo) {
		try {

			ArrayList<String> habitaciones = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.habitacion where tipo='" + tipo + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
				habitaciones.add(resultset.getString("numero"));
				habitaciones.add(resultset.getString("piso"));
				habitaciones.add(resultset.getString("capacidad"));
				habitaciones.add(resultset.getString("precio"));
				habitaciones.add(resultset.getString("tipo"));
				habitaciones.add(resultset.getString("disponible"));
			}
				
				
				
				return habitaciones;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void eliminarHabitacion(String num) {
		try {
			
						
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "delete from sistemahotel.habitacion where numero='" + num + "'";
			
			statement.executeUpdate(instruccionSQL);
			
							
				
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void modificarHabitacion(String numero, String pisoNuevo, String capacidadNueva, String precioNuevo, String disponible) {
try {
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			
			String instruccionSQL = null;
			if(disponible != null) {

				instruccionSQL = "update sistemahotel.habitacion set disponible='" + disponible + "' where numero = '" + numero +"'";

				statement.executeUpdate(instruccionSQL);
			}
			if(!precioNuevo.equals("")) {
				instruccionSQL = "update sistemahotel.habitacion set precio='" + precioNuevo + "' where numero = '" + numero +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!capacidadNueva.equals("")) {
				instruccionSQL = "update sistemahotel.habitacion set capacidad='" + capacidadNueva + "' where numero = '" + numero +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!pisoNuevo.equals("")) {
				instruccionSQL = "update sistemahotel.habitacion set piso='" + pisoNuevo + "' where numero = '" + numero +"'";
				statement.executeUpdate(instruccionSQL);
			}
			
			
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void agregarEmpleado(Empleado empleadoNuevo) {
try {
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "INSERT INTO sistemahotel.empleado (nombre, apellido, dni, cargo, sueldo, usuario, contraseña) VALUES ('" + empleadoNuevo.getNombre() + "','" + empleadoNuevo.getApellido() + "','" + empleadoNuevo.getDNI() + "','" + empleadoNuevo.getCargo() + "','" + empleadoNuevo.getSueldo() + "','" + empleadoNuevo.getUsuario() + "','" + empleadoNuevo.getContraseña()+ "')";
			
			statement.executeUpdate(instruccionSQL);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
