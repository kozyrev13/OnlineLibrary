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

    <form:form method="POST" modelAttribute="libraryUserForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="firstName">
            <div >
                <form:input type="text" path="firstName" class="form-control" placeholder="Firstname"
                            autofocus="true"></form:input>

            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div >
                <form:input type="text" path="lastName" class="form-control" placeholder="Lastname"
                            autofocus="true"></form:input>

            </div>
        </spring:bind>

        <spring:bind path="phoneNumber">
            <div >
                <form:input type="text" path="phoneNumber" class="form-control" placeholder="Phonr Number"
                            autofocus="true"></form:input>

            </div>
        </spring:bind>

        <spring:bind path="email">
            <div >
                <form:input type="text" path="email" class="form-control" placeholder="Email"
                            autofocus="true"></form:input>

            </div>
        </spring:bind>


        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<body>


<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>