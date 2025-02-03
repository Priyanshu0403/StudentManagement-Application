	package com.ps.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ps.dao.ConnectDB;
import com.ps.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServer")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//doPost: This method is called by the servlet container (e.g., Tomcat) when an HTTP POST request is sent to the servlet.
		
//		PrintWriter out=resp.getWriter();  //to check whether the register button connect us with the server or not
//		out.print("Working"); 
		String email= req.getParameter("email");
		String password= req.getParameter("pass");
		
		try {
			Connection conn = ConnectDB.getConnection();//due to static keyword used for getconnection method the class connectDB has
			//                                          no need top create an instance(object)
			//The Connection object allows SQL queries to be executed.
			
			PreparedStatement ps = conn.prepareStatement("select * from Registration where email=? AND password=?");
			ps.setString(1, email);//this are stored as a name attribute in the login.jsp page
			ps.setString(2, password);
			//These lines extract the email and password values
			//sent by the client (e.g., from a login form).
			
			ResultSet rs = ps.executeQuery();  //this will return boolean value
			//it returns a ResultSet object, which can be used to check if there are ma\
			
			if(rs.next()) {//Moves the cursor to the next row in the ResultSet. If there is at least 
				//one row, it returns true;otherwise, it returns false.
				
				//We want the data of the login user so we used a class Student which is already created in a file Student.java
				Student st=new Student();
				st.setName(rs.getString("name"));
				st.setEmail(rs.getString("email"));
				st.setPhone(rs.getString("phone"));
				//Retrieves the value of the specified column
				//(e.g., name, email, phone) from the current row of the ResultSet and 
				//sets it in the Student object using its setter methods.
				
				
				//after setting the data in st object we created a obj of session 
				HttpSession session= req.getSession();//req.getSession(): Retrieves the current session 
				//										object or creates a new one if it doesn’t exist.
				session.setAttribute("std_session", st);// allows the Student object to be accessed across 
				//										multiple pages until the session ends.

//				session.setAttribute=("std_session",st);  //std_session is a key whihc is to be accessed iin the profile.jsp	
				
				RequestDispatcher rd= req.getRequestDispatcher("/Dashboard.jsp");
				rd.forward(req, resp);	
			}else {
				//out.println("<h3>Email or Password didn't match</h3");
				RequestDispatcher rd= req.getRequestDispatcher("/LogIn.jsp");
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			
		}
	}
}
