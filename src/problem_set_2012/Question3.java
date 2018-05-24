package problem_set_2012;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("SJCPennyIn.txt"));
		
		int numberOfItems = Integer.parseInt(sc.nextLine());
		
		double totalPrice = 0;
		
		for(int i = 0; i < numberOfItems; i++) {
			String line = sc.nextLine();
			Scanner sc_line = new Scanner(line);
			
			while(sc_line.hasNext()) {
				String element = sc_line.next();
				
				if(sc_line.hasNext()) continue;
				
				double price = Double.parseDouble(element);
				totalPrice += price;
			}
			
			sc_line.close();
		}
		
		
		
		sc.close();
	}
}
