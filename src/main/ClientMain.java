package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import distribution.VotingProxy;

public class ClientMain {
	
	private static final int PORT = 2424;
	private static final String HOST = "localhost";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VotingProxy voting = new VotingProxy(HOST, PORT, 0);
	
		System.out.println("Welcome to Middleware Voting!");
		String input = new String();
		
		int candidate = 0;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			while (input != null) {
				String result = "";
				System.out.println("Type 1-3 for your desired operation:");
				System.out.println("1. Vote");
				System.out.println("2. Candidates Availables");
				System.out.println("3. Vote Calculation");
				System.out.println("4. Exit");
				
				try {
					input = in.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				if(input.compareTo("4") == 0) {
					System.out.println("Goodbye!");
					System.exit(0);
				}
			
							
				if (input != null) {
					switch (input.toLowerCase()) {
					case "1":
					case "vote":
						candidate = Integer.parseInt(in.readLine());
						result = voting.vote(candidate);
						break;
					case "2":
					case "candidates":
						result = voting.getCandidates();
						break;
					case "3":
					case "calculation":
						result = voting.calculation();
						break;
				
					default:
						System.out.println("Operação inválida!");
					}				
				
					System.out.println(result);
					System.out.println();
				}				
			} 
		
		} catch(Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
