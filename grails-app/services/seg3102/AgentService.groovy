package seg3102

import grails.transaction.Transactional

@Transactional
class AgentService {

    def createAgent(Map agentAttributes) {

        try {
            //Grails Constructor
            Agent agent = new Agent(
                    givenName: agentAttributes.givenName,
                    lastName: agentAttributes.lastName,
                    userName: agentAttributes.userName,
                    creationDate: agentAttributes.creationDate,
                    deleted: agentAttributes.deleted
            )
            agent.save()
        } catch (Exception e) {
            System.println("Failure to create User of Type Agent!")
        }
    }
}
