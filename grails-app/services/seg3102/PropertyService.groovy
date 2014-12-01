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
     * ONLY CRITERIA THIS WILL ACCEPT IS CITY, PROVINCE, COUNTRY (CAN INCLUDE MORE THAN ONE OF THESE)
     *
     * @param searchParameter
     */
    public ArrayList<Property> findPropertyByLocation(Map addressParameter) {

        ArrayList<Address> addressList
        if (addressParameter.city != null && addressParameter.province != null && addressParameter.country != null) {
            addressList = Address.findAllByCityAndProvinceAndCountry(addressParameter.city, addressParameter.province, addressParameter.country)
        } else if (addressParameter.province != null && addressParameter.country != null) {
            addressList = Address.findAllByProvinceAndCountry(addressParameter.province,addressParameter.country)
        } else if (addressParameter.city != null && addressParameter.country != null) {
            addressList = Address.findAllByCityAndCountry(addressParameter.city,addressParameter.country)
        } else if (addressParameter.city != null && addressParameter.province != null) {
            addressList = Address.findAllByCityAndProvince(addressParameter.city,addressParameter.province)
        } else if (addressParameter.city != null) {
            addressList = Address.findAllByCity(addressParameter.city)
        } else if (addressParameter.city != null) {
            addressList = Address.findAllByCity(addressParameter.province)
        } else if (addressParameter.city != null) {
            addressList = Address.findAllByCity(addressParameter.country)
        } else {
            addressList = Address.findAll()
        }

        ArrayList<Property> propertyList = new ArrayList()
        for (a in addressList) {
            propertyList.add(a.getProperty())
        }
        return propertyList
    }

    /**
     * DELETE PROPERTY
     *
     * Delete property, returns true/false depending
     * on whether deletion is successful
     *
     * @param propertyId
     */
    public boolean deleteProperty(String propertyId) {
        try{
            Property property = Property.get(propertyId)
            p.delete()
            return true
        } catch (Exception e)
        {
            return false
        }
    }

    def updateProperty(Map propertyParameter, Map addressParameter, String userName) {

        try {
            Property property = Property.get(propertyParameter.propertyId)
            if (propertyParameter.type != null) {
                property.type = propertyParameter.type
            }
            if (propertyParameter.numBedrooms != null) {
                property.numBedrooms = propertyParameter.numBedrooms
            }
            if (propertyParameter.numBathrooms != null) {
                property.numBathrooms = propertyParameter.numBathrooms
            }
            if (propertyParameter.numOtherRooms != null) {
                property.numOtherRooms = propertyParameter.numOtherRooms
            }
            if (propertyParameter.rent != null) {
                property.rent = propertyParameter.rent
            }

            Address address = property.address
            if (addressParameter.streetName != null) {
                address.streetName = addressParameter.streetName
            }
            if (addressParameter.streetNumber != null) {
                address.streetNumber = addressParameter.streetNumber
            }
            if (addressParameter.aptNumber != null) {
                address.aptNumber = addressParameter.aptNumber
            }
            if (addressParameter.city != null) {
                address.city = addressParameter.city
            }
            if (addressParameter.postalCode != null) {
                address.postalCode = addressParameter.postalCode
            }
            if (addressParameter.province != null) {
                address.province = addressParameter.province
            }
            if (addressParameter.country != null) {
                address.country = addressParameter.country
            }
            address.save()
            property.save()
            return true

        } catch (Exception e) {
            return false
            //Most likely exception will be not finding address or property based on ID
        }
    }

}
