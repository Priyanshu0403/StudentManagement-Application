<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blank Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer">
    <link rel="stylesheet" href="bootstrap.min.css">
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            display: flex;
        }
        
        .navbar{
        	position:relative;
        	z-index: 1;
        }

        /* Sidebar styles */
        .sidebar {
            position: fixed;
            top: 30px;
            width: 250px;
            height: 100vh;
            background-color: #343a40;
            color: white;
            padding: 20px;
            box-sizing: border-box;
            display: flex;
            flex-direction: column;
        }

        .sidebar a {
            color: white;
            text-decoration: none;
            padding: 10px 15px;
            margin: 5px 0;
            background-color: #495057;
            border-radius: 5px;
            display: block;
        }

        .sidebar a:hover {
            background-color: #6c757d;
        }

        /* Navbar styles */
        .navbar {
            position: fixed;
            top: 0;
            left: 0;
            width:100%;
            background-color: #212529;
            color: white;
            display: flex;
            align-items: center;
            padding: 10px 20px;
            box-sizing: border-box;
        }

        .navTags a {
            color: white;
            text-decoration: none;
            margin-right: 50px;
            
        }

        .navbar a:hover {
            text-decoration: underline;
        }

        /* Content area styles */
        /* .content {
            margin: 60px 20px 20px 270px;
            padding: 20px;
            box-sizing: border-box;
            background-color: #c5c8ca;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 1);
            flex-grow: 1;
        } */
        
        .LogOutClass a{
        	text-decoration: none;
        	color:white;
        }
        
        
		
        
    </style>
</head>
<body>

	<!-- Navbar -->
    <div class="navbar row">
    	<div class="Header-icon col col-2"><i class="fa-solid fa-graduation-cap"></i></div>
    	<div class="navTags col col-8">
        	<a href="index.html">Home</a>
        	<a href="index.html">Contact Us</a>
        	<a href="index.html">About Us</a>
        </div>
        <div class="LogOutClass col col-2"><a href="logout" class="btn btn-danger ms-5">Logout<i class="fa-solid fa-right-from-bracket"></i></a></div>
    </div>
    <!-- Sidebar -->
    <div class="sidebar">
        <h2>Sidebar</h2>
        <a href="Profile.jsp" class="profileButton">Profile View</a>
        <a href="AddStudent.jsp" class="addButton">Add Student</a>
        <a href="viewStudent" class="viewStdListButton">View Student List</a>
        <a href="Dashboard.jsp" class="dashBoardButton">Dashboard</a>
    </div>


    <!-- Content area -->
 <!--    <div class="content">
        <h1>Welcome To Dashboard</h1>
    </div> -->
    
    

</body>
</html>
