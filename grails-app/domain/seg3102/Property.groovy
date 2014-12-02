package seg3102

class Property {

    String type
    int numBedrooms
    int numBathrooms
    int numOtherRooms
    double rent
    boolean deleteStatus
    Address address
    VisitingList visitingList

    static hasMany = [history: History, visitingList: VisitingList, rentRecord: RentRecord, photos: Photos]
    static belongsTo = [owner: Owner, visitingList: VisitingList]
    static constraints = {
        visitingList nullable: true
    }
}
