package problem_set_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Question5 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("MaggieIn.txt"));
		
		int shoppingSprees = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < shoppingSprees; i++) {
			double totalPurchases = Double.parseDouble(sc.nextLine());
			
			if(totalPurchases > 100.00) {
				totalPurchases *= 0.65;
			} else if(totalPurchases > 75.00) {
				totalPurchases *= 0.80;
			} else if(totalPurchases > 50.00) {
				totalPurchases *= 0.90;
			} else if(totalPurchases > 25.00) {
				totalPurchases *= 0.95;
			}
			
			NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
			System.out.println("$" + format.format(totalPurchases));
		}
		
		sc.close();
	}
}
