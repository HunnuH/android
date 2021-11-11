package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerReceiveThread extends Thread{
	Socket client;
	public ServerReceiveThread(Socket client) {
		super();
		this.client = client;
	}
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String resmsg = "";
			while(true) {
				resmsg = in.readLine();
				if(resmsg==null) {
					break;
				}
				System.out.println("클라이언트 : "+resmsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

