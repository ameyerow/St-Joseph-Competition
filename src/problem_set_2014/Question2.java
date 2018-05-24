package problem_set_2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("ChangeIn.txt"));
		
		int numCustomers = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < numCustomers; i++) {
			String line = sc.nextLine();
			Scanner sc_line = new Scanner(line);
			
			int numItems = sc_line.nextInt();
			double unitPrice = sc_line.nextDouble();
			double amountPaid = sc_line.nextDouble();
			
			double difference = amountPaid - (unitPrice * numItems);
			
			NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
			if(difference >= 0) {
				System.out.println("Your change is " + formatter.format(difference));
			} else {
				difference*=-1;
				System.out.println("Please pay an additional " + formatter.format(difference));
			}
			
			sc_line.close();
		}
		
		sc.close();
	}
}
