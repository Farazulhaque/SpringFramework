package com.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.pojo.EmployeePojo;

public interface DbInterface {
	public int insertEmployee(EmployeePojo employeePojo)
			throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;

	public void showEmployeeData() throws SQLException;

	public int authorizeEmployee(EmployeePojo emp)
			throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;

	public void showEmployeeNames() throws SQLException;

	public String encryptPassword(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
