
public class ClassA {
	/*synchronized is only reason for deadlock, Avoid Nested Locks, Avoid Unnecessary Locks, Using thread join(long ms) put maximum time we can think execution will take
	 * */
	public synchronized void testA(ClassB b) {	
		System.out.println("Thread1 starts execution of testA");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Trying to call ClassB.last()");
		b.last();
	}
	
	public synchronized void last() {
		System.out.println("ClassA: last()");
	}
	
}
