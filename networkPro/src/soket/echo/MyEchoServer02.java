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
			System.out.println("���� page");
			System.out.println("���� ���� �Ϸ�");
			while(true) {
				client = server.accept();
				InetAddress clientIP = client.getInetAddress();
				System.out.println("������ Ŭ���̾�Ʈ : "+clientIP.getHostAddress());
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream(),true);
				out.println("�ȳ��ϼ��� Ŭ���̾�Ʈ��?");
				String resmsg = "";
				while(true) {
					resmsg = in.readLine();
					if(resmsg == null) {
						break;
					}
					if(resmsg.startsWith("�ȳ��ϼ���?") | resmsg.startsWith("����")) {
						out.println(clientIP.getHostAddress()+"�� �ݰ�����");
					}else if(resmsg.startsWith("���� ������")) {
						out.println(new Date().toString());
					}else {
						out.println(clientIP.getHostAddress()+ "~~�� � ��~~~");
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
