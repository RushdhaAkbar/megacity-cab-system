<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Bookings</title>
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
        .booking-card {
            border: 1px solid #ddd;
            padding: 15px;
            margin: 10px 0;
            border-radius: 5px;
            background: #f9f9f9;
            text-align: left;
        }
        .no-bookings {
            color: #888;
            font-size: 18px;
        }
    </style>
</head>
<body>

<div class="navbar">
    <span>Welcome, ${loggedInUser.email}</span>
    <a href="dashboard.jsp">Dashboard</a>
    <a href="logout.jsp">Logout</a>
</div>

<div class="dashboard-container">
    <h2>My Bookings</h2>

    <c:choose>
        <c:when test="${not empty bookings}">
            <c:forEach var="booking" items="${bookings}">
                <div class="booking-card">
                    <p><strong>Car ID:</strong> ${booking.carID}</p>
                    <p><strong>Pickup:</strong> ${booking.pickup}</p>
                    <p><strong>Destination:</strong> ${booking.destination}</p>
                    <p><strong>Fare:</strong> ${booking.fare}</p>
                    <p><strong>Status:</strong> ${booking.status}</p>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p class="no-bookings">No bookings found.</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
