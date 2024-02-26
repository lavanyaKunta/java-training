
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.example.ManyToMany.entity.Course" %>
<%@ page import="com.example.ManyToMany.entity.Student" %>


<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Course List</title>
</head>
<body>
    <h1>student Course List</h1>
    <table border="1">
        <tr>
            <th>CourseID</th>
            <th>CourseName</th>
            <th>CourseGuid</th>
            <th>Delete</th>



        </tr>
        <%
            List<Course> courses = (List<Course>) request.getAttribute("courses");
            for (Course course : courses) {


        %>
        <tr>
            <td><%= course.getCourseId() %></td>
            <td><%= course.getCourseName() %></td>
            <td><%= course.getCourseGuid() %></td>

            <td><form action="/deleteCourseOfStudent">
             <input type="hidden" name="studentId" value="${id}" >
             <input type="hidden" name="courseId" value="<%= course.getCourseId() %>">
             <input type="submit" value="deleteCourse">
             </form>
            </td>


        </tr>
        <% } %>
    </table>

    <br><br>
    <a href="index">Home</a>
</body>
</html>

