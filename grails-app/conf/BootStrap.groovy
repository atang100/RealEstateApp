import seg3102.Agent
import seg3102.Owner
import seg3102.Person


class BootStrap {

    def init = { servletContext ->
        if (!Person.count()) {
            println("test")
            Owner owner = new Owner(
                    givenName: "John",
                    lastName: "Madden",
                    userName: "JohnMad",
                    password: "1234",
                    email: "test2@hotmail.ca",
                    creationDate: new Date(),
                    deleted: false
            )
            println("test")
            owner.save(failOnError: true)
            println("test")
            Agent agent = new Agent(
                    givenName: "Jason",
                    lastName: "Statham",
                    userName: "JayStat",
                    password: "1234",
                    email: "test@gmail.ca",
                    creationDate: new Date(),
                    deleted: false
            )
            println("test")
            agent.save(failOnError: true)
            println("test")
        }
    }

    def destroy = {
    }
}
