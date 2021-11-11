package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSenderThread extends Thread{
	Socket server;
	public ClientSenderThread(Socket server) {
		super();
		this.server = server;
	}
	@Override
	public void run() {
		BufferedReader keyin = null;
		PrintWriter out = null;
		
		try {
			keyin = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(server.getOutputStream(),true);
			String sendmsg = "";
			while(true) {
				sendmsg = keyin.readLine();
				if(sendmsg==null) {
					break;
				}
				out.println(sendmsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
