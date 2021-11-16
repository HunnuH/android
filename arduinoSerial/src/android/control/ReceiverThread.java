package android.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiverThread extends Thread{
	Socket client;
	BufferedReader clientin;//클라이언트가 보내는 메세지
	PrintWriter clientout;//클라이언트에게 보내는 메세지
	SerialArduinoLEDControl serialobj;//시리얼 통신
	OutputStream serialout;//시리얼통신에서 아두이노로 데이터를 내보내기
	
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
				System.out.println("클라이언트가 보낸 메세지 : "+msg);
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
