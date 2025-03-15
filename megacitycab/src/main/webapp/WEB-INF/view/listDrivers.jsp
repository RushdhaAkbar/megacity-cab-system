<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MANAGE DRIVERS</title>
    <style>
       
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin-top: 60px;
            color: #333;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        
        .add-button {
            display: inline-block;
            margin: 20px 20px;
            padding: 10px 30px;
            background-color: #A1E3F9;
            color:red;
            font-size: 16px;
            border-radius: 5px;
            text-align: center;
        }

        
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

       
        .action-links a {
            color: #007bff;
            padding: 5px 10px;
            font-size: 14px;
            text-decoration: none;
            border: 1px solid #007bff;
            border-radius: 3px;
        }

        .action-links a:hover {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
    <h2>MANAGE DRIVERS</h2>
    
    
    <div class="add-button">
        <a href="driver?action=add">Add New Driver</a>
    </div>

   
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>License Number</th>
                <th>Phone</th>
                <th>Availability</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="driver" items="${drivers}">
                <tr>
                    <td>${driver.driverID}</td>
                    <td>${driver.name}</td>
                    <td>${driver.licenseNumber}</td>
                    <td>${driver.phoneNumber}</td>
                    <td>${driver.availability}</td>
                    <td class="action-links">
                        <a href="driver?action=view&driverID=${driver.driverID}">View</a> | 
                        <a href="driver?action=delete&driverID=${driver.driverID}" onclick="return confirm('Are you sure?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
