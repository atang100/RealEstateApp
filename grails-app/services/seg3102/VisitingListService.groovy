package seg3102

import grails.transaction.Transactional

import java.sql.Date

@Transactional
class VisitingListService {

    def addToVisitingList(String propertyId, String userName) {
        try {
            Property property = Property.get(propertyId)
            Customer customer = Customer.findByUserName(userName)
            VisitingList visitingList = customer.visitingList
            visitingList.addToProperty(property)
            visitingList.save()
            return true
        } catch (Exception e) {
            return false
        }
    }

    def removeFromVisitingList(String propertyId, String userName) {
        try {
            Property property = Property.get(propertyId)
            Customer customer = Customer.findByUserName(userName)
            VisitingList visitingList = customer.visitingList
            visitingList.removeFromProperty(property)
            visitingList.save()
            return true
        } catch (Exception e) {
            return false
        }
    }

    /**
     * VIEW VISITING LIST
     *
     * Returns the visiting list as well as a list of properties associated with the visiting list.
     *
     * @param userName
     * @return
     */
    def viewVisitingList(String userName) {
        try {
            Customer customer = Customer.findByUserName(userName)
            VisitingList visitingList = customer.visitingList
            ArrayList<Property> propertyList = visitingList.property
            return [visitingList, propertyList]
        } catch (Exception e) {
            //Some exception
        }
    }
}
