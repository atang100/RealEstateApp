package seg3102

class UsersController {

    def CustomerService
    def OwnerService
    def AgentService
    def UserService

    def index() {}

    def create(){
        def type = params.userType
        Map map = [:];
        if(type == "Agent"){
            map.givenName = params.givenName
            map.lastName = params.lastName
            map.userName = params.username
            map.password = params.password
            map.email = params.email
            map.creationDate = new Date()
            map.deleted = false
            agentService.createAgent(map)//null pointer exception here
            flash.message = "Agent created."
        }else if(type == "Owner"){
            map.givenName = params.givenName
            map.lastName = params.lastName
            map.userName = params.username
            map.password = params.password
            map.email = params.email
            map.creationDate = new Date()
            map.deleted = false
            ownerService.createOwner(map)//null pointer exception here
            flash.message = "Owner created."
        }else if(type == "Customer"){
            map.givenName = params.givenName
            map.lastName = params.lastName
            map.userName = params.username
            map.password = params.password
            map.email = params.email
            map.creationDate = new Date()
            map.deleted = false
            customerService.createCustomer(map)//null pointer exception here
            flash.message = "Customer created."
        }
        redirect(controller:"users")
    }
    def viewAccount(){
        Person p = Person.findByUserName(session.user.userName)
        def layoutType
        def userType
        if(session.user.instanceOf(Agent)){
            layoutType = "agentLayout"
            userType = "Agent"
        }else if (session.user.instanceOf(Owner)){
            layoutType = "ownerLayout"
            userType = "Owner"
        }else if(session.user.instanceOf(Customer)) {
            layoutType = "customerLayout"
            userType = "Customer"
        }
        Map person = [:]
        person.layoutType = layoutType
        person.userName = p.userName
        person.givenName = p.givenName
        person.lastName = p.lastName
        person.email = p.email
        person.userType = userType

        render (view:"/users/viewAccount", model: [person:person])
    }

    def updateAccountUI(){
        Person p = Person.findByUserName(session.user.userName)
        def userType
        def layoutType
        if(session.user.instanceOf(Agent)){
            layoutType = "agentLayout"
            userType = "Agent"
        }else if (session.user.instanceOf(Owner)){
            layoutType = "ownerLayout"
            userType = "Owner"
        }else if(session.user.instanceOf(Customer)) {
            layoutType = "customerLayout"
            userType = "Customer"
        }
        Map person = [:]
        person.layoutType = layoutType
        person.userType = userType
        person.userName = p.userName
        person.givenName = p.givenName
        person.lastName = p.lastName
        person.email = p.email
        person.password = p.password

        render (view:"/users/updateAccount", model: [person:person])
    }

    def updateAccount() {
        println("UPDATE ACCOUNT CONTROLLER EXECUTED")
        def map = [:]
        map.password = params.password
        map.email = params.email
        map.userId = session.user.id

        def userType
        if(session.user.instanceOf(Agent)){
            userType = "agentLayout"
        }else if (session.user.instanceOf(Owner)){
            userType = "ownerLayout"
            ownerService.updateOwner(map)
        }else if(session.user.instanceOf(Customer)) {
            userType = "customerLayout"
            customerService.updateCustomer(map)
        }
        flash.message = "Profile Updated."
        redirect(controller:"users", action:"viewAccount")
    }

    def deleteAccount(){
        Person p = Person.findByUserName(session.user.userName)
        userService.deactivateAccount(p.userName)
        session.user = null
        redirect(controller: "home", action: "index")
    }



}
