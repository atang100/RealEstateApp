<%--
  Created by IntelliJ IDEA.
  User: alexanderclarke
  Date: 2014-11-25
  Time: 9:18 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <g:render template="${userType}"/>
</head>

<body>
    <g:if test="${flash.message}">
        <div class="alert alert-success" role="alert" style="margin-top:50px">
            ${flash.message}
        </div>
    </g:if>
    <div class="container" style="margin-top:70px">
        <div class="jumbotron">
            <h1>Welcome to Online Property Rental!</h1>
            <p>The premier web hosted realty application.</p>
        </div>
    </div>
</body>
</html>