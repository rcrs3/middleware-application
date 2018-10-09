package distribution;

import voting.IVoting;

public class VotingProxy extends ClientProxy implements IVoting {
	
	private Requestor requestor;
	
	public VotingProxy(String host, int port, int objectID) {		
		super(host, port, objectID);
		this.requestor = new Requestor();
	}	
	
	@Override
	public String vote(int candidateID) throws Throwable {
		// TODO Auto-generated method stub
		return (String) this.requestor.invoke(this.host, this.port, this.objectID, "vote", candidateID);
	}

	@Override
	public String getCandidates() throws Throwable {
		// TODO Auto-generated method stub
		return (String) this.requestor.invoke(this.host, this.port, this.objectID, "candidates", null);
	}

	@Override
	public String calculation() throws Throwable {
		// TODO Auto-generated method stub
		return (String) this.requestor.invoke(this.host, this.port, this.objectID, "calculation", null);
	}

}