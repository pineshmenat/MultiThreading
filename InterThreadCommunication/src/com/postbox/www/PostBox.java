package com.postbox.www;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/*Producer Consumer Problem
To make sure that the producer won’t try to add data into the buffer if it’s full and that the consumer won’t try to remove data from an empty buffer.
 * */

public class PostBox {

	private Queue<Integer> pbQueue = new PriorityBlockingQueue<Integer>(3);
	int capacity = 3;

	public void dropMail() throws InterruptedException {
		synchronized (this) {
			int mail = 0;
			while (true) {
				if (pbQueue.size() == capacity) {
					wait();
				}
				System.out.println("Producer added new mail: " + mail + "++");
				pbQueue.offer(mail++);
				notify();
				Thread.sleep(1000);
			}

		}
	}

	public void receiveMail() throws InterruptedException {
		synchronized (this) {
			while (true) {
				if (pbQueue.isEmpty()) {
					wait();
				}

				System.out.println("Consumer consumemd mail: " + pbQueue.peek() + "--");
				pbQueue.poll();
				notify();

				Thread.sleep(1000);
			}
		}
	}
}