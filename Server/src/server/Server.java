package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {		
	
	public void start() {	
		
		System.out.println("Starting Server...");
		ExecutorService executor = Executors.newFixedThreadPool(100);	
		ServerSocket server;
		try {
			server = new ServerSocket();
			
			while(true) {
				Socket client = server.accept();
				executor.execute(new Clienthandler(client));
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) {
		new Server().start();
	}
}
