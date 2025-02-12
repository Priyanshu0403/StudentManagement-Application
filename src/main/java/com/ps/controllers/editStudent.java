package com.ps.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ps.dao.ConnectDB;
import com.ps.model.Std_Data;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/editStudent")
public class editStudent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int std_Id = Integer.parseInt(req.getParameter("id"));  //converting the string value of id to integer
		//Converts the string id into an integer for use in SQL queries.
		
		try {
			Connection con = ConnectDB.getConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM std_data WHERE id=?");
			ps.setInt(1, std_Id); //here std_Id is the variable declared above
			//which stores the value of the id from the list 
			
		   ResultSet rs=ps.executeQuery();
		   
		   if(rs.next()) {
			   Std_Data sd = new Std_Data();  //import com.ps.model.Std_Data;
			   sd.setId(rs.getInt("Id"));
			   sd.setName(rs.getString("FullName"));
			   sd.setCourse(rs.getString("Course"));
			   sd.setFees(rs.getInt("Fees"));
			   
			   HttpSession session = req.getSession();
			   session.setAttribute("edit_std", sd);
			   
			   RequestDispatcher rd = req.getRequestDispatcher("/editStudent.jsp");
			   rd.forward(req, resp);
			   
		   }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
