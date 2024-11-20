package com.sample;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetEmployee {

	public void getEmployee() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Employee Id : ");

		int empId = scan.nextInt();
		
		 getEmployeeData(empId);

	}

	public void getEmployeeData(int empId) {

		DatabaseConnection con = new DatabaseConnection();
		Connection connection = null;
		connection = con.databaseConnection();

		if (connection != null) {

			String query = "SELECT * FROM employees WHERE empid = ?;";
			

			try {
				PreparedStatement pstate = connection.prepareStatement(query);
				pstate.setInt(1, empId);

				ResultSet rs = pstate.executeQuery();

				while (rs.next()) {

					int employeeId = rs.getInt("empid");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					String dob = rs.getString("dob");
					String maritalStatus = rs.getString("marital_status");
					String fathersName = rs.getString("fathers_name");
					String mothersName = rs.getString("mothers_name");
					String address = rs.getString("address");
					String mobileNumber = rs.getString("mobile_number");
					String status = rs.getString("status");
					String joiningDate = rs.getString("joining_date");

					System.out.println("Employee Id : " + employeeId + ", Employee name : " + name + ", Employee Age : "
							+ age + ", Employee Gender : " + gender + ", Employee DOB : " + dob
							+ ", Employee Marital Status : " + maritalStatus + ", Employee fathers name : "
							+ fathersName + ", Employee mothers name : " + mothersName + ", Employee Address : "
							+ address + ", Employee Mobile number : " + mobileNumber + ", Employee Status : " + status
							+ ", Employee joining Date : " + joiningDate);
				}
			} catch (SQLException e) {

				System.out.println(e);
			}

		}

	}

}
