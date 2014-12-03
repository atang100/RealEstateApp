package seg3102

import java.sql.Date

class History {

    Date startDate
    Date endDate
    int monthVisits
    int reportingVisits

    static belongsTo = [property: Propertys]

    static constraints = {
    }
}
