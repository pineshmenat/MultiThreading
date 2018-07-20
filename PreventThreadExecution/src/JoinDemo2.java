class SomeThread extends Thread {
	public static Thread mt;
	public void run() {
		try {
			mt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i< 10; i++) {
			System.out.println("Some Thread");
		}
	}
}
public class JoinDemo2 {
	public static void main(String[] args) {
		SomeThread.mt = Thread.currentThread();
		SomeThread st = new SomeThread();
		st.start();
		for(int i=0; i< 10; i++) {
			System.out.println("Main Thread");
		}
	}
}
