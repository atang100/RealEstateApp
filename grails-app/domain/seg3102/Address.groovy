package seg3102

class Address {

    String streetName
    String streetNumber //Removes need of typecasting
    String aptNumber //Removes need of typecasting
    String city
    String postalCode
    String province
    String country

    static belongsTo = [propertys: Propertys]

    static constraints = {
        aptNumber nullable: true
    }
}
