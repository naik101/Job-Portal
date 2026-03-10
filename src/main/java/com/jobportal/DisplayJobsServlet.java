package com.jobportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jobportal.entities.Jobs;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({ "/DisplayJobsServlet", "/displayjob" })
public class DisplayJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         // Configuration details
 		String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	    String DB_USER = "root";
	    String DB_PWD = "root123";
        String DB_URL = "jdbc:mysql://localhost/jobportal";
        
        Connection con = null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        
        String sbtn = request.getParameter("sbtn");
        String jtitle = request.getParameter("jtitle");
        
        String qry = "";
        
        if( sbtn==null || jtitle.isEmpty() || sbtn.equals("Refresh"))
        {
           qry = "SELECT *FROM job ORDER BY job_id";
        }
        else if(sbtn.equals("Search"))
        {
        	 qry = "SELECT *FROM job WHERE title LIKE " + "'%" + jtitle + "%'";
        }
        
        
        List<Jobs> l = new ArrayList<Jobs>();
        
        try
        {
        	Class.forName(DB_DRIVER);
        	con = DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
        	
            ps = con.prepareStatement(qry);
        	rs = ps.executeQuery();
        	
        	
        	while(rs.next())
        	{
        		int job_id = rs.getInt("job_id") ;
        		String title = rs.getString("title");
        		String company = rs.getString("company");
        	    String location = rs.getString("location");
        		double salary = rs.getDouble("salary");
        	    l .add(new Jobs(job_id,title,company,location,salary));

        	    
        	}
        	
        	request.setAttribute("jobs", l );
        	RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
        	rd.forward(request, response);
        	
        	
        	
        }
        catch(Exception e)
        {
        	out.print("Problem while displaying the records!! ");
            e.printStackTrace();        	
        }
        finally
        { 
        	 try
        	 {
				con.close();
				ps.close();
				rs.close();
			 } 
        	 catch (SQLException e) 
        	 {
			
				e.printStackTrace();
			 }
        	 
        	
        }
		
        out.close();
        
        
         
	}

}
