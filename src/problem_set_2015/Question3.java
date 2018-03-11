package problem_set_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("LatinIn.txt"));
		
		ArrayList<String> vowels = new ArrayList<>();
		Collections.addAll(vowels, "a", "e", "i", "o", "u");
		
		int lines = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < lines; i++) {
			String line = sc.nextLine();
			Scanner sc_line = new Scanner(line);
			
			String translated = "";
			
			while(sc_line.hasNext()) {
				String word = sc_line.next();
				
				boolean capitalized = !word.toLowerCase().equals(word);
				
				word = word.toLowerCase();
				if(vowels.contains(word.substring(0, 1))) {
					word = word + "way";
				} else {
					String firstCharacter = word.substring(0, 1);
					word = word.substring(1, word.length());
					word = word + firstCharacter + "ay";
				}
				
				if(capitalized) {
					String firstCharacter = word.substring(0, 1).toUpperCase();
					word = firstCharacter + word.substring(1, word.length());
				}
				
				translated = translated + " " + word;
			}
			sc_line.close();
			
			System.out.println(translated.trim());
		}
		sc.close();
	}
}
