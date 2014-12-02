package seg3102
import seg3102.AgentService

class CreateUserController {

    def CustomerService
    def OwnerService
    def AgentService

    def index() {}

    def addUser(){
        def type = params.userType
        Map map = [:];
        if(type == "Agent"){
            map.givenName = params.givenName
            map.lastName = params.lastName
            map.userName = params.username
            map.password = params.password
            map.creationDate = new Date()
            map.deleted = false
            agentService.createAgent(map)//null pointer exception here
            flash.message = "Agent created."
        }else if(type == "Owner"){
            map.givenName = params.givenName
            map.lastName = params.lastName
            map.userName = params.username
            map.password = params.password
            map.creationDate = new Date()
            map.deleted = false
            ownerService.createOwner(map)//null pointer exception here
            flash.message = "Owner created."
        }else if(type == "Customer"){
            map.givenName = params.givenName
            map.lastName = params.lastName
            map.userName = params.username
            map.password = params.password
            map.creationDate = new Date()
            map.deleted = false
            customerService.createCustomer(map)//null pointer exception here
            flash.message = "Customer created."
        }
        redirect(controller:"createUser")
    }



}
