<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>LogIn Page</title>
    <link href="Login.css" rel="stylesheet" />
      <link href="bootstrap.min.css" rel="stylesheet">
    
  </head>
  <body>
  <%@ include file="navbar.html"%>
  <!-- <div class="d-flex align-items-center justify-content-center"> -->
  	<div class="d-flex align-items-center justify-content-center m-5">>
  	<form action="loginServer" method="post">   <!-- here the action value is passed as a @webservelt(/login) -->
    	<div class="loginPage">
      		<div class="login-form">
        		<nav>
          			<h1>Login Here</h1>
          			<br/>
            			Email: <input type="text" name="email" placeholder="Enter Email Id" required/>
            		<br/>
            			Password: <input type="password" name="pass" placeholder="Enter Password" required/>
            		<br />
        		</nav>

        		<div class="button-container">
          			<button type="submit">Login</button>
          			<p>Don't have an account? <a href="SignUp.jsp">SignUp</a></p>
          			<a href="index.html"><button>Back to Home</button></a>
        		</div>
      		</div>


      		<div class="loginImg">
        		<img
          			src="Login Img.png"
          			alt="Login Image"
          			width="500px"
          			height="500px"
        		/>
        
      		</div>
    	</div>
      </form>
      </div>
  	
     </div>
  </body>
</html>
