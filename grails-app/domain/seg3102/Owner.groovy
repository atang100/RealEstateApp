package seg3102

class Owner extends Person{

    /**
     * Creates a one to many relationship between Owner and Photos.
     */
    static hasMany = [propertys: Propertys]
    static constraints = {
        properties nullable:true
    }
}
