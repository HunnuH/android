package androidtcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class senderThread extends Thread{
	Socket client;
	BufferedReader clientin;//Ŭ���̾�Ʈ�� ������ �޼���
	PrintWriter clientout;//Ŭ���̾�Ʈ���� ������ �޼���
	InputStream serialin;
	
	public senderThread(Socket client, InputStream serialin) {
		super();
		this.client = client;
		this.serialin = serialin;
		try {
			clientin = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
			clientout = new PrintWriter(this.client.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		byte[] buffer = new byte[1024];
		int len = -1;
		try {
			while((len = serialin.read(buffer))>-1) {
				String mydata = new String(buffer,0,len);
				System.out.print(mydata);
				if(mydata.trim().length()>0) {
					clientout.println(mydata);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
