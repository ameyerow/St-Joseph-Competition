package problem_set_2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("InchIn.txt"));
		
		int miles = Integer.parseInt(sc.nextLine());
		int hops = miles * 5280 * 12 / 2;
		
		System.out.println("Breanne will make " + hops + " hops");
		
		sc.close();
	}
}
