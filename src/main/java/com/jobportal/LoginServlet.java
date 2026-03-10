package com.jobportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String pwd  = request.getParameter("pwd");
		
		
		    String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
		    String DB_USER = "root";
		    String DB_PWD = "root123";
	        String DB_URL = "jdbc:mysql://localhost/jobportal";
	        
	        
	        Connection con = null;
	        PreparedStatement ps =null;
	        ResultSet rs = null;
	        String msg = "";
	        
	        String qry = "SELECT user_id,name,role FROM user WHERE email=? AND password=?";
	        
	        try
	        {
	        	Class.forName(DB_DRIVER);
	        	con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
	        	
	        	ps = con.prepareStatement(qry);
	        	ps.setString(1,email);
	        	ps.setString(2, pwd);
	            rs  = 	ps.executeQuery();
	            
	            if(rs.next())
	            {
	            	int userId = rs.getInt("user_id");
	            	String name = rs.getString("name");
	            	String role = rs.getString("role");

	            	HttpSession session = request.getSession(true);

	            	session.setAttribute("user_id", userId);
	            	session.setAttribute("username", name);
	            	session.setAttribute("role", role);

	            	RequestDispatcher rd = request.getRequestDispatcher("./displayjob");
	            	rd.forward(request, response);
	            }
	            else
	            {
	            	msg="<div class=\"alert alert-danger text-center mt-2\" role=\"alert\">\r\n"
	           	          + " Login Failed"
	         	          + "</div>";
	            	request.setAttribute("msg", msg);
	                RequestDispatcher rd = request.getRequestDispatcher("./Login.jsp");
	                rd.forward(request,response);
	            }
	        	
	        }
	        catch(Exception e)
	        {
	        	msg="<div class=\"alert alert-danger text-center mt-2\" role=\"alert\">\r\n"
	           	          + " Login Failed"
	         	          + "</div>";
	            	request.setAttribute("msg", msg);
	                RequestDispatcher rd = request.getRequestDispatcher("./Login.jsp");
	                rd.forward(request,response);
	                e.printStackTrace();
	        }
		   finally
		   {
			  
			   try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			   
		   }
		
	        out.close();
		
		
		
		
		
	}

}
