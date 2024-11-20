package com.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateEmployee {

	public void updateEmployeeData() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the Employee Id : ");

		int empId = scan.nextInt();

		GetEmployee getEmployee = new GetEmployee();

		getEmployee.getEmployeeData(empId);

		System.out.println("if any details need to update, please enter 1 : ");

		int updateChoice = scan.nextInt();

		switch (updateChoice) {

		case 1:

			System.out.println("Enter the employee name : ");

			String name = scan.next();

			int age;

			do {

				System.out.println("Enter the Age : ");

				age = scan.nextInt();

				if (age > 0) {

					System.out.println("Employee age is : " + age);

				} else {
					System.out.println("Employee age cannot be negative.. Please try again !!");
				}

			} while (age < 0);

			System.out.println("Please Enter Gender : ");

			String gender = scan.next();

			System.out.println("Please Enter DOB : ");

			String dob = scan.next();

			System.out.println("Please Enter Marital Status : ");
			String marital_status = scan.next();

			System.out.println("Please Enter the fathers name  : ");
			String father_name = scan.next();

			System.out.println("Please Enter the mothers name  : ");
			String mothers_name = scan.next();

			System.out.println("Please Enter the Address  : ");
			String address = scan.next();

			System.out.println("Please Enter the mobile number  : ");
			String mobile_number = scan.next();

			System.out.println("Please Enter the joining Date  : ");
			String joining_date = scan.next();

			updateEmployeeDetails(empId, name, age, gender, dob, marital_status, father_name, mothers_name, address,
					mobile_number, joining_date);
			break;

		default:
			System.out.println("Invalid input");
		}

	}

	public void updateEmployeeDetails(int empId, String name, int age, String gender, String dob, String marital_status,
			String father_name, String mother_name, String address, String mobile_number, String joining_data) {

		DatabaseConnection con = new DatabaseConnection();
		Connection connection = null;
		connection = con.databaseConnection();

		if (connection != null) {

			String query = "UPDATE employees SET name = ?, age = ?, gender = ?, dob = ?, marital_status = ?, fathers_name = ?, mothers_name = ?, address = ?, mobile_number = ?, joining_date = ? WHERE empid = ?;";

			try {
				PreparedStatement pstate = connection.prepareStatement(query);

				pstate.setString(1, name);
				pstate.setInt(2, age);
				pstate.setString(3, gender);
				pstate.setString(4, dob);
				pstate.setString(5, marital_status);
				pstate.setString(6, father_name);
				pstate.setString(7, mother_name);
				pstate.setString(8, address);
				pstate.setString(9, mobile_number);
				pstate.setString(10, joining_data);
				pstate.setInt(11, empId);

				int updateData = pstate.executeUpdate();

				System.out.println("Updated Employee Data Successfully : " + updateData);
			} catch (SQLException e) {
				System.out.println(e);
			}

		}
	}

}
