<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.EmployeeMySqlDemo.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Search Results</title>
</head>
<body>
    <h2>Search Result</h2>
        <%
            Employee employee = (Employee) request.getAttribute("EmployeeSearch");
            if (employee != null) {
        %>
            <p>ID: <%= employee.getEmployeeId() %></p>
            <p>Name: <%= employee.getEmployeeName() %></p>
            <p>Role: <%= employee.getEmployeeRole() %></p>
        <%
            } else {
        %>
            <p>No employee found with the provided ID</p>
        <%
            }
        %>

         <br><br>
            <h4><a href="index">Home</a></h4>


</body>
</html>
