<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import=" com.example.EmployeeMySqlDemo.entity.Employee"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>Employee ID</th>
            <th>Name</th>
            <th>Role</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
            // Assuming employees is a List<Employee> attribute in the model
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            for (Employee employee : employees) {
        %>
        <tr>
            <td><%= employee.getEmployeeId() %></td>
            <td><%= employee.getEmployeeName() %></td>
            <td><%= employee.getEmployeeRole() %></td>
            <td>
                 <form action="/updateEmployeeDetails">
                    <input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
                    <input type="submit" value="edit">
                 </form>
            </td>
            <td>
                <form action="/deleteResults">
                    <input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
                    <input type="submit" value="delete">
                </form>
            </td>
        </tr>
        <% } %>
    </table>

    <br><br>
    <a href="index">Home</a>
</body>
</html>

