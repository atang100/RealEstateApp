package seg3102

class HomeController {

    def index() {
        if (session.user == null){
            redirect(controller:"login")
        }else{
            def userType
            if(session.user.instanceOf(Agent)){
                userType = "agentLayout"
            }else if (session.user.instanceOf(Owner)){
                userType = "ownerLayout"
            }else if(session.user.instanceOf(Customer)) {
                userType = "customerLayout"
            }
            render view:"index", model: [userType:userType]
        }
    }


}
