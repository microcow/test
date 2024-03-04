package ch7;
import java.util.Scanner;
public class Ex03Methodtest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean i = true;
		while (i) {
			System.out.print("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈" + "\n");
			int a = scanner.nextInt();
	
			if (a == 1) {
				calculator num1 = new calculator();
				num1.title = "덧셈을 선택하셨습니다.";
				System.out.print(num1.title + "\n");
				System.out.print("숫자를 입력하세요" + "\n");
				num1.number = scanner.nextInt();
				System.out.print("입력한 숫자에 더할 숫자를 입력하세요" + "\n");
				num1.number2 = scanner.nextInt();
				num1.Arrr();
				System.out.print("계속 하시겠습니까? 1.네 2.종료" + "\n");
				int q = scanner.nextInt();
					if (q == 2)
						i = false;
					else if (q == 1)
						continue;
			}
			else if (a == 2) {
				
					
				
		}
		
		
	}
}
}
class calculator{
	String title;
	int number;
	int number2;
	
	void Arrr() {
		System.out.printf("더한 값은 %d 입니다.%n", number+number2);
	}
	
}
/*
문제 1.
계산기 클래스를 만들고 더하기, 빼기, 곱하기, 나누기 메소드를 작성한 뒤 메소드를 이용하여 결과를 출력하세요.  
*/