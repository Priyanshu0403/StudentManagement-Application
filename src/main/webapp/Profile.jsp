<%@page import="com.ps.model.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    
    <style>
    	.StudentData{
    		margin:60px 20px 0px 170px;
    	}
    	
    	.sidebar a.profileButton{
			background-color:black;
		}
    </style>
</head>
<body>
<%
Student st = (Student) session.getAttribute("std_session");  //here in this jsp file the data is fetched from Login.java file
//Retrieves the Student object stored in the session under the key "std_session".
%>
	<%@include file="sideNnavBar.jsp" %>
    <div class="container">
    	<div class="StudentData">
        	<h2>Hello There : <%=st.getName() %></h2> 
        	<h3>Email id : <%=st.getEmail() %></h3>
        	<h3>Phone Number : <%=st.getPhone() %></h3>
        </div>
    </div>
</body>
</html>