//MMN 12, question 1, April 2020

import java.security.SecureRandom;
import java.util.*; 

//!!!!
//		Depending on the order of the evaluation of the expressions, compound expressions that have subtraction
//		may seem to calculate the wrong result. There is no way to show the order the compound expression is 
//		calculated (no brackets).     
//		For Example, the output:
//			24.0 - 14.0 + 29.0 + 6.0 value: -13.0
//		is calculated as: 
//			24.0 - (14.0 + 29.0) + 6.0 value: -13.0
//!!!!


//There aren't many comments and explanations. 
//The names and code are pretty much self explanatory.

public class Q1 {

	public static void main(String[] args) {

		int MAX_VALUE = 50;
		int MAX_EXPRESSIONS = 50;
		int NUM_TYPE_EXPRESSIONS = 3;
		int expressionType;
		
		ArrayList <Expression> expArray = new ArrayList<Expression>();
		final SecureRandom randomNumbers = new SecureRandom();
		
		//Seed expressions array with 3 atomic expressions.
		expArray.add(new AtomicExpression(randomNumbers.nextInt(MAX_VALUE)));
		expArray.add(new AtomicExpression(randomNumbers.nextInt(MAX_VALUE)));
		expArray.add(new AtomicExpression(randomNumbers.nextInt(MAX_VALUE)));
		
		
		//Loop runs up to MAX_EXPRESSIONS-3 iterations, The '3' is to take into account the 3 seed expressions 
		//in the above lines.
		for (int i=0; i < MAX_EXPRESSIONS-3; i++) {
			expressionType = randomNumbers.nextInt(NUM_TYPE_EXPRESSIONS);

			switch(expressionType) {
			
			case 0: //Atomic expression.
				expArray.add(new AtomicExpression(randomNumbers.nextInt(MAX_VALUE)));
				break;
				
			case 1://AdditionExpression.
				expArray.add(new AdditionExpression(expArray.get(randomNumbers.nextInt(expArray.size()-1)),
						expArray.get(randomNumbers.nextInt(expArray.size()-1))));
				break;
				
			case 2: //SubtractionExpression.
				expArray.add(new SubtractionExpression(expArray.get(randomNumbers.nextInt(expArray.size()-1)),
						expArray.get(randomNumbers.nextInt(expArray.size()-1))));
				break;
				
			}
		}

		printArray(expArray);

	}//End main.
	
	public static void printArray(ArrayList <Expression> expArray) {
		
		int flag=0;
		
		for (int i = 0; i<expArray.size(); i++)
		{
			 System.out.printf(i+1 + ": " +expArray.get(i).toString() + " value: " + expArray.get(i).calculate());
			 flag = 0;		 
			 for (int j = 0; j < expArray.size(); j++) {
				
				 if ((j != i) && ((expArray.get(i).calculate()) == (expArray.get(j).calculate()))) {
					 
					 if (flag == 0) {
						 flag = 1;
						 System.out.printf(".  Equals expressions number: " + (j+1));
					 }
					 else
					 	 System.out.printf(", " + (j+1));
					 
				 }
			 }
			 
			 System.out.printf("\n");
							 
		}
	}//End printArray.

}

