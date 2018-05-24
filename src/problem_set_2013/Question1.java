package problem_set_2013;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("AsAndBsIn.txt"));
		
		int numberOfStrings = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < numberOfStrings; i++) {
			String string = sc.nextLine();
			
			ArrayList<String> letters = new ArrayList<>();
			
			for(int j = 0; j < string.length(); j++) {
				letters.add(string.substring(j, j+1));
			}
			
			int indexOfFirstLetter = 0;
			boolean foundPair = false;
			
			do {
				foundPair = false;
				while(true) {
					String first = letters.get(indexOfFirstLetter);
					String second = letters.get(indexOfFirstLetter+1);
					
					if(first.equals(second)) {
						foundPair = true;
						letters.remove(indexOfFirstLetter+1);
						letters.set(indexOfFirstLetter, first.equals("A")? "B" : "A");
						indexOfFirstLetter = 0;
					} else {
						indexOfFirstLetter++;
					}
					
					if(indexOfFirstLetter > letters.size() - 2) break;
				}
				indexOfFirstLetter = 0;
				if(letters.size() == 1) break;
			} while(foundPair);
			
			for(String letter : letters) {
				System.out.print(letter);
			}
			System.out.println();
		}
		
		sc.close();
	}
}
