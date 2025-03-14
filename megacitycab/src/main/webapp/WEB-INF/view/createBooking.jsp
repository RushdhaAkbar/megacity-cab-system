<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Booking</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 400px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        input, button {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
        }
        .calculate-fare {
            background-color: #007BFF;
            color: white;
            cursor: pointer;
        }
        .confirm-booking {
            background-color: #28a745;
            color: white;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Book Your Ride</h2>
    <form action="booking?action=create" method="post">
        <input type="hidden" name="action" value="create">
        <input type="hidden" name="carID" value="${requestScope.carID}">

        
        <label>Pickup Location:</label>
        <input type="text" name="pickup" id="pickup" required>

        <label>Destination:</label>
        <input type="text" name="destination" id="destination" required>

        <label>Estimated Fare:</label>
        <input type="text" name="fare" id="fare" readonly>

        <button type="button" class="calculate-fare" onclick="calculateFare()">Calculate Fare</button>
        <button type="submit" class="confirm-booking">Confirm Booking</button>
    </form>
</div>

<script>
    function calculateFare() {
        let fare = Math.floor(Math.random() * 100) + 50; // Random fare calculation (Replace with API logic)
        document.getElementById("fare").value = fare;
    }
</script>

</body>
</html>
