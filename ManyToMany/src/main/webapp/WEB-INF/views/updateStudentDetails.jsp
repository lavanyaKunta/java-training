<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ManyToMany.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enter Student updated details</title>
</head>
<body>
    <h2>Update Details</h2>
        <%
            Student student = (Student) request.getAttribute("updateStudent");
            if (student != null) {
        %>
           <form action="/updateStudentResults" >
        <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
                <label for="name">Enter Student Name : </label>
                <input type="text" id="name" name="studentName" required><br>
                <label for="age">Enter Age:</label>
                <input type="text" id="age" name="studentAge" required ><br>
                <input type="submit" value="submit">
           </form>

        <%
            } else {
        %>
            <p>No Student found to update with the provided ID</p>
        <%
            }
        %>

         <br><br>
            <h4><a href="index">Home</a></h4>


</body>
</html>
