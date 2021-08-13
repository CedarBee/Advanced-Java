//MMN 12, question 1, April 2020

public class SubtractionExpression extends CompoundExpression {

	public SubtractionExpression(Expression x, Expression y) {
		
		super(x, y);
		setCompoundExpressionValue(x.calculate() - y.calculate());
		
	}
	
	@Override
	public double calculate() {
		
		return super.getX().calculate() - super.getY().calculate();
	}
	
	public boolean equals(Expression exp) {
		
		if (super.calculate() == exp.calculate())
			return true;
		else
			return false;
		
	}
	
	@Override
	public String toString() {
		
		return super.getX() +" - "+ super.getY();
		
	}
	
}


