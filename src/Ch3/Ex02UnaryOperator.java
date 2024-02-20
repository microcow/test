package Ch3;

public class Ex02UnaryOperator {
	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		System.out.printf("%d + %d = %d%n", a, b, a+b);
		
		b = -b;
		System.out.printf("%d + %d = %d%n", a, b, a+b);
		// b는 -3
		
		b = -b;
		System.out.printf("%d + %d = %d%n", a, b, a+b);
		// -3인 b에 -값을 다시 곱해 +3
	}
}
