package basic;

import java.net.InetAddress;
import java.net.UnknownHostException;
public class inetAddressTest {
	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName(args[0]);
			System.out.println("gethostname >> "+ ia.getHostAddress());
			System.out.println("gethostname >> "+ ia.getHostName());
			System.out.println("gethostname >> "+ InetAddress.getLocalHost());
			
			InetAddress[] lalist  = InetAddress.getAllByName(args[0]);
			for(int i=0; i <lalist.length; i++ ) {
			System.out.println("gethostname >> "+ lalist[i].getHostAddress());
			System.out.println("gethostname >> "+ lalist[i].getHostName());
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}
}
