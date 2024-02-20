package Ch3;

public class Ex05RelationalOperators {
	public static void main(String[] args) {
		int a = 3;
		int b = 7;
		int c = 3;
		int d = 8;
		
		System.out.printf("%d != %d && %d == %d, (%b)%n", a, b, a, c, a != b && a == c);
		// &&(논리연산)는 and연산자. 사용하면 두개의 연산을 묶을 수 있다. 즉, 두연산 모두 참이므로 하나로 묶어 참 출력
		// 둘 중 하나라도 거짓이 있다면, 하나로 묶어 거짓 출력
		
		System.out.printf("%d >= %d && %d == %d, (%b)%n", a, b, a, c, a >= b && a == c);
		
		System.out.printf("%d >= %d || %d == %d, (%b)%n", a, b, a, c, a >= b || a == c);
		//||(버티컬 바)는 or 연산자. 사용하면 두개의 연산을 묶을 수 있다. 즉, 두연산 중 하나가 참이므로 하나로 묶어 참 출력
		// 둘 중 하나라도 참이 있다면, 하나로 묶어 참 출력
		
		
		System.out.printf("%d == %d || %d < %d && %d == %d, (%b)%n", a, c, c, d, a, b, a == c || c < d && a == b);
		// or연산자와 and 연산자가 같이 사용될 경우, and 연산자의 우선순위가 높음
		// 즉, c < d && a == b가 우선 연산된 후(false) a == c || c < d가 연산됨(true)
		
		System.out.printf("(%d == %d || %d < %d) && %d == %d, (%b)%n", a, c, c, d, a, b, (a == c || c < d) && a == b);
		// ()를 사용하면, 우선연산자를 설정할 수 있음
	}
}
