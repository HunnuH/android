package android.control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//�ȵ���̵��� ��û�� ������ �Ƶ��̳� ��ġ�� ���
public class AndroidLEDControlServer {
	private ServerSocket server;
	public void connect() {
		try {
			server = new ServerSocket(12345);
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					while(true) {
					try {
						Socket 	client = server.accept();
						String ip = client.getInetAddress().getHostName();
						System.out.println(ip+"����� ����");
						//Ŭ���̾�Ʈ�� �޽����� �д� ������
						new ReceiverThread(client).start();
					} catch (IOException e) {
						e.printStackTrace();
						}
					}
				}
			});
			t1.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new AndroidLEDControlServer().connect();
	}
}
