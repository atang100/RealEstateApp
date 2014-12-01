package seg3102

import grails.transaction.Transactional

@Transactional
class CustomerService {

    def createCustomer(Map customerAttributes) {

        try {
            //Grails Constructor
            Customer customer = new Customer(
                    givenName: customerAttributes.givenName,
                    lastName: customerAttributes.lastName,
                    userName: customerAttributes.userName,
                    password: customerAttributes.password,
                    creationDate: customerAttributes.creationDate,
                    deleted: customerAttributes.deleted
            )
            customer.save()
        } catch (Exception e) {
            System.println("Failure to create User of Type Customer!")
        }
    }

    def updateCustomer(Map ownerAttributes) {
        //Too complicated, will do it later.
    }
}
