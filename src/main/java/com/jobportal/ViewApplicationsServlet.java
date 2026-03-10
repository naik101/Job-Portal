package com.jobportal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.entities.Application;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewapplications")
public class ViewApplicationsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Application> applications = new ArrayList<>();

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/jobportal",
					"root",
					"root123");

			String qry = "SELECT a.application_id, u.name, u.email, u.skills, j.title, j.company "
					+ "FROM application a "
					+ "JOIN user u ON a.user_id = u.user_id "
					+ "JOIN job j ON a.job_id = j.job_id";

			PreparedStatement ps = con.prepareStatement(qry);

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				Application app = new Application();

				app.setApplicationId(rs.getInt("application_id"));
				app.setName(rs.getString("name"));
				app.setEmail(rs.getString("email"));
				app.setSkills(rs.getString("skills"));
				app.setTitle(rs.getString("title"));
				app.setCompany(rs.getString("company"));

				applications.add(app);
			}

			request.setAttribute("applications", applications);

			RequestDispatcher rd = request.getRequestDispatcher("ViewApplications.jsp");
			rd.forward(request, response);

			rs.close();
			ps.close();
			con.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}