<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank of Roberrs - Dashboard</title>
<style>
    * {
        box-sizing: border-box;
        font-family: 'Poppins', sans-serif;
    }

    body {
        margin: 0;
        padding: 0;
        background-color: #0f1626;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        color: #ffffff;
    }

    .container {
        background-color: rgba(255, 255, 255, 0.05);
        padding: 40px 30px;
        border-radius: 16px;
        backdrop-filter: blur(10px);
        box-shadow: 0 0 15px rgba(0,0,0,0.4);
        width: 400px;
        text-align: center;
    }

    h1, h2, h3 {
        margin-bottom: 15px;
    }

    table {
        margin: 0 auto;
        width: 100%;
    }

    td {
        padding: 10px 0;
    }

    a {
        text-decoration: none;
        color: #fff;
        background-color: navy;
        padding: 10px 15px;
        border-radius: 8px;
        display: block;
        transition: background-color 0.3s ease;
    }

    a:hover {
        background-color: red;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Welcome!!</h1>
        <h2>Bank of Roberrs</h2>
        <h3>Here Is your Choice</h3>
        <table>
            <tr>
                <td><a href="create.jsp">Option 1: Creation of New Account</a></td>
            </tr>
            <tr>
                <td><a href="with.jsp">Option 2: Withdraw Money</a></td>
            </tr>
            <tr>
                <td><a href="Dep.jsp">Option 3: Deposit</a></td>
            </tr>
            <tr>
                <td><a href="Check.jsp">Option 4: Balance Check</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
