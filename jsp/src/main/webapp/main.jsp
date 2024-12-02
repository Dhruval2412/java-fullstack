<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
    }
    label {
        display: block;
        margin-bottom: 10px;
    }
    .button {
        margin-top: 20px;
    }
</style>
</head>
<body>
<form action="Register" method="post">
    <label for="rollno">Roll Number:</label>
    <input type="number" id="rollno" name="rollno" required>
    <p></p>

    <label for="fname">First Name:</label>
    <input type="text" id="fname" name="fname" required>
    <p></p>

    <label for="lname">Last Name:</label>
    <input type="text" id="lname" name="lname" required>
    <p></p>

    <label for="DOB">Date of Birth:</label>
    <input type="date" id="DOB" name="DOB" required>
    <p></p>

    <button type="submit">Submit</button>
</form>

</body>
</html>