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
			
			for(int i = 0; i < 10; i++) {
				int contador = 2500;
				long elapsedTime = 0;
				while(contador-- > 0) {
					long currentTime = System.currentTimeMillis();
					voting.calculation();
					elapsedTime += System.currentTimeMillis() - currentTime;
				}
				System.out.println(elapsedTime);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
