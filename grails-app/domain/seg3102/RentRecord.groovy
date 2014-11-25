package seg3102

import java.sql.Time

class RentRecord {

    String emailAddress
    double rent
    Date rentalDate
    Time rentalTime
    Customer customer
    Property property

    static constraints = {
    }
}
