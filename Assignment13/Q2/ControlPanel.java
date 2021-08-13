//MMN 13, question 2, April 2020

//This class extends a JPanel and contains all the buttons and controls
//and listeners for these buttons.

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ControlPanel extends JPanel implements ActionListener{
	
	JButton rectangleButton, ovalButton, lineButton, colorButton, undoButton, clearButton, exitButton;
	DrawingFrame myFrame;
	JRadioButton fullShapeButton;
	JRadioButton emptyShapeButton;
	
	public ControlPanel(DrawingFrame fatherFrame){
		
		super();
		myFrame = fatherFrame;
		setLayout(new GridLayout(3,3));
		
		rectangleButton = new JButton("Rectangle");
		rectangleButton.addActionListener(this);
		add(rectangleButton);
		
		ovalButton = new JButton("Oval");
		ovalButton.addActionListener(this);
		add(ovalButton);
		
		lineButton = new JButton("Line");
		lineButton.addActionListener(this);
		add(lineButton);
		
		colorButton = new JButton("Choose color");
		colorButton.addActionListener(this);
		add(colorButton);
		
		fullShapeButton   = new JRadioButton("Full shape", false);
		fullShapeButton.addActionListener(this);
		emptyShapeButton  = new JRadioButton("Empty shape", true);
		emptyShapeButton.addActionListener(this);
		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(fullShapeButton);
        bgroup.add(emptyShapeButton);
        add(fullShapeButton);
        add(emptyShapeButton);
        
		undoButton = new JButton("Undo");
		undoButton.addActionListener(this);
		add(undoButton);
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		add(clearButton);
		
		exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		add(exitButton);
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == rectangleButton) {
			myFrame.getDrawingPanel().setShapeType("rectangle");
		}
		else if (e.getSource() == ovalButton) {
			myFrame.getDrawingPanel().setShapeType("oval");
		}
		else if (e.getSource() == lineButton) {
			myFrame.getDrawingPanel().setShapeType("line");
		}
		else if (e.getSource() == colorButton) {
			myFrame.getDrawingPanel().setShapeColor(JColorChooser.showDialog(new JPanel(),
					"Select a color", Color.red));
		}
		else if (e.getSource() == fullShapeButton) {
			myFrame.getDrawingPanel().setShapeFull(true);
		}
		else if (e.getSource() == emptyShapeButton) {
			myFrame.getDrawingPanel().setShapeFull(false);
		}
		else if (e.getSource() == undoButton) {
			myFrame.getDrawingPanel().undo();
		}
		else if (e.getSource() == clearButton) {
			myFrame.getDrawingPanel().clear();
		}
		else if (e.getSource() == exitButton) {
			myFrame.exit();
		}
	}
	
}
