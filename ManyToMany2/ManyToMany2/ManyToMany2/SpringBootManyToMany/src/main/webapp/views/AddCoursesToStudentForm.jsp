
<!DOCTYPE html>
<html>
<head>
    <title>Add Course</title>
</head>
<body>
<center>
    <h2>Enter Course Id Here</h2>
    <form action="AddCoursesToStudentResult">
       <input type="hidden" id="id" name="id" value="${id}"><br>

        <label for="courseId">Course Id:</label><br>
        <input type="number" id="courseId" name="courseId" required><br>


        <input type="submit" value="Submit">
    </form>
           <h3> <a href="home">Home</a></h3>

    </center>
</body>
</html>
