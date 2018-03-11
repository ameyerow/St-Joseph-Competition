package problem_set_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question6 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("MowerIn.txt"));
		
		int lawns = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < lawns; i++) {
			String line = sc.nextLine();
			Scanner sc_line = new Scanner(line);
		
			double lawnMowerWidth = sc_line.nextDouble();
			double lawnHeight = sc_line.nextDouble();
			double lawnWidth = sc_line.nextDouble();
			double walkingSpeed = sc_line.nextDouble();
			double turningTime = sc_line.nextDouble();
			
			sc_line.close();

			double initialWidth = lawnWidth;
			double distanceMowed = 0.0;
			int numTurns = 0;
			
			boolean justPlacedLawnMower = true;
			
			while(true) {
				distanceMowed += justPlacedLawnMower ? lawnHeight - lawnMowerWidth : lawnHeight;
				lawnWidth -= lawnMowerWidth;
				lawnWidth = lawnWidth < 0 ? 0 : lawnWidth;
				if(numTurns == 2*((Math.ceil(initialWidth/lawnMowerWidth))-1)) break;
				
				numTurns++;
				lawnWidth -= numTurns%3 == 0 ? 0 : lawnMowerWidth;
				lawnWidth = lawnWidth < 0 ? 0 : lawnWidth;
				
				distanceMowed += lawnWidth;
				lawnHeight -= lawnMowerWidth;
				
				numTurns++;
				lawnHeight -= numTurns%4 == 0 ? 0 : lawnMowerWidth;
				
				justPlacedLawnMower = false;
			}
			
			double seconds = (distanceMowed/walkingSpeed) + (turningTime*numTurns);
			
			System.out.println(seconds);
		} 
		
		sc.close();
	}
}