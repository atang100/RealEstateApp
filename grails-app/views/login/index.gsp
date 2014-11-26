<%--
  Created by IntelliJ IDEA.
  User: alexanderclarke
  Date: 2014-11-25
  Time: 7:02 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title></title>
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

  <!-- Latest compiled and minified JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin-top:40px">
      <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
          <div class="panel panel-default">
            <div class="panel-heading">
              <strong> Sign in to continue</strong>
            </div>
            <div class="panel-body">
              <g:form controller="login" action="authenticate">
                <fieldset>
                  <div class="row">
                    <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon">
                            <i class="glyphicon glyphicon-user"></i>
                          </span>
                          <input class="form-control" placeholder="Username" name="username" type="text" autofocus>
                        </div>
                      </div>
                      <div class="form-group">
                        <div class="input-group">
                          <span class="input-group-addon">
                            <i class="glyphicon glyphicon-lock"></i>
                          </span>
                          <input class="form-control" placeholder="Password" name="password" type="password" value="">
                        </div>
                      </div>
                      <div class="form-group">
                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="Sign in">
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