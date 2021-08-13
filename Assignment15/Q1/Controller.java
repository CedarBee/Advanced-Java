//MMN 15, question 1, May 2020



public class Controller { //Counts the number of threads have finished and notifies when 
							//all the threads have finished.

	private int num;
	private int count = 0;
	
	public Controller(int num) {
		
		this.num = num;
	}
	
	public synchronized void finished() {
		
		count++;
		if (count>=num) 
			notify();
	}
	
	public synchronized void waitForThreads() {
		
		while (count<num)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("interrupted while waiting");
			}
	}
		
}
