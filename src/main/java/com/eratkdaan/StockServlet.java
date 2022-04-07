package com.eratkdaan;

import java.io.IOException;
import java.io.PrintWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
		
		else if(action.equals("/register"))
		{
			 registerUser(request, response);
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
	
	
	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out =response.getWriter();  
        
      
   

		
        
    	String fname = request.getParameter("fname"); 
    	String lname = request.getParameter("lname"); 
    	String password = request.getParameter("password"); 
    	String gender = request.getParameter("gender"); 
    	String email = request.getParameter("email"); 
    	String phone = request.getParameter("phone"); 
    	String bgroup = request.getParameter("bgroup"); 
    	String city = request.getParameter("city"); 
    	

//		  int pid=Integer.parseInt(request.getParameter("pid"));  
//        String name=request.getParameter("name");  
//        int price=Integer.parseInt(request.getParameter("price")); 
//        int quantity=Integer.parseInt(request.getParameter("quantity")); 
//        int discount=Integer.parseInt(request.getParameter("discount")); 
		
		PersonRegister p = new PersonRegister(fname,lname,password,gender,email,phone,bgroup,city);
	    EraktdaanDao edao = new EraktdaanDao();
		
      try {
			
      	int result=edao.register(p);
      	if(result !=0)
      	{
      		
      		out.println("Registered Successfully, You got a mail very soon");

      		
      	}else
      	{
      		out.println("not inserted");
      	}
      		
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
  		
 	}
	

}
