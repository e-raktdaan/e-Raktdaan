package com.eratkdaan;

import java.io.IOException;
import java.io.PrintWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class StockServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		String action = request.getServletPath();
		
		
		if(action.equals("/find"))
        {
			
			
			try {
				ViewStock(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

        	
        	
        }
		
		if(action.equals("/updatebloodstock"))
        {
			
			
			try {
				updateBloodStock(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			if(action.equals("/deleteBstock"))
	        {
				
				
				deleteBloodStock(request, response); 
				
	        }
			
		

        	
        	
        
        }	

		
		

	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		doGet(request, response);
	}
	
	
	
	
	private void ViewStock(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException
  	{
		response.setContentType("text/html");  
     
        PrintWriter out = response.getWriter();
        
         String city = request.getParameter("city");
       
         Stock s = new Stock(city);

	
  		EraktdaanDao edao = new EraktdaanDao();
  		
  		ArrayList<Stock> list = edao.ViewAllProduct(s);
  		

        	 
        	request.setAttribute("elist", list);
            RequestDispatcher rd= request.getRequestDispatcher("stockview.jsp");
     		rd.include(request, response);   	 
        	 

	
  	}
	
	private void updateBloodStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException 
	{
		response.setContentType("text/html");  
        PrintWriter out =response.getWriter();  
        
        
    	String donorname = request.getParameter("donorname"); 
    	String bgroup = request.getParameter("bgroup"); 
    	String age = request.getParameter("age"); 
    	String quantity = request.getParameter("quantity"); 
    	String donorcity = request.getParameter("donorcity");
    	String email = request.getParameter("email"); 
    	
    	
    	
    	LocalDate today = java.time.LocalDate.now();
    	
    	String currDate = today.toString();

    	    	

				Stock s = new Stock(donorname,bgroup,age,quantity,donorcity,currDate);
			    EraktdaanDao edao = new EraktdaanDao();
				
		      try {
					
		      	int result=edao.insertBloodStock(s,email);
		      	if(result !=0)
		      	{
		      		
		      		out.println("UPDATED");


		      		
		      	}else
		      	{
		      		out.println("not inserted");
		      	}
		      		
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
 	}
	
	


	
	private void deleteBloodStock(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out =response.getWriter();  
		
      
		String email=request.getParameter("email");  
		
		out.print(email);
	    EraktdaanDao edao = new EraktdaanDao();
		
      try {
			
      	int result = edao.removeBloodStock(email);
      	if(result !=0)
      	{
      		
      		out.println("Product Deleted successfully");
      		RequestDispatcher rd= request.getRequestDispatcher("menu.html");
  			rd.include(request, response);
      		
      	}else
      	{
      		out.println("not deleted");
      	}
      		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
  		
 	}
	

	

}
