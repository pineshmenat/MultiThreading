class MyThread extends Thread {
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Child Thread!");
		}
	}
}

public class ThreadPriorityDemo {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		//By setting this priority Child Thread(10) will execute first than low priority(5) main Thread will execute
		t.setPriority(10);					//If we comment this line than both MainThread and Child Thread will have same priority
		t.start();
		for(int i=0; i<10; i++) {
			System.out.println("Main Thread!");
		}
	}
}