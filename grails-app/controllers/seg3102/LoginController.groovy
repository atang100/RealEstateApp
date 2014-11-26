package seg3102

class LoginController {

    def index() { }

    def authenticate = {
        def user = User.findByUserName(params.username)
        if(user){
            session.user = user
            flash.message = "Hello ${user.givenName}!"
            redirect(controller:"home")
        }else{
            render("Failed Login")
            //flash.message = "Sorry, ${params.username}. Please try again."
            //redirect(action:"index")
        }
    }
}
