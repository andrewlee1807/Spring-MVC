<%@ page import="java.util.List" %>
<%@ page import="com.abc.andrew.model.Author" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Book</title>
</head>
<body>
<div align="center">
    <h2>Edit Book</h2>
    <form:form action="save" method="post" modelAttribute="book">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID:</td>
                <td>${book.pojo.idBook}
                    <form:hidden path="pojo.idBook"/>
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="pojo.nameBook"/></td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><form:input path="pojo.isbn"/></td>
            </tr>
            <tr>
                <td>Issue Date:</td>
                <td><form:input path="pojo.issueDate"/></td>
            </tr>
            <tr>
                <td>Category Date:</td>
                <td><form:input path="pojo.categoryDate"/></td>
            </tr>
            <tr>
                <td>Authors:</td>
                <td>
                    <c:forEach var="item" items="${listAuthor}">
                        ${item.name}<input
                        <c:forEach var="i" items="${book.pojo.listAuthor}">
                            <c:if test="${i.idAuthor==item.idAuthor}">checked</c:if>
                        </c:forEach>
                            type="checkbox" value="${item.idAuthor}" name="listID"/>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><form:input path="pojo.price"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>