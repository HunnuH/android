package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyEchoServer02 {
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
				out = new PrintWriter(client.getOutputStream(),true);
				out.println("안녕하세요 클라이언트님?");
				String resmsg = "";
				while(true) {
					resmsg = in.readLine();
					if(resmsg == null) {
						break;
					}
					if(resmsg.startsWith("안녕하세요?") | resmsg.startsWith("하이")) {
						out.println(clientIP.getHostAddress()+"님 반가워요");
					}else if(resmsg.startsWith("오늘 날씨는")) {
						out.println(new Date().toString());
					}else {
						out.println(clientIP.getHostAddress()+ "~~님 어여 가~~~");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
