package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question1 {
	private static final File FILE = new File("MpgIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(FILE);

		double DMT, MPG, RMT, G;

		DMT = scanner.nextInt();
		MPG = scanner.nextInt();
		RMT = scanner.nextInt();
		G =   scanner.nextInt();
		
		int NDMT = (int)(DMT + RMT);
		int NMPG = (int)(NDMT/(DMT/MPG + G));
		
		System.out.println(NDMT + " miles " + NMPG + " mpg");
		
		scanner.close();
	}
}
