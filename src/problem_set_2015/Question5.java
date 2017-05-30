package problem_set_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question5 {
	private static final File file = new File("NumbersIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
	
		int expression = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < expression; i++) {
			int key = scanner.nextInt();
			int num = scanner.nextInt();
			int groupings = (int) Math.pow(2, key);
			
			System.out.println(key);
			System.out.println(groupings);
			boolean negative = false;
			if(num < 0) {
				negative = true;
				num *= -1;
			}
			
			if(scanner.hasNextLine())	
				scanner.nextLine();
			
			String num_bin = Integer.toBinaryString(num);
			
			if(num_bin.length() % groupings != 0) {
				while(true) {
					num_bin = "0" + num_bin;	
					
					if(num_bin.length() % groupings == 0)
						break;
				}
			}
			String[] groups = new String[num_bin.length()/groupings];
			int index = 0;
		
			for(int j = 0; j < num_bin.length()-groupings; j += groupings) {
				String temp = num_bin.substring(j, j+groupings);
				groups[index] = temp;
				index++;
			}
			
			for(String string: groups) {
				System.out.println(string);
				
			}
		}
	}
}
