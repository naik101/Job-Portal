package com.jobportal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({ "/ApplyServlet", "/apply" })
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("./Login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    HttpSession session = request.getSession(false);

	    if(session == null || session.getAttribute("user_id") == null)
	    {
	        response.sendRedirect("Login.jsp");
	        return;
	    }

	    int user_id = (int) session.getAttribute("user_id");
	    int job_id = Integer.parseInt(request.getParameter("job_id"));

	    String DB_DRIVER = "org.postgresql.Driver";
	    String DB_USER = "neondb_owner";
	    String DB_PWD = "npg_Po13muxOaYrg";
        String DB_URL = "jdbc:postgresql://ep-rough-block-a1s825h6-pooler.ap-southeast-1.aws.neon.tech/neondb";


	    String qry = "INSERT INTO application(user_id,job_id) VALUES(?,?)";
	    String msg = "";

	    PreparedStatement ps = null;
	    Connection con = null;

	    try
	    {
	        Class.forName(DB_DRIVER);
	        con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);

	        ps = con.prepareStatement(qry);
	        ps.setInt(1, user_id);
	        ps.setInt(2, job_id);

	        int rows = ps.executeUpdate();

	        if(rows > 0)
	        {
	            msg = "success";
	        }
	        else
	        {
	            msg = "fail";
	        }
	    }
	    catch(Exception e)
	    {
	        msg = "fail";
	        e.printStackTrace();
	    }
	    finally
	    {
	        try
	        {
	            if(ps != null) ps.close();
	            if(con != null) con.close();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }

	    response.sendRedirect("displayjob?msg=" + msg);
	}
}
