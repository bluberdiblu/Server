package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Clienthandler implements Runnable{

	public Socket client;
	public OutputStream out;
	public PrintWriter writer;
	public InputStream in;
	public BufferedReader reader;
	
	public Clienthandler(Socket client) {
		this.client = client;
	}
	
	@Override
	public void run() {
		try {
			out = client.getOutputStream();
			writer = new PrintWriter(out);
			
			in = client.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			
			while(!client.isClosed()) {
				writer.write("Hello, please Send a message back");
				writer.flush();
				
				String ClientMessage = null;
				
				while(!client.isClosed()&&(ClientMessage = reader.readLine())!=null) {
					System.out.println(ClientMessage);
					client.close();
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
