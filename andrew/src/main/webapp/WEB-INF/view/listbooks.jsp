<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Book Manager</title>
</head>
<body>
<div align="center">
    <h2>Book Manager</h2>

    <h3><a href="/create">New Book</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>ISBN</th>
            <th>Issue Date</th>
            <th>Category Name</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${book.idBook}</td>
                <td>${book.nameBook}</td>
                <td>${book.isbn}</td>
                <td>${book.issueDate}</td>
                <td>${book.categoryDate}</td>
                <td>${book.price}</td>
                <td>
                    <a href="/edit?idBookEdit=${book.idBook}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/delete?idBookEdit=${book.idBook}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/books?page=1">Go first</a>
    <c:if test="${command.page-2 > 0}">
        <a href="/books?page=${command.page-2}">${command.page-2}</a>
    </c:if>
    <c:if test="${command.page-1 > 0}">
        <a href="/books?page=${command.page-1}">${command.page-1}</a>
    </c:if>

    <a>${command.page}</a>
    <c:if test="${command.page+1 <= command.maxPage}">
        <a href="/books?page=${command.page+1}">${command.page+1}</a>
    </c:if>
    <c:if test="${command.page+2 <= command.maxPage}">
        <a href="/books?page=${command.page+2}">${command.page+2}</a>
    </c:if>

    <a href="/books?page=${command.maxPage}">Go last</a>
</div>
</body>
</html>