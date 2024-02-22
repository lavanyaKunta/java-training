<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.example.EmployeeMappings.entity.Student" %>

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
            <th>StudentID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
            // Assuming employees is a List<Employee> attribute in the model
            List<Student> students = (List<Student>) request.getAttribute("students");
            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getStudentId() %></td>
            <td><%= student.getStudentName() %></td>
            <td><%= student.getAge() %></td>
            <td>
                 edit
            </td>
            <td>
               delete
            </td>
        </tr>
        <% } %>
    </table>

    <br><br>
    <a href="index">Home</a>
</body>
</html>

