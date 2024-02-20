package Ch3;

public class Ex04RelationalOperators {
	public static void main(String[] args) {
		
		int a = 3, b = 7; //1번의 선언으로 두 개의 변수 지정 가능
		
		boolean result = a == 7; 
		System.out.printf("%d == %d (%b)%n", a, b, result); // ==은 같다는 뜻
		System.out.printf("%d != %d (%b)%n", a, b, a != b); // !=은 같지 않다는 뜻
		System.out.printf("%d > %d (%b)%n", a, b, a > b);
		System.out.printf("%d < %d (%b)%n%n", a, b, a < b);
		
		int c = 7;
		System.out.printf("%d >= %d (%b)%n%n", b, c, b >= c);
		System.out.printf("%d <= %d (%b)%n%n", a, c, a <= c);
		System.out.printf("%d != %d (%b)%n%n", b, c, b != c);
		System.out.printf("%d != %d (%b)%n%n", a, c, a != c);
		// %b를 통해 boolean타입 참거짓 사용 
	}

}
