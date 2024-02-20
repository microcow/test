package Ch3;

public class Ex03UnaryOperator {
	public static void main(String[] args) {
		int a = 3;
		System.out.printf("a = %d%n", a++);
		// ++ 1을 증가시킨다는 뜻 == (a = a+1;)
		// ++이 a 뒤에 있으므로 다음줄부터 증가됨(후행 연산)
		System.out.printf("a = %d%n", a);
		System.out.printf("a = %d%n%n", ++a);
		// ++이 a 앞에 있으므로 이번줄부터 증가됨(전행 연산)
		
		a = 3;
		int b = a++;
		// ++이 a 뒤에 있으므로 b는 3이 저장됨
		System.out.printf("b = %d, a = %d%n%n", b, a);
		
		a = 3;
		b = ++a;
		// ++이 a 앞에 있으므로 b는 4가 저장됨
		System.out.printf("b = %d, a = %d%n%n", b, a);
		
		a = 3;
		System.out.printf("a = %d%n%n", --a);
		// 마찬가지로 --는 1을 감소시킨다는 뜻

	}
}
