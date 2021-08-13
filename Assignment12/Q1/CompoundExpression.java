//MMN 12, question 1, April 2020

public abstract class CompoundExpression extends Expression{

	private Expression x, y;
	private double compoundExpressionValue;
	
	public CompoundExpression(Expression x, Expression y) {
		
		this.x = x;
		this.y = y;
				
	}
	

	public void setCompoundExpressionValue(double num) {
		
		compoundExpressionValue = num;
	}
	
	
	public double getCompoundExpressionValue() {
		
		return compoundExpressionValue;
		
	}
	
	
	public Expression getX() {
		
		return x;
		
	}
	

	public Expression getY() {
		
		return y;
		
	}
	
}
