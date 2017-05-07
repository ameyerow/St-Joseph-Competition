package problem_set_2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Question5 {
	private static final File FILE = new File("MathSyntaxIn.txt");
	private static ArrayList<String> operators;
	private static ArrayList<String> numbers;
	
	private enum Type {
		number, operator, space
	}
	
	public static void main(String[] args) throws FileNotFoundException {	
		operators = new ArrayList<String>();
		numbers = new ArrayList<String>();
		
		operators.add(" / ");	operators.add("/");
		operators.add(" * ");	operators.add("*");
		operators.add(" - ");	operators.add("-");
		operators.add(" + ");	operators.add("+");
		
		
		numbers.add("0");		numbers.add("1");
		numbers.add("2");		numbers.add("3");
		numbers.add("4");		numbers.add("5");
		numbers.add("6");		numbers.add("7");
		numbers.add("8");		numbers.add("9");
		numbers.add(".");		numbers.add("-.");
		
		for(int i = 0; i < 10; i++) {
			numbers.add("-" + i);
		}
		
		Scanner scanner = new Scanner(FILE);
		
		int expressions = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < expressions; i++) {
			String expression = scanner.nextLine();
			
			int earliest_error = Integer.MAX_VALUE;
			
			for(int j = 1; j < expression.length(); j++) {
				String prev = expression.substring(j-1, j  );
				String curr = expression.substring(j  , j+1);
				
				if(prev.equals("-"))
					prev += expression.substring(j  , j+1);
				
				Type curr_type = checkType(curr);
				Type prev_type = checkType(prev);
				
				// If the first character is not a number, it is the character that
				// contains the error.
				if(j == 1 && prev_type != Type.number)
					earliest_error = 1;
				
				// Given the current character's equivalence to " " and the previous
				// character being a number, the current character and the next two 
				// characters must be contained in operators when combined.
				if(curr_type == Type.space && prev_type == Type.number) {
					
					// In the case that the last character in the expression is an operator properly spaced
					// from its previous number, the sequence would not contain 3 more characters and throw
					// and error in the line expression.substring(j, j+3). The error would be the operator.
					if(j+3 > expression.length()) {
						earliest_error = (j+1) + 1 + 1 < earliest_error ? (j+1) + 1 + 1 : earliest_error;
					} else {	
						String sub = expression.substring(j, j+3);	
						
						// If sub isn't contained in operator then an error must exist between
						// characters j and j+3.
						if(checkType(sub) != Type.operator) {
							String a = expression.substring(j+1, j+2);
							String b = expression.substring(j+2, j+3);
							
							if(!operators.contains(a)) 
								earliest_error = (j+1) + 1 < earliest_error ? (j+1) + 1 : earliest_error;
							if(checkType(b) != Type.space) 
								earliest_error = (j+2) + 1 < earliest_error ? (j+2) + 1 : earliest_error;
							
						// In the case the sub is contained in operator than an error will exist if
						// the character immediately following the operator is not contained in 
						// numbers.
						} else {
							String c = expression.substring(j+3, j+4);
							if(c.equals("-")) 
								c += expression.substring(j+4, j+5);
							
							if(!numbers.contains(c)) 
								earliest_error = (j+3) + 1 < earliest_error ? (j+3) +1 : earliest_error;	
						}
					}
				}
				
				// In the case that an operator is not properly spaced from a number the error
				// will be attributed to the operator.
				if(prev_type != Type.space && curr_type == Type.operator) {
					if(j+1 != expression.length()) {
						earliest_error = j + 1 < earliest_error ? j + 1 : earliest_error;
					} else {
						earliest_error = j + 2 < earliest_error ? j + 2 : earliest_error;
					}
				}
			}
			
			if(earliest_error < Integer.MAX_VALUE) {
				System.out.println(earliest_error);
			} else {
				System.out.println("correct");
			}
		}
		
		scanner.close();
	}
	
	private static Type checkType(String str) {
		if(numbers.contains(str)) 
			return Type.number;
		
		if(operators.contains(str))
			return Type.operator;
		
		if(str.equals(" "))
			return Type.space;
		
		return null;
	}
}
