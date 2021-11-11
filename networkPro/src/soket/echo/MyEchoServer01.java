package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MyEchoServer01 {
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
				//Ŭ���̾�Ʈ�� �������� �޼����� Ŭ���̾�Ʈ�� ������
				String resmsg = "";
				while(true) {
					resmsg = in.readLine();
					if(resmsg == null) {
						break;
					}
					System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : "+resmsg);
					out.println(resmsg+"******");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
