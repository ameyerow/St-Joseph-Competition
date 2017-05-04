package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question5 {
	private static final File FILE = new File("MathSyntaxIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(FILE);
		
		int expressions = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < expressions; i++) {
			//String expression = scanner.nextLine();
		}
		
		scanner.close();
	}
}
