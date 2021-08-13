//MMN 14, question 2, May 2020


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextInputFrame extends JFrame implements ActionListener{
	
	JPanel buttonsPanel = new JPanel();
	JButton okButton = new JButton("OK");
	JButton cancelButton = new JButton("Cancel");
	JTextArea text = new JTextArea(20, 30);
	
	
	public TextInputFrame(LocalDate date, HashMap<LocalDate, String> calendarMap, JTextArea cellTextArea) {
	
		super();
		
		String localeDate = date.getDayOfMonth() +"-"+ date.getMonth()+"-"+date.getYear();
		
		buttonsPanel.setLayout(new GridLayout(1,2));
		buttonsPanel.add(okButton);
		buttonsPanel.add(cancelButton);
		
		okButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				calendarMap.put(date, text.getText());
				cellTextArea.setText(localeDate + "\n\n" + CalendarCell.trimNumOfLines(calendarMap.get(date), 4));
				
	
				setVisible(false);
				dispose();
			}
			
		});
		
		
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
			
		});
		
		text.setText(calendarMap.get(date));
		add(buttonsPanel, BorderLayout.SOUTH);
		add(new JScrollPane(text), BorderLayout.CENTER);
		setTitle(date.getDayOfMonth() +"-"+ date.getMonth()+"-"+date.getYear());
		setSize(400, 500);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
