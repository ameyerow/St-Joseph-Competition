package teaching_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> vowels = new ArrayList<>();
		Collections.addAll(vowels, "a", "e", "i", "o", "u");
		
		Scanner sc = new Scanner(new File("LatinIn.txt"));
		
		int numberOfLines = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < numberOfLines; i++) {
			String line = sc.nextLine();
			Scanner sc_line = new Scanner(line);
			
			ArrayList<String> words = new ArrayList<>();
			while(sc_line.hasNext()) {
				words.add(sc_line.next());
			}
			
			sc_line.close();
			
			String finalized = "";
			for(String word : words) {
				String lowerCase = word.toLowerCase();
				boolean capitalized = lowerCase.equals(word) ?  false : true;
				
				if(vowels.contains(lowerCase.substring(0, 1))) {
					word = word + "way";
				} else {
					String firstLetter = lowerCase.substring(0, 1);
					String restOfWord = lowerCase.substring(1);
					
					lowerCase = restOfWord + firstLetter + "ay";
					word = lowerCase;
				}
				
				if(capitalized) {
					String firstLetter = word.substring(0, 1).toUpperCase();
					word = firstLetter + word.substring(1);
				}
				
				finalized = finalized + " " + word;
			}
			
			System.out.println(finalized.trim());
		}
		
		sc.close();
	}
}
