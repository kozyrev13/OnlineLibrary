<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add information about you</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<div class="container">

    <form:form method="post" action="/add" commandName="contact">

        <table>
            <tr>
                <td></td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td></td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td></td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td></td>
                <td><form:input path="phoneNumber" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit"
                                       value="Go" /></td>
            </tr>
        </table>
    </form:form>

</div>
<body>


<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>