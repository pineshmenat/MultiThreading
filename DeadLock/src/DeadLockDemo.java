public class DeadLockDemo extends Thread{
	
	ClassA a = new ClassA();
	ClassB b = new ClassB();
	
	public DeadLockDemo() {
		this.start();
		a.testA(b);	//Executed by main Thread
	}
	
	public void run() {
		b.testB(a);	//Executed by child Thread
	}
	
	public static void main(String[] args) {
		new DeadLockDemo();
	}
}
