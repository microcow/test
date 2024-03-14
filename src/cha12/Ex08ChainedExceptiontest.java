package cha12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex08ChainedExceptiontest {
public static void main(String[] args) {
		
		while (true) {
			User14 user = null;
			
		try {
			user = Service4.work(user);
		} 
		catch (Chained e) {
				System.out.println("문의 사항은 1234로 연락주세요.");	
				e.printStackTrace();	
		}	
			
			break;
		}	
	}
}

class User14{
	int money;
	int drink;
	
	int setDrink12(int drink) {
		return this.drink = drink;
	}
	int setMoney12(int money) {
		return this.money = money;
	}
}

class Service4{
	
	public static User14 work(User14 user)throws Chained     {
		/// 해당 메소드 내에서 발생하는 throws된 클래스의 이슈는 모두 메소드를 호출한 부분에서 처리하도록 하는건가
		user = new User14();
		try {
		Scanner s = new Scanner(System.in);
		System.out.println("음료를 선택해주세요.");
		System.out.println("1번: coke");
		System.out.println("2번: water");
		System.out.println("3번: coffee");
		user.setDrink12(s.nextInt()-1);
		System.out.println("금액을 투입해주세요.");
		user.setMoney12(s.nextInt());
		DrinkList4[] d = DrinkList4.values();
		d[user.drink].price = d[user.drink].setPrice(user.drink);
		
			if (user.drink > d.length) {		  
				throw new Error3 ("잘못된 번호");
			}
			else System.out.print("");
			if (user.money < d[user.drink].price) {
				throw new Nomoney3("금액이 부족");
			}
			else if (user.money > 10000) { 	
				throw new Nomoney3("너무 큰 금액"); 
			}
			else System.out.println("음료를 드리겠습니다.");
		}
		
		catch (Error3 e) {
			throw new Chained ("시스템 오류",e);
		}
		catch (Nomoney3 e) {
			throw new Chained ("시스템 오류",e);
		}
		catch (ArrayIndexOutOfBoundsException e) { 
			throw new Chained ("시스템 오류",e);
		}
		catch (InputMismatchException e) {
			throw new Chained ("시스템 오류",e);
		}		
		catch (Exception e) {
			throw new Chained ("시스템 오류",e);
		}	
		
		
		return user;	
	}
}

enum DrinkList4 {
	cock,
	water,
	coffee;
	public static int cord;
	public static int price;
	
	int setPrice (int para) {
		if (para == 0) {
			return 1000;
		}
		else if (para == 1) {
			return 2000;
		}
		else if (para ==2) {
			return 3000;
		}
		else return 0;
	}
	
}
class Error3 extends Exception{
	public Error3(String message) {
		super(message);
	}
}
class Nomoney3 extends Exception{
	public Nomoney3 (String message) {
		super(message);
	}
}
class Chained extends Exception{
	public Chained (String message, Exception e) {
		super (message, e);
	}
}

/*
문제 1.
자판기 프로그램에 연결 예외를 적용해 주세요.
*/