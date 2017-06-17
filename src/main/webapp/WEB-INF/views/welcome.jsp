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
    <table>
        <tr>
            <td>
                <h3>Library Books</h3>
                <c:if test="${!empty bookList}">
                    <table class="data">
                        <tr>
                            <th>&emsp;Id&emsp;</th>
                            <th>&emsp;Title&emsp;</th>
                            <th>&emsp;Author&emsp;</th>
                            <th>&emsp;Pages&emsp;</th>
                            <th>&emsp;Year&emsp;</th>
                            <th>&emsp;Quantity&emsp;</th>
                            <th>&nbsp;</th>
                        </tr>
                        <c:forEach items="${bookList}" var="book">
                            <tr>
                                <td>&emsp;${book.id}&emsp;</td>
                                <td>&emsp;${book.title}&emsp;</td>
                                <td>&emsp;${book.author}&emsp;</td>
                                <td>&emsp;${book.pages}&emsp;</td>
                                <td>&emsp;${book.year}&emsp;</td>
                                <td>&emsp;${book.quantity}&emsp;</td>
                                <td><a href="take/${book.id}">Take</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </td>
            <td>
                <h3>Books</h3>
                <c:if test="${!empty userbooklist}">
                    <table class="data">
                        <tr>
                            <th>&emsp;Title&emsp;</th>
                            <th>&emsp;Author&emsp;</th>
                            <th>&emsp;Year&emsp;</th>
                            <th>&emsp;Pages&emsp;</th>
                            <th>&nbsp;</th>

                        </tr>
                        <c:forEach items="${userbooklist}" var="userbook">
                            <tr>
                                <td>&emsp;${userbook.title}&emsp;</td>
                                <td>&emsp;${userbook.author}&emsp;</td>
                                <td>&emsp;${userbook.year}&emsp;</td>
                                <td>&emsp;${userbook.pages}&emsp;</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>
                <h3>All Your Books </h3>


                <c:if test="${!empty issuedBookList}">
                    <table class="data">
                        <tr>
                            <th>&emsp;Operation Id&emsp;</th>
                            <th>&emsp;Book Id&emsp;</th>
                            <th>&emsp;User Id&emsp;</th>
                            <th>&emsp;Time&emsp;</th>
                            <th>&nbsp;</th>

                        </tr>
                        <c:forEach items="${issuedBookList}" var="issuedBook">
                            <tr>

                                <td>&emsp;${issuedBook.id}&emsp;</td>
                                <td>&emsp;${issuedBook.id_Book}&emsp;</td>
                                <td>&emsp;${issuedBook.id_LibraryUser}&emsp;</td>
                                <td>&emsp;${issuedBook.time}&emsp;</td>
                                <td><a href="return/${issuedBook.id}">Return</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </td>
            <td>

            </td>
        </tr>


    </table>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>