package soket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient01 {
	public static void main(String[] args) {
		//1. ������ ����Ҽ��ִ� ���ϰ�ü�� ����
		// ������ ������ ��û
		try {
			Socket client = new Socket("192.168.0.221",12345);
			System.out.println("server ok - "+client);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
