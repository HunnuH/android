package thread.basic;
//���ͷ�Ʈ �߻����� ����
class stopThread02 extends Thread{
	 public void run() {
		 
		while(Thread.currentThread().isInterrupted())
		System.out.println("������");
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("������� ����");
		}
			System.out.println("������� : ������·� ��");
		}
	 //�������� ���¸� ������ �� �ִ� ������ ���� �����ϴ� �޼ҵ�
	 }

public class StopThreadTest02 {
	public static void main(String[] args) {
		System.out.println("*******main start*******");
		Thread t1 = new Thread(new stopThread02());
		t1.start();
		System.out.println("�������� �̸� : "+t1.getName());
		System.out.println("�������� ���� �̷��ͷ�Ʈ ����"+t1.isInterrupted());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
		System.out.println("�������� ���� ���ͷ�Ʈ ����");
		System.out.println("*******main stop*******");
	}
}
