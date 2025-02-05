package com.ps.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ps.dao.ConnectDB;

import jakarta.servlet.RequestDispatcher;	
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addStd")
public class AddStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String course=req.getParameter("course");
		String fees=req.getParameter("fees");
		
		try {
			Connection conn= ConnectDB.getConnection();
			
			PreparedStatement ps= conn.prepareStatement("INSERT INTO std_data VALUES (?,?,?,?)");
			
			ps.setString(1,id);
			ps.setString(2,name);
			ps.setString(3,course);
			ps.setString(4,fees);
			
			int count=ps.executeUpdate();
			if (count>0){
				System.out.print("Std Data added successfully");
				
				RequestDispatcher rd= req.getRequestDispatcher("/Dashboard.jsp");
				
				rd.forward(req, resp);
			}else {
				RequestDispatcher rd = req.getRequestDispatcher("/addStudent.jsp");
				rd.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
