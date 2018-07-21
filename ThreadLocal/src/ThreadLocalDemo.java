class MyThread extends Thread {
	ThreadLocal tl = new ThreadLocal() {
		protected Object initialValue() {
			return "default-value";
		}
	};
	
	public void run() {
		tl.set("123");
		System.out.println("ThreadLocal variable: " + tl.get());
		tl.remove();
		System.out.println("ThreadLocal Default value: " + tl.get());
	}
	
}
public class ThreadLocalDemo {
	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
	}
}
