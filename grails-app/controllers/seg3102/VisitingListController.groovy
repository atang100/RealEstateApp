package seg3102

class VisitingListController {

    def PropertyService
    def VisitingListService

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

    def show() {
        def visitingList = visitingListService.viewVisitingList(params.userName)
        render(view:"show", model: [myProperties:visitingList])
    }

    def addToList() {
        visitingListService.addToVisitingList(params.propertyId,session.user.userName)
        redirect(controller:"visitingList", action:"show" )
    }

    def deleteFromList() {
        visitingListService.removeFromVisitingList(params.propertyId,session.user.userName)
        redirect(controller:"visitingList", action:"show")
    }


}
