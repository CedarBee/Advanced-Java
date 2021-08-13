//MMN 13, question 2, April 2020

//This class extends JFrame and holds the panels that compose the GUI.

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingFrame extends JFrame{
	
	private 	JFrame myFrame;
	private DrawingPanel drawingPanel;
	private ControlPanel controlPanel;
	private JPanel mainPanel;
	
	
	public DrawingFrame() {
		super();
		myFrame = new JFrame("Drawing app");
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		drawingPanel = new DrawingPanel(this, super.getGraphics());
		controlPanel = new ControlPanel(this);
		mainPanel.add(controlPanel, BorderLayout.SOUTH);
		mainPanel.add(drawingPanel, BorderLayout.CENTER);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(500, 500);
		myFrame.add(mainPanel);
		myFrame.setVisible(true);
	}
	
	//Returns the pointer to the JPanel that the shapes are drawn on.
	public DrawingPanel getDrawingPanel() {
		
		return drawingPanel;
		
	}
	
	//Repaints the main Jpanel.
	public void repaintMainPanel() {
		
		mainPanel.repaint();
	}
	
	//Exits the program
	public void exit() {
		myFrame.dispose();
		System.exit(0);
	}

}
