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
    <g:render template="${person.layoutType}"/>
</head>

<body>
<g:if test="${flash.message}">
    <div class="alert alert-success" role="alert" style="margin-top:50px">
        ${flash.message}
    </div>
</g:if>
<div class="container" style="margin-top:70px">
    <h1>User Info</h1>
    <table class="table table-striped">
        <tr>
            <td>Username</td>
            <td>${person.userName}</td>
        </tr>
        <tr>
            <td>Given Name</td>
            <td>${person.givenName}</td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>${person.lastName}</td>
        </tr>
        <tr>
            <td>Email Address</td>
            <td>${person.email}</td>
        </tr>
        <tr>
            <td>Type of Account</td>
            <td>${person.userType}</td>
        </tr>
    </table>
    <g:link controller="users" action="updateAccountUI" class="btn-default">
        <button type="button" class="btn btn-default navbar-btn">Update Account</button>
    </g:link>
    <g:link controller="users" action="deleteAccount" class="btn-default">
        <button type="button" class="btn btn-default navbar-btn">Delete Account</button>
    </g:link>
</div>
</body>
</html>