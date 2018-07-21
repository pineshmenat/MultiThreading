class Display {
	public synchronized void displayMethod() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
		System.out.println("---------------------->");
	}
}

class MyThread extends Thread {
	Display d;
	
	MyThread(Display d) {
		this.d = d;
	}
	
	public void run() {
		d.displayMethod();
	}
}

public class ObjectLevelLockDemo {
	public static void main(String[] args) {
		Display d1 = new Display();		//Synchronized method will block execution of other sync methods from same object d1
		
		MyThread t1 = new MyThread(d1);
		MyThread t2 = new MyThread(d1);
		
		/*Whenever multiple threads are working on same object (d1) then only Synchronization play the role. 
		 * If multiple threads are operating on multiple objects (d2 = new Display(), other than d1) then there is no impact of synchronization.
		*/
		/*Display d2 = new Display();
		MyThread t2 = new MyThread(d2);*/

		t1.start();
		t2.start();
	}
}
