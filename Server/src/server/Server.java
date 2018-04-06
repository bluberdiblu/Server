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
			if(server!=null) server.close();
		} catch (IOException e) {
			System.out.println("Server close exception");			
		}
		System.out.println("Console Closed!");
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
			executor.shutdown();
			System.out.println("Server Closed");
			
		} catch (IOException e) {
			shutdown();
			System.exit(0);
		}
	}
	private void shutdown() {
		//TODO
	}	
	
	public static void main(String[] args) {
		new Server().start();;
		new Server().go();	
	}
}
