package seg3102
import seg3102.AgentService

class CreateUserController {

    def index() {}

    def addUser(){
        def type = params.userType
        if(type == "Agent"){
            AgentService agentService = new AgentService();
            Map map = new HashMap();
            map.givenName = params.givenName
            map.lastName = params.lastName
            map.userName = params.username
            map.password = params.password
            map.creationDate = new Date()
            map.deleted = false
            System.println(map.toMapString())
            new AgentService().createAgent(map)//null pointer exception here
            flash.message = "Agent created."
        }else if(type == "Owner"){
            OwnerService ownerService = new OwnerService();
            Map map = new HashMap();
            map.givenName = params.givenName
            map.lastName = params.lastName
            map.userName = params.username
            map.password = params.password
            map.creationDate = new Date()
            map.deleted = false
            ownerService.createOwner(map)//null pointer exception here
            flash.message = "Owner created."
        }else if(type == "Customer"){
            CustomerService customerService = new CustomerService();
            Map map = new HashMap();
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
