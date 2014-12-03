package seg3102

import java.sql.Time

class RentController {

    def PropertyService

    def index() {}

    def rent() {
        Map rentAttributes = [:];
        rentAttributes.rentDate = (Date)params.rentDate
        rentAttributes.rentTime = (Time)params.rentTime
        propertyService.rentProperty(params.propertyId,session.user.userName,rentAttributes)
        redirect(controller: "visitingList")
    }
}
