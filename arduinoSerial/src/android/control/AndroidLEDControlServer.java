package android.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//안드로이드의 요청을 받으면 아두이노 장치와 통신
public class AndroidLEDControlServer {
	private ServerSocket server;
	public void connect() {
		try {
			server = new ServerSocket(12345);
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
					try {
						Socket 	client = server.accept();
						String ip = client.getInetAddress().getHostName();
						System.out.println(ip+"사용자 접속");
						//클라이언트의 메시지를 읽는 쓰레드
						new ReceiverThread(client).start();
					} catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
			});
			t1.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new AndroidLEDControlServer().connect();
	}
}
