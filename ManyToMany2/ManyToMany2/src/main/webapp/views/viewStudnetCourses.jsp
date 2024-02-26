<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="com.example.SpringBootManyToMany.Models.CourseModel" %>
<%@page import="com.example.SpringBootManyToMany.Models.StudentModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Details</title>
</head>
<body>
<center>
    <h1>Course Details</h1>
    <table border="1">
        <tr>
            <th>CourseID</th>
            <th>CourseName</th>
            <th>CourseAge</th>

            <th>Update Course</th>
            <th>Delete Course</th>  </tr>
        <%
            List<CourseModel> courseList = (List<CourseModel>) request.getAttribute("coursesList");
            if (courseList != null) {
                for (CourseModel course : courseList) {
        %>
        <tr>
            <td><%= course.getCourseId() %></td>
            <td><%= course.getCourseName() %></td>
            <td><%= course.getCourseGuide() %></td>


             <td><form action="/updateCourse">
               <input type="hidden" name="CourseId" value="<%= course.getCourseId() %>" >
               <input type="submit" value="Update"></form></td>
             <td><form action="/deleteCourseOfStudent">
                            <input type="hidden" name="id" value="${id}" >

               <input type="hidden" name="CourseId" value="<%= course.getCourseId() %>" >
                <input type="submit" value="Delete"></form></td>

        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No Courses found</td>
        </tr>
        <% } %>

    </table>

       <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
