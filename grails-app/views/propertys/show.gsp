<%--
  Created by IntelliJ IDEA.
  User: alexanderclarke
  Date: 2014-12-01
  Time: 11:05 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <g:render template="ownerLayout"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>

<body>
    <table class="table table-striped" style="margin-top:70px">
        <th>Address</th>
        <th>Number of Bedrooms</th>
        <th>Number of Bathrooms</th>
        <th>Number of Other Rooms</th>
        <th>Rent</th>
        <th>Deletion Status</th>
        <th></th>
        <th></th>
       <g:each in="${myProperties}" var="property">
            <tr>
                <td>${property.properties.address.streetNumber} ${property.properties.address.streetName}</td>
                <td>${property.properties.numBedrooms}</td>
                <td>${property.properties.numBathrooms}</td>
                <td>${property.properties.numOtherRooms}</td>
                <td>$${property.properties.rent}</td>
                <td>${property.properties.deleteStatus}</td>
                <td>
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-default" data-toggle="modal" data-target=".bs-example-modal-sm">
                        Edit
                    </button>
                </td>

                <!-- Modal -->
                <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <g:form controller="propertys" action="update">
                                <g:hiddenField name="propertyId" value="${property.properties.id}" />
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
                                                <div class="input-group">
                                                    <input class="form-control" placeholder="Type" name="type" type="text" autofocus>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <input class="form-control" placeholder="#Bedrooms" name="numBedrooms" type="text" autofocus>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <input class="form-control" placeholder="#Bathrooms" name="numBathrooms" type="text" autofocus>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <input class="form-control" placeholder="#Other Rooms" name="numOtherRooms" type="text" autofocus>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <input class="form-control" placeholder="Rent" name="rent" type="text" autofocus>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="form-group">
                                                    <input type="submit" class="btn btn-primary" value="Add Property">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                            </g:form>
                        </div>
                    </div>
                </div>
                <td>
                    <g:form controller="propertys" action="setDeleteProperty">
                        <g:hiddenField name="propertyId" value="${property.properties.id}" />
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </g:form>
                </td>
            </tr>
        </g:each>
    </table>
</body>
</html>