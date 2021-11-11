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
			System.out.println("���� page");
			System.out.println("���� ���� �Ϸ�");
			while(true) {
				client = server.accept();
				InetAddress clientIP = client.getInetAddress();
				System.out.println("������ Ŭ���̾�Ʈ : "+clientIP.getHostAddress());
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream(),true);
				keyin = new BufferedReader(new InputStreamReader(System.in));
				//Ŭ���̾�Ʈ�� �������� �޼����� Ŭ���̾�Ʈ�� ������
				String resmsg = "";
				String sendmsg = " "; 
				while(true) {
					resmsg = in.readLine();
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : "+resmsg);
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
