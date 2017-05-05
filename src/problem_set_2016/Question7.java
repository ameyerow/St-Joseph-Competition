package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question7 {
	private enum State {
		inside, outside, neither
	}
	
	private static final File FILE = new File("InsideOutsideIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(FILE);
		
		int floors = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < floors; i++) {
			int numDisks = scanner.nextInt();
			int focus = scanner.nextInt();
			scanner.nextLine();
			
			Map<Integer, Disk> map = new HashMap<Integer, Disk>();
			
			for(int j = 1; j <= numDisks; j++) {
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int r = scanner.nextInt();
				scanner.nextLine();
				
				map.put(j, new Disk(x, y, r));
			}
			
			ArrayList<Integer> inside  = new ArrayList<Integer>();
			ArrayList<Integer> outside = new ArrayList<Integer>();
			
			for(int j = 1; j <= numDisks; j++) {
				if(j != focus) {
					if(compareDisks(map.get(focus), map.get(j)) == State.inside) {
						inside.add(j);
					} else if(compareDisks(map.get(focus), map.get(j)) == State.outside) {
						outside.add(j);
					}
				}
			}
			
			Collections.sort(inside);
			Collections.sort(outside);
			
			String output = "";
			
			for(Integer a: inside) {
				output += " " + a;
			}
			for(Integer a: outside) {
				output += " " + a;
			}
			output.trim();
			System.out.println(output);
		}
		
		scanner.close();
	}
	
	private static State compareDisks(Disk d1, Disk d2) {
		double x1 = d1.getX();
		double y1 = d1.getY();
		
		double x2 = d2.getX();
		double y2 = d2.getY();
		
		if(distance(x1, y1, x2, y2) >= d1.getR() + d2.getR()) {			
			return State.outside;
		} else if(distance(x1, y1, x2, y2) + d2.getR() <= d1.getR()) {	
			return State.inside;
		} else {
			return State.neither;
		}
	}
	
	private static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt( Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) );
	}
	
	static class Disk {
		private int x;
		private int y;
		private int r;
		
		public int getX() { return x; }
		public int getY() { return y; }
		public int getR() { return r; }
		
		public Disk(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
}
