package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiveThread extends Thread{
	Socket server;
	public ClientReceiveThread(Socket server) {
		super();
		this.server = server;
	}
	@Override
	public void run() {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			String resmsg = "";
			while(true) {
				resmsg = in.readLine();
				if(resmsg==null) {
					break;
				}
				System.out.println("¼­¹ö : "+resmsg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
