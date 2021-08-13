//MMN 12, question 2, April 2020

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape{
	
	public MyOval(int x1, int y1, int x2, int y2) {
		
		super(x1, y1, x2, y2);
		super.setMyShapeType("Oval");
		super.setShapeFull(true);
		super.setColor(Color.RED);
		
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(super.getColor());
		if (super.getShapeFull()==true)
				g.fillOval(super.getX1(), super.getY1(), super.getX2(), super.getY2());
		else
				g.drawOval(super.getX1(), super.getY1(),super.getX2(), super.getY2());
	}

	public Object clone() {

		MyOval x = new MyOval(super.getX1(), super.getY1(), super.getX2(), super.getY2());
		x.setColor(super.getColor());
		x.setColor(super.getColor());
		x.setMyShapeType(super.getMyShapeType());
		x.setShapeFull(super.getShapeFull());
		
		return x;
		
	}
	
}
