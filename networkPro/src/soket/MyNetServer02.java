package soket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//Ŭ���̾�Ʈ�� ����ϱ� ���� ����
//Ŭ���̾�Ʈ�� �����ϸ� Ŭ���̾�Ʈ�� ����� �� �ִ� IO��Ʈ����ü�� ���ؼ� Ŭ���̾�Ʈ�� �޼����� ����
//Ŭ���̾�Ʈ�� ������ �޼����� �ް� �ٽ� ������ �޼����� �����ֿܼ� ���
//Ŭ���̾�Ʈ�� IO((input > DataInputStream, output > DataOutputStream)

public class MyNetServer02 {
	public static void main(String[] args) {
			Socket client = null;
			InputStream soketIn = null; //Ŭ���̾�Ʈ�� �������� �����͸� �б����� ��Ʈ��
			OutputStream soketOut = null; // Ŭ���̾�Ʈ���� �����͸� ������ ���ؼ� ���Ͽ��� �������� ��Ʈ�� ��ü
			DataInputStream dis = null; //Ŭ���̾�Ʈ�� ���� ���� �����͸� Ÿ�Ժ��� �б� ���� ����ϴ� ��Ʈ����ü
			DataOutputStream dos = null; // Ŭ���̾�Ʈ�� �����͸� Ÿ�Ժ��� ������ ���� ����ϴ� ��Ʈ����ü
			//Ŭ���̾�Ʈ�� ��� �ϱ� ���� Input/Output ��Ʈ�� ��ü�� �������� ���� ���� ����
			
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("server ready ok......client wait");
			//������ Ŭ���̾�Ʈ���� ���񽺸� ���� �ϱ� ���� ���ѷ���
			while(true) {
			client = server.accept();
			InetAddress clientIP = client.getInetAddress();
			System.out.println("client inform - "+clientIP.getHostAddress());	
				
			soketIn = client.getInputStream();
			soketOut = client.getOutputStream();
			dis = new DataInputStream(soketIn);
			dos = new DataOutputStream(soketOut);
			
			//1.Ŭ���̾�Ʈ�� ������ �ϸ� �޽����� ������
			//���� >> Ŭ���̾�Ʈ(���� �߿�)
			dos.writeUTF(clientIP.getHostAddress()+" welcome connection ");
			dos.writeInt(2000);
			
			String data = dis.readUTF();
			System.out.println("client message : "+data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
