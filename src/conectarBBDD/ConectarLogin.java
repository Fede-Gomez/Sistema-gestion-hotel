package conectarBBDD;

import java.sql.*;
import java.util.*;

import habitaciones.*;
import personal.Empleado;

public class ConectarLogin {
	
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
	

	
	
}

	
