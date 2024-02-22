package ch5;

public class memo {
	public static void main(String[] args) {
		for (int i=2; i<=9; i++) {
			for (int j=1; j<=9; j++) {
				System.out.printf("%dx%d=%-5d", i, j, i*j);
			}
			System.out.println();
		}
	}
}
