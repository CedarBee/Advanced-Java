//MMN 12, question 1, April 2020

public class AtomicExpression extends Expression{

	public AtomicExpression(double num)	{
		
		super.setExpression(num);
	
	}
	
	@Override
	public String toString() {
		
		return String.valueOf(super.calculate());
	
	}

	
	public boolean equals(Expression exp) {
		
		if (super.getExpression() == exp.calculate())
			return true;
		else
			return false;
		
	}
	
}
