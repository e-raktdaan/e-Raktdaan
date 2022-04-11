package com.eratkdaan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DonorHistoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");  
        PrintWriter out =response.getWriter();  
        
        
    	String email = request.getParameter("email"); 
    	String referenceid = request.getParameter("referenceid"); 
    	
    	
    	DonorHistory dh = new DonorHistory(referenceid);
        
    	
  		EraktdaanDao edao = new EraktdaanDao();
  		
  		int k=0;
  		
  		try {
  			
			k = edao.validateBlood(dh,email);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		
  		if(k==1)
  		{
  			out.print("Updated");
  		}
    	if(k==0)
    	{
    		out.print("Invalid id");
    	}




	}

}
