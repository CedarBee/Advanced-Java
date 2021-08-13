//MMN 12, question 2, April 2020

import java.util.ArrayList;
import java.security.SecureRandom;
import javax.swing.JFrame;
import java.awt.Color;


public class Q2 {

	public static void main(String[] args) {
	
		int MAX_SIZE = 200, NUM_SHAPE = 2;
		int x1, y1, x2, y2;
		
		ArrayList <MyShape> myShapeArray = new ArrayList<MyShape>();
		ArrayList <MyShape> clonedMyShapeArray = new ArrayList<MyShape>();
		SecureRandom randomNumbers = new SecureRandom();
		
		//Draw 2 items of each shape.
		for (int i = 0; i < NUM_SHAPE; i++) {
			x1 = randomNumbers.nextInt(MAX_SIZE);
			y1 = randomNumbers.nextInt(MAX_SIZE);
			x2 = randomNumbers.nextInt(MAX_SIZE);
			y2 = randomNumbers.nextInt(MAX_SIZE);
			myShapeArray.add(new MyLine(x1, y1, x2, y2));
			x1 = randomNumbers.nextInt(MAX_SIZE);
			y1 = randomNumbers.nextInt(MAX_SIZE);
			x2 = randomNumbers.nextInt(MAX_SIZE);
			y2 = randomNumbers.nextInt(MAX_SIZE);
			myShapeArray.add(new MyRectangle(x1, y1, x2, y2));
			x1 = randomNumbers.nextInt(MAX_SIZE);
			y1 = randomNumbers.nextInt(MAX_SIZE);
			x2 = randomNumbers.nextInt(MAX_SIZE);
			y2 = randomNumbers.nextInt(MAX_SIZE);
			myShapeArray.add(new MyOval(x1, y1, x2, y2));
		}

		//Clone each shape.
		for (int i = 0; i < myShapeArray.size(); i++) {
			clonedMyShapeArray.add((MyShape)myShapeArray.get(i).clone());
			clonedMyShapeArray.get(i).changeFirstPoint();
			clonedMyShapeArray.get(i).setColor(Color.GREEN);
			//Check to see if the shape if of type bounded shape to change the full/unfull property.
			if (clonedMyShapeArray.get(i) instanceof MyBoundedShape)
					((MyBoundedShape)clonedMyShapeArray.get(i)).setShapeFull(false);
		}

		//Add the cloned shapes to the shapes array (in order to send one array to DrawPanel.
		for (int i = 0; i < clonedMyShapeArray.size(); i++) {
			myShapeArray.add(clonedMyShapeArray.get(i));
		}
					
		DrawPanel panel  = new DrawPanel(myShapeArray);
		
		JFrame app = new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(400, 400);
		app.add(panel);
		app.setVisible(true);
		
	}

}
