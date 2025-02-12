
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

@WebServlet("/updateStd")
public class updateStudent extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String course = req.getParameter("course");
		int fees = Integer.parseInt(req.getParameter("fees"));
				
		try {
			Connection conn = ConnectDB.getConnection();
			

			PreparedStatement ps = conn.prepareStatement("UPDATE std_data SET FullName = ?, Course = ?, Fees = ? WHERE ID = ?");

			ps.setString(1, name);
			ps.setString(2, course);
			ps.setInt(3, fees);
			ps.setInt(4, id);
			
			int count = ps.executeUpdate();
			
			System.out.println(count);
			
			if(count > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("/Profile.jsp");
				rd.include(req, resp);
			}
			else {
				System.out.println("data not changed");
				RequestDispatcher rd = req.getRequestDispatcher("/editStudent.jsp");
				rd.include(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
