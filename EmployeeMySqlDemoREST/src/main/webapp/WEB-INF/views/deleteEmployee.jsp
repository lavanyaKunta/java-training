<%@page language="java" %>
<%@page import="com.example.EmployeeMySqlDemo.entity.Employee"%>

<html>
<h5>Enter Employee Id to Delete Employee</h5>
<form action="/deleteResults" >
    <label for="eid">Enter employee Id:</label>
    <input type="number" id="eid" name="employeeId" required><br><br>
    <input type="submit" value="Delete">
  </form>
  <br>
     <a href="index">Home</a>
  </center>
  </html>

