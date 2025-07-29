<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Customer Registration</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 0;
            height: 100vh;
            background-color: navy;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: Arial, sans-serif;
        }

        .container {
            width: 90%;
            max-width: 400px;
            background-color: #ffffff;
            color: #000;
            padding: 25px 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="number"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 1rem;
        }

        input[type="submit"] {
            background-color: navy;
            color: white;
            border: none;
            padding: 12px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-size: 1rem;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: red;
        }

        @media (max-width: 400px) {
            .container {
                padding: 20px 15px;
            }

            input[type="submit"] {
                font-size: 0.95rem;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>New Customer</h2>
        <form action="Validation" method="post">
            <label>Enter Your Name<sup style="color:red">*</sup></label>
            <input type="text" name="name" required>

            <label>Enter Your Phone Number<sup style="color:red">*</sup></label>
            <input type="number" name="contact" required>

            <label>Enter Your Email<sup style="color:red">*</sup></label>
            <input type="email" name="email" required>

            <label>Enter Your Password<sup style="color:red">*</sup></label>
            <input type="password" name="password" required>

            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
