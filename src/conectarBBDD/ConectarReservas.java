package conectarBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import clientes.Cliente;
import habitaciones.habitacion;

public class ConectarReservas {

	private Connection conectar;
	private Statement statement;
	private ResultSet resultset;
	
public void reservarHabitacion(Cliente clienteBuscado, habitacion reserva, java.sql.Date fechaIngreso, java.sql.Date fechaEgreso) {
		
		try {
			
			conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
			statement = conectar.createStatement();
			
			String instruccionSQL = "insert into sistemahotel.reservas (docCliente, nombreCliente,numeroHabitacion, tipoHabitacion, precio, fechaIngreso, fechaEgreso)"
					+ " values ('" + clienteBuscado.getDni() + "','" + 	clienteBuscado.getNombre() + "','" + reserva.getNumero() + "','" + 	reserva.getTipoDeHabitacion() + "','" + reserva.getPrecio() + "','" +	fechaIngreso + "','" + 	fechaEgreso +"')";
			
			statement.executeUpdate(instruccionSQL);
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<String> buscarReserva(String numReserva, String docCliente, String nombreCliente) {
			try {

				ArrayList<String> reservas = new ArrayList<String>();
				
				conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306?serverTimezone=UTC","admin","1234");
				
				statement = conectar.createStatement();
				
				String instruccionSQL = "select * from sistemahotel.reservas where numeroReserva = '" + numReserva.trim().toLowerCase() + "' or docCliente = '" + docCliente.trim().toLowerCase() + "' or nombreCliente = '" + nombreCliente.trim().toLowerCase() + "'";
				
				resultset = statement.executeQuery(instruccionSQL);
				
					
					while(resultset.next()) {
						reservas.add(resultset.getString("numeroReserva"));
						reservas.add(resultset.getString("docCliente"));
						reservas.add(resultset.getString("nombreCliente"));
						reservas.add(resultset.getString("numeroHabitacion"));
						reservas.add(resultset.getString("tipoHabitacion"));
						reservas.add(resultset.getString("precio"));
						reservas.add(resultset.getString("fechaIngreso"));
						reservas.add(resultset.getString("fechaEgreso"));
				}
					
					
					
					return reservas;
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
	
}
