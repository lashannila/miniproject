package com.student.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentSqlConnection {
	 static Connection conn=null;
	 
	    public static Connection getConnection()
	    {
	        
	        try
	        {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_app_db", "root", "Lashani@07");         
	        }
	        
	        catch(Exception e)
	        {
	            System.out.println(e.getMessage());
	        }

	        return conn;
	    }
	    
	    public static void closeConnection()
	    {
	    	
	        if(conn!=null)
	        {
	        	
	            try 
	            {
	                conn.close();
	            } 
	            
	            catch (SQLException e)
	            {
	                 System.out.println("Something went wrong!!");
	            }
	        }
	    } 
	}
