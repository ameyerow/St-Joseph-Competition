package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question2 {
	private static final File FILE = new File("IntersectionIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(FILE); 	
    
        int intersections = Integer.parseInt(scanner.nextLine());
        
        int[][] inputs = new int[intersections][2];
        
        for(int i = 0; i < intersections; i++) {
        	String line = scanner.nextLine();
        	
            inputs[i][0] = Integer.parseInt(line.substring(0, 1));
            inputs[i][1] = Integer.parseInt(line.substring(2, 3));
        }
        scanner.close();
                
        for(int j = 0; j < intersections; j++) {
            int color = inputs[j][0];
            int direction = inputs[j][1];
            
            if(color == 1) {
                switch(direction) {
                    case 1:
                        System.out.println("P");
                        break;
                    case 2:
                        System.out.println("LT");
                        break;
                    case 3: 
                        System.out.println("RT");
                        break;
       
                }
            } else {
                switch(direction) {
                    case 1:
                        System.out.println("S");
                        break;
                    case 2:
                        System.out.println("S");
                        break;
                    case 3:
                        System.out.println("SRT");
                        break;
                }
            }
        }
    }
}
