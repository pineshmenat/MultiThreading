import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableJob implements Callable {
	int number;
	
	public CallableJob(int number) {
		this.number = number;
	}
	
	public Object call() {
		System.out.print(Thread.currentThread().getName() + " will calculate and return sum of first " + number + " numbers ");
		int sum = 0;
		for(int i=0; i<=number; i++) {
			sum += i;
		}
		return sum;
	}
}
public class CallableAndFutureDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CallableJob[] jobs = { new CallableJob(50),
				new CallableJob(10),
				new CallableJob(20),
				new CallableJob(30),
				new CallableJob(40),
				new CallableJob(70),
				new CallableJob(60)
		};
		
		ExecutorService eService = Executors.newFixedThreadPool(3);
		for(CallableJob job : jobs) {
			Future f = eService.submit(job);
			System.out.println(f.get());
		}
		
		System.out.println("Shutting down...");
		eService.shutdown();
	}
}