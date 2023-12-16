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
    <c:set var="checkout" value = "${checkout}"/>

    <div class="style_1">
    <h1> Movie List </h1>
    <table>
    <tr>
    <th> Movie Name </th>
    <th> Movie Age </th>
    </tr>
    <c:forEach var="movies" items="${movies}">
     <c:url var="addMovieToList" value="/MovieSystem/addMovieToList">
            <c:param name="customerId" value ="${customer.id}"/>
            <c:param name="checkoutId" value ="${checkout.id}"/>
            <c:param name="movieId" value ="${movies.id}"/>
            </c:url>
    <tr>
    <td> ${movies.movie_name}</td>
    <td> ${movies.age_level}</td>
    <td><a href="${addMovieToList}"/>Add Movie to Cart</td>
    </tr>
    </c:forEach>
    <a href=${pageContext.request.contextPath}/MovieSystem/checkoutList?customerId=${customer.id}> Back to Cart </a>
    </table>
    </div>
    </body>
    </html>