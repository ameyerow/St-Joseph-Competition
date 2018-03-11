package problem_set_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("HatchingIn.txt"));
		
		int numEggs = Integer.parseInt(sc.nextLine());
		int hours = (numEggs*13)/60;
		int minutes = (numEggs*13)%60;
		System.out.println("Cathy will be hatching eggs for " + hours + " hours and " + minutes + " minutes");
		
		sc.close();
	}
}
