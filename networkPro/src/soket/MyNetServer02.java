package soket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
//클라이언트와 통신하기 위한 서버
//클라이언트가 접속하면 클라이언트와 통신할 수 있는 IO스트림객체를 구해서 클라이언트에 메세지를 전송
//클라이언트가 서버의 메세지를 받고 다시 보내온 메세지를 서버콘솔에 출력
//클라이언트와 IO((input > DataInputStream, output > DataOutputStream)

public class MyNetServer02 {
	public static void main(String[] args) {
			Socket client = null;
			InputStream soketIn = null; //클라이언트가 보내오는 데이터를 읽기위한 스트림
			OutputStream soketOut = null; // 클라이언트에게 데이터를 보내기 위해서 소켓에서 꺼내오는 스트림 객체
			DataInputStream dis = null; //클라이언트로 부터 읽은 데이터를 타입별로 읽기 위해 사용하는 스트림객체
			DataOutputStream dos = null; // 클라이언트로 데이터를 타입별로 보내기 위해 사용하는 스트림객체
			//클라이언트와 통신 하기 위한 Input/Output 스트림 객체를 소켓으로 부터 구해 생성
			
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("server ready ok......client wait");
			//다중의 클라이언트에게 서비스를 제공 하기 위해 무한루프
			while(true) {
			client = server.accept();
			InetAddress clientIP = client.getInetAddress();
			System.out.println("client inform - "+clientIP.getHostAddress());	
				
			soketIn = client.getInputStream();
			soketOut = client.getOutputStream();
			dis = new DataInputStream(soketIn);
			dos = new DataOutputStream(soketOut);
			
			//1.클라이언트가 접속을 하면 메시지를 보내기
			//서버 >> 클라이언트(순서 중요)
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
