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
			System.out.println("���� page");
			System.out.println("���� ���� �Ϸ�");
			while(true) {
				client = server.accept();
				InetAddress clientIP = client.getInetAddress();
				System.out.println("������ Ŭ���̾�Ʈ : "+clientIP.getHostAddress());
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintWriter(client.getOutputStream());
				out.println("Ŭ���̾�Ʈ�� ���� ����");
				out.flush();
				String msg = in.readLine();
				System.out.println("Ŭ���̾�Ʈ�� ������ �޼��� : "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
