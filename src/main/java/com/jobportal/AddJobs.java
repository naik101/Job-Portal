package com.jobportal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({ "/AddJobs", "/addjob" })
public class AddJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if(session == null || !"admin".equals(session.getAttribute("role"))) {
			response.sendRedirect("Login.jsp");
			return;
		}

		String title = request.getParameter("title");
		String company = request.getParameter("company");
		String location = request.getParameter("location");

		double salary = Double.parseDouble(request.getParameter("salary"));

		String DB_DRIVER = "org.postgresql.Driver";
	    String DB_USER = "root";
	    String DB_PWD = "root@123";
        String DB_URL = "jdbc:postgresql://localhost/jobportal";
		try {

			Class.forName(DB_DRIVER);

			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

			String qry = "INSERT INTO job(title,company,location,salary) VALUES(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(qry);

			ps.setString(1, title);
			ps.setString(2, company);
			ps.setString(3, location);
			ps.setDouble(4, salary);

			ps.executeUpdate();

			ps.close();
			con.close();

			response.sendRedirect("displayjob?msg=jobadded");

		} 
		catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("AddJob.jsp?msg=fail");
		}
	}

}
