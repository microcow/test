package ch6;
import java.util.Scanner;
public class memo3 {
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		boolean i = true;
		int a=500, b=300, c=200, d=1300;
		int code = 0;
		
		while (i) {
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
				else if (d < a && d >= b && d >= c) {
					System.out.printf(" 잔액이 부족합니다. 음료를 재선택해주세요%n 1번 콜라 2번 사이다 3 번 환타");
					code = scann.nextInt();
					
					if (code == 2) {
						if (d >= b) {
							d = d-b;
						System.out.printf("사이다를 선택하셨습니다. 현재 잔액은%d 입니다.%n", d);
						if (d < c)
							i = !i; // i = !i;같은거 쓰지 말고 걍 break; 쓰자
						}
					}
					else if (code == 3) {
						if (d >= c) {
							d = d-c;
						System.out.printf("환타를 선택하셨습니다. 현재 잔액은%d 입니다.%n", d);						
						if (d < c)
						i = !i;
						}
					}
					else {System.out.printf("잔액이 부족합니다.");
					i = !i; // 해당 코드가 없으면 정상동작함 왜??
					} 		// 왜냐하면 i = !i;를 else에 {}로 묶지 않아서, else가 아니라 계속 실행되었던것
							// 그러니 i는 false에서 true로 바뀐것 !i = 참거짓 값 반대로 변경
					
					
					
				}
				
				
				else {
					System.out.printf("잔액이 부족합니다.");
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
					System.out.printf("콜라를 선택하셨습니다. 현재 잔액은%d 입니다.%n", d);
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
//굿 ㅠㅠㅠㅠㅠ 내가 해냈다고
}
