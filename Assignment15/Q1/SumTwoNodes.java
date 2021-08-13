//MMN 15, question 1, May 2020


import java.util.Vector;

public class SumTwoNodes { //Gets two values from the Vector and returns to
							// the Vector the sum of the two values.
	
	public static synchronized void sum (Vector<Integer> myArray){
		
		int val1;
		int val2;
		
		val1 = myArray.remove(0);
		val2 = myArray.remove(0);
		myArray.add(val1+val2);

	}
}