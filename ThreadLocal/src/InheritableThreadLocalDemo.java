class ParentThread extends Thread{
    
    public static InheritableThreadLocal tl = new InheritableThreadLocal() {
        public Object childValue(Object p) {
            return "CC";
        }
    };
    
    @Override
    public void run() {
        tl.set("PP");
        System.out.println("Parent Thread Value: " + tl.get());
        ChildThread ct = new ChildThread();
        ct.start();
    }
}

class ChildThread extends Thread {
    public void run() {
        System.out.println("Child Thread Value: " + ParentThread.tl.get());
    }
}

public class InheritableThreadLocalDemo {
	public static void main(String[] args) {
		ParentThread pt = new ParentThread();
        pt.start();
	}
}
