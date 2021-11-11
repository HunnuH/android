package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSenderThread extends Thread{
	Socket client;
	public ServerSenderThread(Socket client) {
		super();
		this.client = client;
	}
	@Override
	public void run() {
		BufferedReader keyin = null;
		PrintWriter out = null;
		try {
			keyin = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(client.getOutputStream(),true);
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
