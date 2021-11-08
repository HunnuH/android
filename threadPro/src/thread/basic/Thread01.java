package thread.basic;

 class ThreadDemo01  extends Thread{
	 ThreadDemo01(String name) {
		 super(name);
	 }
	 @Override
	 public void run() {
		 for(int i =1; i <=20; i++) {
			 System.out.print(i+"("+getName()+")");
			 if(i%5==0) {
				 System.out.println();
			 }
			 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	 }
	 
}
 //Thread
public class Thread01 {
	public static void main(String[]args) {
		System.out.println("*******start*******");
		ThreadDemo01 t1 = new ThreadDemo01("t1");
		ThreadDemo01 t2 = new ThreadDemo01("t2");
		t1.start();
		t2.start();
		 for(int i =1; i <=10; i++) {
			 System.out.println("main: "+i);
			 try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		System.out.println("*******end*******");
		
	}
}
