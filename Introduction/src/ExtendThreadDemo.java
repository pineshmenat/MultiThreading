class SomeThread extends Thread {
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}


public class ExtendThreadDemo {
	public static void main(String[] args) {
		SomeThread thread = new SomeThread();
		thread.start();
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
		System.out.println("End of main..");
	}

}
