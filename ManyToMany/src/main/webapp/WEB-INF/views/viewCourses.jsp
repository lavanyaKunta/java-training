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
            <th>Add Student</th>
             <th>view Students</th>
             <th>update Course</th>
            <th>Delete</th>



        </tr>
        <%
            // Assuming employees is a List<Employee> attribute in the model
            List<Course> courses = (List<Course>) request.getAttribute("courses");
            for (Course course : courses) {

        %>
        <tr>
            <td><%= course.getCourseId() %></td>
            <td><%= course.getCourseName() %></td>
            <td><%= course.getCourseGuid() %></td>

            <td>
              <form action="/addStudentToCourse">
               <input type="hidden" name="courseId" value="<%= course.getCourseId() %>">
               <input type="submit" value="addStudent">
               </form>
            </td>

             <td>
               <form action="/viewCourseStudents">
               <input type="hidden" name="courseId" value="<%= course.getCourseId() %>">
               <input type="submit" value="viewStudents">
               </form>
             </td>
            <td><form action="/updateCourseDetails">
                 <input type="hidden" name="courseId" value="<%= course.getCourseId() %>">
                 <input type="submit" value="updateCourse">
            </form>
            </td>
            <td><form action="/deleteCourse">
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

