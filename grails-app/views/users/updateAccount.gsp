<%--
  Created by IntelliJ IDEA.
  User: Andy
  Date: 03/12/2014
  Time: 2:50 AM
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
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Update User Information</strong>
                </div>
                <div class="panel-body">
                    <g:form controller="users" action="updateAccount">
                        <fieldset>
                            <div class="row">
                                <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                    <div class="form-group">
                                        <div class="input-group">
                                            Given Name: <input class="form-control" value="${person.givenName}" name="givenName" type="text" autofocus disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            Last Name: <input class="form-control" value="${person.lastName}" name="lastName" type="text" autofocus disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            Username: <input class="form-control" value="${person.userName}" name="username" type="text" autofocus disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            Password: <input class="form-control" value="${person.password}" name="password" type="password" value="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            Email: <input class="form-control" value="${person.email}" name="email" type="text" autofocus>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            User Type: <input class="form-control" value="${person.userType}" name="email" type="text" autofocus disabled>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Update Account">
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>