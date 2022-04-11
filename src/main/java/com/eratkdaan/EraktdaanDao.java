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


import com.mysql.cj.protocol.Resultset;








public class EraktdaanDao {
	
	//method to create connection to the database
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eRaktdaan","root","12345678");
			
		
		return con;
		
	}
	
	
	
	// method to view blood stock from database
	
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
					  
					  ,rs.getString("User.city"),rs.getString("User.Phone"),rs.getString("B_Stock.Quantity"));
			
			  list.add(s1);
			
			}
		
			return list;
			
	}
	
	
	
	// method to register user into the database
	
	public  int register(PersonRegister p) throws ClassNotFoundException, SQLException 
	{     
		Connection con = EraktdaanDao.createConnection();
		
		String x = "insert into user (password,city,email,phone) values (?,?,?,?)";
		PreparedStatement pmt = con.prepareStatement(x);
		
		
		pmt.setString(1, p.getPassword());
		pmt.setString(2, p.getCity());
		pmt.setString(3, p.getEmail());
		pmt.setString(4, p.getPhone());
		
		int result1=pmt.executeUpdate();
		
		int result2=0;
		
		if (result1!=0)
		{

			String y = "insert into person (UserID,firstName,lastName,bgroup,Gender,DOB) values ((select user_Id from user order by user_id desc limit 1),?,?,?,?,?)";
			PreparedStatement pmt1 = con.prepareStatement(y);
			
			pmt1.setString(1, p.getFname());
			pmt1.setString(2, p.getLname());
			pmt1.setString(3, p.getBgroup());
			pmt1.setString(4, p.getGender());
			pmt1.setString(5, p.getDob());
			
			result2=pmt1.executeUpdate();
		}
		
		return result2;	
	}
	
	
	
	
	//method to validate the user and password from database 
	
	public ArrayList<PersonRegister> getUsernamePassword(PersonRegister p, String s) throws ClassNotFoundException, SQLException 
	{
		Connection con = EraktdaanDao.createConnection();
		
		String q = null;
		PreparedStatement pmt = null;
		
		if(s.equals("logincheck"))
		{
			q = "select email,password from user where email=? and password=?";

			pmt = con.prepareStatement(q);
			
			pmt.setString(1, p.getEmail());
			pmt.setString(2, p.getPassword());
		}
		
		else if(s.equals("registercheck"))
		{
			q = "select email,password from user where email=?";
			pmt = con.prepareStatement(q);
			
			pmt.setString(1, p.getEmail());
		}
		
			
		ResultSet rs =pmt.executeQuery();
		
		ArrayList<PersonRegister> list = new ArrayList<>();

			while(rs.next())
			{
			  p= new PersonRegister(rs.getString("User.email"),rs.getString("User.password"));
			  list.add(p);
			
			}

			return list;
			
	}
	
	//Get User details after login success
	
	public ArrayList<Object> getUserDetails(PersonRegister p) throws ClassNotFoundException, SQLException 
	{
		Connection con = EraktdaanDao.createConnection();
		
		String q = "select firstName,lastName,password,gender,email,phone,bgroup,city,DOB from person,user where user.User_ID=person.UserID and user.email=?";
		
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, p.getEmail());

		ResultSet rs =pmt.executeQuery();
		
		ArrayList<Object> list = new ArrayList<>();
		
		

			while(rs.next())
			{
			  p= new PersonRegister(rs.getString("person.firstName"),rs.getString("person.lastName")
					  ,rs.getString("user.password"),rs.getString("person.gender"),rs.getString("user.email")
					  ,rs.getString("user.phone"),rs.getString("person.bgroup"),rs.getString("user.city"),rs.getString("person.DOB"));
			  list.add(p);
			
			}

			return list;
			
	}
	
	//validate donated blood and update history table
	
	public int validateBlood(DonorHistory dh,String email) throws ClassNotFoundException, SQLException 
	{
		Connection con = EraktdaanDao.createConnection();
		
		int result=0;
		
		String x = "select referenceid from dhistory where referenceid=?";
		PreparedStatement pmt = con.prepareStatement(x);
		
		
		pmt.setString(1, dh.getReferenceId());

		
		ResultSet rs = pmt.executeQuery(); 
		
		if (rs.getFetchSize()!=0)
		{
			String q = "update dhistory set userID=(select User_ID from user where email=?) where referenceid=?";
			
			PreparedStatement pmt1 = con.prepareStatement(q);
			
			pmt1.setString(1,email);
			pmt1.setString(2,dh.getReferenceId() );
;

			
			result=pmt1.executeUpdate();
				
				
		}
		
		return result;
			
	}

