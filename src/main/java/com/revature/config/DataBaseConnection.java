package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBaseConnection {
	 private static Connection connection = null;

	public static Connection getConnection()
	{
		if (connection == null) 
		{
			
			ResourceBundle rbd = ResourceBundle.getBundle("brms"); 
			String url=rbd.getString("url");
			String uname=rbd.getString("uname");
			String pwd=rbd.getString("pwd");
			try 
			{
				Class.forName(rbd.getString("driver"));
				connection = DriverManager.getConnection (url,uname,pwd);
			} 
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (SQLException e) 
			{
				e.printStackTrace(); 
			}
			}
		return connection;
	}
}










//ResourceBundle rbd = ResourceBundle.getBundle ("brms"); 
//rbd.getString("com.mysql.cj.jdbc.Driver");
//rbd.getString("jdbc:mysql://localhost:3306/brms1");
//rbd.getString("root");
//rbd.getString("root08");




//String driver= "com.mysql.cj.jdbc.Driver";
//String url= "jdbc:mysql://localhost:3306/p0_brms";  
//String uname= "root";
//String pwd ="root08";
