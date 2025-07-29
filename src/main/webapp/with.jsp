<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw Money</title>
<!-- Poppins font -->
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
<style>
    * {
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        background-color: #0f1626;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    .form-container {
        background-color: rgba(255, 255, 255, 0.05);
        padding: 40px 30px;
        border-radius: 15px;
        box-shadow: 0 0 15px rgba(0,0,0,0.4);
        backdrop-filter: blur(10px);
        color: #ffffff;
        width: 400px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-top: 15px;
        font-weight: 500;
    }

    input[type="text"],
    input[type="password"],
    input[type="number"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: none;
        border-radius: 6px;
        font-size: 1rem;
        background-color: #f1f1f1;
    }

    input[type="submit"] {
        width: 100%;
        margin-top: 25px;
        padding: 12px;
        border: none;
        background-color: navy;
        color: white;
        font-size: 1rem;
        border-radius: 6px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: red;
    }

    @media (max-width: 450px) {
        .form-container {
            width: 90%;
            padding: 30px 20px;
        }
    }
</style>
</head>
<body>
    <div class="form-container">
        <h2>Withdraw Funds</h2>
        <form action="withdraw" method="post">
            <label>Account Holder Name:</label>
            <input type="text" name="accountholder" required>

            <label>Account Number:</label>
            <input type="text" name="number" required>

            <label>Secret Password:</label>
            <input type="password" name="secretpassword" required>

            <label>Amount to Withdraw:</label>
            <input type="number" name="amount" step="0.01" min="1" required>

            <input type="submit" value="Withdraw">
        </form>
    </div>
</body>
</html>
