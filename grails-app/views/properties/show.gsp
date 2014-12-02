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
        <th>Street Name</th>
        <th>Street Number</th>
        <th>Rent</th>
        <th></th>
        <th></th>
        <%--<g:each in="properties" var="property">--%>
            <%--
             <g:hiddenField name="propertyId" value="${property.id}" />
            <td>${property.address.streetName}</td>
            <td>${property.address.streetNumber}</td>
            <td>${property.rent}</td>
            --%>
        <tr>
            <td>address</td>
            <td>12</td>
            <td>$6000.00</td>
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
                        <g:form controller="properties" action="update">
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
                <g:link controller="properties" action="destroy" class="btn-default">
                    <button type="button" class="btn btn-default">Delete</button>
                </g:link>
            </td>
        </tr>
        <%--</g:each>--%>
    </table>
</body>
</html>