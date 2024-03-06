<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Registration</title>
</head>
<body>
    <h1>Admin Registration</h1>
    <form:form action="registerAdmin" modelAttribute="adminModel">
        <label>AdminId:</label><br>
        <form:input path="adminId"/><br>
        <form:errors path="adminId"/><br>

        <label>Password:</label><br>
        <form:input path="adminPassword"/><br>
        <form:errors path="adminPassword"/><br>

         <input type="submit" value="Register">
    </form:form>
</body>
</html>




