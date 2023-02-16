package com.dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

import com.pojo.EmployeePojo;

public interface DbInterface {
	public abstract int insertEmployee(EmployeePojo employeePojo)
			throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;

	public abstract void showEmployeeData() throws SQLException;

	public abstract int authorizeEmployee(EmployeePojo emp)
			throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;

	public abstract void showEmployeeNames() throws SQLException;

	public abstract String encryptPassword(String password)
			throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
