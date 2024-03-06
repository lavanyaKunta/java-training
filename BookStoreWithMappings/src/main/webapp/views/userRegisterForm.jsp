<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form:form action="registerUser" modelAttribute="userModel">
        <label >UserId:</label><br>
        <form:input path="userId"/><br>
        <form:errors path="userId" style="color: red;" /><br>

        <label >Password:</label><br>
        <form:input type="password"  path="password"/><br>
         <form:errors path="password" style="color: red;"/><br>

        <label >FirstName:</label><br>
        <form:input path="firstName"/><br>
        <form:errors path="firstName" style="color: red;"/><br>

        <label>Email:</label><br>
        <form:input  path="email"/><br>
        <form:errors path="email" style="color: red;"/><br>

        <label>Phone No:</label><br>
         <form:input path="phoneNo"/><br>
          <form:errors path="phoneNo" style="color: red;"/><br>

        <input type="submit" value="Register">
    </form:form>
</body>
</html>
