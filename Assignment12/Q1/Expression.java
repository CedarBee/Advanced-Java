//MMN 12, question 1, April 2020

public abstract class Expression {

	private double x;
	
	public double calculate() {
		
		return x;
		
	}
	
	
	public abstract boolean equals(Expression exp);

	
	public void setExpression(double x) {
		
		this.x = x;
		
	}
	
	public double getExpression() {
		
		return x;
		
	}
}
