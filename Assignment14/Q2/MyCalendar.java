//MMN 14, question 2, May 2020

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyCalendar extends JFrame{

	private static int selectedMonth;
	private static int selectedYear;
	private final static int GAP = 20;
	private HashMap<LocalDate, String> calendarMap;
	private JPanel myMainPanel;
	private DateSelectionPanel dateSelectionPanel; //The panel for the selection of the month and year
	private CalendarMonthPanel monthPanel; //The panel that shows the cells of the selected month

	
	MyCalendar(){


		calendarMap = new HashMap<LocalDate, String>(); 
		calendarMap.put(LocalDate.now(), "Readme\nclick here.\n\n\nClick on a date cell and edit the "
				+ "date's itinerary.\nThe blue cell is today.\nPressing 'OK' will save the content.\n"
				+ "Cancel will ignore the changes made.");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myMainPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(myMainPanel,BoxLayout.PAGE_AXIS );
		myMainPanel.setLayout(boxLayout);
		myMainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

		dateSelectionPanel = new DateSelectionPanel(this);
		monthPanel = new CalendarMonthPanel(this);

		myMainPanel.add(dateSelectionPanel);
		myMainPanel.add(printWeekdays());
		myMainPanel.add(monthPanel);
	
		setSize(800, 900);
		setContentPane(myMainPanel);
		setVisible(true);

	}
	
//Repaints the JFrame after a new selection of month and/or year.
	public void repaint(){
	
		myMainPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(myMainPanel,BoxLayout.PAGE_AXIS );
		myMainPanel.setLayout(boxLayout);
		myMainPanel.setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
		monthPanel = new CalendarMonthPanel(this);
		myMainPanel.add(dateSelectionPanel);
		myMainPanel.add(printWeekdays());
		myMainPanel.add(monthPanel);
		setContentPane(myMainPanel);
		setVisible(true);
		
	}
	
	public CalendarMonthPanel getMonthPanel() {
		return monthPanel;
	}
	
	public HashMap<LocalDate, String> getCalendarHashMap() {
		return calendarMap;
	}
	
//Creates a JPanel showing the week days in row.
	public static JPanel printWeekdays(){
		
		JPanel weekdays = new JPanel();
		weekdays.setLayout(new GridLayout(1, 7 , 1, 1));
		Font myFont = new Font("Serif", Font.ITALIC, 16);
		
		for (int i=0; i < 7; i++) {
			JLabel myLabel = new JLabel();
			myLabel.setFont(myFont);
			myLabel.setHorizontalAlignment(myLabel.CENTER);
			myLabel.setForeground(Color.black);

	        switch (i) { 
	
	        case 0: 
	        		myLabel.setText("Sunday");
	            break; 
	        case 1: 
	        		myLabel.setText("Monday"); 
	            break; 
	        case 2: 
        			myLabel.setText("Tuesday"); 
        			break; 
	        case 3: 
    				myLabel.setText("Wednesday"); 
    				break; 
	        case 4: 
	        		myLabel.setText("Thursday"); 
	        		break;
	        case 5: 
        			myLabel.setText("Friday"); 
        			break;
	        case 6: 
	        		myLabel.setText("Saturday"); 
	        		break;
	        }
			weekdays.add(myLabel);
		}

		return weekdays;
	}
	
	public static void setSelectedMonth(int month) {
		
		selectedMonth = month;
		
	}
	
	public static int getSelectedMonth() {
		
		return selectedMonth;
		
	}
	
	public static void setSelectedYear(int year) {
		
		selectedYear = year;
		
	}
	
	public static int getSelectedYear() {
		
		return selectedYear;
		
	}

}
