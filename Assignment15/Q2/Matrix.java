//MMN 15, question 2, June 2020


public class Matrix {
	
	Integer[][] matrix;
	int m,n;
	
	public Matrix(int m, int n) { //Creates a matrix of m*n and populates with random ints of 0..10. 
		
		matrix = new Integer[m][n];
		this.m = m;
		this.n = n;
		
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				matrix[i][j] = ((int)(Math.random()*10));
		
	}
	
	public Integer getCell(int i, int j) {
		
		return matrix[i][j];
		
	}
	
	public void print() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println();
		}
	}
	

}
