package com.propertymanagemnt.DB;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBManager {

	public static Connection getConnection() {
		
		String url="jdbc:mysql://localhost:3306/property_management";
		String userName="root";
		String password="root";
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void main(String[] args) {
			Connection con=DBManager.getConnection();
			try {
				System.out.println(con.isClosed());
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	}
}
