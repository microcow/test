package Ch3;

public class Ex02UnaryOperatortest {
	public static void main(String[] arg) {
		int q = 735;
		int w = 525;
		System.out.printf("a * b = %d%n", w*q);
		int sum = w*q;
		System.out.printf("a * b = %d%n", sum);
		
		int a = 30;
		System.out.printf("a = %d%n", a);
		a = -a;
		System.out.printf("a = %d%n", a);
		a = -a;
		System.out.printf("a = %d%n", a);
	}
}
/*
문제 1.
735 + 525 를 두 개의 변수에 저장 후 연산하여 출력하세요.

문제 2.
int a = 30;
변수 a의 값을 음수로 출력하세요. 
*/