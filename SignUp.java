package com.ps.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ps.dao.ConnectDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signup")   //this annotation method is mostly used instead of using web.xml file for servlets
public class SignUp extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		PrintWriter out=resp.getWriter();  //to check whether the register button connect us with the server or not
//		out.print("Working");
		
		String uname = req.getParameter("name");
		String uemail = req.getParameter("email");
		String uphone=req.getParameter("phone");
		String upass = req.getParameter("pass");
		
//		System.out.println(uname);  // to check if the program is running or not
//		System.out.println(uemail);
//		System.out.println(uphone);
//		System.out.println(upass);

	
//		out.print(uname);
//		out.print(uemail);
//		out.print(up	hone);
//		out.print(upass);
		
		
		try {
			Connection conn=ConnectDB.getConnection(); 
			PreparedStatement ps= conn.prepareStatement("INSERT INTO registration VALUES(?,?,?,?)"); //if we put variables at place of ? then we can only access single data
			//so used positional parameters
			ps.setString(1,uname);
			ps.setString(2,uemail);
			ps.setString(3,uphone);
			ps.setString(4,upass);
			
			int rowcount=ps.executeUpdate();  //this method will affect the number of row affected
			//this method returns integer 
			
			if(rowcount>0) {
				System.out.print("Registeration Successfull");
				RequestDispatcher rd= req.getRequestDispatcher("/LogIn.jsp");
				rd.include(req, resp);
			}else {
				System.out.print("Registeration failed");
			}
//			
		}catch(Exception e) {
			
		}
	}
}
