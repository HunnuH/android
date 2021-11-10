package soket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyNetServer01 {
	public static void main(String[] args) {
			//1.클라이언트와 통신할수있는 객체를 생성
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("server ready ok......client wait");
			//2.클라이언트가 접속할때 까지 대기, 클라이언트가 접속하면 접속한 정보를 리턴
			Socket client = server.accept();
			System.out.println("client inform - "+client);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
