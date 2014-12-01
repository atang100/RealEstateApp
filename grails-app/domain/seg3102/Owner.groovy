package seg3102

class Owner extends User{

    /**
     * Creates a one to many relationship between Owner and Photos.
     */
    static hasMany = [property: Property]
    static constraints = {
    }
}
