<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.example.ManyToMany.entity.Student" %>

<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    <table border="1">
        <tr>
            <th>StudentID</th>
            <th>Name</th>
            <th>Age</th>
            <th>addCourse</th>
            <th>View Course</th>
            <th>Edit Student</th>
            <th>DeleteStudent</th>
        </tr>
        <%
            // Assuming employees is a List<Employee> attribute in the model
            List<Student> students = (List<Student>) request.getAttribute("students");
            for (Student student : students) {
        %>
        <tr>
            <td><%= student.getStudentId() %></td>
            <td><%= student.getStudentName() %></td>
            <td><%= student.getStudentAge() %></td>
            <td>
                <form action="/addCourseToStudent">
                 <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
                 <input type="submit" value="addCourse">
                 </form>
            </td>
            <td>
                <form action="/viewStudentCourses">
                <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
                 <input type="submit" value="viewCourses">
                 </form>
            </td>
            <td>
                <form action="/updateStudentDetails">
                    <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
                     <input type="submit" value="updateStudent">
                </form>
            </td>
            <td>
               <form action="/deleteStudent">
                <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
                 <input type="submit" value="deleteStudent">
                </form>
            </td>

        </tr>
        <% } %>
    </table>

    <br><br>
    <a href="index">Home</a>
</body>
</html>

