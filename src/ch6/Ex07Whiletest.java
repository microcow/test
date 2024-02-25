package ch6;
import java.util.Scanner;
public class Ex07Whiletest {
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		boolean i = true;
		int a=500, b=300, c=200, d=1000;
		int code = 0;
		
		while (i) { //참 거짓을 사용한다면, 종료를 원하는 시점에 참거짓을 바꿔주도록 하자 예) i = !i; 
			System.out.printf("1번 콜라, 2번 사이다, 3번 환타%n음료 번호를 선택하세요 :");
			code = scann.nextInt();
			if (code == 1) {
				if (d >= a) {
					d = d - a;
					System.out.printf("콜라를 선택하셨습니다. 현재 잔액은%d 입니다.%n", d);
					if (d < c) {
						System.out.printf(" 추가 구매 가능한 음료가 없습니다. 잔액을 돌려드리겠습니다.");
						i = !i;
					}	
				}			
				else if (d < a) {
					System.out.printf(" 잔액이 부족합니다.현재 잔액은%d 입니다.%n", d);
					i = !i;
				}
			} else if (code == 2) {
				if (d >= b) {
					d = d - b;
					System.out.printf("사이다를 선택하셨습니다. 현재 잔액은%d 입니다.%n", d);
					if (d < c) {
						System.out.printf(" 추가 구매 가능한 음료가 없습니다. 잔액을 돌려드리겠습니다.");
						i = !i;
					}	
				}			
				else if (d < b) {
					System.out.printf(" 잔액이 부족합니다.");
					i = !i;
				}
			} else if (code == 3) {
				if (d >= c) {
					d = d - c;
					System.out.printf("환타를 선택하셨습니다. 현재 잔액은%d 입니다.%n", d);
					if (d < c) {
						System.out.printf(" 추가 구매 가능한 음료가 없습니다. 잔액을 돌려드리겠습니다.");
						i = !i;
					}	
				}			
				else if (d < c) {
					System.out.printf(" 잔액이 부족합니다.");
					
					i = !i;
				}
			} else if (code > 3 || code < 1) {
				System.out.printf("잘못된 번호입니다.");
				i = !i;
			}
		}
	}
}
