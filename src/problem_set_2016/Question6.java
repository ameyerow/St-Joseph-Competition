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
			 * @double[] rect
			 * rect[0] = left
			 * rect[1] = right
			 * rect[2] = top
			 * rect[3] = bottom
			 * 
			 */
			double[] rect = getRectangle(params);
			double[] bounds = getBounds(params, rect);
			
			int numDarts = Integer.parseInt(scanner.nextLine());
			Point[] coord_darts = new Point[numDarts]; 
			
			for(int k = 0; k < numDarts; k++) {
				String coord_str = scanner.nextLine();
				
				for(int j = 0; j < coord_str.length(); j++) {
					if(coord_str.substring(j, j+1).equals(" ")) {
						coord_darts[k] = new Point( Double.parseDouble(coord_str.substring(0, j)),
								Double.parseDouble(coord_str.substring(j+1, coord_str.length())) );
					}
				}
			}
			
			int score_l = 0;
			int score_b = 0;
			for(int k = 0; k < numDarts; k++) {
				if(rectangleContains(coord_darts[k], rect)) {
					score_l++;
				} else {
					score_b++;
				}
				translateRectangle(rect, bounds);
			}
			
			System.out.println(score_b + " " + score_l);
		}
		scanner.close();
	}	
	
	private static double[] getRectangle(double[] params) {
		/*
		 * @double[] rect
		 * rect[0] = left
		 * rect[1] = right
		 * rect[2] = top
		 * rect[3] = bottom
		 * 
		 */
		double[] rect = new double[4];
		rect[0] = params[0]/-2;
		rect[1] = params[0]/2;
		rect[2] = params[1]/2;
		rect[3] = params[1]/-2;
		
		return rect;
	}
	
	private static double[] getBounds(double[] params, double[] rect) {
		/*
		 * @double[] bounds
		 * bounds[0] = left
		 * bounds[1] = right
		 * bounds[2] = top
		 * bounds[3] = bottom
		 * 
		 */
		double[] bounds = new double[4];
		bounds[0] = rect[0] - params[4];
		bounds[1] = rect[1] + params[5];
		bounds[2] = rect[2] + params[2];
		bounds[3] = rect[3] - params[3];
		
		return bounds;
	}
	
	private static void translateRectangle(double[] rect, double[] bounds) {	
		/*
		 * @int direction
		 * 0 = left
		 * 1 = right
		 * 2 = up
		 * 3 = down
		 * 
		 */
		int direction = (int)(Math.random()*4);
		
		double dx = 0.0;
		double dy = 0.0;
		
		switch(direction) {
			case 0:
				dx = Math.random() * (rect[0] - bounds[0]);
				rect[0] -= dx;
				rect[1] -= dx;
				break;
			case 1:
				dx = Math.random() * (bounds[1] - rect[1]);
				rect[0] += dx;
				rect[1] += dx;
				break;
			case 2:
				dy = Math.random() * (rect[2] - bounds[2]);
				rect[2] -= dy;
				rect[3] -= dy;
				break;
			case 3: 
				dy = Math.random() * (bounds[3] - rect[3]);
				rect[2] += dy;
				rect[3] += dy;
				break;
		}
		
	}
	
	private static boolean rectangleContains(Point point, double[] rect) {
		if((point.getX() >= rect[0] && point.getX() <= rect[1])
				&&
		   (point.getY() <= rect[2] && point.getY() >= rect[3])) {
			
			return true;
			
		}
		return false;
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
