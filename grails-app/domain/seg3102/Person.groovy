package seg3102

class Person {

    String givenName
    String lastName
    String userName
    String password
    String email
    Date creationDate
    boolean deleted

    static constraints = {
        userName unique: true
        email unique: true
    }
}
