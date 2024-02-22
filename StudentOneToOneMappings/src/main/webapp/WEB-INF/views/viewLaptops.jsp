<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.example.EmployeeMappings.entity.Laptop" %>
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
            <th>LaptopID</th>
            <th>Brand</th>
            <th>Price</th>
            <th>StudentId</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
            // Assuming employees is a List<Employee> attribute in the model
            List<Laptop> laptops = (List<Laptop>) request.getAttribute("laptops");
            for (Laptop laptop : laptops) {
            Student student=laptop.getStudent();
        %>
        <tr>
            <td><%= laptop.getLaptopId() %></td>
            <td><%= laptop.getBrand() %></td>
            <td><%= laptop.getPrice() %></td>
            <td><%= student != null ? student.getStudentId() : "N/A" %></td>

            <td>
                 <a>edit</a>
            </td>
            <td>
               <a>delete</a>
            </td>
        </tr>
        <% } %>
    </table>

    <br><br>
    <a href="index">Home</a>
</body>
</html>

