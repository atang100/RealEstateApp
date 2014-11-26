package seg3102

class HomeController {

    def index() {
        if (session.user == null){
            redirect(controller:"login")
        }else{
            render view:"index"
        }
    }
}
