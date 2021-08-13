//MMN 13, question 2, April 2020

//This class extends JPanel and represents the panel all the shapes are drawn on.


import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.*;


public class DrawingPanel extends JPanel{
	
	private String shapeType = "line";
	
	private Point p1;
	private Point p2;

	private ArrayList <MyShape> myShapeArray = new ArrayList<MyShape>();
	//tempShape is a temporary shape object that is used to represent the shape 
	//while it is being dragged by the user on the drawing panel
	private MyShape tempShape;
	private boolean dragFlag, shapeFull;
	private Color shapeColor = Color.red;
	private DrawingFrame dFrame;
	
	public DrawingPanel(DrawingFrame fatherFrame, Graphics g) {
		
		super();
		dFrame = fatherFrame;
		addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						dragFlag = true;
						p1 = e.getPoint();
					}
				}
			);
		
		addMouseMotionListener(
				new MouseMotionAdapter() {
					public void mouseDragged(MouseEvent e) {
						p2 = e.getPoint();
						fatherFrame.repaintMainPanel();
							if (shapeType == "rectangle") {
								tempShape = new  MyRectangle(Math.min((int)p1.getX(), (int)p2.getX()), Math.min((int)p1.getY(), (int)p2.getY()),
										Math.abs((int)p2.getX()-(int)p1.getX()), Math.abs((int)p2.getY()-(int)p1.getY()));
								((MyBoundedShape)tempShape).setShapeFull(shapeFull);
								tempShape.setColor(shapeColor);
							}
							else if (shapeType == "oval") {
								tempShape = new  MyOval(Math.min((int)p1.getX(), (int)p2.getX()), Math.min((int)p1.getY(), (int)p2.getY()),
										Math.abs((int)p2.getX()-(int)p1.getX()), Math.abs((int)p2.getY()-(int)p1.getY()));
								((MyBoundedShape)tempShape).setShapeFull(shapeFull);
								tempShape.setColor(shapeColor);
							}
							else if (shapeType == "line") {
								tempShape = new  MyLine((int)p1.getX(),(int)p1.getY(), (int)p2.getX(), (int)p2.getY());
								tempShape.setColor(shapeColor);
							}
						}
					}
				);
				
		addMouseListener(
				new MouseAdapter() {
					public void mouseReleased(MouseEvent e) {
						if (shapeType == "rectangle") {
							myShapeArray.add(new  MyRectangle(Math.min((int)p1.getX(), (int)p2.getX()), Math.min((int)p1.getY(), (int)p2.getY()),
									Math.abs((int)p2.getX()-(int)p1.getX()), Math.abs((int)p2.getY()-(int)p1.getY())));
							((MyBoundedShape)myShapeArray.get(myShapeArray.size()-1)).setShapeFull(shapeFull);
							myShapeArray.get(myShapeArray.size()-1).setColor(shapeColor);
						}
						else if (shapeType == "oval") {
							myShapeArray.add(new  MyOval(Math.min((int)p1.getX(), (int)p2.getX()), Math.min((int)p1.getY(), (int)p2.getY()),
									Math.abs((int)p2.getX()-(int)p1.getX()), Math.abs((int)p2.getY()-(int)p1.getY())));
							((MyBoundedShape)myShapeArray.get(myShapeArray.size()-1)).setShapeFull(shapeFull);
							myShapeArray.get(myShapeArray.size()-1).setColor(shapeColor);
						
						}
						else if (shapeType == "line") {
							myShapeArray.add(new  MyLine((int)p1.getX(),(int)p1.getY(), (int)p2.getX(), (int)p2.getY()));
							myShapeArray.get(myShapeArray.size()-1).setColor(shapeColor);
						}
					
						fatherFrame.repaintMainPanel();
						p2 = null;
						dragFlag = false;
					}
				}
		);		
	}
	
	//Removes the last drawn shape from the drawing panel
	public void undo() {
		
		if (myShapeArray.size()>0)
			myShapeArray.remove(myShapeArray.size()-1);
		dFrame.repaintMainPanel();
	
	}
	
	//Clears the drawing panel.
	public void clear() {
		
		myShapeArray.clear();
		dFrame.repaintMainPanel();
	
	}
	//Draws all the shapes that have been created.
	public void paintComponent(Graphics g) {
		for (int i = 0; i < myShapeArray.size(); i++) {
			myShapeArray.get(i).draw(g);
		}

		if (dragFlag == true)
			tempShape.draw(g);

	}
	
	public void setShapeFull(boolean b) {
		
		shapeFull = b;
		
	}
	
	public boolean getShapeFull() {
		
		return shapeFull;
		
	}
	
	public void setShapeColor(Color c) {
		
		shapeColor = c;
		
	}
	
	public Color getShapeColor() {
		
		return shapeColor;
		
	}
	
	
	public void setShapeType(String st) {
		
		shapeType = st;
	
	}
	
	public String getShapeType() {
		
		return shapeType;
	
	}
		
}
