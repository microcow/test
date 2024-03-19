package ch6;
//for문 (반복문)
public class Ex01For {
	public static void main(String[] args) { 
		for (int i=1; i<=3; i++) {
			int a=0;
			System.out.println("i는 " + i + "입니다.");
		}
		// i가 1이고(선언), 3보다 작거나 같을때(조건 (참,거짓)), i++로 반복실행한다(증가) (i는 1에서 3까지 1씩 증가시키며 반복한다)
		// for문이 한 줄일 경우엔 {}로 감싸주지 않아도 괜찮다
		// int로 선언된 변수 i는 for문이 종료되면 다른 코드에서 변수로 사용할 수 없음(for문 안에서만 사용 가능함)
		// 선언(int)는 최초 한번만 하고 조건이 참일 경우에 증가만 반복 수행 (단, 증가(i++)는 없어도 됨)	
		// for문의 조건(i<=3;)이 참일 경우에 반복 (즉, 조건이 거짓이 될 때 까지 반복)
		// for문(반복문) 내에서 새로운 변수를 생성할 경우(int a=0;), for문이 반복될 때마다 그 변수가 생성되지만 for문의()내에 생성된 변수(int i=1)는 최초 1회만 생성(선언)된다 
		
		
		System.out.println();
		
		for (int i=1; i<=3; i++)
			System.out.println("i는 " + i + "입니다.");
		System.out.println("반복문 또는 loop문이라고 합니다.");
		System.out.println();
		// {}로 감싸주지 않았기에, 첫번째 줄만 반복된다
		
		
		int sum = 0;
		System.out.printf("%d%n",sum);
		for (int i=1; i<=10; i++) {
			sum += i;
			System.out.printf("i가 %d일 때 sum은 %d입니다.%n", i, sum);
		}
		//i가 1에서 10까지 1씩 증가되며, sum에 더해진다.		
		
		System.out.println();
		
		
		int evenSum = 0;
		int oddSum = 0;
		for (int i=1; i<=10; i++) {
			if (i%2 == 0) //%는 나눈 나머지
				evenSum += i;
			else
				oddSum += i;
		}
		System.out.println("1에서 10 중 짝수의 합은 = " + evenSum);
		System.out.println("1에서 10 중 홀수의 합은 = " + oddSum);
	}
}
