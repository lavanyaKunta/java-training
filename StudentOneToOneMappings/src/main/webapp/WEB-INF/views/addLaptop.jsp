<%@page language="java" %>
<html>
<head>
    <title>Spring MVC Demo</title>
</head>

</body>

    <form action="/laptopResults" >
         <label for="eid">Enter Laptop Id:</label>
          <input type="number" id="eid" name="laptopId" required><br><br>
          <label for="brand">Enter Brand:</label>
          <input type="text" id="brand" name="brand" required><br><br>
            <label for="price">Enter Price:</label>
            <input type="text" id="price" name="price" required><br><br>
             <label for="sid">Enter student Id:</label>
            <input type="text" id="sid" name="student" required><br><br>
          <input type="submit" value="submit">
    </form>

          <br><br>
             <h4><a href="index">Home</a></h4>
</body>
</html>


