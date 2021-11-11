package soket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyNetClient03 {
	public static void main(String[] args) {
		Socket serverobj = null;
		InputStream soketIn = null; 
		OutputStream soketOut = null; 
		DataInputStream dis = null;
		DataOutputStream dos = null; 
		try {
			serverobj = new Socket("192.168.0.21",12345);
			System.out.println("client page");
			System.out.println("server ok - "+serverobj);
			soketIn = serverobj.getInputStream();
			soketOut = serverobj.getOutputStream();
			dis = new DataInputStream(soketIn);
			dos = new DataOutputStream(soketOut);
			String data = dis.readUTF();
			
			System.out.println("server message - "+data);
			int intdata = dis.readInt();
			System.out.println("±¸±¸´Ü  - "+intdata+" ´Ü");
			 int m = 1;
		     int n = intdata;
		      while(m<10){
		           int result = n*m;
		           System.out.println(n+" * "+m+" = "+result);
		           m++;
		      		}
		      
	      	if(intdata % 2==0) {
	      		dos.writeUTF("Â¦¼ö");
	      	}else {
	      		dos.writeUTF("È¦¼ö");
	      	}
		     
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
