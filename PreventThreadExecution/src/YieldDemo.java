class MyThread extends Thread {
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Child Thread");
			Thread.yield();
		}	
	}
}

/*On calling yield method, current Thread will will go back to ready state, thereby allowing othrt Thread with Simillar priority to execute, 
 * if there are no threads waiting then current Thread will resume it's processing
 * */
public class YieldDemo {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		for(int i=0; i<10; i++) {
			System.out.println("Main Thread");
		}
	}
}