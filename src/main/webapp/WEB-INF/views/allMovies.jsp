<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Pizza Ordering</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>
    <body>

    <div class="style_1">
    <h1> Movie List </h1>
    <table>
    <tr>
    <th> Movie Name </th>
    <th> Movie Age </th>
    </tr>
    <c:forEach var="movies" items="${movies}">
    <tr>
    <td> ${movies.movie_name}</td>
    <td> ${movies.age_level}</td>
    </tr>
    </c:forEach>
    <a href=${pageContext.request.contextPath}/MovieSystem/cust_list> Back to Customers </a>
    </table>
    </div>
    </body>
    </html>