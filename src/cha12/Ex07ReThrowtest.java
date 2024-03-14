package cha12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex07ReThrowtest {
public static void main(String[] args) {
		
		while (true) {
			User13 user = null;
			
		try {
			user = Service3.work(user);
		} 
		catch (Error2 e) {
				System.out.println("번호를 다시 선택해주세요.");	
				
		}
		catch (Nomoney2 e) {
				System.out.println(e.getMessage());
				System.out.println("금액을 다시 투입해주세요");
				e.printStackTrace();
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

class User13{
	int money;
	int drink;
	
	int setDrink12(int drink) {
		return this.drink = drink;
	}
	int setMoney12(int money) {
		return this.money = money;
	}
}

class Service3{
	
	public static User13 work(User13 user)throws Error2,Nomoney2,ArrayIndexOutOfBoundsException,InputMismatchException,Exception     {
		/// 해당 메소드 내에서 발생하는 throws된 클래스의 이슈는 모두 메소드를 호출한 부분에서 처리하도록 하는건가
		user = new User13();
		try {
		Scanner s = new Scanner(System.in);
		System.out.println("음료를 선택해주세요.");
		System.out.println("1번: coke");
		System.out.println("2번: water");
		System.out.println("3번: coffee");
		user.setDrink12(s.nextInt()-1);
		System.out.println("금액을 투입해주세요.");
		user.setMoney12(s.nextInt());
		DrinkList3[] d = DrinkList3.values();
		d[user.drink].price = d[user.drink].setPrice(user.drink);
		
			if (user.drink > d.length) {		  
				throw new Error2 ("잘못된 번호입니다");
			}
			else System.out.print("");
			if (user.money < d[user.drink].price) {
				throw new Nomoney2("금액이 부족합니다");
			}
			else if (user.money > 10000) { 	
				throw new Nomoney2("너무 큰 금액입니다."); 
			}
			else System.out.println("음료를 드리겠습니다.");
		}
		
		catch (Error2 e) {
			System.out.println("번호오류");
			throw e;
		}
		catch (Nomoney2 e) {
			System.out.println("금액 비정상");
			throw e;
		}
		catch (ArrayIndexOutOfBoundsException e) { 
			System.out.print("없는 번호");
			throw e;
		
		}
		catch (InputMismatchException e) {
			System.out.print("오류가 발생");
			throw e;
		}		
		catch (Exception e) {
			System.out.print("error");
			throw e;
		}	
		
		
		return user;	
	}
}

enum DrinkList3 {
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
class Error2 extends Exception{
	public Error2(String message) {
		super(message);
	}
}
class Nomoney2 extends Exception{
	public Nomoney2 (String message) {
		super(message);
	}

}
/*
문제 1.
자판기 프로그램에 re throw를 적용해 주세요.
*/