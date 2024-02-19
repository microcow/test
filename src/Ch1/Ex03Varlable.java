package Ch1;

public class Ex03Varlable {
	
	public static void main(String[] args) {
		int a = 2000;
		System.out.println("현재 잔액은" + a + "원 입니다.");
		int b = 300;
		System.out.println("TV는" + b + "원 입니다.");
		System.out.println("TV를 2대 구매하였습니다");
		
		a = a - b;
		System.out.println("현재 잔액은" + a + "원 입니다");
		
		int c = 300;
		System.out.println("월급" + c + "원이 입금되었습니다.");
		
		a = a + c;
		System.out.println("현재 잔액은" + a + "원 입니다.");
	}
}
/* 

문제 1. 2000원의 잔액에서 300원 짜리 TV 2대를 구매하고 300원의 월급이 입금되는 코드를 작성하세요.
 
*/ 