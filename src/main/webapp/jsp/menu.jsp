<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page import="by.itclass.constants.ApplicationConstants" %>
<ul class="nav-ul">
    <c:choose>
        <c:when test="${empty user}">
            <li class="nav-li float-left">
                <a class="active" href="<c:url value="<%= JspConstants.INDEX_JSP %>"/>">Home</a></li>
            <li class="nav-li">
                <a href="<c:url value="<%= JspConstants.LOGIN_JSP %>"/>">Login</a></li>
            <li class="nav-li">
                <a href="<c:url value="<%= JspConstants.REGISTRATION_JSP %>"/>">Registration</a></li>
        </c:when>
        <c:otherwise>
            <li class="nav-li float-left">
                <a class="active" href="<c:url value="<%= JspConstants.HOME_JSP %>"/>">Home</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%= ApplicationConstants.LOGOUT_CONTROLLER %>"/>">Logout</a>
            </li>
            <li class="nav-li float-left">
                <a href="<c:url value="<%=ApplicationConstants.PIZZAS_MENU%>"/>">Pizza</a></li>
            <li class="nav-li float-left">
                <a href="<c:url value="<%=ApplicationConstants.DRINKS_MENU%>"/>">Drink</a></li>
            <li class="nav-li">
                <a href="<c:url value="<%= JspConstants.CART_JSP %>"/>">Cart</a></li>
            <li class="nav-li">
                <a href="<c:url value="<%= ApplicationConstants.ORDERS_HISTORY_CONTROLLER %>"/>">
                    Orders
                </a></li>

        </c:otherwise>
    </c:choose>
</ul>