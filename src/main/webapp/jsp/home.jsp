<%@ page import="by.itclass.constants.ApplicationConstants" %><%--
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
</head>
<body>
<p>
    <a href="<c:url value="<%= ApplicationConstants.LOGIN_CONTROLLER%>"/>" > Logout</a>
</p>
<h2>User Info:</h2>
<p>User id: ${user.id}</p>
<p>User login: ${user.login}</p>
<p>User name: ${user.name}</p>
<p>User email: ${user.email}</p>
</body>
</html>
