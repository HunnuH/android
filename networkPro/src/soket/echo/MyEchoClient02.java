package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyEchoClient02 {
	public static void main(String[] args) {
		Socket server = null;
		BufferedReader in = null;//서버에서 보내오는 메세지를 읽음
		BufferedReader keyin = null;//서버로 보내기 위한 키보드를 통해 입력한 메세지를 읽음
		PrintWriter out = null;
		try {
			server = new Socket("192.168.0.21",12345);
			System.out.println("클라이언트 page");
			System.out.println("서버 접속 완료");
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			out = new PrintWriter(server.getOutputStream(),true);
			keyin = new BufferedReader(new InputStreamReader(System.in));
			String sendmsg = " "; //서버로 보낼 메세지
			String resmsg = " ";//서버에서 받은 메세지
			resmsg = in.readLine();
			System.out.println("서버 : "+resmsg);
			while((sendmsg = keyin.readLine())!=null) {
				out.println(sendmsg);
				resmsg = in.readLine();
				System.out.println("서버 : "+resmsg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
