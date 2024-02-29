package ch6;
import java.util.Scanner;
public class Ex09DoWhile {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// do while 문 : do문을 반복해라 while문의 조건까지
		char ch = ' ';//char 값의 작은 따옴표(' ')안에 빈 값을 저장하려면 공백이 있어야한다.
		do { // do 문은 조건과 관계없이 무조건 한번은 실행하여야 할때 사용한다.
			System.out.println("문자를 입력해 주세요: ");
			String str = scanner.nextLine(); // nextint는 숫자(int)만 입력가능한 반면, nextLine은 숫자와 문자 모두 입력 가능하지만 문자열(char)타입으로 반환한다
			ch = str.charAt(0);
			// str.charAt(0) = 문자열의 첫번째 문자만 char타입으로 변환해서 가져온다
			// 1이라면 두번째 3이라면 세번째
			if (ch >= '0' && ch <= '9') 
				System.out.println("숫자입니다.");
			else if (ch >= 'A' && ch <= 'Z')
				System.out.println("알파뱃 대문자입니다.");
			else if (ch >= 'a' && ch <= 'z')
				System.out.println("알파뱃 소문자입니다.");
		} while (ch != 'q');
		// while문은 조건이 참일 경우 do 문을 반복한다
		// 위에는 ch가 q가 아닐 경우 참이다 (ch는 q가 아니다 → 참)
		// 즉, q와 동일하지 않는다면, 다시 do 문으로 돌아간다
		// while 문이 거짓일 경우 do while 문을 빠져나온다
		// do 문을 사용하려면 while문이 반드시 do문 다음에 사용되어야 한다.
		
		
		System.out.println("프로그램이 종료되었습니다.");
		// while문의 조건에 적합하여 while문의 코드가 실행된다는 것은 do 문 블록의 코드가 이미 한 번 실행되었고,
		// 조건이 더 이상 충족되지 않기 때문에 더 이상 do 문을 반복하지 않음
				
			
	}
}
