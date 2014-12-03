import seg3102.Agent
import seg3102.Owner
import seg3102.User


class BootStrap {

    def init = { servletContext ->
        if (!User.count()) {
            Owner owner = new Owner(
                    givenName: "John",
                    lastName: "Madden",
                    userName: "JohnMad",
                    password: "1234",
                    creationDate: new Date(),
                    deleted: false
            )
            owner.save(failOnError: true)

            Agent agent = new Agent(
                    givenName: "Jason",
                    lastName: "Statham",
                    userName: "JayStat",
                    password: "1234",
                    creationDate: new Date(),
                    deleted: false
            )
            agent.save(failOnError: true)
        }
    }

    def destroy = {
    }
}
