package teaching_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("HatchingIn.txt"));
		
		int numberOfEggs = Integer.parseInt(sc.nextLine());
		int totalMinutes = numberOfEggs * 13;
		int numberOfHours = totalMinutes / 60;
		int numberOfMinutes = totalMinutes % 60;
		
		System.out.println("Cathy will be hatching eggs for " + numberOfHours + " hours and " + numberOfMinutes + " minutes");
		
		sc.close();
	}
}
