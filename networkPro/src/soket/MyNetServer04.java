package soket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyNetServer04 {
	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("서버 page");
			System.out.println("서버 접속 완료");
			while(true) {
				client = server.accept();
				InetAddress clientIP = client.getInetAddress();
				System.out.println("접속한 클라이언트 : "+clientIP.getHostAddress());
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream());
				out.println("클라이언트님 접속 성공");
				out.flush();
				String msg = in.readLine();
				System.out.println("클라이언트가 전송한 메세지 : "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
