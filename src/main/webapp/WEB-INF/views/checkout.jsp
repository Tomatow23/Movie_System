<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Add Customers</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    </head>
    <body>
    <div class="style_1">
    <h1>${customer.name}</h1>
    <table>
        <tr>
        <th> Checkout for ${customer.name} </th>
        </tr>
    <c:forEach var="checkout" items="${checkout}">
    <c:url var="deleteLink" value="/MovieSystem/deleteCheckout">
            <c:param name="checkoutId" value ="${checkout.id}"/>
            <c:param name="customerId" value ="${customer.id}"/>
            </c:url>
         <tr>
        <td>${checkout.movies}</td>
        <td><a href="${deleteLink}"/>Delete Checkout</td>
        </tr>
        </c:forEach>
        </table>
        <a href=${pageContext.request.contextPath}/MovieSystem/cust_list> Back to customer list </a>
         <c:url var="newCheckout" value="/MovieSystem/addCheckout">
                    <c:param name="customerId" value ="${customer.id}"/>
                    </c:url>
        <a href="${newCheckout}"> New Order </a>

    </div>
    </body>
    </html>