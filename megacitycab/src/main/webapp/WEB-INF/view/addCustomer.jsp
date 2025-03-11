<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Signup</title>
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
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 28px;
        }

        .form-grid {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px 30px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        .form-group label {
            font-size: 16px;
            font-weight: bold;
            color: #333;
            margin-bottom: 8px;
        }

        .form-group input {
            width: 80%;
            padding: 14px;
            border: 2px solid #ccc;
            border-radius: 6px;
            font-size: 16px;
        }

        .form-group input:focus {
            border-color: #007BFF;
            outline: none;
        }

        .btn-primary {
            width: 50%;
            padding: 16px;
            background-color: #007BFF;
            color: white;
            font-size: 18px;
            border: none;
            align:center;
            border-radius: 6px;
            cursor: pointer;
            margin-top: 30px;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Customer Signup</h1>
        <form action="customer?action=add" method="post">
            <div class="form-grid">
                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" id="name" name="name" placeholder="Enter your name ex: John_Dew" required>
                </div>
                 <div class="form-group">
                    <label for="nic">NIC:</label>
                    <input type="nic" id="nic" name="nic" placeholder="Enter your NIC" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" placeholder="Enter your email" required>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" placeholder="Enter your password" required>
                </div>
                
                <div class="form-group">
                    <label for="phoneNumber">Phone Number:</label>
                    <input type="tel" id="phoneNumber" name="phoneNumber" placeholder="Enter your phone number" required>
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" id="address" name="address" placeholder="Enter your address" required>
                </div>
            </div>
            <button type="submit" class="btn-primary">Sign Up</button>
        </form>
    </div>
</body>
</html>
