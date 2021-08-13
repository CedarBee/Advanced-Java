//MMN 15, question 1, May 2020

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter { //Counts the number of addition operations have occurred (by all
						// the threads).
	
	private int count = 0;
	private Lock lock = new ReentrantLock();
	
	public Counter() {
		
	}
	
	public int getAndInc() {
		lock.lock();
		try {
			return count++;
		} finally {
			lock.unlock();
		}
	}

}
