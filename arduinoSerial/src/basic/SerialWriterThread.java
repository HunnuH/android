package basic;

import java.io.IOException;
import java.io.OutputStream;

public class SerialWriterThread implements Runnable{
	OutputStream out;
	
	public SerialWriterThread(OutputStream out) {
		super();
		this.out = out;
	}

	@Override
	public void run() {
		int data = 0;
		try {
			while((data=System.in.read())>-1) {
				out.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
