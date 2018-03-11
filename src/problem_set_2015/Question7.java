package problem_set_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question7 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("NumbersIn.txt"));
		
		int numberOfEncryptions = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < numberOfEncryptions; i++) {
			String line = sc.nextLine();
			Scanner sc_line = new Scanner(line);
			
			int n = Integer.parseInt(sc_line.next());
			int groupingSize = (int) Math.pow(2, n);
			int intToBeEncrypted = Integer.parseInt(sc_line.next());
			
			String binary = Integer.toBinaryString(intToBeEncrypted);
			while(binary.length() < 32) {
				binary = "0" + binary;
			}
			
			String encryptedBinary = "";
			for(int j = 0; j < 32/(2*groupingSize); j++) {
				String a = binary.substring(2*j*groupingSize, 2*j*groupingSize + groupingSize);
				String b = binary.substring(2*j*groupingSize + groupingSize, 2*j*groupingSize + 2*groupingSize);
				
				encryptedBinary = encryptedBinary + b + a;
			}
			
			int intEncrypted = 0;
			try {
				intEncrypted = Integer.parseInt(encryptedBinary, 2);
			} catch(NumberFormatException e) {
				encryptedBinary = encryptedBinary.replace("0", "a").replace("1", "0").replace("a", "1");
				intEncrypted = -1 * (Integer.parseInt(encryptedBinary, 2) + 1);
			}
			System.out.println(intToBeEncrypted + " " + n + " " + intEncrypted);
			
			sc_line.close();
		} 
		
		sc.close();
	}
}
