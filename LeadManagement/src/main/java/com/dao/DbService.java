package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbService {
	static Connection con = null;
	private static String user = "root";
	private static String password = "password";
	private static String dbName = "cdacdb";
	static {
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			if (con != null) {
				System.out.println("Connection Established");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//	public DbService() throws SQLException {
//		String url = "jdbc:mysql://localhost:3306/" + dbName;
//		con = DriverManager.getConnection(url, user, password);
//		
//	}

	public static int insertData(int rollno, String sname, String password2, String sdept) throws SQLException {
		String query = "insert into student values (?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, rollno);
		ps.setString(2, sname);
		ps.setString(3, password2);
		ps.setString(4, sdept);
		int i = ps.executeUpdate();
		if (i > 0) {
			System.out.println("Data inserted");
		} else {
			System.out.println("Data insertion Failed!!!!");
		}
		return i;
	}

	public static ResultSet getStudentData() throws SQLException {
		String query = "select * from student";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

}
