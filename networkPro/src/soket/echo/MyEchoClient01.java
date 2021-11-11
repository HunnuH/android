package soket.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyEchoClient01 {
	public static void main(String[] args) {
		Socket server = null;
		BufferedReader in = null;//�������� �������� �޼����� ����
		BufferedReader keyin = null;//������ ������ ���� Ű���带 ���� �Է��� �޼����� ����
		PrintWriter out = null;
		try {
			server = new Socket("192.168.0.21",12345);
			System.out.println("Ŭ���̾�Ʈ page");
			System.out.println("���� ���� �Ϸ�");
			in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			out = new PrintWriter(server.getOutputStream(),true);
			keyin = new BufferedReader(new InputStreamReader(System.in));
			//Ű����� �Է��� �����͸� ������ ���� ����, ������ �ٽ� �������� �޼����� �ֿܼ� ���
			String sendmsg = " "; //������ ���� �޼���
			String resmsg = " ";//�������� ���� �޼���
			while((sendmsg = keyin.readLine())!=null) {
				//1.Ŭ���̾�Ʈ >> ���� (Ű����� �Է��ϴ� �޼����� ������ ����)
				out.println(sendmsg);
				//2.Ŭ���̾�Ʈ << ����
				resmsg = in.readLine();
				System.out.println("������ ������ �޼��� : "+resmsg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
