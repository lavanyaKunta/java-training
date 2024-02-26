

<!DOCTYPE html>
<html>
<head>

    <title>Add Course to Student</title>
</head>

<body>
    <h1>Add Course to Student</h1>
    <form action="addToStudentList" >
        <label for="courseId">Course ID:</label>
        <input type="number" id="courseId" name="courseId"><br><br>
         <input type="hidden" id="studentId" name="studentId" value="${id}"><br><br>

        <input type="submit" value="add">
    </form>
</body>

 <h3> <a href="home">Home</a></h3>
 </html>
