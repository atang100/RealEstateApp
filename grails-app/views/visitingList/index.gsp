<%--
  Created by IntelliJ IDEA.
  User: alexanderclarke
  Date: 2014-12-02
  Time: 4:54 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <g:render template="customerLayout"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
<button type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-sm" style="margin-top:70px">
    Search Parameters
</button>
    <table class="table table-striped" style="margin-top:30px">
        <th>Street Name</th>
        <th>Street Number</th>
        <th>City</th>
        <th>Province</th>
        <th>Bedrooms</th>
        <th>Bathrooms</th>
        <th>Rent</th>
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
                    <g:link controller="visitingList" action="addToList" class="btn-default">
                        <g:hiddenField name="propertyId" value="${property.properties.id}" />
                        <button type="button" class="btn btn-default">Add to Viewing List</button>
                    </g:link>
                </td>
            </tr>
        </g:each>
    </table>

<!-- Modal -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <g:form controller="visitingList" action="index">
                <fieldset>
                    <div class="row">
                        <div class="col-sm-12 col-md-10  col-md-offset-1 ">
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" placeholder="Street Name" name="streetName" type="text" autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" placeholder="Street Number" name="streetNumber" type="text" autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" placeholder="Apartment Number" name="aptNumber" type="text" autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" placeholder="City" name="city" type="text" autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" placeholder="Postal Code" name="postalCode" type="text" autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" placeholder="Province" name="province" type="text" autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" placeholder="Country" name="country" type="text" autofocus>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-group">
                                    <input type="submit" class="btn btn-primary" value="Search">
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