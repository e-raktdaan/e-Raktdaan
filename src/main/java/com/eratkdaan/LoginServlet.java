package com.eratkdaan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		

		
		HttpSession session1 = request.getSession();
		
		String email=(String) request.getParameter("email");
		String password=(String) request.getParameter("password");
		
		PersonRegister p = new PersonRegister(email, password);
		
        EraktdaanDao edao = new EraktdaanDao();
        
        ArrayList<PersonRegister> list = null;
  		

			try {
				list = edao.getUsernamePassword(p,"logincheck");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(list.size()>1) {
				out.print("Repeated Email");
			}
            if(list.size()==1) {
            	
            	try {
					loginSucces(request,response,email,password);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
            
            if(list.size()==0) {
            	RequestDispatcher rd = request.getRequestDispatcher("login.html");
                out.println("<div class=\"alert alert-danger\" role=\"alert\">\n"
                		+ "  This is a danger alert—check it out!\n"
                		+ "</div>");
                rd.include(request, response);
			}
			
	
	}
	
	private void loginSucces(HttpServletRequest request, HttpServletResponse response, String email,String password) throws ClassNotFoundException, SQLException, ServletException, IOException
  	{
		response.setContentType("text/html");  
     
        PrintWriter out = response.getWriter();       
       
        PersonRegister p = new PersonRegister(email,password);
	
  		EraktdaanDao edao = new EraktdaanDao();
  		
  		ArrayList<Object> list = edao.getUserDetails(p);
  		ArrayList<Object> dhlist = edao.getDonorHistory(p);
  		ArrayList<Stock> bslist = edao.getBloodStockperson(p);
  		
  		 
        request.setAttribute("elist", list);
        request.setAttribute("dh_elist", dhlist);
        request.setAttribute("bs_elist", bslist);

        RequestDispatcher rd= request.getRequestDispatcher("loginsuccess.jsp");
        rd.include(request, response);  
        

	
  	}
	
	private void loginSuccesOrganisation(HttpServletRequest request, HttpServletResponse response, String email,String password) throws ClassNotFoundException, SQLException, ServletException, IOException
  	{
		response.setContentType("text/html");  
     
        PrintWriter out = response.getWriter();       
       
        PersonRegister p = new PersonRegister(email,password);
	
  		EraktdaanDao edao = new EraktdaanDao();
  		
  		ArrayList<Object> list = edao.getUserDetails(p);

        RequestDispatcher rd= request.getRequestDispatcher("ologinsuccess.jsp");
        rd.include(request, response);  
        

	
  	}




}
