import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements Runnable{
	String name;
	
	public PrintJob(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println(name + " started by " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name + " ended by " + Thread.currentThread().getName());
	}
}
public class ExecutorServiceDemo {
	public static void main(String[] args) {
		PrintJob[] jobs = { new PrintJob("job-0"),
				new PrintJob("job-1"),
				new PrintJob("job-2"),
				new PrintJob("job-3"),
				new PrintJob("job-4"),
				new PrintJob("job-5")
		};
		
		ExecutorService eService = Executors.newFixedThreadPool(3);
		for(PrintJob job : jobs) {
			eService.submit(job);
		}
		
		System.out.println("Shutting down...");
		eService.shutdown();
	}
}
