package com.sample;

import java.util.Scanner;

public class Employee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scann = new Scanner(System.in);

		System.out.println("1. Add Employee");
		System.out.println("2. Get Employee Data");
		System.out.println("3. Delete Employee");
		System.out.println("4. Update Employee");
		int input = scann.nextInt();

		AddEmployee addEmployee = new AddEmployee();
		GetEmployee getEmployee = new GetEmployee();
		UpdateEmployee updateEmployee = new UpdateEmployee();
		DeleteEmployee deleteEmployee = new DeleteEmployee();
		switch (input) {

		case 1:

			addEmployee.addEmployee();
			//System.out.println("Added Employee details successfully");
			break;

		case 2:
			getEmployee.getEmployee();
			// System.out.println("Get Employee details successfully");
			break;

		case 3:
			deleteEmployee.deleteEmployee();
			//System.out.println("Delete Employee details succesfully");
			break;
		case 4:
			updateEmployee.updateEmployeeData();
			// System.out.println("Update Employee details succesfully");
			break;
		default:
			System.out.println("Enter invvalid Input");

		}

	}

}