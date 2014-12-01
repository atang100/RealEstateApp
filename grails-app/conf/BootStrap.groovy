import seg3102.Agent
import seg3102.Owner
import seg3102.User


class BootStrap {

    def init = { servletContext ->
        if(!User.count()){
            Owner owner = new Owner(
                    givenName:"John",
                    lastName: "Madden",
                    userName: "JohnMad",
                    creationDate: new Date(),
                    deleted: false
            )
            owner.password = "kony2012"
            owner.save(failOnError:true)

           Agent agent = new Agent(
                    givenName:"Jason",
                    lastName: "Statham",
                    userName: "JayStat",
                    creationDate: new Date(),
                    deleted: false
            )
            agent.password = "rambleon"
            agent.save(failOnError:true)
        }
    }
    def destroy = {
    }
}
