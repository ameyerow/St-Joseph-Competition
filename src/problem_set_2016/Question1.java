package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question1 {
	private static final File FILE = new File("MpgIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		String input = null;
		
		Scanner scanner = new Scanner(FILE);
		input = scanner.nextLine();
		
		scanner.close();
		
		double DMT, MPG, RMT, G;
		int[] endpoints = new int[3];
		int index_arr = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(input.substring(i, i+1).equals(" ")) {
				endpoints[index_arr] = i;
				index_arr++;
			}
		}
		
		DMT = Integer.parseInt(input.substring(0, endpoints[0]));
		MPG = Integer.parseInt(input.substring(endpoints[0]+1, endpoints[1]));
		RMT = Integer.parseInt(input.substring(endpoints[1]+1, endpoints[2]));
		G =   Integer.parseInt(input.substring(endpoints[2]+1, input.length()));
		
		int NDMT = (int)(DMT + RMT);
		int NMPG = (int)(NDMT/(DMT/MPG + G));
		
		System.out.println(NDMT + " miles " + NMPG + " mpg");
	}
}
