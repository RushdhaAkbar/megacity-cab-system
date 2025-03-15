<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Detail</title>
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
            width: 600px;
            padding: 30px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.15);
        }
        .container h1 {
            text-align: center;
        }
        .details {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Car Details</h1>
        <div class="details">
            <p><strong>Model:</strong> ${car.carModel}</p>
            <p><strong>Color:</strong> ${car.color}</p>
            <p><strong>Seats:</strong> ${car.noOfSeats}</p>
            <p><strong>Availability:</strong> ${car.availability ? 'Available' : 'Not Available'}</p>
        </div>
    </div>
</body>
</html>
