package problem_set_2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question4 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("SquareIn.txt"));
		
		int numValues = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < numValues; i++) {
			int n = Integer.parseInt(sc.nextLine());
			
			double total = 0;
			
			for(double j = 1; j <= n; j++) {
				total += Math.pow(j, 2);
			}
			
			System.out.println(String.format("%.0f", total));
		}
		
		sc.close();
	}
}
