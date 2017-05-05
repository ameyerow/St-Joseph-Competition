package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question4 {
	private static final File FILE = new File("NumbersGameIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException  {
		Scanner scanner = new Scanner(FILE);
		int messages = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < messages; i++) {
			String encrypted = scanner.nextLine();
			int length = Integer.parseInt(scanner.nextLine());
			
			
			String decrypted = "";

			Map<Integer, String> map = new HashMap<Integer, String>();
			
			for(int j = 0; j < encrypted.length(); j++) {
				map.put(j+1, encrypted.substring(j, j+1));
			}
			
			for(int k = 0; k < length; k++) {
				String a = getCharacter(map, scanner.nextInt());
				decrypted += a;
			}
			
			if(scanner.hasNextLine())
				scanner.nextLine();
			
			System.out.println(decrypted);
			
		}
		scanner.close();
	}
	
	private static String getCharacter(Map<Integer, String> map, int key) {
		if(key > 20) {
			return " ";
		} else {
			return map.get(key);
		}
	}
}
