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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	     RequestDispatcher rd = request.getRequestDispatcher("./Register.jsp");
	 	 rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
	    String skills = request.getParameter("skills");
		String pwd  = request.getParameter("pwd");
		String role = request.getParameter("role");
		
		String DB_DRIVER = "org.postgresql.Driver";
	    String DB_USER = "neondb_owner";
	    String DB_PWD = "npg_Po13muxOaYrg";
        String DB_URL = "jdbc:postgresql://ep-rough-block-a1s825h6-pooler.ap-southeast-1.aws.neon.tech/neondb";

	        
	        Connection con = null;
	        PreparedStatement ps =null;
	      
	        String msg = "";
	        
	        String qry = "INSERT INTO users(name,email,skills,password,role) values(?,?,?,?,?)";
	        
	        try
	        {
	        	Class.forName(DB_DRIVER);
	        	con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
	        	
	        	ps = con.prepareStatement(qry);
	        	ps.setString(1, name);
	        	ps.setString(2, email);
	        	ps.setString(3, skills);
	        	ps.setString(4, pwd);
	        	ps.setString(5,role);
	            int r  = 	ps.executeUpdate();
	            
	            if(r > 0)
	            {
	            	RequestDispatcher rd = request.getRequestDispatcher("./Login.jsp");
	            	rd.forward(request, response);
	            }
	            else
	            {
	            	msg="<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
	           	          + " Faild to Register"
	         	          + "</div>";
	            	request.setAttribute("msg", msg);
	                RequestDispatcher rd = request.getRequestDispatcher("./Register.jsp");
	                rd.forward(request,response);
	            }
	        	
	        }
	        catch(Exception e)
	        {
	        	msg="<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
	           	          + " Registration Filed"
	         	          + "</div>";
	            	request.setAttribute("msg", msg);
	                RequestDispatcher rd = request.getRequestDispatcher("./Register.jsp");
	                rd.forward(request,response);
	                e.printStackTrace();
	        }
		   finally
		   {
			  
			   try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			   
		   }
		
	        out.close();
		
		
		
		
		
	
	}

}
