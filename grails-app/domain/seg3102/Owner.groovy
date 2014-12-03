package seg3102

class Owner extends Person{

    /**
     * Creates a one to many relationship between Owner and Photos.
     */
    static hasMany = [propertys: Property]
    static constraints = {
        properties nullable:true
    }
}
