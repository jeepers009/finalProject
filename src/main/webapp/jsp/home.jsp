<%@ page import="by.itclass.constants.ApplicationConstants" %>
<%@ page import="by.itclass.constants.JspConstants" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.08.2023
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<jsp:include page="<%= JspConstants.MENU_JSP%>"/>
<h2>hello ${user.name}</h2>
<c:if test="${not empty pizzas}">
    <h2>Today we propose next Pizzas...</h2>
    <c:forEach var="pizza" items="${pizzas}">
        ${pizza.name}
        ${pizza.price}
    </c:forEach>
</c:if>
<c:if test="${not empty drinks}">
    <h2>Today we propose next Drinks...</h2>
    <c:forEach var="drink" items="${drinks}">
        ${drink.name}
        ${drink.price}
    </c:forEach>
</c:if>
</body>
</html>
