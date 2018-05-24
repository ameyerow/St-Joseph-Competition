package teaching_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("AddThemUp.txt"));
		
		int numberOfSums = sc.nextInt();
		
		for(int i = 0; i < numberOfSums; i++) {
			int numberOfTerms = sc.nextInt();
			int twoTermsPrior = 1;
			int oneTermPrior = 2;
			int sum = 3;
			
			for(int x = 3; x <= numberOfTerms; x++) {
				int currentTerm = twoTermsPrior - oneTermPrior;
				sum += currentTerm;
				twoTermsPrior = oneTermPrior;
				oneTermPrior = currentTerm;
			}
			
			System.out.println(sum);
		}
		
		sc.close();
	}
}
