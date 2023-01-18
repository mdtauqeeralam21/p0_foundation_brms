package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBaseConnection {
	 static Connection connection = null;
	private DataBaseConnection() 
	{
		
	}

	public static Connection getConnection()
	{
		if (connection == null) 
		{
			
			String driver= "com.mysql.cj.jdbc.Driver";
			String url= "jdbc:mysql://localhost:3306/p0_brms";  
			String uname= "root";
			String pwd ="root08";

			try 
			{
				Class.forName(driver);
				connection = DriverManager.getConnection (url, uname, pwd);
			} 
			catch (SQLException | ClassNotFoundException e) 
			{
				e.printStackTrace(); 
			} 		}
		return connection;
	}
}










//ResourceBundle resourceBundle = ResourceBundle.getBundle ("brms"); 
//resourceBundle.getString("com.mysql.cj.jdbc.Driver");
//resourceBundle.getString("jdbc:mysql://localhost:3306/brms1");
//resourceBundle.getString("root");
//resourceBundle.getString("root08");
