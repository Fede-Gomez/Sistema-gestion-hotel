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
	

	public void crearHabitacion( habitacion habitacion) {

	
	try {
		
		conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
		
		statement = conectar.createStatement();
		
		String instruccionSQL = "insert into sistemahotel.habitacion (numero, piso, capacidad, precio, tipo, disponible) values ('" + habitacion.getNumero() + "','" + habitacion.getPiso() + "','" + habitacion.getCapacidad() + "','" + habitacion.getPrecio() + "','" + habitacion.getTipoDeHabitacion()+ "','" + "si" +"')";
		
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
	
	
	public ArrayList<String> buscarHabitacion(String numero, String precio, String capacidad, String piso, String tipo, String disponible) {
		try {

			ArrayList<String> habitaciones = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.habitacion where numero = '" + numero.trim().toLowerCase() + "' or precio = '" + precio.trim().toLowerCase() + "' or capacidad = '" + capacidad.trim().toLowerCase() +"' or piso = '" + piso.trim().toLowerCase() + "' or tipo='" + tipo.trim().toLowerCase() + "' or disponible='" + disponible.trim().toLowerCase() + "'";
			
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
	

	public ArrayList<String> listarEmpleados() {
		
try {
			
			ArrayList<String> empleados = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.empleado";
			
			resultset = statement.executeQuery(instruccionSQL);
			
			while(resultset.next()) {
				empleados.add(resultset.getString("nombre"));
				empleados.add(resultset.getString("apellido"));
				empleados.add(resultset.getString("dni"));
				empleados.add(resultset.getString("cargo"));
				empleados.add(resultset.getString("sueldo"));
				empleados.add(resultset.getString("usuario"));
			}
				
				
				
				return empleados;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	public ArrayList<String> buscarEmpleado(String nombre, String apellido, String sueldo, String cargo, String usuario){
		try {
			ArrayList<String> empleados = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.empleado where nombre = '" + nombre.trim().toLowerCase() + "' or apellido = '" + apellido.trim().toLowerCase() + "' or sueldo = '" + sueldo.trim().toLowerCase() +"' or cargo = '" + cargo.trim().toLowerCase() + "' or usuario='" + usuario.trim().toLowerCase() + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
					empleados.add(resultset.getString("nombre"));
					empleados.add(resultset.getString("apellido"));
					empleados.add(resultset.getString("dni"));
					empleados.add(resultset.getString("cargo"));
					empleados.add(resultset.getString("sueldo"));
					empleados.add(resultset.getString("usuario"));
			}
				
				
				
				return empleados;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	return null;
	}
	
	
	
	
}

	
