//MMN 15, question 2, June 2020



public class Controller { //Keeps tracks of which cell needs to print next.

	private int num;
	private int count = 0;
	
	public Controller(int num) {
		
		this.num = num;
	}
	
	public synchronized void finished() {
		
		count++;
		notifyAll();

	}
	
	public synchronized void waitForTurn(int myTurn) { //Causes the thread to wait until it is it's turn to print to screen.
														// myTurn is the cell's place in the order for printing. 
		while (myTurn != count)
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("interrupted while waiting");
			}
	}
		
}
