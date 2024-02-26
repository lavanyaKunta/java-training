   <%@page language="java" %>
   <%@ page import="com.example.OneToMany.entity.Student" %>
   <%@ page import="com.example.OneToMany.entity.Course" %>
   <html>
   <head>
       <title>Spring MVC Demo</title>
   </head>

   <body>

       <%
           Course course = (Course) request.getAttribute("course");
             if(course!=null) {
             Student student=course.getStudent();

          %>
             <h1>Course Details</h1>
             <p><strong>Course ID:</strong><%= course.getCourseId() %></p>
              <p><strong>Course Name:</strong> <%= course.getCourseName() %></p>
              <p><strong>Course Guid</strong><%= course.getCourseGuid() %></p>
               <p><strong>Student Id:</strong><%= student.getStudentId() %></p>
          <% } else { %>
                <h2>Course Id already exists!</h2>
                <h3>Try with unique Id</h3>
            <% } %>
           <br><br>
           <h4><a href="index">Home</a></h4>
   </body>
   </html>




