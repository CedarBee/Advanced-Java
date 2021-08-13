//MMN 12, question 2, April 2020

import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;


public class DrawPanel extends JPanel{

	ArrayList <MyShape> shapeArray;

	public DrawPanel(ArrayList <MyShape> shapeArray){
		
		this.shapeArray = shapeArray;
		
	}
	
	@Override	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		for (int i = 0; i<shapeArray.size(); i++) {
			shapeArray.get(i).draw(g);

		}
	}

}
	


