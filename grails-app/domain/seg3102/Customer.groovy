package seg3102

class Customer extends User{

    CreditCard creditCard
    VisitingList visitingList

    static hasMany = [rentRecord: RentRecord]

    static constraints = {
    }
}
