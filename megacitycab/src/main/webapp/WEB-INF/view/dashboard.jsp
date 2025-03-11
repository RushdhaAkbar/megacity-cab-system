<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-align: right;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            font-size: 16px;
        }
        .dashboard-container {
            padding: 20px;
            max-width: 1000px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .dashboard-container h2 {
            text-align: center;
        }
        .cab-card {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 10px;
            border-radius: 5px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .cab-card p {
            margin: 5px 0;
        }
        .book-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .book-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="navbar">
    <span>Welcome, ${loggedInUser.email}</span>
    <a href="logout.jsp">Logout</a>
</div>

<div class="dashboard-container">
    <h2>Available Cabs</h2>

    
    <div class="cab-card">
        <div class="cab-details">
            <p><strong>Cab ID:</strong> 101</p>
            <p><strong>Model:</strong> Toyota Prius</p>
            <p><strong>Available Seats:</strong> 4</p>
        </div>
        <button class="book-button" onclick="window.location.href='bookCab?cabId=101'">Book Now</button>
    </div>

    <div class="cab-card">
        <div class="cab-details">
            <p><strong>Cab ID:</strong> 102</p>
            <p><strong>Model:</strong> Honda Civic</p>
            <p><strong>Available Seats:</strong> 2</p>
        </div>
        <button class="book-button" onclick="window.location.href='bookCab?cabId=102'">Book Now</button>
    </div>

   
</div>

</body>
</html>
