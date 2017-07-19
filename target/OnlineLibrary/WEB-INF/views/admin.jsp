<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    <form id="logoutForm" method="post" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <h2>Admin Page ${pageContext.request.userPrincipal.name} | <a
            onclick="document.forms['logoutForm'].submit()">Logout</a>
    </h2>

    <table>
        <tr>
            <td valign="top">
                </c:if>
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
                        </tr>
                        <c:forEach items="${bookList}" var="book">
                            <tr>
                                <td>&emsp;${book.id}&emsp;</td>
                                <td>&emsp;${book.title}&emsp;</td>
                                <td>&emsp;${book.author}&emsp;</td>
                                <td>&emsp;${book.pages}&emsp;</td>
                                <td>&emsp;${book.year}&emsp;</td>
                                <td>&emsp;${book.quantity}&emsp;</td>
                            </tr>
                        </c:forEach>

                    </table>
                </c:if>

            </td>
            <td valign="top">
                <h3>Add Book</h3>
                <form:form method="POST" modelAttribute="book">

                    <form:input type="text" path="title" class="form-control" placeholder="title"
                                autofocus="true"></form:input>
                    <form:input type="text" path="author" class="form-control" placeholder="author"
                                autofocus="true"></form:input>
                    <form:input type="text" path="pages" class="form-control" placeholder="pages"
                                autofocus="true"></form:input>
                    <form:input type="text" path="year" class="form-control" placeholder="year"
                                autofocus="true"></form:input>
                    <form:input type="text" path="quantity" class="form-control" placeholder="quantity"
                                autofocus="true"></form:input>

                    <button type="submit">Add</button>


                </form:form>
            </td>
        </tr>
        <tr>
            <td valign="top">
                <h3>Books Operations </h3>


                <c:if test="${!empty issuedBookList}">
                    <table class="data">
                        <tr>
                            <th>&emsp;Operation Id&emsp;</th>
                            <th>&emsp;Book Id&emsp;</th>
                            <th>&emsp;User Id&emsp;</th>
                            <th>&emsp;Issued Time&emsp;</th>
                            <th>&emsp;Return Time&emsp;</th>

                        </tr>
                        <c:forEach items="${issuedBookList}" var="issuedBook">
                            <tr>

                                <td>&emsp;${issuedBook.id}&emsp;</td>
                                <td>&emsp;${issuedBook.id_Book}&emsp;</td>
                                <td>&emsp;${issuedBook.id_LibraryUser}&emsp;</td>
                                <td>&emsp;${issuedBook.time}&emsp;</td>
                                <td>&emsp;${issuedBook.returnTime}&emsp;</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>

            </td>
            <td valign="top">
                <h3>Library Users</h3>


                <c:if test="${!empty libraryUserList}">
                    <table class="data">
                        <tr>
                            <th>&emsp;User Id&emsp;</th>
                            <th>&emsp;Firstname&emsp;</th>
                            <th>&emsp;Lastname&emsp;</th>
                            <th>&emsp;Phone Number&emsp;</th>
                            <th>&emsp;Email&emsp;</th>

                        </tr>
                        <c:forEach items="${libraryUserList}" var="libraryUser">
                            <tr>

                                <td>&emsp;${libraryUser.id}&emsp;</td>
                                <td>&emsp;${libraryUser.firstName}&emsp;</td>
                                <td>&emsp;${libraryUser.lastName}&emsp;</td>
                                <td>&emsp;${libraryUser.phoneNumber}&emsp;</td>
                                <td>&emsp;${libraryUser.email}&emsp;</td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </td>
        </tr>
    </table>

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
