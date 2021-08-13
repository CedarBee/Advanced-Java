//MMN 12, question 2, April 2020

import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape{

	private double length;
	
	
	public MyLine(int x1, int y1, int x2, int y2) {
		
		super(x1, y1, x2, y2);
		super.setMyShapeType("Line");
		super.setColor(Color.red);
		length = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(super.getColor());
		g.drawLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
	}

	public Object clone() {
		
		MyLine x = new MyLine(super.getX1(), super.getY1(), super.getX2(), super.getY2());
		x.setColor(super.getColor());
		
		return x;
	
	}

	@Override	
	public void changeFirstPoint() {
		
		super.setX1(super.getX1() + super.getPIXEL_INCREASE());
		super.setY1(super.getY1() + super.getPIXEL_INCREASE());
		//Update length of line to be persistent with new coordinates.
		length = Math.sqrt((super.getX1()-super.getX2())*((super.getX1()-super.getX2())+
				(super.getY1()-super.getY2())*(super.getY1()-super.getY2())));
		
	}
	
	public double getLength() {
		
		return length;
		
	}
	
	public void setLength(double len) {
		
		length = len;
		
	}
	
	@Override	
	public boolean equals(Object obj) {
		
		if ((obj.getClass() == this.getClass()) && ((MyLine)obj).getLength() == this.getLength()) 
			return true;
		
		return false;
		
	}

}
