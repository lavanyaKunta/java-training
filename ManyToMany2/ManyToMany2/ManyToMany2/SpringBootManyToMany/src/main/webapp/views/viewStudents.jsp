<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="com.example.SpringBootManyToMany.Models.CourseModel" %>
<%@page import="com.example.SpringBootManyToMany.Models.StudentModel" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
</head>
<body>
<center>
    <h1>Student Details</h1>
    <table border="1">
        <tr>
            <th>StudentID</th>
            <th>StudentName</th>
            <th>StudentAge</th>
            <th>Courses</th>
            <th>Add Course</th>
            <th>Update Student</th>
            <th>Delete student</th>
        </tr>
        <%
          List<StudentModel> students = (List<StudentModel>) request.getAttribute("studentList");
         if (students != null) {
                for (StudentModel student : students) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getAge() %></td>

              <td><form action="/viewStudnetCourses">
                  <input type="hidden" name="id" value="<%= student.getId() %>" >
                      <input type="submit" value="viewCourses"></form></td>

             <td><form action="/AddCoursesToStudent">
              <input type="hidden" name="id" value="<%= student.getId() %>" >
            <input type="submit" value="AddCourse"></form></td>

             <td><form action="/updateStudent">
              <input type="hidden" name="id" value="<%= student.getId() %>" >
               <input type="submit" value="UpdateStudent"></form></td>

          <td><form action="/deleteStudent">
                <input type="hidden" name="id" value="<%= student.getId() %>" >
              <input type="submit" value="DeleteStudent"></form></td>


        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No students found</td>
        </tr>
        <% } %>

    </table>
    </h2>${msg}</h2>
       <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
