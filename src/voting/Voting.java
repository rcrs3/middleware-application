package voting;

import java.util.ArrayList;
import java.util.HashMap;

public class Voting implements IVoting {
	
	private HashMap<Integer, String> candidates;
	private int[] votes;
	
	public Voting() {
		this.candidates = new HashMap<Integer, String>();
		
		this.candidates.put(1, new String("Goku"));
		this.candidates.put(2, new String("Elon Musk"));
		this.candidates.put(3, new String("Shakira"));
		this.candidates.put(4, new String("Katy Perry"));
		this.candidates.put(5, new String("Cabo Daciolo"));
		
		this.votes = new int[5];
	}
	
	@Override
	public String vote(int candidateID) throws Throwable {

		if(candidates.containsKey(candidateID)) {
			
			this.votes[candidateID - 1]++;
			
			return "Voto realizado com sucesso!";
		}
		
		return "Candidato não encontrado";
	}

	@Override
	public String getCandidates() throws Throwable {
		
		String ret = "";
		
		for(int i = 0; i < 5; i++) {
			ret += "Candidato: ";
			ret += this.candidates.get(i + 1);
			ret += ", Número: ";
			ret += i + 1;
			
			ret += "\n";
		}
		
		return ret;
	}

	@Override
	public String calculation() throws Throwable {

		String ret = "";
		
		for(int i = 0; i < 5; i++) {
			ret += "Candidato: ";
			ret += this.candidates.get(i + 1);
			ret += ", Votos: ";
			ret += this.votes[i];
			
			ret += "\n";
		}
		
		return ret;
	}

}
