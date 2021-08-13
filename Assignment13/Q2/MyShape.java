//MMN 13, question 2, April 2020


import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape implements Cloneable{

	private int PIXEL_INCREASE = 10;
	
	private int x1, y1, x2, y2;
	
	private String MyShapeType;
	
	private Color color;
	
	public MyShape(int x1, int y1, int x2, int y2) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
	}
	
	public int getPIXEL_INCREASE() {
		
		return PIXEL_INCREASE;
	}
	
	public void changeFirstPoint() {
		
		x1 = x1 + PIXEL_INCREASE;
		y1 = y1 + PIXEL_INCREASE;
		
	}
	
	public abstract Object clone();
	
	public abstract void draw(Graphics g);
	
	public void setMyShapeType(String type) {
		
		MyShapeType = type;
	}
	
	public String getMyShapeType() {
		
		return MyShapeType;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public Color getColor() {
		
		return this.color;
	}
	
	public void setX1(int x) {
		
		x1 = x;
	}
	
	public void setX2(int x) {
		
		x2 = x;
	}
	
	public void setY1(int y) {
		
		y1 = y;
	}
	
	public void setY2(int y) {
		
		y2 = y;
	}

	public int getX1() {
		return x1;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getY1() {
		return y1;
	}
	
	public int getY2() {
		return y2;
	}
}
