<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.OneToMany.entity.Course" %>
<%@ page import="com.example.OneToMany.entity.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Enter Course updated details</title>
</head>
<body>
    <h2>Update Details</h2>
           <form action="/updateCourseResults" >
            <label for="id"> Course Id : </label>
                <input type="number" id="id" name="courseId" value="${id}" readonly><br>
                <label for="name">Enter Course Name : </label>
                <input type="text" id="name" name="courseName" required><br>
                <label for="guid">Enter courseGuid:</label>
                <input type="text" id="guid" name="courseGuid" required ><br>
                <label for="studentId">Enter studentId:</label>
                 <input type="text" id="studentId" name="studentId" %>
                <input type="submit" value="submit">

           </form>


         <br><br>
            <h4><a href="index">Home</a></h4>


</body>
</html>
