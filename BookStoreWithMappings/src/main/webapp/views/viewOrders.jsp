<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="com.example.BookStoreWithMappings.entity.Book" %>
<%@page import="com.example.BookStoreWithMappings.models.BookModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>view Books</title>
</head>
<body>
<center>
    <h1>Order Books Details</h1>
    <table border="1">
        <tr>
            <th>Book ID</th>
            <th>Book Name</th>
            <th>Book Author</th>
            <th>Book Category</th>
            <th>Book Price</th>


        </tr>
        <%

            List<Book> bookList = (List<Book>) request.getAttribute("orderModel");
            if (bookList != null) {
                for (Book book : bookList) {
        %>
        <tr>
            <td><%= book.getBookId() %></td>
            <td><%= book.getBookName() %></td>
            <td><%= book.getBookAuthor() %></td>
            <td><%= book.getBookCategory() %></td>
            <td><%= book.getBookPrice() %></td>



        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">out off stack</td>
        </tr>
        <% } %>

    </table>

    <h3> <a href="userDashboard">userDashboard</a></h3>

    </center>
</body>
</html>
