package cha12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex06Throwstest {
public static void main(String[] args) {
		
		while (true) {
			User12 user = null;
			
		try {
			user = Service2.work(user);
		} 
		catch (Error1 e) {
				System.out.println("번호를 다시 선택해주세요.");	
		}
		catch (Nomoney1 e) {
				System.out.println(e.getMessage());
				System.out.println("금액을 다시 투입해주세요");
		}
		catch (ArrayIndexOutOfBoundsException e) { 
			System.out.print("없는 번호입니다.");
			
		}
		catch (InputMismatchException e) {
			System.out.print("오류가 발생했습니다. 문의를 부탁드립니다.");
		}		
		catch (Exception e) {
			System.out.print("시스템 장애");
			
		}	
			
			break;
		}	
	}
}

class User12{
	int money;
	int drink;
	
	int setDrink12(int drink) {
		return this.drink = drink;
	}
	int setMoney12(int money) {
		return this.money = money;
	}
}

class Service2{
	
	public static User12 work(User12 user)throws Error1,Nomoney1,ArrayIndexOutOfBoundsException,InputMismatchException,Exception     {
		/// 해당 메소드 내에서 발생하는 throws된 클래스의 이슈는 모두 메소드를 호출한 부분에서 처리하도록 하는건가
		user = new User12();
		
		Scanner s = new Scanner(System.in);
		System.out.println("음료를 선택해주세요.");
		System.out.println("1번: coke");
		System.out.println("2번: water");
		System.out.println("3번: coffee");
		user.setDrink12(s.nextInt()-1);
		System.out.println("금액을 투입해주세요.");
		user.setMoney12(s.nextInt());
		DrinkList2[] d = DrinkList2.values();
		d[user.drink].price = d[user.drink].setPrice(user.drink);
		
			if (user.drink > d.length) {		  
				throw new Error1 ("잘못된 번호입니다");
			}
			else System.out.print("");
			if (user.money < d[user.drink].price) {
				throw new Nomoney1("금액이 부족합니다");
			}
			else if (user.money > 10000) { 	
				throw new Nomoney1("너무 큰 금액입니다.");
		
			 
			}
			else System.out.println("음료를 드리겠습니다.");
		
		return user;	
	}
}

enum DrinkList2 {
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
class Error1 extends Exception{
	public Error1(String message) {
		super(message);
	}
}
class Nomoney1 extends Exception{
	public Nomoney1 (String message) {
		super(message);
	}

}
/*
문제 1.
자판기 프로그램을 throws 가 적용된 코드로 수정하세요.
*/