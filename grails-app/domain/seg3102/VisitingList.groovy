package seg3102

class VisitingList {

    static belongsTo = [customer: Customer]
    static hasMany = [property: Property]
    static constraints = {
    }
}
