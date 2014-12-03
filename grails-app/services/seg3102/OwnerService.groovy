package seg3102

import grails.transaction.Transactional

@Transactional
class OwnerService {

    /**
     * Create User of Type Owner
     *
     * @param ownerAttributes
     * @return
     */
    def createOwner(Map ownerAttributes) {

        try {
            //Grails Constructor
            Owner owner = new Owner(
                    givenName: ownerAttributes.givenName,
                    lastName: ownerAttributes.lastName,
                    userName: ownerAttributes.userName,
                    password: ownerAttributes.password,
                    email: ownerAttributes.email,
                    creationDate: ownerAttributes.creationDate,
                    deleted: ownerAttributes.deleted
            )
            owner.save()
        } catch (Exception e) {
            System.println("Failure to create User of Type Owner!")
        }
    }

    def updateOwner(Map ownerAttributes) {

        try {
            Owner owner = Owner.get(ownerAttributes.userId)

            if (ownerAttributes.password != "") {
                owner.password = ownerAttributes.password
            }
            if (ownerAttributes.email != "") {
                owner.email = ownerAttributes.email
            }
            owner.save()
        } catch (Exception e) {
            System.println("Failure to create User of Type Owner!")
        }
    }

    /**
     * RETURNS ALL OF OWNER'S PROPERTIES
     *
     * @param userName
     * @return
     */
    public ArrayList<Propertys> ownerViewProperties(String userName) {
        try {
            Owner owner = Owner.findByUserName(userName)
            ArrayList<Propertys> propertyList = owner.propertys
            return propertyList
        } catch (Exception e) {
            println("ERRRORRRR" + e)
        }
    }

    /**
     *  VIEW OWNER ACCOUNT (NOT REALLY USEFUL)
     *
     * @param userName
     * @return
     */
    public viewAccount(String userName) {
        try {
            Owner owner = Owner.findByUserName(userName)
            return owner
        } catch (Exception e) {

        }
    }
}
