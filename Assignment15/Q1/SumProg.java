//MMN 15, question 1, May 2020

import java.util.Vector;

public class SumProg extends Thread { //This class represents a thread for summing the Vector.
	

	Vector<Integer> myArray;
	Counter counter;
	int maxIterations;
	Controller controller;


	public SumProg (Vector<Integer> myArray, Counter counter, int maxIterations, Controller controller ) {

		this.myArray = myArray;
		this.counter = counter;
		this.maxIterations = maxIterations;
		this.controller = controller;
	} 
	
	public void run() {
		while (counter.getAndInc() < maxIterations) {
			SumTwoNodes.sum(myArray);
			System.out.println(myArray.toString());
		}
		controller.finished();
	} 
} 