package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
	
		try {
			Socket client = new Socket("localhost",5555);
			System.out.println("Client gestartet!");
			
			OutputStream out = client.getOutputStream();
			PrintWriter writer = new PrintWriter(out);
			InputStream in = client.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			writer.write("Hallo Server!\n");
			writer.flush();
			

			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
