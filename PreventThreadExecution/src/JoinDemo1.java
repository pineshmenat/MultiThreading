class NewThread extends Thread {
	public void run() {
		for(int i=0; i< 10; i++) {
			System.out.println("New Thread");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class JoinDemo1 {
	public static void main(String[] args) throws InterruptedException {
		NewThread t = new NewThread();
		t.start();
		t.join();
		for(int i=0; i< 10; i++) {
			System.out.println("Main Thread");
		}
	}
}
