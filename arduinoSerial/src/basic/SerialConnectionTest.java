package basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class SerialConnectionTest {
	public void connect(String portName) {
		//com포트가 실제 존재하고 사용가능한 상태인지 확인
		try {
			CommPortIdentifier comportidentifier = CommPortIdentifier.getPortIdentifier(portName);
			//포트가 사용중인지 체크
			if(comportidentifier.isCurrentlyOwned()) {
				System.out.println("포트 사용불가");
			}else {
				System.out.println("포트 사용가능");
				CommPort commport = comportidentifier.open("basic_serial", 3000);
				System.out.println(commport);
				
				if(commport instanceof SerialPort) {
					SerialPort serialport = (SerialPort)commport;
					serialport.setSerialPortParams(
							9600,//통신 속도
							SerialPort.DATABITS_8,//데이터 길이
							SerialPort.STOPBITS_1,//stop bit
							SerialPort.PARITY_NONE); //오류검출
					//시리얼 포트와 통신 할수있도록 input/output스트림 객체 구하기
					InputStream in = serialport.getInputStream();
					OutputStream out = serialport.getOutputStream();
					
					new Thread(new SerialReaderThread(in)).start();
					new Thread(new SerialWriterThread(out)).start();
				}
			}
		} catch (NoSuchPortException e) {
			e.printStackTrace();
		} catch (PortInUseException e) {
			e.printStackTrace();
		} catch (UnsupportedCommOperationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SerialConnectionTest().connect("COM5");
	}
}
