package thread.basic;

class AlphaThread extends Thread {
	public AlphaThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(char i='A'; i<='Z'; i++) {
			System.out.print(i+"("+getName()+")");
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}	

class DigitThread extends Thread{
	public DigitThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		for(int i=1; i<=100; i++) {
			System.out.print(i+"("+getName()+")");
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

public class Thread02 {
	public static void main(String[] args) {
		System.out.println("*******start*******");
		AlphaThread A = new AlphaThread("AA");
		DigitThread B = new DigitThread("BB");
		A.start();
		B.start();
		System.out.println("*******end*******");
	}
}
