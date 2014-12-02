package seg3102

class PropertiesController {

    def OwnerService
    def PropertyService

    def index() {}

    def show() {
        def properties = ownerService.ownerViewProperties(session.user.userName)
        render view:"show", model: [properties:properties]
    }

    def create() {
        Map addressMap = [:];
        Map propertyMap = [:];

        addressMap.streetName = params.streetName
        addressMap.streetNumber = params.streetNumber
        addressMap.aptNumber = params.aptNumber
        addressMap.city = params.city
        addressMap.postalCode = params.postalCode
        addressMap.province = params.province
        addressMap.country = params.country

        propertyMap.type = params.type
        propertyMap.numBedrooms = params.numBedrooms
        propertyMap.numBathrooms = params.numBathrooms
        propertyMap.numOtherRooms = params.numOtherRooms
        propertyMap.rent = params.rent
        propertyMap.deleteStatus = false

        propertyService.addProperty(propertyMap,addressMap,session.user.userName)

        redirect(controller:"properties", action:"show")
    }

    def update() {}

    def destroy() {}
}
