class MyThread extends Thread {
	public MyThread(ThreadGroup tg, String name) {
		super(tg,name);
	}
	
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class ThreadGroupDemo {
	public static void main(String[] args) throws InterruptedException {
		ThreadGroup parent = new ThreadGroup("ParentGroup");
		ThreadGroup child = new ThreadGroup(parent, "ChildGroup");
		MyThread t1 = new MyThread(parent, "Thread1");
		MyThread t2 = new MyThread(parent, "Thread2");
		t1.start();
		t2.start();
		parent.setMaxPriority(4);
		MyThread t3 = new MyThread(parent, "Thread3");
		t3.start();		
		System.out.println("Thread1 priority: " + t1.getPriority());
		System.out.println("Thread3 priority: " + t3.getPriority());
		System.out.println("Active Thread count in Parent: " + parent.activeCount());
		System.out.println("Active Group count in Parent: " + parent.activeGroupCount());
		parent.list();
		Thread.sleep(3000);
		System.out.println("Active Thread count in Parent: " + parent.activeCount());
		System.out.println("Active Group count in Parent: " + parent.activeGroupCount());
		parent.list();
		ThreadGroup sys = Thread.currentThread().getThreadGroup().getParent();
		System.out.println("sys: " + sys.getName());
		Thread[] tarray = new Thread[sys.activeCount()];
		sys.enumerate(tarray);
		for(Thread t : tarray) {
			System.out.println(t.getThreadGroup() + " " +  t.getName() + " isDaemon: " + t.isDaemon() + " " + t.getPriority());
		}
	}
}
