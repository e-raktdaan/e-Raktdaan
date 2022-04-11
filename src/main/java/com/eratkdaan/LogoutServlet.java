package com.eratkdaan;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the print writer object to write into the response
        PrintWriter out = response.getWriter();
  
        // Set the content type of response to "text/html"
        response.setContentType("text/html");

        RequestDispatcher rd= request.getRequestDispatcher("one.html");
        rd.include(request, response);
        
        HttpSession session1=request.getSession();  
        session1.invalidate();  
        
        out.print("You are successfully logged out!");  
        
        out.close();

 
        

  
  

	}

}
