class ThreadA extends Thread {
	public void run() {
		try {
			Thread.sleep(2000);
			for(int i=0; i< 10; i++) {
				System.out.println("New Thread");
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}


public class InterruptDemo {
	public static void main(String[] args) throws InterruptedException {
		ThreadA t = new ThreadA();
		t.start();
		t.interrupt();
		for(int i=0; i< 10; i++) {
			System.out.println("Main Thread");
		}
	}
}