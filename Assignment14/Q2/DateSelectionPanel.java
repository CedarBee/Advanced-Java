//MMN 14, question 2, May 2020


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.util.Vector;
import javax.swing.*;

//Panel with comboBox's to select a month and year. Default values of the comboBox's
//are the present month and year.
public class DateSelectionPanel extends JPanel implements ItemListener{

    private static String[] months = new DateFormatSymbols().getMonths(); //The list of months
    private static Vector<String> years = new Vector<String>(); //The years for selection. 
    																//Will populate the years comboBox
    private static boolean runOnce = false;
    private static MyCalendar myCalendar;
    private static JComboBox<String> monthList;
    private static JComboBox<String> yearList;
 

    DateSelectionPanel(MyCalendar myCalendar){
		
			super();
			
			this.myCalendar = myCalendar;
		    
		    if (runOnce == false) { //Generates the months and years list. Needs to only run once	
		    							//and not every repaint of the monthPanel.
				yearsGenerator();
	
				LocalDate today = LocalDate.now();
			
				BoxLayout boxLayout = new BoxLayout(this,BoxLayout.LINE_AXIS);
				monthList = new JComboBox(months);
				monthList.addItemListener(this);

				yearList = new JComboBox(years);
				yearList.addItemListener(this);
					
				monthList.setSelectedIndex(today.getMonthValue()-1);
				myCalendar.setSelectedMonth(today.getMonthValue()-1);
				yearList.setSelectedIndex(today.getYear()-1970);
				myCalendar.setSelectedYear(today.getYear());
				yearList.addItemListener(this);
			
				runOnce = true;
			}
		    else
		    {
  	
				myCalendar.setSelectedMonth(getMonthNum(monthList.toString()));
				myCalendar.setSelectedYear(yearList.getSelectedIndex()+1970);
		    }
		    
		    add(monthList);
			add(yearList);
		
		}
    
    
    private static int getMonthNum(String month){
    	
    		for (int i = 0; i< months.length; i++)
    			if (months[i].equals(month))
    				return i;
    		
    		return 0;
    	
    }
    
    private static void yearsGenerator(){

    	for (int i = 1970; i < 2070; i++)
    		years.add(Integer.toString(i));

    }

    @Override
    public void itemStateChanged(ItemEvent event) {
	    	if (event.getStateChange() == ItemEvent.SELECTED && runOnce==true) {
	    		Object item = event.getItem();
	
	    		if (event.getSource() == monthList) {
	    			if (getMonthNum(item.toString())!=myCalendar.getSelectedMonth()) {
	    				myCalendar.setSelectedMonth(getMonthNum(item.toString()));
	    				myCalendar.repaint();
	    			}
	    		}
	
	    		if (event.getSource() == yearList) {
	    			if ((item.toString())!=Integer.toString(myCalendar.getSelectedYear())) {
	    				myCalendar.setSelectedYear(Integer.decode(item.toString()));
	    				myCalendar.repaint();
	    			}
	    		}
	    	}
    }       

}
