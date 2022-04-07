package com.eratkdaan;

import java.io.PrintStream;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;




public class EraktdaanDao {
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eRaktdaan","root","12345678");
			
		
		return con;
		
	}
	
	
	public ArrayList ViewAllProduct(Stock s) throws ClassNotFoundException, SQLException 
	{
		
		Connection con = EraktdaanDao.createConnection();
		String q;
		PreparedStatement pmt;
		if(s.getCity().equals("any")) {
			 q = "select B_Group,Best_Before,City,Phone,Quantity from B_STOCK,USER where B_STOCK.User_ID=USER.User_ID";
			 pmt = con.prepareStatement(q);
		}
		else {
			 q = "select B_Group,Best_Before,City,Phone,Quantity from B_STOCK,USER where B_STOCK.User_ID=USER.User_ID and user.city=?";
				 pmt = con.prepareStatement(q);
				
				pmt.setString(1,s.getCity());
		}

		
		ResultSet rs =pmt.executeQuery();
		
		ArrayList<Stock> list = new ArrayList<>();
		
		Stock s1 =null;
		
			while(rs.next())
			{

				

			  s1= new Stock(rs.getString("B_Stock.B_Group"),rs.getString("B_Stock.Best_Before")
					  
					  ,rs.getString("User.city"),rs.getString("User.Phone"),rs.getInt("B_Stock.Quantity"));
			
			  list.add(s1);
			
			}
		
			return list;
			
	}
	
	
	public  int register(PersonRegister p) throws ClassNotFoundException, SQLException 
	{     
		Connection con = EraktdaanDao.createConnection();
		
		String x = "insert into user (password,city,email,phone) values (?,?,?,?)";
		PreparedStatement pmt = con.prepareStatement(x);
		
		
		pmt.setString(1,p.getPassword());
		pmt.setString(2, p.getCity());
		pmt.setString(3, p.getEmail());
		pmt.setString(4, p.getPhone());
		
		int result1=pmt.executeUpdate();
		
		int result2=0;
		
		if (result1!=0)
		{

		
			String y = "insert into person (UserID,firstName,lastName,bgroup,Gender) values ((select user_Id from user order by user_id desc limit 1),?,?,?,?)";
			PreparedStatement pmt1 = con.prepareStatement(y);
			
			pmt1.setString(1,p.getFname());
			pmt1.setString(2, p.getLname());
			pmt1.setString(3, p.getBgroup());
			pmt1.setString(4, p.getGender());
			
			result2=pmt1.executeUpdate();
		}
		
		return result2;	
	}
	

	
}
