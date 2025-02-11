	package com.ps.dao;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	
	public class ConnectDB{
		public static Connection getConnection() { //here method is create using static keyword  
			//Static: The method can be called without creating an instance of the class 
			//(e.g., ConnectDB.getConnection()).
			Connection conn=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");//Loads the MySQL JDBC driver class at runtime.
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","Priyanshu","1234");
				 System.out.println("Database connected successfully.");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Database connection failed.");
			}
			return conn;
		}
	}
