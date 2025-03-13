<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
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
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            font-size: 16px;
        }
        .dashboard-container {
            padding: 20px;
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .cab-card {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 10px 0;
            border-radius: 5px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: #f9f9f9;
        }
        .cab-card p {
            margin: 5px 0;
        }
        .book-button {
            background-color: #007BFF;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .book-button:hover {
            background-color: #0056b3;
        }
        .no-cars {
            color: #888;
            font-size: 18px;
        }
    </style>
</head>
<body>

<div class="navbar">
    <span>Welcome, ${loggedInUser.email}</span>
    <a href="logout.jsp">Logout</a>
</div>

<div class="dashboard-container">
    <h2>Available Cars</h2>

    <c:choose>
        <c:when test="${not empty cars}">
            <c:forEach var="car" items="${cars}">
                <div class="cab-card">
                    <div class="cab-details">
                        <p><strong>Model:</strong> ${car.carModel}</p>
                        <p><strong>Color:</strong> ${car.color}</p>
                        <p><strong>Seats Available:</strong> ${car.noOfSeats}</p>
                    </div>
                    <button class="book-button"">Book Now</button>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p class="no-cars">No cars available at the moment.</p>
        </c:otherwise>
    </c:choose>

</div>

</body>
</html>
