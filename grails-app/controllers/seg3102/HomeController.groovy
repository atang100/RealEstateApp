package seg3102

class HomeController {

    def index() {
        if (session.user == null){
            redirect(controller:"login")
        }else{
            def userType
            if(session.user.instanceOf(Agent)){
                userType = "agent"
            }else if (session.user.instanceOf(Owner)){
                userType = "owner"
            }else if(session.user.instanceOf(Customer)){
                userType = "customer"
            }
            session.user
            render view:"index", model: [userType:userType]
        }
    }


}
