package com.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AddEmployee {

	static List<String> employeeList = new ArrayList<String>();

	public void addEmployee() {

		Scanner scan = new Scanner(System.in);

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

		employeeList.add(name);
		employeeList.add(String.valueOf(age));
		employeeList.add(gender);
		employeeList.add(dob);
		employeeList.add(marital_status);
		employeeList.add(father_name);
		employeeList.add(mothers_name);
		employeeList.add(address);
		employeeList.add(mobile_number);
		employeeList.add(joining_date);

		System.out.println(employeeList);

		/*
		 * addEmployeeData(name, age, gender, dob, marital_status, father_name,
		 * mothers_name, address, mobile_number, joining_date);
		 */

		addEmployeeData();

		// System.out.println("Employee Added Successfully");
		/*
		 * System.out.println("Employee name : " + name + ", Employee Age : " + age +
		 * ", Employee Gender : " + gender + ", Employee DOB : " + dob +
		 * ", Employee Marital Status : " + marital_status +
		 * ", Employee fathers name : " + father_name + ", Employee mothers name : " +
		 * mothers_name + ", Employee Address : " + address +
		 * ", Employee Mobile number : " + mobile_number + ", Employee joining Date : "
		 * + joining_date);
		 */

	}

	/*
	 * public void addEmployeeData(String name, int age, String gender, String dob,
	 * String marital_status, String father_name, String mothers_name, String
	 * address, String mobile_number, String joining_date)
	 */
	public void addEmployeeData() {
		DatabaseConnection con = new DatabaseConnection();
		Connection connection = null;
		connection = con.databaseConnection();

		if (connection != null) {

			String query = "INSERT INTO employees (name, age, gender, dob, marital_status, fathers_name, mothers_name, address, mobile_number, joining_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			try {
				PreparedStatement pstate = connection.prepareStatement(query);

				/*
				 * pstate.setString(1, name); pstate.setInt(2, age); pstate.setString(3,
				 * gender); pstate.setString(4, dob); pstate.setString(5, marital_status);
				 * pstate.setString(6, father_name); pstate.setString(7, mothers_name);
				 * pstate.setString(8, address); pstate.setString(9, mobile_number);
				 * pstate.setString(10, joining_date);
				 */

				pstate.setString(1, employeeList.get(0));
				pstate.setInt(2, Integer.parseInt(employeeList.get(1)));
				pstate.setString(3, employeeList.get(2));
				pstate.setString(4, employeeList.get(3));
				pstate.setString(5, employeeList.get(4));
				pstate.setString(6, employeeList.get(5));
				pstate.setString(7, employeeList.get(6));
				pstate.setString(8, employeeList.get(7));
				pstate.setString(9, employeeList.get(8));
				pstate.setString(10, employeeList.get(9));

				int insertData = pstate.executeUpdate();

				System.out.println("Employee data successfully insert : " + insertData);

				System.out.println("Employee Added Successfully");

				/*
				 * System.out.println("Employee name : " + name + ", Employee Age : " + age +
				 * ", Employee Gender : " + gender + ", Employee DOB : " + dob +
				 * ", Employee Marital Status : " + marital_status +
				 * ", Employee fathers name : " + father_name + ", Employee mothers name : " +
				 * mothers_name + ", Employee Address : " + address +
				 * ", Employee Mobile number : " + mobile_number + ", Employee joining Date : "
				 * + joining_date);
				 */

			} catch (SQLException e) {

				System.out.println(e);
			}

			try {
				connection.close();
			} catch (SQLException e) {

				System.out.println(e);
			}

		}

	}
}
