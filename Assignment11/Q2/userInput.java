import javax.swing.JOptionPane;

public class userInput {
	
	//gets the input from the user and checks input validty.
	public static int getYearInput() {
		String userYear = JOptionPane.showInputDialog(null, "Enter year (2015-2019)");
		if (userYear==null)
			return -1;
		if (userYear.isBlank())
			return 0;
		if (!isNumeric(userYear))
			return -2;
		else
			return validateUserYear(Integer.parseInt(userYear));
	}

	//Validates the year inputed by the user. Returns 0 if the year inputed is not valid.
	public static int validateUserYear(int input) {
		if ((input >= TemperatureData.FIRST_YEAR) &&
			(input <TemperatureData.FIRST_YEAR + TemperatureData.NUM_OF_YEARS))
				return input;
		else 
			return 0;
		
	}
	
	//Checks if the string inputed by user is a string only of digits. 
	public static boolean isNumeric(String str){
	    for (char c : str.toCharArray()){
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}

}
