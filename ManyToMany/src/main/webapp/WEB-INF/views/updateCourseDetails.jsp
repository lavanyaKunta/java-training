<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.ManyToMany.entity.Course" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enter Student updated details</title>
</head>
<body>
    <h2>Update Details</h2>
        <%
            Course course = (Course) request.getAttribute("course");
            if (course != null) {
        %>
           <form action="/updateCourseResults" >
        <input type="hidden" name="courseId" value="<%= course.getCourseId() %>">
                <label for="name">Enter Course Name : </label>
                <input type="text" id="name" name="courseName" required><br>
                <label for="guid">Enter Course Guid:</label>
                <input type="text" id="guid" name="courseGuid" required ><br>
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
