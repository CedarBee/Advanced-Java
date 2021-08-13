//MMN 12, question 2, April 2020

public abstract class MyBoundedShape extends MyShape{
	
	private boolean shapeFull; //true if shape is full, false is shape is empty.
	private int PIXEL_INCREASE = 10;
	private int width;
	private int height;
	
	
	public MyBoundedShape(int x1, int y1, int x2, int y2) {
		
		super(x1, y1, x2, y2);

	}
	
	public void setWidth(int w) {
		
		width =w;
		
	}
	
	public int getWidth() {
		
		return width;
		
	}
	
	public void setHeight(int h) {
		
		height = h;
		
	}
	
	public int getHeight() {
		
		return height;
		
	}
	
	public void setShapeFull(boolean val) {
		
		shapeFull = val;
		
	}
	
	public boolean getShapeFull() {
		
		return shapeFull;
		
	}

	@Override
	public void changeFirstPoint() {
		
		super.setX1(super.getX1() + PIXEL_INCREASE); 
		super.setY1(super.getY1() + PIXEL_INCREASE);
		super.setX2(super.getX2() - PIXEL_INCREASE); 
		super.setY2(super.getY2() - PIXEL_INCREASE);
		height = super.getY2();
		width = super.getX2();
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if ((obj.getClass()== this.getClass()) && (((MyBoundedShape)obj).getWidth() == this.getWidth())
				&& (((MyBoundedShape)obj).getHeight()== this.getHeight())) 
			return true;
		
		return false;
		
	}

}
