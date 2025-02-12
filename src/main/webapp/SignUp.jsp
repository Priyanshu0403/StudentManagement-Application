<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>SignUp</title>
  <link href="SignUp.css" rel="stylesheet">
  <link href="bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<%@ include file="navbar.html"%>
	<div class="d-flex align-items-center justify-content-center min-vh-75">
	<div class="d-flex align-items-center justify-content-center mt-5 border border-bottom rounded w-25">
  <div class="form-container">
    <h1>SignUp Here</h1>
    <form action="signup" method="post">
      <div class="input-group">
        Full Name: <input type="text"  class="form-control" name="name" placeholder="Enter your full name"/ required>
      </div>
      <div class="input-group">
        Email Id: <input type="email"  class="form-control" name="email" placeholder="Enter your email id"/ required>
      </div>
      <div class="input-group">
        Phone Number: <input type="text" class="form-control" name="phone" placeholder="Enter Phone Number"/>
      </div> 
      <div class="input-group">
        Password: <input type="password" class="form-control" name="pass" placeholder="Enter Password"/required>
      </div>
      <!-- <div class="input-group">
        Gender:
        <select id="gender" name="gender">
          <option>Male</option>
          <option>Female</option>
          <option>Other</option>
        </select>
      </div>
       -->
      <button type="submit">Register</button>   <!-- here i have removed the anchor tag used for the register button with href to the other file -->
      <p>Already have an account? <a href="LogIn.jsp">Login</a></p>
    </form>
    <a href="index.html"><button>Back to Home</button></a>
  </div>
  </div>
  </div>
</body>
</html>
