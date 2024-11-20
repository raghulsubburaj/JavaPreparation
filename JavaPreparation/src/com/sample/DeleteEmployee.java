package com.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {

	public void deleteEmployee() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Employee Id : ");

		int empId = scan.nextInt();

		deleteEmployeeDetails(empId);

	}

	public void deleteEmployeeDetails(int empId) {

		DatabaseConnection con = new DatabaseConnection();
		Connection connection = null;
		connection = con.databaseConnection();

		if (connection != null) {

			String query = "DELETE FROM employees WHERE empid = ?;";

			try {
				PreparedStatement pstate = connection.prepareStatement(query);

				pstate.setInt(1, empId);

				int deleteData = pstate.executeUpdate();

				System.out.println("Deleted Employee Data Successfully : " + deleteData);
			} catch (SQLException e) {
				System.out.println(e);
			}

		}
	}

}
