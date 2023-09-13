<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page import="by.itclass.constants.ApplicationConstants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="nav-ul">
    <c:choose>
        <c:when test="${empty user}">
            <li class="nav-li float-left">
                <a class="active" href="<c:url value="<%= JspConstants.INDEX_JSP%>"/>">Index</a>
            </li>
            <li class="nav-li ">
                <a href="<c:url value="<%= JspConstants.LOGIN_JSP%>"/>">Login</a>
            </li>
            <li class="nav-li ">
                <a href="<c:url value="<%= JspConstants.REGISTRATION_JSP%>"/>">Registration</a>
            </li>

        </c:when>
        <c:otherwise>
            <li class="nav-li float-left">
                <a class="active" href="<c:url value="<%= JspConstants.HOME_JSP%>"/>">Home</a>
            </li>
            <li class="nav-li float-left">
                <a href="<c:url value="<%= ApplicationConstants.PIZZAS_MENU%>"/>">Pizzas</a>
            </li>
            <li class="nav-li float-left">
                <a href="<c:url value="<%= ApplicationConstants.DRINKS_MENU%>"/>">Drinks</a>
            </li>
            <li class="nav-li">
                <a class="active" href="<c:url value="/logout"/>">Logout</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%= JspConstants.CART_JSP%>"/>">Cart</a>
            </li>
        </c:otherwise>
    </c:choose>
</ul>