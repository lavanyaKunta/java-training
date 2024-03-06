
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Login</title>
</head>
<body>
    <h1>Admin Login</h1>

    <form:form action="adminLogin" modelAttribute="adminModel">
           <label>UserId:</label><br>
           <form:input path="adminId"/><br>
           <form:errors path="adminId" style="color: red;"/><br>

           <label>Password:</label><br>
           <form:input type="password" path="adminPassword"/><br>
           <form:errors path="adminPassword" style="color: red;"/><br>
           <input type="submit" value="login">
        </form:form>
</body>
</html>

