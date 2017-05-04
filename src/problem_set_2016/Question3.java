package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {
	private static final File FILE = new File("WindyWalkIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(FILE);
		
		int walks = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < walks; i++) {
			int destination = Integer.parseInt(scanner.nextLine());
			String sequence = scanner.nextLine();
			
			ArrayList<Integer> steps = new ArrayList<Integer>();
			
			int start = 0;
			
			for(int j = 0; j < sequence.length(); j++) {
				if(sequence.length() - j  <= 1) {
					steps.add(Integer.parseInt(sequence.substring(start, sequence.length()).replace(" ", "")));
					
					break;
				} else if(sequence.substring(j, j+1).equals(" ")) {
					steps.add(Integer.parseInt(sequence.substring(start, j)));
					start = j+1;
				}
			}
			
			int sum = 0;
			int time = 0;
			outer: for(int k = 0; k < steps.size(); k++) {
				for(int l = 0; l < Math.abs(steps.get(k)); l++) {
					time++;
					sum = steps.get(k) > 0 ? sum+1 : sum-1;
					
					if(sum == destination) {
						break outer;
					}
				}
			}
			
			System.out.println(time);
		}
		
		scanner.close();
	}
}
