package androidtcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket client;
	BufferedReader clientin;//Ŭ���̾�Ʈ�� ������ �޼���
	PrintWriter clientout;//Ŭ���̾�Ʈ���� ������ �޼���
	SerialArduinoLEDControl serialobj;//�ø��� ���
	OutputStream serialout;//�ø�����ſ��� �Ƶ��̳�� �����͸� ��������
	
	public ReceiverThread(Socket client, OutputStream serialout) {
		super();
		this.client = client;
		this.serialout = serialout;
		try {
			clientin = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			clientout = new PrintWriter(this.client.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		super.run();
		while(true) {
			try {
				String msg = clientin.readLine();
				System.out.println("Ŭ���̾�Ʈ�� ���� �޼��� : "+msg);
				if(msg.equals("led_on")) {
					serialout.write('o');
				}else if(msg.equals("led_off")) {
					serialout.write('f');
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
