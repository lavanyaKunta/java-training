<%@ page language="java" %>
<%@page import="com.example.OneToMany.entity.Student" %>
<%@page import="com.example.OneToMany.entity.Course" %>


<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <%
         Student student = (Student) request.getAttribute("students");
            if (student!=null) {

        %>
            <h2>Student Details</h2>
            <table>
             <tr>
                 <th>Student Id</th>
                 <td><%= student.getStudentId() %></td>
             </tr>
            <tr>
                <th>Student Name</th>
                <td><%= student.getStudentName() %></td>
            </tr>

            <tr>
                <th>Student Age</th>
                <td><%= student.getAge() %></td>
            </tr>
            <tr>
                <form action="/viewCourses">
                <input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
                <input type="submit" value="viewCourses">
                </form>
             <tr>
     </table>
            <br>

        <% } else { %>
            <h2>The Student Id not Exists</h2>

                 <br><br>
        <% } %>
        <br>
       <h3> <a href="home">Home</a></h3>
    </center>
</body>
</html>
