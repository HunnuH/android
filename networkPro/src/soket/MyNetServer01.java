package soket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyNetServer01 {
	public static void main(String[] args) {
			//1.Ŭ���̾�Ʈ�� ����Ҽ��ִ� ��ü�� ����
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("server ready ok......client wait");
			//2.Ŭ���̾�Ʈ�� �����Ҷ� ���� ���, Ŭ���̾�Ʈ�� �����ϸ� ������ ������ ����
			Socket client = server.accept();
			System.out.println("client inform - "+client);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
