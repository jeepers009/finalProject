<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Receipt</title>
</head>
<body>
<jsp:include page="<%=JspConstants.MENU_JSP %>"/>
<c:if test="${not empty orderReceipt}">
    <div class="receipt-container">
            ${orderReceipt}
    </div>
</c:if>
</body>
</html>
