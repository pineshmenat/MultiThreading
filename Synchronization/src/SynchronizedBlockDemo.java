class BlockDisplay {
	public synchronized void displayMethod() {
		for(int i=0; i<10; i++) {
			//Object level lock using this and Class level lock using BlockDisplay.class
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + ": " + i); //Synchronized statements
			}
		}
		System.out.println("---------------------->");
	}
}

class ThreadForBlock extends Thread {
	BlockDisplay d;
	
	ThreadForBlock(BlockDisplay d) {
		this.d = d;
	}
	
	public void run() {
		d.displayMethod();
	}
}


public class SynchronizedBlockDemo {
	public static void main(String[] args) {
		BlockDisplay d1 = new BlockDisplay();
		ThreadForBlock t1 = new ThreadForBlock(d1);
		ThreadForBlock t2 = new ThreadForBlock(d1);
		
		t1.start();
		t2.start();
		
	}
}
