<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #c7254e;
        }
        p {
            background-color: #f5c6cb;
            padding: 10px;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
        }
        a {
            color: #004085;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Error Occurred</h1>
    <p><c:out value="${param.message}"/></p>
    <a href="main.jsp">Go back to Home</a>
    <br><br>
    <p>If the problem persists, please contact <a href="mailto:support@example.com">support</a>.</p>
</body>
</html>