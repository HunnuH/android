package soket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MyNetServer03 {
	public static void main(String[] args) {
			Socket client = null;
			InputStream soketIn = null; 
			OutputStream soketOut = null;
			DataInputStream dis = null; 
			DataOutputStream dos = null; 
			
		try {
			ServerSocket server = new ServerSocket(12345);
			System.out.println("server page");
			System.out.println("server ready ok......client wait");
			while(true) {
			client = server.accept();
			InetAddress clientIP = client.getInetAddress();
			System.out.println("client inform - "+clientIP.getHostAddress());	
				
			soketIn = client.getInputStream();
			soketOut = client.getOutputStream();
			dis = new DataInputStream(soketIn);
			dos = new DataOutputStream(soketOut);
			
			dos.writeUTF("안녕하세요 클라이언트님");
			dos.writeInt((int)(Math.random() * 7)+2);
			
			
			String data = dis.readUTF();
			System.out.println("client message : "+data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
