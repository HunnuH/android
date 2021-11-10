package soket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient02 {
	public static void main(String[] args) {
		Socket serverobj = null;
		InputStream soketIn = null; //������ �������� �����͸� �б����� ��Ʈ��
		OutputStream soketOut = null; // �������� �����͸� ������ ���ؼ� ���Ͽ��� �������� ��Ʈ�� ��ü
		DataInputStream dis = null; //������ ���� ���� �����͸� Ÿ�Ժ��� �б� ���� ����ϴ� ��Ʈ����ü
		DataOutputStream dos = null; // ������ �����͸� Ÿ�Ժ��� ������ ���� ����ϴ� ��Ʈ����ü
		try {
			serverobj = new Socket("192.168.0.21",12345);
			System.out.println("server ok - "+serverobj);
			soketIn = serverobj.getInputStream();
			soketOut = serverobj.getOutputStream();
			dis = new DataInputStream(soketIn);
			dos = new DataOutputStream(soketOut);
			
			//1.������ �������� ������ �б� (���� �߿�)
			//Ŭ���̾�Ʈ << ����
			String data = dis.readUTF();
			System.out.println("server sending message1 - "+data);
			int intdata = dis.readInt();
			System.out.println("server sending message2 - "+intdata);
			
			dos.writeUTF("Hello number21 client");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
