package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pojo.EmployeePojo;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class DbService implements DbInterface {
	static Connection con = null;
	private static String user = "root";
	private static String password = "password";
	private static String dbName = "cdacdb";

	// Static block is automatically called
	static {
		try {
			String url = "jdbc:mysql://localhost:3306/" + dbName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Connection Established");
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Driver class not found" + e);
		} catch (SQLException e) {
			System.err.println("SQL Exception while connection");
		}

	}

	@Override
	public int insertEmployee(EmployeePojo employeePojo)
			throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		String query = "insert into Employee(Name, Password, Dept) values(?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, employeePojo.getEmpName());
		preparedStatement.setString(2, encryptPassword(employeePojo.getEmpPassword()));
		preparedStatement.setString(3, employeePojo.getEmpDept());
		int i = preparedStatement.executeUpdate();

		return i;
	}

	@Override
	public void showEmployeeData() throws SQLException {
		Statement stmt = con.createStatement();
		String query = "select * from Employee";
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4)
					+ "\t" + rs.getInt(5));
		}
	}

	@Override
	public int authorizeEmployee(EmployeePojo emp)
			throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
		String query = "update Employee set Status = 1 where Name = ? and Password = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, emp.getEmpName());
		preparedStatement.setString(2, encryptPassword(emp.getEmpPassword()));
		int i = preparedStatement.executeUpdate();

		return i;
	}

	@Override
	public void showEmployeeNames() throws SQLException {
		Statement stmt = con.createStatement();
		String query = "select * from Employee";
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<EmployeePojo> emplist = new ArrayList<EmployeePojo>();
		while (rs.next()) {
			EmployeePojo employeePojo = new EmployeePojo();
			employeePojo.setEmpName(rs.getString(2));
			emplist.add(employeePojo);
		}
		int i = 0;
		while (i < emplist.size()) {
			System.out.println(emplist.get(i).getEmpName());
			i++;
		}
	}

	@Override
	public String encryptPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		/* MessageDigest instance for MD5. */
		MessageDigest m = MessageDigest.getInstance("MD5");

		/* Add plain-text password bytes to digest using MD5 update() method. */
		m.update(password.getBytes());

		/* Convert the hash value into bytes */
		byte[] bytes = m.digest();

		/*
		 * The bytes array has bytes in decimal form. Converting it into hexadecimal
		 * format.
		 */
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}

		/* Complete hashed password in hexadecimal format */
		String encrytedPassword = s.toString();
		return encrytedPassword;
	}

}
