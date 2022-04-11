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


public class UserServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String action = request.getServletPath();
		
		
		 if(action.equals("/register"))
		{
			 registerPerson(request, response);
		}
		 else if(action.equals("/oregister"))
			{
			 registerOrganisation(request, response);
			}

	}
	

	
	
	private void registerPerson(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
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
    	String dob = request.getParameter("dob"); 
    	    	
		PersonRegister p1 = new PersonRegister(email, password);
		
        EraktdaanDao edao1 = new EraktdaanDao();
        
        ArrayList<PersonRegister> list = null;
  		

			try {
				list = edao1.getUsernamePassword(p1,"registercheck");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(list.size()>=1) {
				out.print("Already Registered User");
			}
			
			if(list.size()==0) 
			{
				PersonRegister p = new PersonRegister(fname,lname,password,gender,email,phone,bgroup,city,dob);
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
	
	private void registerOrganisation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");  
        PrintWriter out =response.getWriter();  
        
        
    	String o_name = request.getParameter("oname"); 
    	String o_type = request.getParameter("otype"); 
    	String password = request.getParameter("password"); 
    	String alternatephone = request.getParameter("alternatephone"); 
    	String email = request.getParameter("email"); 
    	String phone = request.getParameter("phone"); 
    	String ownedBy = request.getParameter("ownedby"); 
    	String city = request.getParameter("city");
    	

    	    	
		PersonRegister p1 = new PersonRegister(email, password);
		
        EraktdaanDao edao1 = new EraktdaanDao();
        
        ArrayList<PersonRegister> list = null;
  		

			try {
				list = edao1.getUsernamePassword(p1,"registercheck");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(list.size()>=1) {
				out.print("Already Registered User");
			}
			
			if(list.size()==0) 
			{
				OrganisationRegister o = new OrganisationRegister(o_name,o_type,ownedBy,password,email,phone,alternatephone,city);
			    EraktdaanDao edao = new EraktdaanDao();
				
		      try {
					
		      	int result=edao.register(o);
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

}
