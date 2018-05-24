package problem_set_2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.text.NumberFormatter;

public class Question5 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("RaiseIn.txt"));
		
		int employees = sc.nextInt();
		
		for(int i = 0; i < employees; i++) {
			double income = sc.nextDouble();
			
			double fivePercent = income * .05;
			
			if(fivePercent > 1.00) { 
				double newIncome = fivePercent + income;
				
				NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
				
				System.out.println("5% " + nf.format(newIncome));
			} else {
				double newIncome = income + 1.00;
				
				NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
				
				System.out.println("$1.00 " + nf.format(newIncome));
			}	
		}
		
		sc.close();
	}
}
