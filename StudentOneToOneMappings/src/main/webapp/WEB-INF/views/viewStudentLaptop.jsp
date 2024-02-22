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
            <th>StudentID</th>
             <th>Name</th>
             <th>Age</th>
            <th>LaptopID</th>
            <th>Brand</th>
            <th>Price</th>
        </tr>
        <%
            // Assuming employees is a List<Employee> attribute in the model
            List<Laptop> laptops = (List<Laptop>) request.getAttribute("laptops");
            if(laptops!=null){
                for (Laptop laptop : laptops) {
                    Student student=laptop.getStudent();
        %>
        <tr>
            <td><%= student.getStudentId() %></td>
            <td><%= student.getStudentName() %></td>
            <td><%= student.getAge() %></td>
            <td><%= laptop.getLaptopId() %></td>
            <td><%= laptop.getBrand() %></td>
            <td><%= laptop.getPrice() %></td>


        </tr>
        <% } }
         else{ %>
         <tr><td>No student laptop details found </td><tr>
            <% } %>
    </table>

    <br><br>
    <a href="index">Home</a>
</body>
</html>

