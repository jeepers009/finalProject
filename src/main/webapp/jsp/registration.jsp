<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23.08.2023
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page import="by.itclass.constants.ApplicationConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<jsp:include page="<%= JspConstants.MENU_JSP%>"/>
<img class="default-image" src="/img/pizza-dinner.jpg" alt="pizza"/>
<h2>Registration</h2>
<form method="post" action="<c:url value="<%=ApplicationConstants.REGISTRATION_CONTROLLER%>"/>">
    <input name="<%= JspConstants.LOGIN_PARAM %>" placeholder="Login">
    <input type="password" name="<%= JspConstants.PASSWORD_PARAM %>" placeholder="Password">
    <input name="<%= JspConstants.NAME_PARAM %>" placeholder="Name">
    <input name="<%= JspConstants.EMAIL_PARAM %>" placeholder="Email">
    <input type="submit" value="Register...">
    <c:if test="${not empty message}">
        <h2 class="error">${message}</h2>
    </c:if>
</form>
</div>
</body>
</html>
