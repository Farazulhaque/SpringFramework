package com.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbService;

/**
 * Servlet implementation class ShowStudentServlet
 */
@WebServlet("/ShowStudentServlet")
public class ShowStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			ResultSet rs = DbService.getStudentData();
			out.println("<table><tr>");
			out.println("<th>" + "RollNo" + "</th>");
			out.println("<th>" + "Name" + "</th>");
			out.println("<th>" + "Password" + "</th>");
			out.println("<th>" + "Department" + "</th>");
			out.println("</tr>");
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getInt(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td>");
				out.println("<td><a href=DeleteStudentServlet?sid="+rs.getInt(1) + ">Delete</a></td>");
				
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
