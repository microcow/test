package ch6;
import java.util.Scanner;
public class Ex08Branching {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int balance = 1000; 
		while (true) {
			System.out.println("출금할 금액을 입력하세요:");
			int money = scanner.nextInt();
			if (balance - money < 0) {
				System.out.println("잔액을 초과합니다.");
				continue;
				//반복문에서 (for,while문)에서 continue 문을 만나면 반복문의 첫번째로 이동하게된다. (출금할 금액을 ~~)
			} else if (balance - money == 0) {
				System.out.println("더이상 출금할 수 있는 잔액이 없습니다.");
				break;
				// break 문은 가장 가까운 반복문(while)을 즉시 빠져나오게된다.
				// break 문으로 빠져나오게되면, 아래 9줄의 코드도 실행지 않고 while문 바깥의 코드로 이동한다.
			}				
			balance -= money;
			System.out.println(money + "원을 출금하였습니다.");
			System.out.println(balance + "원이 남았습니다.\n1번: 계속 출금 2번:종료");
			int arr = scanner.nextInt();
				if (arr == 1) continue;
				else if (arr == 2) break;
				else if (arr <1 || arr>2);{
					System.out.println("잘못 입력하였습니다.");
					continue;
					
				}
			
		}

		System.out.println("----------");
		System.out.println("잔액은 " + balance + "원입니다.");

	}


}
