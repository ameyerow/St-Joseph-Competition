package problem_set_2012;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("BigBucksIn.txt"));
		
		int numberOfLines = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < numberOfLines; i++) {
			String line = sc.nextLine();
			Scanner sc_line = new Scanner(line);
			
			String finalNumber = "";
			while(sc_line.hasNext()) {
				try {
					int digit = Integer.parseInt(sc_line.next());
					finalNumber += digit;
				} catch(Exception e) {}
			}
			
			NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
			System.out.println(formatter.format(Double.parseDouble(finalNumber)));
			
			sc_line.close();
		}
		
		sc.close();
	}
}