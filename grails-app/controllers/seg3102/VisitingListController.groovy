package seg3102

class VisitingListController {

    def PropertyService

    def index() {
        Map addressMap = [:];
        addressMap.streetName = params.streetName
        addressMap.streetNumber = params.streetNumber
        addressMap.aptNumber = params.aptNumber
        addressMap.city = params.city
        addressMap.postalCode = params.postalCode
        addressMap.province = params.province
        addressMap.country = params.country

        ArrayList<Property> propertyList = propertyService.browsePropertyByLocation(addressMap)

        render (view:"index", model: [myProperties:propertyList])

    }

    def show() {}

    def addToList() {}

    def deleteFromList() {}


}
