<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Bank Account</title>
    <!-- Poppins Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            height: 100vh;
            background: linear-gradient(to right, #0f2027, #203a43, #2c5364);
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
            color: #fff;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.1);
            padding: 40px 30px;
            border-radius: 12px;
            backdrop-filter: blur(6px);
            box-shadow: 0 8px 16px rgba(0,0,0,0.3);
            width: 100%;
            max-width: 450px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            font-size: 1.8rem;
        }

        label {
            display: block;
            margin-top: 15px;
            margin-bottom: 5px;
            font-weight: 600;
        }

        input[type="text"],
        input[type="password"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: none;
            font-size: 1rem;
        }

        input[type="submit"] {
            margin-top: 20px;
            width: 100%;
            background-color: #ff4c4c;
            color: white;
            border: none;
            padding: 12px;
            font-size: 1rem;
            border-radius: 6px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #ff0000;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Create New Bank Account</h2>
        <form action="New" method="post">
            <label>Account Holder Name:</label>
            <input type="text" name="accountholder" required>

            <label>Secret Password:</label>
            <input type="password" name="secretpassword" required>

            <label>Initial Deposit Amount (optional):</label>
            <input type="number" name="initialAmount" step="0.01" min="0">

            <input type="submit" value="Create Account">
        </form>
    </div>
</body>
</html>
