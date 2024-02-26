<%@page language="java" %>
<%@page import="com.example.OneToMany.entity.Student"%>

<html>
<h5>Enter Employee Id to Delete Student</h5>
<form action="/deleteResults" >
    <label for="eid">Enter Student Id:</label>
    <input type="number" id="eid" name="studentId" required><br><br>
    <input type="submit" value="Delete">
  </form>
  <br>
     <a href="index">Home</a>
  </center>
  </html>

