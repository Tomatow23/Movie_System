<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h1>Add Customer</h1>
    <form:form class="form-style-6" action="processCustomer" modelAttribute="customer" method="post">
    <form:hidden path="id"/>
    <table>
    <tr>
    <td> Full Name </td>
    <td><form:input path="name"/>
    <td> Age </td>
    <td><form:input path="age"/>
    </tr>
     <tr>
     <td><input type="submit" value="Save Customer"/></td>
     </tr>
    <a href=${pageContext.request.contextPath}/MovieSystem/cust_list> Back to customer list </a>
    </form:form>
    </div>
    </body>
    </html>