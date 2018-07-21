class NewDisplay {
	/*static synchronized method will block any other method executing this method as This is class level lock.
	 * */
	public static synchronized void staticSyncDisplay() {
		for(int i=0; i<10; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
		System.out.println("---------------------->");
	}
	
	/*There is no link between Object Level Lock and Class Level Lock both are independent
	 * */
	public synchronized void normalDisplay() {
		for(int i=0; i<10; i++) {
			System.out.println(i + ": " + Thread.currentThread().getName());
		}
		System.out.println("---------------------->");
	}
	
	
	
}

class NewThread extends Thread {
	NewDisplay d;
	int i;
	
	NewThread(NewDisplay d, int indexForCallingMethod) {
		this.d = d;
		i = indexForCallingMethod;
	}
	
	public void run() {
		if(i == 1) {
			NewDisplay.staticSyncDisplay();
		} else if(i == 2) {
			d.normalDisplay();
		}
		
	}
}

public class ClassLevelLockDemo {
	public static void main(String[] args) {
		NewDisplay d1 = new NewDisplay();
		NewDisplay d2 = new NewDisplay();
		NewThread t1 = new NewThread(d1,1);
		NewThread t2 = new NewThread(d2,1);
		t1.start();
		t2.start();
		
		/*There is no link between Object Level Lock and Class Level Lock both are independent
		 */
		NewThread t3 = new NewThread(d2,2);
		t3.start();	
	}
}