// method to register organization

	public int register(OrganisationRegister o) throws ClassNotFoundException, SQLException {
		Connection con = EraktdaanDao.createConnection();
		
		String x = "insert into user (password,city,email,phone) values (?,?,?,?)";
		PreparedStatement pmt = con.prepareStatement(x);
		
		
		pmt.setString(1, o.getPassword());
		pmt.setString(2, o.getCity());
		pmt.setString(3, o.getEmail());
		pmt.setString(4, o.getPhone());
		
		int result1=pmt.executeUpdate();
		
		int result2=0;
		
		if (result1!=0)
		{

			String y = "insert into organisation (UserID,o_name,o_type,owned_by,alternatePhone) values ((select user_Id from user order by user_id desc limit 1),?,?,?,?)";
			PreparedStatement pmt1 = con.prepareStatement(y);
			
			pmt1.setString(1, o.getO_name());
			pmt1.setString(2, o.getO_type());
			pmt1.setString(3, o.getOwnedBy());
			pmt1.setString(4, o.getAlternatePhone());

			
			result2=pmt1.executeUpdate();
		}
		
		return result2;	
	}
	
	
	// Get donor history table
	public ArrayList<Object> getDonorHistory(PersonRegister p) throws ClassNotFoundException, SQLException 
	{
		Connection con = EraktdaanDao.createConnection();
		
		String q = "select ReferenceID, quantity,dcity,ddate,organisationName from dhistory where userid=(select user_Id from user where email=?)";
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, p.getEmail());

		ResultSet rs =pmt.executeQuery();
		
		ArrayList<Object> dhlist = new ArrayList<>();
		
		DonorHistory dh = null;

			while(rs.next())
			{
				dh = new DonorHistory(rs.getString("dhistory.ReferenceID"),rs.getString("dhistory.dcity"),rs.getString("dhistory.ddate"),rs.getString("dhistory.Quantity"),rs.getString("dhistory.OrganisationName"));
			    dhlist.add(dh);
			
			}

			return dhlist;
			
	}
	// method to insert into blood stock by user
	public int insertBloodStock(Stock s,String email) throws ClassNotFoundException, SQLException {
		Connection con = EraktdaanDao.createConnection();
		
		String x = "insert into b_stock (dName,User_ID,B_group,age,quantity,bCity,Best_Before) values (?,(select User_ID from user where email=?),?,?,?,?,?)";
		PreparedStatement pmt = con.prepareStatement(x);
		
		
		pmt.setString(1, s.getDonorName());
		pmt.setString(2, email);
		pmt.setString(3, s.getB_Group());
		pmt.setString(4, s.getAge());
		pmt.setString(5, s.getQuantity());
		pmt.setString(6, s.getCity());
		pmt.setString(7, s.getCurrDate());
		
		int result=pmt.executeUpdate();
	
		return result;	
	}
	
	// method to see updated blood stock by user
	
	public ArrayList<Stock> getBloodStockperson(PersonRegister p) throws ClassNotFoundException, SQLException 
	{
		Connection con = EraktdaanDao.createConnection();
		
		String q = "select dName, B_group,age,quantity,Best_Before,bcity from b_stock where User_ID=(select user_Id from user where email=?);";
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, p.getEmail());

		ResultSet rs =pmt.executeQuery();
		
		ArrayList<Stock> bslist = new ArrayList<>();
		
		Stock bs = null;

			while(rs.next())
			{
				bs = new Stock(rs.getString("b_stock.dName"),rs.getString("b_stock.B_Group"),rs.getString("b_stock.age"),rs.getString("b_stock.quantity"),rs.getString("b_stock.bcity"),rs.getString("b_stock.Best_Before"));
			    bslist.add(bs);
			
			}

			return bslist;
			
	}
	
	// remove from blood stock
	
	public int removeBloodStock(String email) throws ClassNotFoundException, SQLException 
	{
		Connection con = EraktdaanDao.createConnection();
		
		String q = "delete from b_stock where user_id=(select user_id from user where email=?)";
		
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, email);

		
		int result=pmt.executeUpdate();
			
		return result;
			
	}






	

}
