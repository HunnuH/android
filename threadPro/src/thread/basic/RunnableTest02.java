package thread.basic;

class Super2 {
}

class AlphaThread2 extends Super2 implements Runnable {

	@Override
	public void run() {
		for(char i='A'; i<='Z'; i++) {
			System.out.print(i+"("+Thread.currentThread().getName()+")");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class DigitThread2 extends Super2 implements Runnable {

	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			System.out.print(i+"("+Thread.currentThread().getName()+")");
			if(i%10==0) {
				 System.out.println();
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


public class RunnableTest02 {
	public static void main(String[] args) {
		System.out.println("*******start*******");
		AlphaThread2 at1 = new AlphaThread2();
		DigitThread2 dt1 = new DigitThread2();
		Thread A1 = new Thread(at1);
		Thread B1 = new Thread(dt1);
		A1.start();
		B1.start();
		System.out.println("*******end*******");
	}
}
