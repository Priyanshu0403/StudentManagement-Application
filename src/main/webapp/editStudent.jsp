<%@page import="com.ps.model.Std_Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="bootstrap.min.css">
<style>
	h1{
	color:  #f3971b;
	font-size: 35px;
}
body {
	background-color: rgb(72, 61, 139);
	color: white;
	display: flex;
	
	height: 720px;
	margin: 0;
	font-family: sans-serif;
  }
  
  form{
	color: black;
	
  }
  .form-container {
  	margin-left:35em;
  	margin-top:5em;
	width: 400px;
	text-align: center;
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  
  
  .input-group {
	margin-bottom: 15px;
  }
  
  input[type="text"]
  select {
	height: 30px;
	width: 100%;
	padding: 5px;
	margin-top: 5px;
	border-radius: 5px;
	border: 1px solid #ddd;
  }
  
  button {
	color: #483D8B;
	width: 150px;
	height: 50px;
	border: none;
	border-radius: 10px;
	margin-top: 15px;
  }
  
  button:hover {
	color: red;
  }
  
  p{
	color: black;
  }
  p a {
	color: #ff0080;
  }
  
  a {
	text-decoration: none;
  }
  </style>
</head>
<body>
	<div class="row">
<%@ include file="sideNnavBar.jsp"%>
	
		
		<div>

			<%
			Std_Data st = (Std_Data) session.getAttribute("edit_std"); //page import="com.ps.model.Std_Data"
			%>
				<div class="form-container">
    				<h1>Edit Student</h1>
					<form action="updateStd" method="post" >
						<br/>
    					<div class="input-group">
        					ID: <input type="number"  class="form-control" name="id" required 
        					value="<%=st.getId()%>">
						</div>
						<br/>
      					<div class="input-group">
        					Full Name: <input type="text"  class="form-control" name="name" required value="<%=st.getName()%>">
      					</div>
      					<br/>
      					<div class="input-group">
        					Course: <input type="text" class="form-control" name="course"  required value="<%=st.getCourse()%>">
      					</div> 
      					<br/>
      					<div class="input-group">
        					Fees: <input type="number" class="form-control" name="fees" required value="<%=st.getFees()%>">
      					</div>
      					<br/>
      	 
      					<div class="d-flex justify-content-center">
							<input type="submit" class="btn btn-warning" value="Edit" />
						</div>
					</form>
				</div>
			</div>
	</div>
	<script src="bootstrap.bundle.min.js"></script>
</body>
</html>