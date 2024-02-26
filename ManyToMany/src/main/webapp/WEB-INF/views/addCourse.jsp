<%@page language="java" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

</body>

    <form action="/courseResults" modelAttribute="courseModel">
         <label for="eid">Enter Course Id:</label>
          <input type="number" id="eid" name="courseId" required><br><br>
          <label for="cname">Enter course Name:</label>
          <input type="text" id="cname" name="courseName" required><br><br>
            <label for="guid">Enter course GuidName:</label>
            <input type="text" id="guid" name="courseGuid" required><br><br>
          <input type="submit" value="submit">
    </form>

          <br><br>
             <h4><a href="index">Home</a></h4>
</body>
</html>


