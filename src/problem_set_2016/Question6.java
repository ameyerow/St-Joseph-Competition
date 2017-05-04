package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question6 {
	private static final File FILE = new File("DarthEvaderIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner scanner = new Scanner(FILE);
		
		int games = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < games; i++) {
			String params_str = scanner.nextLine();
			/*
			 * @double[] params
			 * params[0] = width (w)
			 * params[1] = height (h)
			 * params[2] = upward (U)
			 * params[3] = downward (D)
			 * params[4] = left (L)
			 * params[5] = right (R)
			 * 
			 */
			double[] params = new double[6];
			
			int params_index = 0;
			
			int start = 0;
				
			for(int k = 0; k < params_str.length(); k++) {
				if(params_str.length() - k  <= 1) {
					params[params_index] = Integer.parseInt(
							params_str.substring(start, params_str.length()).replace(" ", ""));					
					break;
				} else if(params_str.substring(k, k+1).equals(" ")) {
					params[params_index] = Integer.parseInt(params_str.substring(start, k));
						
					params_index++;
					start = k+1;
				}
			}
			/*
			 * @Point[] rect
			 * rect[0] = top left
			 * rect[1] = top right
			 * rect[2] = bottom left
			 * rect[3] = bottom right
			 * 
			 */
			Point[] rect = getRectangle(params);
			
			int numDarts = Integer.parseInt(scanner.nextLine());
			Point[] coords = new Point[numDarts]; 
			
			for(int k = 0; k < numDarts; k++) {
				String coord_str = scanner.nextLine();
				
				for(int j = 0; j < coord_str.length(); j++) {
					if(coord_str.substring(j, j+1).equals(" ")) {
						coords[k] = new Point( Double.parseDouble(coord_str.substring(0, j)),
								Double.parseDouble(coord_str.substring(j+1, coord_str.length())) );
					}
				}
			}
			
			
		}
		scanner.close();
	}	
	
	private static Point[] getRectangle(double[] params) {
		Point[] rect = new Point[4];
		rect[0] = new Point(params[4], params[2]);
		rect[1] = new Point(params[4]+params[0], params[2]);
		rect[2] = new Point(params[4], params[2]+params[1]);
		rect[3] = new Point(params[4]+params[0], params[2]+params[1]);
		
		return rect;
	}
	
	private static boolean rectangleContains(Point point, Point[] rect) {
		
		//change!!
		return true;
	}
	
	static class Point {
		private double x;
		public double getX() { return x; }
		
		private double y;
		public double getY() { return y; }
		
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
}
