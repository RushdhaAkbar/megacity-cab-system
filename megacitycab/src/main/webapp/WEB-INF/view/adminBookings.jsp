<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Bookings</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h2 {
            text-align: center;
            margin-top: 20px;
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
        select, button {
            padding: 5px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <h2>Manage Bookings</h2>
    
    <table>
        <thead>
            <tr>
                <th>Booking ID</th>
                <th>User</th>
                <th>Car</th>
                <th>Pickup</th>
                <th>Destination</th>
                <th>Fare</th>
                <th>Driver</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookings}">
                <tr>
                    <td>${booking.bookingID}</td>
                    <td>${booking.userID}</td>
                    <td>${booking.carID}</td>
                    <td>${booking.pickup}</td>
                    <td>${booking.destination}</td>
                    <td>${booking.fare}</td>
                    <td>${booking.driverID <= 0 ? 'Not Assigned' : booking.driverID}</td>
                    <td>
                        <c:if test="${booking.driverID <= 0}">
                            <form action="booking?action=assignDriver" method="post">
                                <input type="hidden" name="bookingID" value="${booking.bookingID}">
                                <select name="driverID" required>
                                    <option value="">Select Driver</option>
                                    <c:forEach var="driver" items="${drivers}">
                                        <option value="${driver.driverID}">${driver.name}</option>
                                    </c:forEach>
                                </select>
                                <button type="submit">Assign</button>
                            </form>
                        </c:if>
                        <c:if test="${booking.driverID > 0}">
                            Assigned to Driver ${booking.driverID}
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
