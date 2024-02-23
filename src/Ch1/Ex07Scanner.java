package Ch1;

import java.util.Scanner;
// 빠트리면 안되는 입력문
public class Ex07Scanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int balance;
		int tvPrice;
		int salary;
		
		System.out.printf("잔액을 입력하세요.%n");
		balance = scan.nextInt();
		System.out.printf("티비의 금액을 입력하세요.%n");
		tvPrice = scan.nextInt();
		System.out.printf("월급을 입력하세요.%n");
		salary = scan.nextInt();
		
		System.out.printf("현재 잔액은 %d원 입니다.%n%n", balance);
		
		System.out.printf("TV는 %d원 입니다.%n", tvPrice);
		System.out.printf("TV를 구매하였습니다.%n");
		
		balance = balance - tvPrice;
		System.out.printf("현재 잔액은 %d원입니다.%n", balance);
		
		System.out.printf("%n월급 %d원이 입금되었습니다.", salary);
		
		balance = balance + salary;
		System.out.printf("%n현재 잔액은 %d원입니다.", balance);
	}
}
