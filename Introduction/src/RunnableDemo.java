/* 1. Prefer this method to create thread insted of Extending Thread class because if you extend one class you won't have option to 
 * 	  extend other class, Whereas here you can implement Runnable and still can extend any required class
 * 2. Always override run method but never override start() method as start() method performs registration of thread to ThreadSchedular and other
 * 	  Initialization activities. And it won't create new Thread if we extend start() method
 * 3. Never try to call run() directly, it won't create thread and it will be normal method call.
 * */

class MyThread implements Runnable {
	
	public void start() {
		System.out.println(Thread.currentThread().getName() + "786");
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i );
		}
	}
	
}

public class RunnableDemo {
	
	public static void main(String[] args) {
		MyThread runnable = new MyThread();
		Thread thread = new Thread(runnable);
		thread.setName("MyThread");
		thread.start();
		Thread.currentThread().setName("MainThread");
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i );
		}
		System.out.println("End of main method..");
	}
}