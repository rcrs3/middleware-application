package distribution;

import java.io.IOException;
import java.util.HashMap;

import srh.ServerRequestHandler;
import voting.Voting;

public class VotingInvoker {

	private ServerRequestHandler requestHandler;

	public void invoke(int port) throws Throwable {
		this.requestHandler = new ServerRequestHandler(port);
		String result = "";
		Voting voting = new Voting();
		
		System.out.println("Running votingInvoker");
		
		while (true) {
			Message message = (Message) Marshaller.unmarshall(this.requestHandler.receive());			
			
			switch(message.getOperation()) {
			case "vote":
				result = voting.vote((int) message.getParameter());
				break;
			
			case "candidates":
				result = voting.getCandidates();
				break;
				
			case "calculation":
				result = voting.calculation();
				break;
				
			}

			this.requestHandler.send(Marshaller.marshall(result));
		}
	}
	
}