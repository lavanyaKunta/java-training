<%@page language="java" %>
<%@page import="com.example.OneToMany.entity.Student" %>
<%@page import="com.example.OneToMany.entity.Course" %>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
          <h2>course Details Updated Successfully</h2>
          <%
              Course course = (Course) request.getAttribute("course");
              if(course!=null){
               %>

                <table border="1">
                    <tr>
                        <th>Course Id</th>
                        <th>Course Name</th>
                        <th>Course Guid</th>
                    </tr>
                    <tr>
                        <td><%= course.getCourseId() %></td>
                        <td><%= course.getCourseName() %></td>
                        <td><%= course.getCourseGuid() %></td>
                    </tr>
                </table>
                <% }
                else { %>
                <h3>course is not found </h3>
                <% } %>

  <br><br>
       <h4><a href="index">Home</a></h4>


</body>
</html>
