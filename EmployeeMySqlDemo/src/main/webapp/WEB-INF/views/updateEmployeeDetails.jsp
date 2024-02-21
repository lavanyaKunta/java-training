<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.EmployeeMySqlDemo.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enter Employee updated details</title>
</head>
<body>
    <h2>Update Result</h2>
        <%
            Employee employ = (Employee) request.getAttribute("updateEmployee");
            if (employ != null) {
        %>
           <form action="/updateEmployeeResults" >
        <input type="hidden" name="id" value="<%= employ.getEmployeeId() %>">
                <label for="fname">Enter Employee Name : </label>
                <input type="text" id="fname" name="employeeName" required><br>
                <label for="role">Enter role:</label>
                <input type="text" id="role" name="employeeRole" required ><br>
                <input type="submit" value="submit">
           </form>

        <%
            } else {
        %>
            <p>No employee found to update with the provided ID</p>
        <%
            }
        %>

         <br><br>
            <h4><a href="index">Home</a></h4>


</body>
</html>
