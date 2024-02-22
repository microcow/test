package ch6;

public class memo {
	public static void main(String[] args) {
		int[][] arg = {
				{10, 40, 90},
				{30, 50, 70},
				{13, 47, 25}
			};
			for (int j=0; j < arg.length; j++) {
				System.out.printf("%d반%n", arg[1][0]);	
			}
	}
}
