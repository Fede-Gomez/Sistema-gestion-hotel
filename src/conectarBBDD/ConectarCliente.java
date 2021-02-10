package conectarBBDD;

import java.sql.*;
import java.util.*;

import clientes.Cliente;

public class ConectarCliente {
	
	private Connection conectar;
	private Statement statement;
	private ResultSet resultset;
	
	public void agregarCliente(Cliente nuevoCliente) {
		try {
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "insert into sistemahotel.cliente (nombre, apellido, dni, celular, email, direccion) values ('" + nuevoCliente.getNombre()
			+ "','" + nuevoCliente.getApellido() + "','" + nuevoCliente.getDni() + "','" + nuevoCliente.getCelular()+ "','"
					+ nuevoCliente.getEmail() + "','" + nuevoCliente.getDireccion() +"')";
			
			statement.executeUpdate(instruccionSQL);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> mostrarCliente(String id, String nombre, String apellido, String dni, String celular, String email, String direccion){
		try {
			ArrayList<String> cliente = new ArrayList<String>();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "select * from sistemahotel.cliente where nombre = '" + nombre.trim().toLowerCase()+ "' or id = '" + id + "' or apellido = '" + apellido.trim().toLowerCase() + "' or dni = '" + dni.trim().toLowerCase() + "' or celular = '" + celular.trim().toLowerCase()+ "' or email = '" + email.trim().toLowerCase() +"' or direccion = '" + direccion.trim().toLowerCase() + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
				
				while(resultset.next()) {
					cliente.add(resultset.getString("id"));
					cliente.add(resultset.getString("nombre"));
					cliente.add(resultset.getString("apellido"));
					cliente.add(resultset.getString("dni"));
					cliente.add(resultset.getString("celular"));
					cliente.add(resultset.getString("email"));
					cliente.add(resultset.getString("direccion"));
			}
				
			resultset.close();
			statement.close();
			conectar.close();
				
				return cliente;
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	return null;
	}
	
	public ArrayList<String> listarClientes(String nombre, String apellido, String dni, String celular, String email, String direccion) {
		
		try {
					
					ArrayList<String> cliente = new ArrayList<String>();
					
					conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
					
					statement = conectar.createStatement();
					
					String instruccionSQL = "select * from sistemahotel.cliente";
					
					resultset = statement.executeQuery(instruccionSQL);
					
					while(resultset.next()) {
						cliente.add(resultset.getString("id"));
						cliente.add(resultset.getString("nombre"));
						cliente.add(resultset.getString("apellido"));
						cliente.add(resultset.getString("dni"));
						cliente.add(resultset.getString("celular"));
						cliente.add(resultset.getString("email"));
						cliente.add(resultset.getString("direccion"));
					}
						
						
						
						return cliente;
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
				return null;
			}
	
	public Cliente buscarCliente(Cliente criterioCliente) {
		
		try {
			
			Cliente clienteBuscado = new Cliente();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();

			String instruccionSQL = "select * from sistemahotel.cliente where nombre = '" + criterioCliente.getNombre().trim().toLowerCase()
																	+ "' and apellido = '" + criterioCliente.getApellido().trim().toLowerCase()
																	+ "' and dni = '" + criterioCliente.getDni() 
																	+ "' and celular = '" + criterioCliente.getCelular()
																	+ "' and email = '" + criterioCliente.getEmail().trim().toLowerCase()
																	+ "' and direccion = '" + criterioCliente.getDireccion().trim().toLowerCase() + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
			while(resultset.next()) {
				clienteBuscado.setId(Integer.parseInt(resultset.getString("id")));
				clienteBuscado.setNombre(resultset.getString("nombre"));
				clienteBuscado.setApellido(resultset.getString("apellido"));
				clienteBuscado.setDni(Integer.parseInt(resultset.getString("dni")));
				clienteBuscado.setCelular(Integer.parseInt(resultset.getString("celular")));
				clienteBuscado.setEmail(resultset.getString("email"));
				clienteBuscado.setDireccion(resultset.getString("direccion"));
			}
				
				
				
				return clienteBuscado;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public Cliente buscarClienteDoc(String doc) {
		
		try {
			
			Cliente clienteBuscado = new Cliente();
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();

			String instruccionSQL = "select * from sistemahotel.cliente where dni = '" + doc + "'";
			
			resultset = statement.executeQuery(instruccionSQL);
			
			while(resultset.next()) {
				clienteBuscado.setId(Integer.parseInt(resultset.getString("id")));
				clienteBuscado.setNombre(resultset.getString("nombre"));
				clienteBuscado.setApellido(resultset.getString("apellido"));
				clienteBuscado.setDni(Integer.parseInt(resultset.getString("dni")));
				clienteBuscado.setCelular(Integer.parseInt(resultset.getString("celular")));
				clienteBuscado.setEmail(resultset.getString("email"));
				clienteBuscado.setDireccion(resultset.getString("direccion"));
			}
				
				
				
				return clienteBuscado;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void modificarCliente(int idCliente, String nombreModificado, String apellidoModificado, String dniModificado, String celularModificado, String emailModificado, String direccionModificado) {
		try {

			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();

			String instruccionSQL = null;
			if(!nombreModificado.equals("")) {
				instruccionSQL = "update sistemahotel.cliente set nombre='" + nombreModificado + "' where id = '" + idCliente +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!apellidoModificado.equals("")) {
				instruccionSQL = "update sistemahotel.cliente set apellido='" + apellidoModificado + "' where id = '" + idCliente +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!dniModificado.equals("")) {
				instruccionSQL = "update sistemahotel.cliente set dni='" + dniModificado + "' where id = '" + idCliente +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!celularModificado.equals("")) {
				instruccionSQL = "update sistemahotel.cliente set celular='" + celularModificado + "' where id = '" + idCliente +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!emailModificado.equals("")) {
				instruccionSQL = "update sistemahotel.cliente set email='" + emailModificado + "' where id = '" + idCliente +"'";
				statement.executeUpdate(instruccionSQL);
			}
			if(!direccionModificado.equals("")) {
				instruccionSQL = "update sistemahotel.cliente set direccion='" + direccionModificado + "' where id = '" + idCliente +"'";
				statement.executeUpdate(instruccionSQL);
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void eliminarCliente(Cliente clienteEliminar) {
		
		
		try {
			
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			
			statement = conectar.createStatement();
			
			String instruccionSQL = "delete from sistemahotel.cliente where id='" + clienteEliminar.getId() + "'";
			
			statement.executeUpdate(instruccionSQL);
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

	
