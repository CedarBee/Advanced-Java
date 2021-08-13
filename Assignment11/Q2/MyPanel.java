import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

public class MyPanel extends JPanel{

	public void paintComponent(Graphics g) { //Draws the graph
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int COL_WIDTH = 20;
		int minTemp = TemperatureData.getMinTemp(drawGraph.getUserYear());
		int maxTemp = TemperatureData.getMaxTemp(drawGraph.getUserYear());
		int SCALE = 10;
		String tempString = new String();
		
		//Draw X and Y axis.
		g.drawLine(50,  0,  50, height-50);
		g.drawLine(0,  height-50,  width, height-50);
		//Draw title.
		tempString= "Year: " + Integer.toString(drawGraph.getUserYear());  
		g.drawString(tempString, width/2, 30 );
		//Display months under X axis.
		for (int i=0; i<TemperatureData.months.length; i++) {
			g.drawString(TemperatureData.months[i], 60+i*(width-60)/12, (height-20));
		}
		//Draw temperature values on Y axis.
		for (int i=0; i<TemperatureData.months.length; i++) {
			tempString= Integer.toString(TemperatureData.getTemp(drawGraph.getUserYear(),i));  
			g.drawString(tempString, 30, ((height-50)-(SCALE*TemperatureData.getTemp(drawGraph.getUserYear(),i))));
		}
		//Display temperature columns. Changes colors for min and max months. 
		//It is possible that more than one month has same min/max value.
		for (int i=0; i<TemperatureData.months.length; i++) {
			g.setColor(Color.GRAY);
			if (TemperatureData.getTemp(drawGraph.getUserYear(),i)==maxTemp) 
				g.setColor(Color.RED);
			if (TemperatureData.getTemp(drawGraph.getUserYear(),i)==minTemp) 
				g.setColor(Color.BLUE);
			g.fillRect(75+i*(width-60)/12, ((height-50)-(SCALE*TemperatureData.getTemp(drawGraph.getUserYear(),i))),
					COL_WIDTH, SCALE*TemperatureData.getTemp(drawGraph.getUserYear(),i));
		}
	}
}