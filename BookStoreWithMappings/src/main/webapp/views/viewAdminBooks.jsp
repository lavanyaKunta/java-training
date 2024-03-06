<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="com.example.BookStoreWithMappings.Models.AdminModel" %>
<%@page import="com.example.BookStoreWithMappings.Models.BookModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>view Books</title>
</head>
<body>
<center>
    <h1>Book Details</h1>
    <table border="1">
        <tr>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Book Author</th>
            <th>Book Category</th>
            <th>Book Price</th>
            <th>Book Quantity</th>
            <th>Update Book</th>
            <th>Delete Book</th>
            <th>INC quantity</th>
            <th>DEC quantity</th>
        </tr>
        <%
            List<BookModel> bookList = (List<BookModel>) request.getAttribute("bookList");
            if (bookList != null) {
                for (BookModel book : bookList) {
        %>
        <tr>
            <td><%= book.getBookId() %></td>
            <td><%= book.getBookName() %></td>
            <td><%= book.getBookAuthor() %></td>
            <td><%= book.getBookCategory() %></td>
            <td><%= book.getBookPrice() %></td>
            <td><%= book.getBookQuantity() %></td>


             <td><form action="/updateBook">
                <input type="hidden" name="adminId" value="${adminId}" >
               <input type="hidden" name="bookId" value="<%= book.getBookId() %>" >
               <input type="submit" value="Update"></form>
             </td>
             <td><form action="/deleteBook">
                <input type="hidden" name="adminId" value="${adminId}" >
                 <input type="hidden" name="BookId" value="<%= book.getBookId() %>" >
                <input type="submit" value="Delete"></form>
             </td>
              <td><form action="/increaseBookQuantity">

                <input type="hidden" name="adminId" value="${adminId}" >
                 <input type="hidden" name="bookId" value="<%= book.getBookId() %>" >
                  <input type="submit" value="INC"></form>
              </td>
              <td><form action="/decreaseBookQuantity">
                <input type="hidden" name="adminId" value="${adminId}" >
                  <input type="hidden" name="bookId" value="<%= book.getBookId() %>" >
                  <input type="submit" value="DEC"></form>
              </td>


        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">No Books found</td>
        </tr>
        <% } %>

    </table>

       <h3> <a href="index">Home</a></h3>

    </center>
</body>
</html>
