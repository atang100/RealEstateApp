package seg3102

class LoginController {

    def index() { }

    def authenticate = {
        def user = Person.findByUserName(params.username)
        if(user && (user.password == params.password)){
            session.user = user
            flash.message = "Hello ${user.givenName}!"
            return redirect(controller:"home")
        }else{
            flash.message = "Sorry, ${params.username}. Please try again."
            redirect(action:"index")
        }
    }
}
