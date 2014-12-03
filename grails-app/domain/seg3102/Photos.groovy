package seg3102

class Photos {

    /**
     * Aggregrate relationship with owner. If we delete owner, the photos should also be deleted.
     */
    static belongsTo = [property: Propertys]

    static constraints = {
    }
}
