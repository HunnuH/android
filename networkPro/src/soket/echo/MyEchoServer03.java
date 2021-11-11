package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyEchoServer03 {
	public static void main(String[] args) {
		Socket client = null;
		BufferedReader in = null;
		BufferedReader keyin = null;
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
				out = new PrintWriter(client.getOutputStream(),true);
				keyin = new BufferedReader(new InputStreamReader(System.in));
				//클라이언트가 보내오는 메세지를 클라이언트로 재전송
				String resmsg = "";
				String sendmsg = " "; 
				while(true) {
					resmsg = in.readLine();
					System.out.println("클라이언트가 보낸 메세지 : "+resmsg);
					if(resmsg == null) {
						break;
					}
					
					sendmsg=keyin.readLine();
					out.println(sendmsg);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
