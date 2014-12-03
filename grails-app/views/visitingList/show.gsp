<%--
  Created by IntelliJ IDEA.
  User: alexanderclarke
  Date: 2014-12-02
  Time: 4:56 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <g:render template="customerLayout"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<g:if test="${flash.message}">
    <div class="alert alert-success" role="alert" style="margin-top:50px">
        ${flash.message}
    </div>
</g:if>
    <body>
        <table class="table table-striped" style="margin-top:70px">
            <th>Street Name</th>
            <th>Street Number</th>
            <th>City</th>
            <th>Province</th>
            <th>Bedrooms</th>
            <th>Bathrooms</th>
            <th>Rent</th>
            <th></th>
            <th></th>
            <g:each in="${myProperties}" var="property">
                <tr>
                    <td>${property.properties.address.streetName}</td>
                    <td>${property.properties.address.streetNumber}</td>
                    <td>${property.properties.address.city}</td>
                    <td>${property.properties.address.province}</td>
                    <td>${property.properties.numBedrooms}</td>
                    <td>${property.properties.numBathrooms}</td>
                    <td>${property.properties.rent}</td>
                    <td>
                        <g:link controller="visitingList" action="deleteFromList" class="btn-default">
                            <g:hiddenField name="propertyId" value="${property.properties.id}" />
                            <button type="button" class="btn btn-default">delete</button>
                        </g:link>
                    </td>
                    <td>
                        <g:link controller="rent" action="index" class="btn-default">
                            <g:hiddenField name="propertyId" value="${property.properties.id}" />
                            <button type="button" class="btn btn-default">rent</button>
                        </g:link>
                    </td>
                </tr>
            </g:each>
        </table>
    </body>
</html>