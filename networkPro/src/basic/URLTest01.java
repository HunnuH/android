package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest01 {
	public static void main(String[] args) {
		try {
			//URL url = new URL("https://www.kisa.or.kr/public/laws/laws1.jsp");
			URL url = new URL("http://www.daum.net");
			System.out.println(url.toString());
			System.out.println("gethost >> "+ url.getHost());
			System.out.println("getpath >> "+ url.getPath());
			System.out.println("getport >> "+ url.getPort()); //http의 -1 기본포트로 접속을 의미
			System.out.println("getprotocol >> "+ url.getProtocol());
			System.out.println("getfile >> "+ url.getFile());
			
			/*
			 * InputStream is = url.openStream();
			 *  InputStreamReader isr = new InputStreamReader(is);
			 */
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			while(true) {
				String data_byte = br.readLine();
				if(data_byte==null) {
					break;
				}
				System.out.println(data_byte);
			}
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
