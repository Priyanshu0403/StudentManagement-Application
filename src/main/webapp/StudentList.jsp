<%@page import="java.util.List"%>
<%@page import ="com.ps.model.Std_Data" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>

	<style>
		.Student-data{
			margin:60px 20px 0px 170px;
		}
		
		.sidebar a.viewStdListButton{
			background-color:black;
		}
	</style>
	
	<link href="bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="row" style="">
	 <%@include file="sideNnavBar.jsp"%>
	<div class="col-md-9 m-5" style="padding-left: 400px ;padding-top:100px">
		<h2>Student List</h2>
  		
		
		<%
			//Retrieves the list of Std_Data objects stored in the session under the key "std_list"
			List<Std_Data> std = (List<Std_Data>) session.getAttribute("std_list");
			if(std != null && !std.isEmpty()) { 
		%>
			<table class="table table-hover border " style="width: 50rem">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">name</th>
						<th scope="col">course</th>
						<th scope="col">fees</th>
						<th scope="col">Edit</th>
						<th scope="col">Delete</th>
					</tr>
				</thead>
				<% for(Std_Data stdl : std) {   //used advance for loop here std1 is a single element in the list obj std %> 
				<tbody>
					<tr>
						<td scope="row"><%= stdl.getId() %></td>
						<td><%= stdl.getName()%> </td>
						<td><%= stdl.getCourse() %>  </td>
						<td><%= stdl.getFees() %>  </td>
						<td><a class="btn btn-warning" href="editStudent?id=<%= stdl.getId() %>">Edit</a></td><!-- Links to an editStudent endpoint, passing the id as a query parameter. -->
						<td><a class="btn btn-danger" href="deleteStudent?id=<%= stdl.getId() %>">Delete</a></td> <!-- Links to a deleteStudent endpoint, passing the id as a query parameter. -->
					</tr>
				</tbody>
				<% } } %>
			</table>
		</div>
	</div>
    <script src="bootstrap.bundle.min.js"></script>
</body>
</html>