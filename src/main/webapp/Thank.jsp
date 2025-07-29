<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Successful</title>
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
        color: #fff;
        text-align: center;
        padding: 20px;
    }

    .message-box {
        background-color: rgba(255, 255, 255, 0.1);
        padding: 40px 30px;
        border-radius: 12px;
        backdrop-filter: blur(6px);
        box-shadow: 0 8px 16px rgba(0,0,0,0.3);
        max-width: 500px;
        width: 90%;
    }

    h1 {
        font-size: 1.8rem;
        margin-bottom: 10px;
    }

    p {
        font-size: 1rem;
        margin-top: 10px;
        color: #dcdcdc;
    }
</style>
</head>
<body>
    <div class="message-box">
        <h1>Thank You!</h1>
        <p>You are now a proud member of <strong>BankRobers</strong>.</p>
    </div>
</body>
</html>
