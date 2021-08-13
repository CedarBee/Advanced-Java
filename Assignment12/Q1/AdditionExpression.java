//MMN 12, question 1, April 2020

public class AdditionExpression extends CompoundExpression {

	public AdditionExpression(Expression x, Expression y) {
		
		super(x, y);
		setCompoundExpressionValue(x.calculate() + y.calculate());
		
	}
	
	
	@Override
	public double calculate() {
		
		return super.getX().calculate() + super.getY().calculate();
	}
	
	
	public boolean equals(Expression exp) {
		
		if (super.getCompoundExpressionValue()==exp.calculate())
			return true;
		else
			return false;
		
	}
	

	@Override
	public String toString() {
		
		return super.getX() +" + "+ super.getY();
		
	}
	
}
