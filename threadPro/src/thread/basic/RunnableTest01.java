package thread.basic;

class Super {
	
}

//이미 상속하고 있느느 클래스가 있는경우  Thread프로그래밍을 하기 위해서 Runnable인터페이스를 상속한다.
class RunnableDemo01 extends Super implements Runnable{		 
	
	 @Override
	 public void run() {
		 for(int i =1; i <=20; i++) {
			 System.out.print(i+"("+Thread.currentThread().getName()+")");
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

public class RunnableTest01 {
	public static void main(String[] args) {
		System.out.println("*******start*******");
		RunnableDemo01 obj1  = new RunnableDemo01();
		RunnableDemo01 obj2  = new RunnableDemo01();
		Thread t1 = new Thread(obj1);
		Thread t2 = new Thread(obj2);	
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
