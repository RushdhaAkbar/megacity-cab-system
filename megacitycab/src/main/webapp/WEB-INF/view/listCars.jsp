<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car List</title>
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
            flex-direction: column;
        }
        .table-container {
            width: 80%;
            margin-top: 30px;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ccc;
        }
        th, td {
            padding: 12px;
            text-align: center;
        }
        .action-btn {
            padding: 10px 20px;
            background-color: #28a745;
            color: white;
            border: none;
            cursor: pointer;
        }
        .action-btn:hover {
            background-color: #218838;
        }
        .delete-btn {
            background-color: #dc3545;
        }
        .delete-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <h1>Manage Cars</h1>
    <div class="table-container">
        <table>
            <thead>
                <tr>
                    <th>Car Model</th>
                    <th>Color</th>
                    <th>Seats</th>
                    <th>Availability</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="car" items="${cars}">
                    <tr>
                        <td>${car.carModel}</td>
                        <td>${car.color}</td>
                        <td>${car.noOfSeats}</td>
                        <td>${car.availability ? 'Available' : 'Not Available'}</td>
                        <td>
                            <button class="action-btn" onclick="location.href='car?action=view&carID=${car.carID}'">View</button>
                            <button class="action-btn" onclick="location.href='car?action=update&carID=${car.carID}'">Update</button>
                            <button class="delete-btn" onclick="location.href='car?action=delete&carID=${car.carID}'">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>
        <button class="action-btn" onclick="location.href='car?action=add'">Add New Car</button>
    </div>
</body>
</html>
