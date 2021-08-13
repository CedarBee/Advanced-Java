//MMN 15, question 2, June 2020


public class MatrixThreads extends Thread { //This class represents a thread for multiplying a row and a column of two matrices.
	

	Matrix A;
	Matrix B;
	int numRow;
	int numCol;
	int numMultiplies;
	int cellNum; //This variable controls the order of the printing. Each cell has a running number that represents 
				// when it is it's time to print.
	int newLineFlag; //Flag representing a new line whilst printing the multiplication product.
	Controller controller;

	
	public MatrixThreads (Matrix A, Matrix B, int numRow, int numCol, int numMultiplies, Controller controller, int cellNum,
			int newLineFlag) {

		this.A = A;
		this.B = B;
		this.numRow= numRow;
		this.numCol = numCol;
		this.numMultiplies = numMultiplies;
		this.controller = controller;
		this.cellNum = cellNum;
		this.newLineFlag = newLineFlag;
		
	} 
	
	public synchronized void run() {
		
		int sum = 0;
		
		for (int k = 0; k < numMultiplies; k++) { //Sums the multiplication value of a row by column.
			
			sum = sum + A.getCell(numRow, k) + B.getCell(k, numCol);
			
		}
				
		controller. waitForTurn(cellNum); // Cell waits for it's turn to print.
		
		if (newLineFlag==0)
			System.out.println();
		
		System.out.print(sum + " ");
		
		controller.finished(); //Cell reports it has finished.
	} 
} 