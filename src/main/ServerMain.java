package main;

import distribution.VotingInvoker;

public class ServerMain {
	private static final int PORT = 2424;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VotingInvoker invoker = new VotingInvoker();
		
		try {
			invoker.invoke(PORT);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
