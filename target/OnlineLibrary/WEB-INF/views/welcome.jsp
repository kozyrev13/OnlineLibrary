<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>

    </c:if>
    <h3>Books</h3>
    <c:if test="${!empty contactList}">
        <table class="data">
            <tr>
                <th>Title </th>
                <th>Authoe </th>
                <th>Pages </th>
                <th>Year </th>
                <th>Quantity </th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${contactList}" var="contact">
                <tr>
                    <td>${contact.title}</td>
                    <td>${contact.author}</td>
                    <td>${contact.pages}</td>
                    <td>${contact.year}</td>
                    <td>${contact.quantity}</td>
                    <td><a href="take/${contact.id}">Take</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>