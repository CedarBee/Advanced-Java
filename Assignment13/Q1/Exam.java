//MMN 13, question 1, April 2020


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;


public class Exam {
	
	public ArrayList <examQuestion> exam = new ArrayList<examQuestion>(0);
	private int counter = 0;
	private int questionIterator = 0;
	private int correctAnswersCounter = 0;
	

	JPanel myPanel = new JPanel();
	private JFrame frame = new JFrame("Exam");
	JScrollPane scrPane = new JScrollPane(myPanel);
	private JButton scoreButton; 
	private JButton reExamButton;
	
	public Exam(Scanner input) {
		
		while (input.hasNext()) {
			if (counter==0) {
				exam.add(new examQuestion());
			}
			counter++;	
			String st = input.nextLine();
			(exam.get(questionIterator)).addQuestionOrAnswer(st);
			if (counter==examQuestion.NUM_ANSWERS+1) {
				counter = 0;
				questionIterator++;
			}
		}
	}

	public void printExam() {
		
		for (examQuestion question : exam) {
			
			question.printQuestion();
				
			}
	}
	
	public void displayQuestionFrame() {

		myPanel.removeAll();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scrPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scrPane);
		counter = 0;
		myPanel.setLayout(new GridLayout(0,1,10,10));
		myPanel.setSize(400, 300);

		for (examQuestion question : exam)
			question.displayQuestion(myPanel);

		scoreButton = new JButton("Calculate score");
		scoreButton.addActionListener( new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
				checkExam();
		    		int temp = 100*correctAnswersCounter/exam.size();
		    		scoreButton.setText("Your score is: " + temp);
		      }
		    });

		myPanel.add(scoreButton);
		reExamButton = new JButton("New Exam");
		reExamButton.addActionListener( new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    		correctAnswersCounter = 0;
		    		displayQuestionFrame();
		      }
		});
		
		myPanel.add(reExamButton);
		frame.pack();
		frame.setVisible(true);
	}
	
	private String getQuestionCorrectAnswer(String st) {
		
        for (examQuestion question : exam)
        		if (question.getQuestionString() == st)
        			return question.getAnswer();
        
        return st;
		
	}
	
	public void checkExam() {

		for (int j =0; j < myPanel.getComponentCount(); j++) {
			if (myPanel.getComponent(j) instanceof JLabel) {
				for (int i =0; i < myPanel.getComponentCount(); i++) {
					if (myPanel.getComponent(i) instanceof JRadioButton &&
							myPanel.getComponent(i).getName() 
							== ((JLabel)myPanel.getComponent(j)).getText()) {
						if ( ((JRadioButton)myPanel.getComponent(i)).isSelected() &&
								(( getQuestionCorrectAnswer(myPanel.getComponent(i).getName()) == 
										((JRadioButton)myPanel.getComponent(i)).getText()) )){
											((JLabel)myPanel.getComponent(j)).setForeground(Color.GREEN);
											((JLabel)myPanel.getComponent(j)).setText(((JLabel)myPanel.getComponent(j)).getText() + " - Correct");
											correctAnswersCounter++;
						}				
						
					}
				}	
			}
		}
	}
		
}


