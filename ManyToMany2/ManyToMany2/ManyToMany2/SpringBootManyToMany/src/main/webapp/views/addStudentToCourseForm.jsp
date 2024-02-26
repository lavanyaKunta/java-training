
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<center>
    <h2>Add Student</h2>
    <form action="addStudentToCourseResult">
        <label for="id">Student ID:</label><br>
        <input type="text" id="id" name="id" required><br>
       <input type="hidden" id="cid" name="cid" value="${cid}" required><br>
        <input type="submit" value="Submit" required>
    </form>
           <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
