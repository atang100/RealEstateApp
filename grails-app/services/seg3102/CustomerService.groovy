package seg3102

import grails.transaction.Transactional

@Transactional
class CustomerService {

    def createCustomer(Map customerAttributes) {
        log.info("CREATE CUSTOMER")
        try {
            VisitingList visitingList = new VisitingList()

            //Grails Constructor
            Customer customer = new Customer(
                    givenName: customerAttributes.givenName,
                    lastName: customerAttributes.lastName,
                    userName: customerAttributes.userName,
                    password: customerAttributes.password,
                    email: customerAttributes.email,
                    creationDate: customerAttributes.creationDate,
                    deleted: customerAttributes.deleted,
                    visitingList: visitingList
            )
            customer.save(failOnError:true)
        } catch (Exception e) {
            System.println("Failure to create User of Type Customer!")
            System.println(e)
        }
    }

    def addCreditCard(Map creditCardAttributes, String userName) {
        try {
            CreditCard creditCard = new CreditCard(
                    type: creditCardAttributes.type,
                    number: creditCardAttributes.number,
                    cardHolder: creditCardAttributes.cardHolder,
                    expiryMonth: creditCardAttributes.expiryMonth,
                    expiryYear: creditCardAttributes.expireYear
            )
            creditCard.save()
            Customer customer = Customer.findByUserName(userName)
            customer.creditCard = creditCard
            customer.save()

        } catch (Exception e) {
            System.println("Mostly likely failed due poorly formatted creditCard info!")
        }
    }

    def updateCreditCard(Map creditCardAttributes, String userName) {
        try {
            Customer customer = Customer.findByUserName(userName)
            CreditCard creditCard = customer.creditCard

            if (creditCardAttributes.type != null) {
                creditCard.type = creditCardAttributes.type
            }
            if (creditCardAttributes.number != null) {
                creditCard.number = creditCardAttributes.number
            }
            if (creditCardAttributes.cardHolder != null) {
                creditCard.cardHolder = creditCardAttributes.cardHolder
            }
            if (creditCardAttributes.expiryMonth != null) {
                creditCard.expiryMonth = creditCardAttributes.expiryMonth
            }
            if (creditCardAttributes.expiryYear != null) {
                creditCard.expiryYear = creditCardAttributes.expiryYear
            }
            creditCard.save()

        } catch (Exception e) {
            System.println("Mostly likely failed due poorly formatted creditCard info!")
        }
    }

    def updateCustomer(Map customerAttributes) {
        try {

            Customer customer = Customer.get(customerAttributes.userId)
            if (customerAttributes.password != "") {
                customer.password = customerAttributes.password
            }
            if (customerAttributes.email != "") {
                customer.email = customerAttributes.email
            }
            customer.save()
            return true
        } catch (Exception e) {
            return false
        }
    }

    /**
     * VIEW CUSTOMER ACCOUNT
     *
     * Returns customer and their credit Card info.  Might be useful since view account will
     * most likely display credit card information.
     *
     * @param userName
     * @return
     */
    public viewAccount(String userName) {
        try {
            Customer customer = Customer.findByUserName(userName)
            CreditCard creditCard = customer.creditCard
            return [customer,creditCard]
        } catch (Exception e) {
            //Probably cannot find user by username
        }
    }
}
