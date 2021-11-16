package android.control;

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
	
	public ReceiverThread(Socket client) {
		super();
		this.client = client;
		try {
			clientin = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			clientout = new PrintWriter(this.client.getOutputStream(),true);
			serialobj = new SerialArduinoLEDControl();
			serialobj.connect("COM5");
			serialout = serialobj.getOutput();
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
				if(msg.equals("led_1")) {
					serialout.write('1');
				}else if(msg.equals("led_2")) {
					serialout.write('2');
				}else if(msg.equals("led_3")){
					serialout.write('3');
				}else if(msg.equals("led_4")) {
					serialout.write('4');
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
