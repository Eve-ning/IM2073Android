<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title><link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div align="center">
    <h1>Employee Register Form</h1>
    <form action="<%= request.getContextPath() %>/register" method="post">
        <table style="with: 80%">
            <tr>
                <td>First Name</td>
                <td><input type="text" itemDetails="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" itemDetails="lastName" /></td>
            </tr>
            <tr>
                <td>UserName</td>
                <td><input type="text" itemDetails="username" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" itemDetails="password" /></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" itemDetails="address" /></td>
            </tr>
            <tr>
                <td>Contact No</td>
                <td><input type="text" itemDetails="contact" /></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>
</body>
</html>