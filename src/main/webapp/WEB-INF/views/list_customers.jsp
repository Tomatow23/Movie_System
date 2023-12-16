<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Movie System</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>
    <body>
    <div class="style_1">
    <form class="form-style-6" action="addCustomer" method="post">
    <input type="submit" value="Add Customer">
    </form>
    <form class="form-style-6" action="addNewMovie" method="post">
    <input type="submit" value="Add New Movie">
    </form>
    <form class="form-style-6" action="displayAllMovies" method="post">
        <input type="submit" value="Display All Movies">
        </form>
    </div>
    <div class="style_1">
    <h1> Customer List </h1>
    <table>
    <tr>
    <th> Name </th>
    <th> Age </th>
    </tr>
    <c:forEach var="cust" items="${customers}">
    <c:url var="updateLink" value="/MovieSystem/updateCustomer">
        <c:param name="customerId" value ="${cust.id}"/>
        </c:url>
    <c:url var="deleteLink" value="/MovieSystem/deleteCustomer">
            <c:param name="customerId" value ="${cust.id}"/>
            </c:url>
    <c:url var="addMovie" value="/MovieSystem/checkoutList">
           <c:param name="customerId" value ="${cust.id}"/>
           </c:url>

    <tr>

    <td> ${cust.name}</td>
    <td> ${cust.age}</td>
    <td><a href="${updateLink}"/>Update Customer</td>
    <td><a href="${deleteLink}"/>Delete Customer</td>
    <td><a href="${addMovie}"/>Add Order</td>
    </tr>
    </c:forEach>
    </table>
    </div>
    </body>
    </html>