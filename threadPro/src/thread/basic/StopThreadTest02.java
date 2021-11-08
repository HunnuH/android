package thread.basic;
//인터럽트 발생시켜 종료
class stopThread02 extends Thread{
	 public void run() {
		 
		while(Thread.currentThread().isInterrupted())
		System.out.println("실행중");
	
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("현재상태 종료");
		}
			System.out.println("현재상태 : 종료상태로 들어감");
		}
	 //쓰레드의 상태를 조절할 수 있는 변수의 값을 변경하는 메소드
	 }

public class StopThreadTest02 {
	public static void main(String[] args) {
		System.out.println("*******main start*******");
		Thread t1 = new Thread(new stopThread02());
		t1.start();
		System.out.println("스레드의 이름 : "+t1.getName());
		System.out.println("스레드의 현재 이러터럽트 상태"+t1.isInterrupted());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
		System.out.println("쓰레드의 현재 인터럽트 상태");
		System.out.println("*******main stop*******");
	}
}
