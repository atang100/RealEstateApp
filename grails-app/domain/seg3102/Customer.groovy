package seg3102

class Customer extends Person{

    CreditCard creditCard
    VisitingList visitingList

    static hasMany = [rentRecord: RentRecord]

    static constraints = {
        creditCard nullable: true
    }
}
