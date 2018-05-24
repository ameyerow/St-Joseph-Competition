package problem_set_2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("SpotsIn.txt"));
		
		int numProperties = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < numProperties; i++) {
			String firstLine = sc.nextLine();
			Scanner sc_firstLine = new Scanner(firstLine);
			
			int signX = sc_firstLine.nextInt();
			int signY = sc_firstLine.nextInt();
			
			int numSpotlights = sc_firstLine.nextInt();
			
			String secondLine = sc.nextLine();
			Scanner sc_secondLine = new Scanner(secondLine);
			
			double totalIntensity = 0.0;
			for(int j = 0; j < numSpotlights; j++) {	
				int apex = sc_secondLine.nextInt(); //x-coordinate
				int focusAngle = sc_secondLine.nextInt(); //focus angle
				int intensity = sc_secondLine.nextInt(); //intensity
				
				double leftX = ((-1*signY) / Math.tan((90 - focusAngle) * Math.PI / 180)) + apex;
				double rightX = (signY / Math.tan((90 - focusAngle) * Math.PI / 180)) + apex;
				
				if(signX >= leftX && signX <= rightX) { //if the sign is inside the spotlight
					double distance = Math.sqrt((signX-apex)*(signX-apex) + (signY*signY));
					double intensityAtSign = intensity / (distance * distance);
					totalIntensity += intensityAtSign;
				}
			}
		
			sc_firstLine.close();
			sc_secondLine.close();
			
			totalIntensity = Math.round(totalIntensity * 100.0) / 100.0;
			
			System.out.println(String.format("%.2f", totalIntensity));
		}
		sc.close();
	}
}
