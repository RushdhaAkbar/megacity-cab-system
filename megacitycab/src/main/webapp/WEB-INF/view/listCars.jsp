<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car List</title>
    <style>
        /* Basic layout */
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

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        /* Container styling */
        .table-container {
            width: 80%;
            max-width: 900px;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
            text-align: center;
        }

        /* Table styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
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

        /* Button styling */
        .action-btn {
            padding: 8px 15px;
            border: none;
            border-radius: 5px;
            color: white;
            font-size: 14px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin: 5px;
        }

        .view-btn {
            background-color: #007bff;
        }

        .view-btn:hover {
            background-color: #0056b3;
        }

        .update-btn {
            background-color: #28a745;
        }

        .update-btn:hover {
            background-color: #218838;
        }

        .delete-btn {
            background-color: #dc3545;
        }

        .delete-btn:hover {
            background-color: #c82333;
        }

        .add-btn {
            background-color: #17a2b8;
            padding: 10px 20px;
            margin-top: 15px;
        }

        .add-btn:hover {
            background-color: #138496;
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
                            <a href="car?action=view&carID=${car.carID}" class="action-btn view-btn">View</a>
                            <a href="car?action=update&carID=${car.carID}" class="action-btn update-btn">Update</a>
                            <a href="car?action=delete&carID=${car.carID}" class="action-btn delete-btn" onclick="return confirm('Are you sure you want to delete this car?');">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="car?action=add" class="action-btn add-btn">Add New Car</a>
    </div>
</body>
</html>






