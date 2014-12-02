package seg3102

class LogoutController {

    def index() {
        session.user = null
        redirect(controller: "home", action: "index")
    }
}
