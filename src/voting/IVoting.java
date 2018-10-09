package voting;

import java.util.ArrayList;

public interface IVoting {
	public String vote(int candidateID) throws Throwable;
	
	public String getCandidates() throws Throwable;
	
	public String calculation() throws Throwable;
	
}
