//MMN 13, question 1, April 2020


import java.util.*;
import javax.swing.*;
import java.awt.Container;


public class examQuestion extends JFrame {
	
	private ArrayList <String> question = new ArrayList<String>(NUM_ANSWERS+1);
	private ArrayList <String> shuffledAnswers = new ArrayList<String>(NUM_ANSWERS-1);
	private String correctAnswer;
	private int BORDER_CONSTANT = 20;
	
	final static int NUM_ANSWERS= 4;

	
	public void addQuestionOrAnswer(String q) {
		
		question.add(q);
		
	}
	
	public ArrayList <String> getQuestion(){
		
		return question;
		
	}
	
	public String getQuestionString() {
		
		return question.get(0);
	}
	
	public String getAnswer() {
		
		return question.get(1);
	}
	
	
	public void printQuestion() {
		for (String st : question) {
			System.out.println(st);
		}
	}
	
	public void displayQuestion(Container myPanel) {
		
		correctAnswer = question.get(1);
		shuffledAnswers.clear();

		for (int i=1; i < question.size(); i++) {
    	   		shuffledAnswers.add(question.get(i));
       }

     	Collections.shuffle(shuffledAnswers);
           
		JRadioButton A1   = new JRadioButton(shuffledAnswers.get(0), true);
		A1.setBorder(BorderFactory.createEmptyBorder(0, BORDER_CONSTANT, 0, 0));
		A1.setName(question.get(0));
		JRadioButton A2    = new JRadioButton(shuffledAnswers.get(1));
		A2.setBorder(BorderFactory.createEmptyBorder(0, BORDER_CONSTANT, 0, 0));
		A2.setName(question.get(0));
		JRadioButton A3 = new JRadioButton(shuffledAnswers.get(2));
		A3.setBorder(BorderFactory.createEmptyBorder(0, BORDER_CONSTANT, 0, 0));
		A3.setName(question.get(0));
		JRadioButton A4 = new JRadioButton(shuffledAnswers.get(3));
		A4.setBorder(BorderFactory.createEmptyBorder(0, BORDER_CONSTANT, 0, 0));
		A4.setName(question.get(0));
		
        ButtonGroup bgroup = new ButtonGroup();

        bgroup.add(A1);
        bgroup.add(A2);
        bgroup.add(A3);
        bgroup.add(A4);
 		
        JLabel label = new JLabel(question.get(0));

        label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		myPanel.add(label);
        myPanel.add(A1);
        myPanel.add(A2);
        myPanel.add(A3);
        myPanel.add(A4);
	
	}

}
