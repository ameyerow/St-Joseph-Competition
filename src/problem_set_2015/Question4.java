package problem_set_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question4 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("LuckyIn.txt"));
		
		int numbers = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < numbers; i++) {
			int n = Integer.parseInt(sc.nextLine());
			
			ArrayList<Integer> oddNumbers = new ArrayList<>();
			for(int j = 0; j < 10000; j++) {
				oddNumbers.add(2*j+1);
			}
			
			for(int j = 1; j < n; j++) {
				int indexToEliminate = oddNumbers.get(j);
				
				for(int k = (oddNumbers.size()-1) - (oddNumbers.size()%indexToEliminate); k > 0; k = k - indexToEliminate) {
					oddNumbers.remove(k);
				}
			}
			
			System.out.println(oddNumbers.get(n-1));
		}
		
		sc.close();
	}
}