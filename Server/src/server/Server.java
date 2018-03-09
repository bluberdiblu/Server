package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {	
	ExecutorService executor;
	ServerSocket server;
	
	public void start() {
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
	}
}
