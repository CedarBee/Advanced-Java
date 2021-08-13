import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class drawGraph {

	private static int userYear = 0;
	
	public static void makeGraph(){

		JFrame window = new JFrame();
		
		while (userYear != -1) { //Loop runs until user requested to exit by pressing the close button or 'cancel' in the dialog box.
			
			userYear = userInput.getYearInput();

			if (userYear == 0) {
				//System.out.println("User bad input."); //Was used for debug.
		        JOptionPane.showMessageDialog(null, "Unavailable year. Try again.");
			}
			
			if (userYear == -2) {
				//System.out.println("User bad input.");//Was used for debug.
		        JOptionPane.showMessageDialog(null, "Illegal input. Try again.");
			}

			if (userInput.validateUserYear(userYear)!=0 && userInput.validateUserYear(userYear)!=-2) {
				MyPanel drawing = new MyPanel();
				//TemperatureData.printYearData(userYear);
				window.add(drawing);
				window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.setSize(1000, 600);
				window.setVisible(true);
			}
			
			if (userYear == -1) { //Closes the JFrame
				//System.out.println("User exited.");  //Was used for debug.
				window.dispose();
			}

		}//End while loop.

	}//End makeGraph
	
	public static int getUserYear() { //Returns the user input of requested year.
		return userYear;
	}

}
