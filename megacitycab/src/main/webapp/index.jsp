<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome - Vehicle Booking System</title>
    
    <style>
        
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f4f7fa;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

   
        .container {
            text-align: center;
            background-color: #ffffff;
            padding: 40px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            width: 100%;
            max-width: 400px;
        }

     
        header {
            margin-bottom: 40px;
        }

        header h1 {
            font-size: 2.5rem;
            color: #2e5c9e;
            margin-bottom: 10px;
        }

        header p {
            font-size: 1rem;
            color: #777;
        }

      
        .buttons-container {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .button {
            text-decoration: none;
            padding: 15px 30px;
            font-size: 1.1rem;
            color: #fff;
            background-color: #2e5c9e;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 100%;
            text-align: center;
        }

        .button:hover {
            background-color: #1f4c7f;
        }

        .secondary {
            background-color: #f0b03d;
        }

        .secondary:hover {
            background-color: #d18a2d;
        }

       
        footer {
            margin-top: 30px;
            font-size: 0.9rem;
            color: #aaa;
        }
    </style>
</head>
<body>
    <div class="container">
        <header>
            <h1>MegaCity Cab Booking System</h1>
            <p>Your trusted platform for vehicle bookings</p>
        </header>

        <div class="buttons-container">
            <a href="login.jsp" class="button">Login</a>
            <a href="customer?action=add" class="button secondary">Register</a>
        </div>
        
        <footer>
            <p>&copy; 2025 Vehicle Booking System. All Rights Reserved.</p>
        </footer>
    </div>

    <script>
        // You can add JavaScript here if needed
        console.log("Welcome to the Vehicle Booking System!");
    </script>
</body>
</html>
