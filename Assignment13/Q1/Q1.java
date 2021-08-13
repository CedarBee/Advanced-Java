//MMN 13, question 1, April 2020

import java.util.*;
import java.io.*;

public class Q1 {

	public static void main(String[] args) {

		Scanner input = null;
		Exam exam = null;
		
		try {
			
			input = new Scanner(new File("exam.txt"));
			exam = new Exam(input);
			exam.displayQuestionFrame();
			
		}
		
		catch(FileNotFoundException e) {
			System.out.println("File not found");			
		}
		
		finally	{
			
			if (input!=null) input.close();
			
		}
	}

}
