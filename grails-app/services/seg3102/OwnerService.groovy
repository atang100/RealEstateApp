package seg3102

import grails.transaction.Transactional
import seg3102.Owner

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
                    creationDate: ownerAttributes.creationDate,
                    deleted: ownerAttributes.deleted
            )
            owner.save()
        } catch (Exception e) {
            System.println("Failure to create User of Type Owner!")
        }
    }


}
