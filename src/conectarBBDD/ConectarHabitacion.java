package conectarBBDD;

import java.sql.*;
import java.util.*;

import clientes.Cliente;
import habitaciones.*;
import personal.Empleado;

public class ConectarHabitacion {
	
	private Connection conectar;
	private Statement statement;
	private ResultSet resultset;
	
	

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
	
	
	public ArrayList<String> buscarHabitaciones(String numero, String precio, String capacidad, String piso, String tipo, String disponible) {
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
	
	public habitacion buscarHabitacionNumero(String num) {
		
		try {

			habitacion habitacion = new habitacion();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.habitacion where numero = '" + num.trim().toLowerCase() + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
					habitacion.setNumero(Short.parseShort(resultset.getString("numero")));
					habitacion.setCapacidad(Short.parseShort(resultset.getString("capacidad")));
					habitacion.setPiso(Short.parseShort(resultset.getString("piso")));
					habitacion.setPrecio(Double.parseDouble(resultset.getString("precio")));
					habitacion.setTipoDeHabitacion(resultset.getString("tipo"));
					habitacion.setDisponible(resultset.getString("disponible"));
			}
				
				return habitacion;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
	
}

	
