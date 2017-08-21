package thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestThreadPool {

	@Test
	public void testName() throws Exception {

		ExecutorService threadPoolExe = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			threadPoolExe.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println( Thread.currentThread().getName());
					try {
						Thread.sleep(1000*new Random().nextInt(10));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		Thread.sleep(100000);
	}
	
	

	@Test
	public void testNewScheduledThreadPool() throws Exception {

		ExecutorService threadPoolExe = Executors.newScheduledThreadPool(2);
		for (int i = 0; i < 10; i++) {
			threadPoolExe.submit(new Runnable() {
				@Override
				public void run() {
					System.out.println( Thread.currentThread().getName());
					try {
						Thread.sleep(1000*new Random().nextInt(10));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		Thread.sleep(100000);
	}

}
