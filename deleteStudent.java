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

@WebServlet("/deleteStudent")
public class deleteStudent extends HttpServlet{
	@Override
//	here doGet is necessary
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int studentId = Integer.parseInt(req.getParameter("id"));
        
        try {
            Connection conn = ConnectDB.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("DELETE FROM std_data WHERE id = ?");
            ps.setInt(1, studentId);
            
            int count = ps.executeUpdate();
            
            if (count > 0) {
            	RequestDispatcher rd = req.getRequestDispatcher("/AddStudent.jsp");
				rd.forward(req, resp);
            } else {
            	RequestDispatcher rd = req.getRequestDispatcher("/StudentList.jsp");
				rd.forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}