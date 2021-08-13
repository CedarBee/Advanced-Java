//MMN 13, question 2, April 2020

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle extends MyBoundedShape{
	
	public MyRectangle(int x1, int y1, int x2, int y2) {
		
		super(x1, y1, x2, y2);
		super.setMyShapeType("Rectangle");
		super.setShapeFull(true);
		super.setColor(Color.RED);
		super.setHeight(y2);
		super.setWidth(x2);
		
	}
	
	public void draw(Graphics g) {
		
		g.setColor(super.getColor());
		if (super.getShapeFull()==true)
				g.fillRect(super.getX1(), super.getY1(), super.getX2(), super.getY2());
		else
				g.drawRect(super.getX1(), super.getY1(),super.getX2(), super.getY2());
	}

	@Override	
	public Object clone() {

		MyRectangle x = new MyRectangle(super.getX1(), super.getY1(), super.getX2(), super.getY2());
		x.setColor(super.getColor());
		x.setColor(super.getColor());
		x.setMyShapeType(super.getMyShapeType());
		x.setShapeFull(super.getShapeFull());
		
		return x;
		
	}
	
}
