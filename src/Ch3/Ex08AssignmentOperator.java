package Ch3;
//할당 연산자
public class Ex08AssignmentOperator {
	public static void main(String[] args) {
		int sum = 20;
		System.out.println("sum = " + sum);
		
		sum += 500;
		// sum = sum + 500과 동일한 코드
		System.out.printf("sum += 500 (%d)%n", sum);
		
		sum -= 220;
		System.out.printf("sum -= 220 (%d)%n", sum);
		
		sum *= 2;
		System.out.printf("sum *= 2 (%d)%n", sum);

		sum /= 2;
		System.out.printf("sum /= 2 (%d)%n", sum);
		
		sum %= 290;
		System.out.printf("sum %%= 290 (%d)%n", sum);
	}
}
