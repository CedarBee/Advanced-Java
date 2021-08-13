//MMN 15, question 1, May 2020


/* The program creates a Vector with n random Integers
 * then creates m threads that sum the Vector according to the instructions of question.
 * 
 * The class Counter counts the number of addition operations have occurred. The counter 
 * is mutually exclusive so that no thread will try to get a non existent cell of the Vector.
 * 
 * The class Controller waits and notifies when all the created threads have finished their run.
 * 
 * For each addition iteration the Vector is printed to screen (This helped my see what's going on during run).
 * 
 * At the end of the run the addition value is printed twice. Once for the thread addition
 * and once for a "regular" sum of the Vector (to see the correctioness of the program). 
 * 
 * 
 */

import java.util.Vector;

public class Q1 {
	
	public static void main (String[ ] args){
		
		int n = 500; //n - number of objects in myArray
		int m = 300; //m - number of threads
		int threadlessSum = 0;
		
		Vector<Integer> myArray = new Vector<Integer>();	
		
		Counter counter = new Counter();
		
		Controller controller = new Controller(m);
		
		int maxIterations = n-1; // The number of addition operations needed to sum the Vector.
		
		for (int i=0; i < n; i++) 
			myArray.add((int)(Math.random()*100)); //Populates the Vector.
		
		for (int i=0; i < n; i++) 
			threadlessSum+= myArray.get(i); // Does a "regular" sum of the array.
											//This was needed to check the thread summation correctness. 
			
		for (int j = 0; j<m ; j++) {
			(new SumProg(myArray, counter, maxIterations, controller)).start(); //Creates m threads.
		}
		
	
		controller.waitForThreads(); //Waits for all the threads to finish.
		System.out.println("Sum of the values as computed with the threads (the one cell in the array): "
							+ myArray.toString());
		System.out.println("Threadless sum value is: " + threadlessSum);
		System.out.println("THE END");
	} 
} 
