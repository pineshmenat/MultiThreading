
public class ClassB {
	public synchronized void testB(ClassA a) {
		System.out.println("Thread2 starts execution of testB");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Trying to call ClassA.last()");
		a.last();
	}
	
	public synchronized void last() {
		System.out.println("ClassB: last()");
	}
}
