package com.sample;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.json.JSONObject;

public class GetEmployee {

	public JSONObject getEmployee() {
		
		JSONObject jsonData = new JSONObject();

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Employee Id : ");

		int empId = scan.nextInt();
		
		JSONObject employeeData = getEmployeeData(empId);
		
		//System.out.println(employeeData);

		return employeeData;
		
		

		
		
	}

	public JSONObject getEmployeeData(int empId) {
		
		 JSONObject jObject = new JSONObject();
		 

		DatabaseConnection con = new DatabaseConnection();
		Connection connection = null;
		connection = con.databaseConnection();

		HashMap<String, String> employeeMap = new HashMap<String, String>();

		if (connection != null) {

			String query = "SELECT * FROM employees WHERE empid = ?;";

			try {
				PreparedStatement pstate = connection.prepareStatement(query);
				pstate.setInt(1, empId);

				ResultSet rs = pstate.executeQuery();

				while (rs.next()) {
					
					jObject.put("EmpID", rs.getInt("empID"));
					jObject.put("Name", rs.getString("name"));
					jObject.put("Age", rs.getInt("age"));
					jObject.put("Gender", rs.getString("gender"));
					jObject.put("DOB", rs.getString("dob"));
					jObject.put("MaritalStatus", rs.getString("marital_status"));
					jObject.put("FathersName",  rs.getString("fathers_name"));
					jObject.put("MothersName", rs.getString("mothers_name"));
					jObject.put("Address", rs.getString("address"));
					jObject.put("MobileNumber", rs.getString("mobile_number"));
					jObject.put("Status", rs.getString("status"));
					jObject.put("JoiningDate", rs.getString("joining_date"));
					
					//System.out.println("Get Employee Data in Json : " + jObject);

					/*
					 * int employeeId = rs.getInt("empid"); String name = rs.getString("name"); int
					 * age = rs.getInt("age"); String gender = rs.getString("gender"); String dob =
					 * rs.getString("dob"); String maritalStatus = rs.getString("marital_status");
					 * String fathersName = rs.getString("fathers_name"); String mothersName =
					 * rs.getString("mothers_name"); String address = rs.getString("address");
					 * String mobileNumber = rs.getString("mobile_number"); String status =
					 * rs.getString("status"); String joiningDate = rs.getString("joining_date");
					 */

					/* employeeMap.put("EmpId", String.valueOf(rs.getInt("empid")));
					employeeMap.put("Name", rs.getString("name"));
					employeeMap.put("Age", String.valueOf(rs.getInt("age")));
					employeeMap.put("Gender", rs.getString("gender"));
					employeeMap.put("DOB", rs.getString("dob"));
					employeeMap.put("MaritalStatus", rs.getString("marital_status"));
					employeeMap.put("FathersName", rs.getString("fathers_name"));
					employeeMap.put("MothersName", rs.getString("mothers_name"));
					employeeMap.put("Address", rs.getString("address"));
					employeeMap.put("MobileNumber", rs.getString("mobile_number"));
					employeeMap.put("Status", rs.getString("status"));
					employeeMap.put("JoiningDate", rs.getString("joining_date"));

					//System.out.println(employeeMap.entrySet());
					System.out.println("Employee Details : ");
					for (Map.Entry<String, String> empDetails : employeeMap.entrySet()) {

						System.out.println(empDetails);

					} */

					/*
					 * employeeMap.clear(); System.out.println("After clear Map : " + employeeMap);
					 * 
					 * boolean value = employeeMap.isEmpty();
					 * System.out.println("Check Map is Empty : " + value);
					 * 
					 * HashMap<String, String> cloneEmployeeDetails = (HashMap<String, String>)
					 * employeeMap.clone();
					 * 
					 * System.out.println("Clone Map Employee Details : "); for (Map.Entry<String,
					 * String> cloneEmpDetails : cloneEmployeeDetails.entrySet()) {
					 * 
					 * System.out.println(cloneEmpDetails); }
					 * 
					 * Set<String> setOfKey = employeeMap.keySet();
					 * System.out.println("Return Set of Keys : " + setOfKey);
					 * 
					 * 
					 * 
					 * System.out.println("Employee Id : " + employeeId + ", Employee name : " +
					 * name + ", Employee Age : " + age + ", Employee Gender : " + gender +
					 * ", Employee DOB : " + dob + ", Employee Marital Status : " + maritalStatus +
					 * ", Employee fathers name : " + fathersName + ", Employee mothers name : " +
					 * mothersName + ", Employee Address : " + address +
					 * ", Employee Mobile number : " + mobileNumber + ", Employee Status : " +
					 * status + ", Employee joining Date : " + joiningDate);
					 */
				}
			} catch (SQLException e) {

				System.out.println(e);
			}

		}
		return jObject;

	}

}
