
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<center>
    <h2>Add Student</h2>
    <form action="addStudentToCourseResult">
        <label for="studentId">Student ID:</label><br>
        <input type="number" id="studentId" name="studentId" required><br>
       <input type="hidden" id="courseId"  value="${cid}" required><br>
        <input type="submit" value="Submit" required>
    </form>
           <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
