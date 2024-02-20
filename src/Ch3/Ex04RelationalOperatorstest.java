package Ch3;

public class Ex04RelationalOperatorstest {
	public static void main(String[] args) {
		int tv = 300, money = 1000;
		
		System.out.printf("현재 잔액으로 tv 1대를 구매할 수 있는가? (%B)%n", tv <= money);
		System.out.printf("현재 잔액으로 tv 2대를 구매할 수 있는가? (%B)%n", 2*tv <= money);
		System.out.printf("현재 잔액으로 tv 3대를 구매할 수 있는가? (%B)%n", 3*tv <= money);
		System.out.printf("현재 잔액으로 tv 4대를 구매할 수 있는가? (%B)%n", 4*tv <= money);
	}

}
/*
문제 1.
TV의 금액은 300원입니다.
잔액이 1000원일 때 TV의 구매 가능 여부를 조건식을 이용하여 출력하세요. 
*/