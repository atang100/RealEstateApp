package seg3102

import grails.transaction.Transactional
import java.util.ArrayList;
import java.sql.Date;

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
        log.info("ADD PROPERTY")
        try {
            Owner owner = Owner.findByUserName(userName)

            def address = new Address(
                    streetName: addressParameter.streetName,
                    streetNumber: addressParameter.streetNumber,
                    aptNumber: addressParameter.aptNumber,
                    city: addressParameter.city,
                    postalCode: addressParameter.postalCode,
                    province: addressParameter.province,
                    country: addressParameter.country
            )

            def myProperty = new Property(
                    type: propertyParameter.type,
                    numBedrooms: propertyParameter.numBedrooms,
                    numBathrooms: propertyParameter.numBathrooms,
                    numOtherRooms: propertyParameter.numOtherRooms,
                    rent: propertyParameter.rent,
                    deleteStatus: propertyParameter.deleteStatus,
                    address: address,
                    owner: owner
            )

            address.propertys = myProperty
            address.save(failOnError: true)

            myProperty.save(failOnError:true)

            owner.addToPropertys(myProperty)
            owner.save(failOnError:true)

        } catch (Exception e) {
            println("ERRRROOORRR " + e)
        }
    }

    /**
     * BROWSE PROPERTY BY LOCATION
     *
     * Takes in a list of search criteria, then searches for
     * properties based on those criteria.
     *
     * ONLY CRITERIA THIS WILL ACCEPT IS CITY, PROVINCE, COUNTRY (CAN INCLUDE MORE THAN ONE OF THESE)
     *
     * @param searchParameter
     */
    public ArrayList<Property> browsePropertyByLocation(Map addressParameter) {

        ArrayList<Address> addressList
        if (addressParameter.city != "" && addressParameter.province != "" && addressParameter.country != "") {
            addressList = Address.findAllByCityAndProvinceAndCountry(addressParameter.city, addressParameter.province, addressParameter.country)
        } else if (addressParameter.province != "" && addressParameter.country != "") {
            addressList = Address.findAllByProvinceAndCountry(addressParameter.province, addressParameter.country)
        } else if (addressParameter.city != "" && addressParameter.country != "") {
            addressList = Address.findAllByCityAndCountry(addressParameter.city, addressParameter.country)
        } else if (addressParameter.city != "" && addressParameter.province != "") {
            addressList = Address.findAllByCityAndProvince(addressParameter.city, addressParameter.province)
        } else if (addressParameter.city != "") {
            addressList = Address.findAllByCity(addressParameter.city)
        } else if (addressParameter.province != "") {
            addressList = Address.findAllByCity(addressParameter.province)
        } else if (addressParameter.country != "") {
            addressList = Address.findAllByCity(addressParameter.country)
        } else {
            addressList = Address.findAll()
        }

        ArrayList<Property> propertyList = new ArrayList()
        if (addressList != null) {
            for (a in addressList) {
                Property myProperty = a.getProperty()
                if (myProperty != null) {
                    if (myProperty.deleteStatus == false) {
                        propertyList.add(myProperty)
                    }
                }
            }
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
        try {
            Property myProperty = Property.get(propertyId)
            myProperty.deleteStatus = true
            myProperty.save()
            return true
        } catch (Exception e) {
            println("FAILED TO DELETE PROPERTY")
            println(e)
            return false
        }
    }

    def updateProperty(Map propertyParameter, Map addressParameter) {
        println(propertyParameter)
        println(addressParameter)
        try {
            Property myProperty = Property.get(propertyParameter.propertyId)

            if (propertyParameter.type != "") {
                myProperty.type = propertyParameter.type
            }
            if (propertyParameter.numBedrooms != "") {
                myProperty.numBedrooms = Integer.parseInt(propertyParameter.numBedrooms)
            }
            if (propertyParameter.numBathrooms != "") {
                myProperty.numBathrooms = Integer.parseInt(propertyParameter.numBathrooms)
            }
            if (propertyParameter.numOtherRooms != "") {
                myProperty.numOtherRooms = Integer.parseInt(propertyParameter.numOtherRooms)
            }
            if (propertyParameter.rent != "") {
                myProperty.rent = Integer.parseInt(propertyParameter.rent)
            }
            myProperty.save(failOnError:true)

            Address address = myProperty.address
            if (addressParameter.streetName != "") {
                address.streetName = addressParameter.streetName
            }
            if (addressParameter.streetNumber != "") {
                address.streetNumber = addressParameter.streetNumber
            }
            if (addressParameter.aptNumber != "") {
                address.aptNumber = addressParameter.aptNumber
            }
            if (addressParameter.city != "") {
                address.city = addressParameter.city
            }
            if (addressParameter.postalCode != "") {
                address.postalCode = addressParameter.postalCode
            }
            if (addressParameter.province != "") {
                address.province = addressParameter.province
            }
            if (addressParameter.country != "") {
                address.country = addressParameter.country
            }
            address.save(failOnError:true)

            return true

        } catch (Exception e) {
            println("UPDATE PROPERTY FAILED")
            println(e)
            return false
            //Most likely exception will be not finding address or property based on ID
        }
    }

    def viewVisitHistory(Date startDate, Date endDate, String propertyId) {
        try {
            Property property = Property.get(propertyId)
            ArrayList<History> historyList = History.findAllByStartDateGreaterThanAndEndDateLessThan(startDate, endDate)
            return historyList
        } catch (Exception e) {

        }
    }

    def rentProperty(String propertyId, String userName, Map rentAttributes) {
        try {
            Customer customer = Customer.findByUserName(userName)
            VisitingList visitingList = customer.visitingList
            Property property = visitingList.property.find { it.id = propertyId }

            RentRecord rentRecord = new RentRecord(
                    emailAddress: rentAttributes.emailAddress,
                    rent: property.rent,
                    rentalDate: rentAttributes.rentalDate,
                    rentalTime: rentAttributes.rentalTime
            )
            rentRecord.save()
            property.addToRentRecord(rentRecord)
            customer.addToRentRecord(rentRecord)
            property.save()
            customer.save()

            return true
        } catch (Exception e) {
            return false
        }
    }

}
