//MMN 14, question 2, May 2020



import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;



//Represents a cell in the calendar. Each cell is a 'day'.
public class CalendarCell extends JPanel{
	
	LocalDate cellDate;
	JTextArea textArea;
	
	CalendarCell(LocalDate date, HashMap<LocalDate, String> calendarMap){

		super();
		LocalDate cellDate = date;
		calendarMap.containsValue(cellDate);
		
		String localeDate = cellDate.getDayOfMonth() +"-"+ cellDate.getMonth()+"-"+cellDate.getYear();
		
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		textArea = new JTextArea(9,20);
		textArea.setEditable(false);
		textArea.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e) {

				new TextInputFrame(date, calendarMap, textArea);
            	}
        });
		
		if (date.equals(LocalDate.now()))
			textArea.setBackground(new Color(124, 185, 232));
		else
			textArea.setBackground(Color.LIGHT_GRAY);
		
		if (	calendarMap.containsKey(cellDate)) {
			textArea.setText(localeDate + "\n\n" + trimNumOfLines(calendarMap.get(cellDate), 4));
	
		}
		else
			textArea.setText(localeDate + "\n\n" );

		add(textArea);
		
	}

	
//Trims the amount of text shown in a cell. This controls the size of a cell since GridLayout 
//ignores the setSize of a JTextArea.
	public static String trimNumOfLines(String st, int numLines) {

		String temp, trimmedSt;
		int i = 0;
		int k = 0;

		temp = "";
		trimmedSt = st;

		k = trimmedSt.indexOf("\n");

		if (k==-1)
			return st;

		while (k!=-1 && i < numLines) {
			temp = temp + trimmedSt.substring(0, k+1);
			trimmedSt = trimmedSt.substring(k+1);
			k = trimmedSt.indexOf("\n");
			i++;

		}

		return temp;
	}

}
