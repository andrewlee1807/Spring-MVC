<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
    Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Book</title>
</head>
<body>
    <div align="center">
        <h2>New Book</h2>
        <form action="save" method="post" >
            <table border="0" cellpadding="5">
                <input type="hidden" name="pojo.idBook" value="${requestScope.book.idBook}"/>
                <tr>
                    <td>Name: </td>
                    <td><input name="pojo.nameBook" /></td>
                </tr>
                <tr>
                    <td>Category Date: </td>
                    <td><input name="pojo.categoryDate" /></td>
                </tr>
                <tr>
                    <td>Issue Date: </td>
                    <td><input name="pojo.issueDate" /></td>
                </tr>
                <tr>
                    <td>ISBN: </td>
                    <td><input name="pojo.isbn" /></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><input name="pojo.price"/></td>
                </tr>
                <tr>
                    <td>Author: </td>
                    <td>
                            <c:forEach var="item" items="${listAuthor}">
                                 ${item.name}<input type="checkbox" value="${item.idAuthor}" name="listID" />
                            </c:forEach>

                    </td>

                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="save"></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>