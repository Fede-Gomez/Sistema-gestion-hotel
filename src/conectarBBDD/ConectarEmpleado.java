package conectarBBDD;

import java.sql.*;
import java.util.*;

import clientes.Cliente;
import habitaciones.*;
import personal.Empleado;

public class ConectarEmpleado {
	
	private Connection conectar;
	private Statement statement;
	private ResultSet resultset;
	
	
	
	
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
				empleados.add(resultset.getString("legajo"));
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
	
	

	public ArrayList<String> mostrarEmpleado(String legajo, String nombre, String apellido,String dni, String sueldo, String cargo, String usuario){
		try {
			ArrayList<String> empleados = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.empleado where nombre = '" + nombre.trim().toLowerCase() + "' or legajo = '" + legajo + "' or apellido = '" + apellido.trim().toLowerCase() + "' or dni = '" + dni.trim().toLowerCase()+ "' or sueldo = '" + sueldo.trim().toLowerCase() +"' or cargo = '" + cargo.trim().toLowerCase() + "' or usuario='" + usuario.trim().toLowerCase() + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
					empleados.add(resultset.getString("legajo"));
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
	

	public void modificarEmpleado(int legajoCriterio, String nombreModificado, String apellidoModificado, String dniModificado, String sueldoModificado, String nombreUsuarioModificado, String cargoModificado) {
		try {
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = null;
			if(!nombreModificado.equals("")) {
				instruccionSQL = "update sistemahotel.empleado set nombre='" + nombreModificado + "' where legajo = '" + legajoCriterio +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!apellidoModificado.equals("")) {
				instruccionSQL = "update sistemahotel.empleado set apellido='" + apellidoModificado + "' where legajo = '" + legajoCriterio +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!dniModificado.equals("")) {
				instruccionSQL = "update sistemahotel.empleado set dni='" + dniModificado + "' where legajo = '" + legajoCriterio +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!sueldoModificado.equals("")) {
				instruccionSQL = "update sistemahotel.empleado set sueldo='" + sueldoModificado + "' where legajo = '" + legajoCriterio +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!nombreUsuarioModificado.equals("")) {
				instruccionSQL = "update sistemahotel.empleado set usuario='" + nombreUsuarioModificado + "' where legajo = '" + legajoCriterio +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!cargoModificado.equals("")) {
				instruccionSQL = "update sistemahotel.empleado set cargo='" + cargoModificado + "' where legajo = '" + legajoCriterio +"'";
				statement.executeUpdate(instruccionSQL);
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarEmpleado(String legajo) {
		try {
			
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();

			String instruccionSQL = "delete from sistemahotel.empleado where legajo='" + legajo + "'";
			
			statement.executeUpdate(instruccionSQL);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Empleado buscarEmpleado(Empleado empleadoCriterio) {
		
try {
			
			Empleado empleadoBuscado = new Empleado();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.empleado where legajo = '" + empleadoCriterio.getLegajo()+ "'";;
			resultset = statement.executeQuery(instruccionSQL);
			
			while(resultset.next()) {
				empleadoBuscado.setLegajo(Integer.parseInt(resultset.getString("legajo")));
				empleadoBuscado.setNombre(resultset.getString("nombre"));
				empleadoBuscado.setApellido(resultset.getString("apellido"));
				empleadoBuscado.setDNI(Integer.parseInt(resultset.getString("dni")));
				empleadoBuscado.setCargo(resultset.getString("cargo"));
				empleadoBuscado.setSueldo(Double.parseDouble(resultset.getString("sueldo")) );
				empleadoBuscado.setUsuario(resultset.getString("usuario"));
			}
				
				
				
				return empleadoBuscado;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}

	
