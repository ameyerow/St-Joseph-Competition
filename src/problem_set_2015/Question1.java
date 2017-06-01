package problem_set_2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Question1 {
	private static File file = new File("CombinationIn.txt");
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		
		int locks = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < locks; i++) {
			int n = Integer.parseInt(scanner.nextLine());
			
			int[][] lock = getLock(scanner, n);
			String key = getKey(n, lock);
			
			if(key == null) {
				System.out.println("false\n");
				continue;
			}
			
			System.out.println("true");
			
			insertKey(lock, key, n);
			
			for(int[] a : lock) {
				for(int b : a) {
					System.out.print(b + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		scanner.close();
	}
	
	private static int[][] getLock(Scanner scanner, int n) {
		int[][] lock = new int[n+2][n+2];
		
		String top = scanner.nextLine();
		for(int j = 1; j <= n; j++) {
			lock[0][j] = Integer.parseInt(top.substring(2*j-2, 2*j-1));
		}
		
		String bottom = scanner.nextLine();
		for(int j = 1; j <= n; j++) {
			lock[n+1][j] = Integer.parseInt(bottom.substring(2*j-2, 2*j-1));
		}
		
		String left = scanner.nextLine();
		for(int j = 1; j <= n; j++) {
			lock[j][0] = Integer.parseInt(left.substring(2*j-2, 2*j-1));
		}
		
		String right = scanner.nextLine();
		for(int j = 1; j <=n; j++) {
			lock[j][n+1] = Integer.parseInt(right.substring(2*j-2, 2*j-1));
		}
		
		return lock;
	}
	
	private static String getKey(int n, int[][] lock) {
		String key = "";
		for(int j = 0; j < n*n; j++) {
			key += "0";
		}
		
		int combos = (int) Math.pow(n, n*n);
		long start = System.currentTimeMillis();
		int u = 0;
		for(int l = 0; l < combos; l++) {
			u++;

			int[][] temp = insertKey(lock, key, n);
			
			Test test = testKey(temp, n);
			
			if(test.getKeyBoolean()) {
				long end = System.currentTimeMillis();
				
				double rate = 0;
				
				if(end-start > 0)
					rate = (u / (end-start)) * 1000;
				
				System.out.println("Tested " + u +" of the " + combos + " cases at " + rate + " cases/sec");
				return key;
			} 
			
			int z = test.getIndex();
			
			if(z <= (n*n-1)-n) {
				z += n;	
			} else if(z > (n*n-1)-n && z < n*n -1) {
				z += 1;
			}
	
			/*if(Integer.parseInt(key.substring(z, z+1)) >= n-1) {
				z = n*n-1;
			}*/
			
			String a = "";
			for(int j = 0; j < n*n; j++) {
				if(j != z) {
					a += "0";
				} else {
					a += "1";
				}
			}
			int add = Integer.parseInt(a, n);
			l += add-1;
			
			key = Integer.toString(Integer.parseInt(key, n)+add, n);		
			
			while(key.length() < n*n) {
				key = "0" + key;
			}
			if(key.length() > n*n) {break;}
		}
		long end = System.currentTimeMillis();
		
		double rate = 0;
		
		if(end-start > 0) 
			rate = (u / (end-start)) * 1000;
		
		System.out.println("Tested " + u +" of the " + combos + " cases at " + rate + " cases/sec");
		
		return null;
	}
	
	private static int[][] insertKey(int[][] lock, String key, int n) {
		int i = 0;
		for(int x = 1; x <= n; x++) {
			for(int y = 1; y <= n; y++) {
				int a = Integer.parseInt(key.substring(i, i+1));
				lock[x][y] = a;
				i++;
			}
		}	
		
		return lock;
	}
	
	private static Test testKey(int[][] lock, int n) {
		for(int x = 1; x <= n; x++) {
			for(int y = 1; y <= n; y++) {
				int r = elementRemainder(lock, n, x, y);
				
				int index = (n * (x-1) + (y-1));
				
				if(r > 0) {
					return new Test(index, false);
				}
			}
		}
		return new Test(-1, true);
	}
			
	private static int elementRemainder(int[][] lock, int n, int x, int y) {
		int sum = lock[x  ][y  ] + 
				  lock[x+1][y  ] + 
				  lock[x-1][y  ] +
				  lock[x  ][y+1] +
				  lock[x  ][y-1];
		return sum%n;
	}
	
	static class Test {
		private int index;
		private boolean keyboolean;
		
		public int getIndex() {return index;}
		public boolean getKeyBoolean() {return keyboolean;}
		
		public Test(int index, boolean keyboolean) {
			this.index = index;
			this.keyboolean = keyboolean;
		}
	}
}
