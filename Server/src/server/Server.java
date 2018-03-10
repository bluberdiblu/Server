package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server extends Thread{	
	ExecutorService executor;
	static ServerSocket server;
	
	@Override
	public	void run() {
		System.out.println("Type and enter to close Server");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		scanner.close();
				
		try {
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void go() {
		System.out.println("Starting Server...");
		executor = Executors.newFixedThreadPool(100);		
		
		try {
			server = new ServerSocket(5555);
			
			while(!server.isClosed()) {
				Socket client = server.accept();
				executor.execute(new Clienthandler(client));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new Server().start();
		new Server().go();
	}
}
