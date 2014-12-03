<%--
  Created by IntelliJ IDEA.
  User: alexanderclarke
  Date: 2014-12-02
  Time: 6:38 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<div class="container" style="margin-top:70px">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong> Enter User Information</strong>
                </div>
                <div class="panel-body">
                    <g:form controller="rent" action="rent">
                        <fieldset>
                            <div class="row">
                                <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input class="form-control" placeholder="Email Address" name="emailAddress" type="text" autofocus>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input class="form-control" placeholder="Rent Date" name="rentDate" type="text" autofocus>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input class="form-control" placeholder="Rent Duration" name="rentTime" type="text" autofocus>
                                        </div>
                                    </div>
                                    <g:hiddenField name="propertyId" value="${params.propertyId}" />
                                    <div class="form-group">
                                        <div class="form-group">
                                            <input type="submit" class="btn btn-lg btn-primary btn-block" value="Rent Property">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </g:form>
                </div>
            </div>
        </div>
</body>
</html>