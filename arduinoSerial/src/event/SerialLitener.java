package event;

import java.io.IOException;
import java.io.InputStream;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialLitener implements SerialPortEventListener{
	private InputStream in;
	
	public SerialLitener(InputStream in) {
		super();
		this.in = in;
	}

	@Override
	public void serialEvent(SerialPortEvent event) {
		if(event.getEventType()==SerialPortEvent.DATA_AVAILABLE) {
			try {
				int data = in.available();
				byte[] bytedata = new byte[data];
				in.read(bytedata, 0, data);
				System.out.print("받은 데이터 : "+new String(bytedata));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
