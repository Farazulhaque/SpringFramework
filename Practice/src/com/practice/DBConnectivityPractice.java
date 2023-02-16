package com.practice;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.dao.DbInterface;
import com.dao.DbService;
import com.pojo.EmployeePojo;

public class DBConnectivityPractice {

	public static void main(String[] args) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {

//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cdacdb", "root", "password");// Establishing
//																														// connection
//
//		System.out.println("Connected With the database successfully");

		/*
		 * Statement stmtStatement = connection.createStatement();
		 * 
		 * // The Statement interface provides methods to execute queries with the //
		 * database. The statement interface is a factory of ResultSet i.e. it provides
		 * // factory method to get the object of ResultSet. // If you want to run SQL
		 * query only once then this interface is preferred over // PreparedStatement54
		 * 
		 * // Executing The Statement stmtStatement.
		 * executeUpdate("CREATE TABLE Employee(EmployeeID int, Name varchar(255), Dept varchar(255));"
		 * );
		 * stmtStatement.executeUpdate("insert into Employee values (1, 'Faraz', 'CSE')"
		 * );
		 * 
		 * PreparedStatement stmt =
		 * connection.prepareStatement("insert into Employee values(?,?,?)");
		 * stmt.setInt(1, 2); stmt.setString(2, "Parwez"); stmt.setString(3, "CSE");
		 * stmt.executeUpdate();
		 * 
		 * stmt = connection.prepareStatement("select * from Employee"); ResultSet rs =
		 * stmt.executeQuery(); while (rs.next()) { System.out.println(rs.getInt(1) +
		 * "\t" + rs.getString(2) + "\t" + rs.getString(3)); }
		 */

//		CREATE TABLE Employee(EmployeeID int primary key auto_increment, Name varchar(255), Password varchar(32), Dept varchar(255), Status int default 0);
		Scanner scanner = new Scanner(System.in);
		DbInterface dbService = new DbService();
		int choice;
		do {
			System.out.println("Enter 1 to insert data");
			System.out.println("Enter 2 to view data");
			System.out.println("Enter 3 to authorize user");
			System.out.println("Enter 4 to show Employee Names");
			System.out.println("Enter 5 to quit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.print("Enter Employee Name: ");
				String name = scanner.next();
				scanner.nextLine();
				System.out.print("Enter Employee Password: ");
				String password = scanner.nextLine();
				System.out.print("Enter Employee Department: ");
				String dept = scanner.nextLine();
				EmployeePojo emp = new EmployeePojo();
				emp.setEmpName(name);
				emp.setEmpDept(dept);
				emp.setEmpPassword(password);
				int i = dbService.insertEmployee(emp);
				if (i != 0) {
					System.out.println("Employee Inserted");
				} else {
					System.out.println("Employee Insertion Failed!!!");
				}
				break;
			}
			case 2: {
				dbService.showEmployeeData();
				break;
			}
			case 3: {
				System.out.print("Enter Employee Name: ");
				String name = scanner.next();
				scanner.nextLine();
				System.out.print("Enter Employee Password: ");
				String password = scanner.nextLine();
				EmployeePojo emp = new EmployeePojo();
				emp.setEmpName(name);
				emp.setEmpPassword(password);
				int i = dbService.authorizeEmployee(emp);
				if (i != 0) {
					System.out.println("Employee Authorized");
				} else {
					System.out.println("Employee Authorization Failed!!!");
				}
				break;
			}
			case 4: {
				dbService.showEmployeeNames();
				break;
			}
			default:
				break;
			}
		} while (choice != 5);

	}

}
