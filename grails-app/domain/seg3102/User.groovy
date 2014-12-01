package seg3102

class User {

    String givenName
    String lastName
    String userName
    String password
    Date creationDate
    boolean deleted

    static constraints = {
        userName unique: true
    }
}
