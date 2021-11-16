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
		//com��Ʈ�� ���� �����ϰ� ��밡���� �������� Ȯ��
		try {
			CommPortIdentifier comportidentifier = CommPortIdentifier.getPortIdentifier(portName);
			//��Ʈ�� ��������� üũ
			if(comportidentifier.isCurrentlyOwned()) {
				System.out.println("��Ʈ ���Ұ�");
			}else {
				System.out.println("��Ʈ ��밡��");
				CommPort commport = comportidentifier.open("basic_serial", 3000);
				System.out.println(commport);
				
				if(commport instanceof SerialPort) {
					SerialPort serialport = (SerialPort)commport;
					serialport.setSerialPortParams(
							9600,//��� �ӵ�
							SerialPort.DATABITS_8,//������ ����
							SerialPort.STOPBITS_1,//stop bit
							SerialPort.PARITY_NONE); //��������
					//�ø��� ��Ʈ�� ��� �Ҽ��ֵ��� input/output��Ʈ�� ��ü ���ϱ�
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
