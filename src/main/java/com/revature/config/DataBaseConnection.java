package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBaseConnection {
	 
	 private static Connection connection = null;
	 private DataBaseConnection() {
		 
	 }

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
				connection = DriverManager.getConnection(url,uname,pwd);
			} 
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			}
		return connection;
	}
}