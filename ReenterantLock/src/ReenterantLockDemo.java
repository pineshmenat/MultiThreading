import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BlockDisplay {
	ReentrantLock l = new ReentrantLock();
	public void displayMethod() throws InterruptedException {
		do {
            try {
                if (l.tryLock(500, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + "...Got lock");
                    Thread.sleep(2000);
                    l.unlock();
                    System.out.println(Thread.currentThread().getName() + "...releases lock");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName()
                            + "...unable to get lock, let's try again");
                }
            } catch (InterruptedException ex) {
            }
        } while (true);
	}
}

class ThreadForBlock extends Thread {
	BlockDisplay d;
	
	ThreadForBlock(BlockDisplay d) {
		this.d = d;
	}
	
	public void run() {
		try {
			d.displayMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class ReenterantLockDemo {
	public static void main(String[] args) {
		BlockDisplay d1 = new BlockDisplay();
		ThreadForBlock t1 = new ThreadForBlock(d1);
		ThreadForBlock t2 = new ThreadForBlock(d1);
		
		t1.start();
		t2.start();
		
	}
}