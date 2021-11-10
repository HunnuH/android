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
		InputStream soketIn = null; //서버가 보내오는 데이터를 읽기위한 스트림
		OutputStream soketOut = null; // 서버에게 데이터를 보내기 위해서 소켓에서 꺼내오는 스트림 객체
		DataInputStream dis = null; //서버로 부터 읽은 데이터를 타입별로 읽기 위해 사용하는 스트림객체
		DataOutputStream dos = null; // 서버로 데이터를 타입별로 보내기 위해 사용하는 스트림객체
		try {
			serverobj = new Socket("192.168.0.21",12345);
			System.out.println("server ok - "+serverobj);
			soketIn = serverobj.getInputStream();
			soketOut = serverobj.getOutputStream();
			dis = new DataInputStream(soketIn);
			dos = new DataOutputStream(soketOut);
			
			//1.서버가 보내오는 데이터 읽기 (순서 중요)
			//클라이언트 << 서버
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
