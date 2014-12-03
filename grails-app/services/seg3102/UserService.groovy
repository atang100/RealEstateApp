package seg3102

import grails.transaction.Transactional

@Transactional
class UserService {

    def deactivateAccount(String userName) {

        try {
            Person person = Person.findByUserName(userName)
            person.delete()
        } catch (Exception e) {

        }
    }
}
