//MMN 15, question 2, June 2020


public class Q2 {

	public static void main(String[] args) {

		int n, m1, m2, p, cellCounter;
		
		if (args.length != 4) {
			
			System.out.println("\nNeed to enter 4 arguments, 2 dimensions per matrix.\n"
					+ "For Example: \"run 10 5 5 20\".");
			return;
			
		}
		
		//Arguments from the command line. m1 and m2 should be equal for the matrix multiplication to be defined.
		n = Integer.parseInt(args[0]);
		m1 = Integer.parseInt(args[1]);
		m2 = Integer.parseInt(args[2]);
		p = Integer.parseInt(args[3]);
		
		if (m1!=m2) {
			System.out.println("\nNumber of columns in first matrix is different from number of rows in second matrix.");
			return;
			
		}
		
		cellCounter = 0; //Gives each cell it's order for printing.
		
		Matrix A = new Matrix(n, m1);
		System.out.println("\nMatrix A:\n");
		A.print();
		System.out.println("\nMatrix B:\n");
		Matrix B = new Matrix(m1, p);
		B.print();
		System.out.println();
		
		Controller controller = new Controller(n*p);
		
//		MultiplyMatrices(A, B, n, m1, p); //This was used to check that the multiplication with threads works correctly.
											//Left it here just in case.
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < p; j++) {
				(new MatrixThreads(A, B, i, j, m1, controller, cellCounter, j)).start(); //Creates n*p threads.
				cellCounter++;
			}
		}

	}
	
	public static void MultiplyMatrices(Matrix A, Matrix B,int n, int m, int p) { //Multiplies two matrices (one thread).
																					//Was used to check correctness of threaded
																					//multiplication.
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < p; j++) {
				sum = 0;
				for (int k = 0; k < m; k++) {
					sum = sum + A.getCell(i, k) + B.getCell(k, j);
				}
				System.out.print(sum + " ");
			}

		}
		
	}

}
