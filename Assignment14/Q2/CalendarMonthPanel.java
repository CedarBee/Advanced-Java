//MMN 14, question 2, May 2020

import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Panel of the month with a cell for each day
public class CalendarMonthPanel extends JPanel{
	
	private final int ROWS = 6;
	private final int COLUMNS = 7;
	private final int GAP = 2;
	private static final Color BG = Color.WHITE;
	private int j;
	
	CalendarMonthPanel(MyCalendar myCalendar){
	
		super();

		setLayout(new GridLayout(ROWS, COLUMNS, 1, 1));
		setBackground(BG);
		LocalDate firstDayOfMonth = LocalDate.of(myCalendar.getSelectedYear(), MyCalendar.getSelectedMonth()+1, 1);
		firstDayOfMonth.getDayOfWeek();
		 
		 j=0; //Counts the number of cells created.
		 
		 //Create empty cells to align the table with the days of the week.
		 for (int i = 0 ; i<= firstDayOfMonth.getDayOfWeek().getValue()-1; i++) {

			 JLabel myLabel = new JLabel();
				setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
				add(myLabel);
				j++;
		 
		 }
		
		 int numDaysInMonth = LocalDate.of(myCalendar.getSelectedYear(), MyCalendar.getSelectedMonth()+1, 1).lengthOfMonth();
		 
		for (int i = 1; i <= numDaysInMonth; i++) {
			LocalDate date = LocalDate.of(myCalendar.getSelectedYear(), MyCalendar.getSelectedMonth()+1, i);
			CalendarCell cell = new CalendarCell(date, myCalendar.getCalendarHashMap());
			setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
			add(cell);
			j++;
		}
		
		//Adds empty cells to pad the month panel.
		for (int i = j ; i< ROWS * COLUMNS; i++) {

			JLabel myLabel = new JLabel();
			setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
			add(myLabel);
		 
		 }
	}
	
	public CalendarMonthPanel getCalendarMonthPanel() {
		return this;
	}
	
}
