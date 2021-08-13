import java.security.SecureRandom;

public class TemperatureData { //Generates random temperatures for the 5 year period.

	static int NUM_OF_YEARS = 5;
	private static int NUM_OF_MONTHS = 12;
	private static int MAX_TEMP = 40;
	private static int MIN_TEMP = 5;
	static int FIRST_YEAR = 2015;
	private static int tempData[][] = new int [NUM_OF_YEARS][NUM_OF_MONTHS];
	static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", 
			"September", "October", "November", "December"};
	//random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	static { //Populates temperatures in the temperatures array
		for (int i = 0; i < NUM_OF_YEARS; i++) {
			for (int j=0; j < NUM_OF_MONTHS; j++) {
				tempData[i][j] = MIN_TEMP + randomNumbers.nextInt(MAX_TEMP);
			}
		}
	}

	public static void printYearData(int year) { //Was used for debug. Prints to console the generated temperatures for given year.
		for (int j = 0; j < NUM_OF_MONTHS; j++)
			System.out.printf("%d %d\n", j,  tempData[year-FIRST_YEAR][j]);
	}
	
	public static int getTemp(int year, int month) { //Returns temperature for given year and month.
		return tempData[year-FIRST_YEAR][month];
	}
	
	public static int getMinTemp(int year){ //Returns minimum temperature of a given year.
		
		int temp = MAX_TEMP;
		for (int i =0; i < NUM_OF_MONTHS; i++){
			if (tempData[year-FIRST_YEAR][i] < temp)
				temp =  tempData[year-FIRST_YEAR][i];
		}
		return temp;
	}
	
	public static int getMaxTemp(int yearInput){ //Returns maximum temperature of a given year.
		
		int temp = 0;
		for (int i =0; i < NUM_OF_MONTHS; i++){
			if (tempData[yearInput-FIRST_YEAR][i] > temp)
				temp =  tempData[yearInput-FIRST_YEAR][i];
		}
		return temp;
	}
}
