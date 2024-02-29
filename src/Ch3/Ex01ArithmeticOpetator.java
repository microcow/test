package Ch3;

public class Ex01ArithmeticOpetator {
	public static void main(String[] args) { 
		System.out.printf("3 + 7 = %d%n", 3+7);
		System.out.printf("7 - 5 = %d%n", 7-5);
		System.out.printf("7 * 5 = %d%n", 7*5);
		System.out.printf("5 / 2 = %d%n", 5/2);
		//정수 리터럴끼리 곱해서 결과값이 정수
		System.out.printf("5 %% 2 = %d%n%n", 5%2);
		//%는 5를 2로 나눈 나머지를 구할 때 사용 (5/2와 다름)
		//printf에 %문자를 출력하려면 %%라고 입력
		
		int a = 5;
		int b = 7;
		int sum = a*b;
		System.out.printf("%d * %d = %d%n", a, b, a*b);
		System.out.printf("%d * %d = %d", a, b, sum);
	}
}
