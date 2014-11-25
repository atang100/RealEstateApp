package seg3102

import grails.transaction.Transactional
import java.util.ArrayList;

@Transactional
class PropertyService {

    def serviceMethod() {

    }

    /**
     * ADD PROPERTY - Andy's Example
     *
     * @param propertyParameter
     * @param addressParameters
     * @param userName
     */
    def addProperty(Map propertyParameter, Map addressParameter, String userName) {

        //Address Constructor
        Address address = new Address(
                streetName: addressParameter.streetName,
                streetNumber: addressParameter.streetNumber,
                aptNumber: addressParameter.aptNumber,
                city: addressParameter.city,
                postalCode: addressParameter.postalCode,
                province: addressParameter.province,
                country: addressParameter.country
        )
        //Property Constructor
        Property property = new Property(
                type: propertyParameter.type,
                numBedrooms: propertyParameter.numBedrooms,
                numBathrooms: propertyParameter.numBathrooms,
                numOtherRooms: propertyParameter.numOtherRooms,
                rent: propertyParameter.rent,
                deleteStatus: propertyParameter.deleteStatus,
                address: address
        )
    }

    /**
     * FIND PROPERTY - RUI
     *
     * Takes in a list of search criteria, then searches for
     * properties based on those criteria.
     *
     * @param searchParameter
     */
    public ArrayList<Property> findProperty(Map searchCriteria) {

    }

    /**
     * DELETE PROPERTY - RUI
     *
     * @param propertyId
     */
    def deleteProperty(String propertyId) {

    }

    def updateProperty(Map propertyParameter, Map addressParameter, String userName) {

    }

}
