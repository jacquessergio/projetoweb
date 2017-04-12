package br.com.fabricaweb.projetoweb.persistencia.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try{
			
			String driverName = "com.mysql.jdbc.Driver";                        
			 
			Class.forName(driverName);
			
			return  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/fabricaweb", "root", "root");
			
		}catch(SQLException e){
			
			throw new RuntimeException(e);
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

}
