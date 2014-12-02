<%--
  Created by IntelliJ IDEA.
  User: alexanderclarke
  Date: 2014-12-01
  Time: 7:54 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:if test="${flash.message}">
        <div class="alert alert-success" role="alert">
            ${flash.message}
        </div>
    </g:if>
<div class="container" style="margin-top:40px">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong> Enter User Information</strong>
                </div>
                <div class="panel-body">
                    <g:form controller="createUser" action="addUser">
                        <fieldset>
                            <div class="row">
                                <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input class="form-control" placeholder="John" name="givenName" type="text" autofocus>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input class="form-control" placeholder="Smith" name="lastName" type="text" autofocus>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input class="form-control" placeholder="Username" name="username" type="text" autofocus>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <select class="form-control" name="userType">
                                                <option>Agent</option>
                                                <option>Customer</option>
                                                <option>Owner</option>
                                            </select>
                                         </div>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Add User">
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