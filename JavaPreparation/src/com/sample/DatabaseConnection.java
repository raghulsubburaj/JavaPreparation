package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	public Connection databaseConnection() {

		Connection c = null;

		try {

			Class.forName("org.postgresql.Driver");

			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cxc_phase2", "cxcuser", "P@ssw0rd");

			System.out.println("Opened database successfully");

		} catch (ClassNotFoundException e) {

			System.out.println(e);
		} catch (SQLException e) {

			System.out.println("Connection failed: " + e);
		}

//		try {
//			c.close();
//		} catch (SQLException e) {
//			
//			System.out.println(e);
//		}

		return c;
	}
}
