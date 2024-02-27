package ch7;
import java.util.Arrays;
import java.util.Scanner;
public class Ex04Methodtest {
	public static void main(String[] args) {
		Booktest[] book = new Booktest[10];
		Scanner scanner = new Scanner(System.in);
		boolean a = true;
		int w = 0;
		while (a) {
		
			System.out.printf("책 가격을 설정하세요%n");
			int Q = scanner.nextInt();
			if (Q >= 10000 && Q < 80000 && w < book.length) {
				book[w] = new Booktest(); // 메모리 주소 생성 잊지말기
				book[w].bookprice(Q);
				
				w++;
				// 반복문 내 선언된 변수는 반복문 종료 시 사라지며, 새로 반복문이 시작될 때 새로 선언되지만
				// 반복문 전에 선언된 변수는 반복문 내에서 변경해도 반복문 종료 후에도 변경된 값을 유지한다.
				System.out.println(Arrays.toString(book)); // 배열 내 제대로 저장되고 있는지 확인하기 위한 코드
				
				continue;
			}
			else if (Q < 10000 || Q >= 80000) {
				System.out.printf("설정 가능하지 않은 가격입니다. 다시 시도해주세요.%n");
				continue;
			}
			else if (w >= book.length) 
				a = false;
			
		}
		System.out.printf("종료");
		System.out.println(w); 
		
				
	}
}
class Booktest {
	int price;
	
	void bookprice (int price) {
		this.price = price;
		System.out.printf("책 가격이 %d로 설정되었습니다.%n", this.price);
		
		
	}
}
	
/*
문제 1.
BookTest 클래스를 작성하세요.
가격을 저장하는 인스턴스 변수를 선언하세요.
책의 가격을 설정하는 메소드를 작성하세요.
책의 가격은 10000원 이상 80000원 미만으로만 설정가능해야 하며 그 외의 금액은 "설정 가능하지 않은 가격입니다." 를 출력하세요.*/