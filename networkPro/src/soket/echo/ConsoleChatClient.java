package soket.echo;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConsoleChatClient {
	public static void main(String[] args) {
		Socket server;
		try {
			server = new Socket("192.168.0.123",12345);
			System.out.println("서버접속완료...");
			new ClientReceiveThread(server).start();
		new ClientSenderThread(server).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
