<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 500px;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
            text-align: center;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 28px;
        }

        .btn-container {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .btn {
            width: 100%;
            padding: 14px;
            font-size: 18px;
            font-weight: bold;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn-manage-cars {
            background-color: #007BFF;
            color: white;
        }

        .btn-manage-cars:hover {
            background-color: #0056b3;
        }

        .btn-manage-drivers {
            background-color: #AA60C8;
            color: white;
        }
.btn-manage-customers {
            background-color: #BE5985;
            color: white;
        }
        .btn-manage-bookings {
            background-color: #28a745;
            color: white;
        }
        .btn-manage-drivers:hover {
            background-color: #218838;
        }

        .btn-logout {
            background-color: #dc3545;
            color: white;
            margin-top: 20px;
            margin-left:150px;
             width: 30%;
             align-items:center;
        }

        .btn-logout:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Admin Dashboard</h1>
        <div class="btn-container">
            <button class="btn btn-manage-cars" onclick="location.href='car?action=list'">Manage Cars</button>
            <button class="btn btn-manage-drivers" onclick="location.href='driver?action=list'">Manage Drivers</button>
             <button class="btn btn-manage-bookings" onclick="location.href='booking?action=list'">Manage Bookings</button>
              <button class="btn btn-manage-customers" onclick="location.href='customer?action=list'">Manage customers</button>
            
            <button class="btn btn-logout" onclick="location.href='logout.jsp'">Logout</button>
        </div>
    </div>
</body>
</html>
