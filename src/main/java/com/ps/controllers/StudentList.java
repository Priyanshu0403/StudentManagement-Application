package com.ps.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ps.dao.ConnectDB;
import com.ps.model.Std_Data;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewStudent")  //this comes from the sidebar button view student 
public class StudentList extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Std_Data> st1=new ArrayList<Std_Data>();  //imported class from com.ps.model class Std_Data.java
		//ArrayList: Used to dynamically store student data retrieved from the database.

		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM std_data");
			
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				Std_Data stdd= new Std_Data();//this is a java class not a database 
				stdd.setId(rs.getInt("ID"));  //this id names course and fees in get method originally the table variables in database
				stdd.setName(rs.getString("FullName"));
				stdd.setCourse(rs.getString("Course"));
				stdd.setFees(rs.getInt("Fees"));
				
				st1.add(stdd); //The Std_Data object is added to the st1 list.
				
				
			}
			HttpSession session =req.getSession();
	 		session.setAttribute("std_list", st1);//here an id std_list is created which is used in the jsp page while using the session attribute
	 		//the jsp page having this id will now be considered 
	 		
	 		RequestDispatcher rd = req.getRequestDispatcher("/StudentList.jsp");
	 		rd.forward(req, resp);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
