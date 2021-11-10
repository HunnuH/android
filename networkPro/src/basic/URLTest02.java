package basic;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest02 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			URL url =  new URL("http://cafefiles.naver.net/20120209_226/pododumok_13287752996753FNE4_jpg/%C0%E5%B5%BF%B0%C7_5_pododumok.jpg");
			/*인터넷에서 확인할 수 있는 자원인 이미지를 이용해서 URL생성
			 * 이 이미지를 클라이언트 oc애 저장(image폴더에 myimg.jpg로 저장)
			 * file io(binary file이므로 BufferdInputStrem(read메소드), FileOutputStream이용
			 * 출력 >> fileOutputStream */
			
			BufferedInputStream br = new BufferedInputStream(url.openStream());
			fos = new FileOutputStream("src/img/myimg.jpg");
			while(true) {
				int data_byte = br.read();
				if(data_byte==-1) {
					break;
				}
				fos.write(data_byte);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
			if(fos!=null) fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
