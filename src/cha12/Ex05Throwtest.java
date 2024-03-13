package cha12;
import java.util.Scanner;
import java.util.InputMismatchException; ///해당 Exception은 lang 소속이 아닌가

public class Ex05Throwtest {
	public static void main(String[] args) {
		
		while (true) {
			//User1 user = new User1(); // new User(); 혹은 null입력하지 않으면 메모리에 정보가 없어서 인스턴스 사용 불가(The local variable user may not have been initialized)
			User1 user = null; /// new User1();가 아닌 null;입력 후 실행 시 시스템 장애만 출력
			// User1 user = new User1(); : User1 클래스의 객체(인스턴스 변수)를 참조하고 있음을 나타냄
			// User1 user = null; : 인스턴스는 생성되었으나 어떠한 클래스의 객체(인스턴스 변수)도 참조하지 않고 있음을 나타냄 (즉, user = new User1(); 혹은 업캐스팅 등으로 객체를 참조해주어야 사용가능 (*cha10 Ex01))
			
			user = Service.work(user);
			break;
		}
		
		
	}
}
class User1{
	int money;
	int drink;
	
	int setDrink(int drink) {
		return this.drink = drink;
	}
	int setMoney(int money) {
		return this.money = money;
	}
}
class Service{
	
	public static User1 work(User1 user) {
		user = new User1();
		try {
		Scanner s = new Scanner(System.in);
		System.out.println("음료를 선택해주세요.");
		System.out.println("1번: coke");
		System.out.println("2번: water");
		System.out.println("3번: coffee");
		user.setDrink(s.nextInt()-1);
		System.out.println("금액을 투입해주세요.");
		user.setMoney(s.nextInt());
		DrinkList[] d = DrinkList.values();
		d[user.drink].price = d[user.drink].setPrice(user.drink);
		
		// try { → try가 해당 부분에 있을 때 위에서 잘못된 값을 입력 받을시 문제발생. (아래 ///부분 참고)
		
			if (user.drink > d.length) { /* → d.length보다 큰 값을 입력받게 되면, 입력받는 순간인 코드 user.setDrink(s.nextInt()-1);부분에서 먼저 에러가 발생하기에
			 해당 이슈를 throw하기 이전에 ArrayIndexOutOfBoundsException(배열 인덱스 범위 초과)이슈가 먼저 발생하게 되므로 해당 throw 문은 실행될 가능성이 없음 */
				throw new Error ("잘못된 번호입니다");
			}
			else System.out.print("");
			if (user.money < d[user.drink].price) {
				throw new Nomoney("금액이 부족합니다");
			}
			else if (user.money > 10000) { /* → 2147483647보다 큰 값을 입력받게 되면, 입력받는 순간인 코드 user.setMoney(s.nextInt());부분에서 먼저 에러가 발생하기에
				 해당 이슈를 throw하기 이전에 InputMismatchException이슈가 먼저 발생하게 되므로 해당 throw문이 실행되지 않음. 단, 입력받는 값이 10000<2147483647 일 경우엔 해당 throw문이 실행됨*/	
				throw new Nomoney("너무 큰 금액입니다.");
			//int는 2147483647까지 저장 가능하기에 그 이상 값 입력 시 오류
			 
			}
			else System.out.println("음료를 드리겠습니다.");
		} 
			
		catch (Error e) {
				System.out.println("번호를 다시 선택해주세요.");	
		}
		catch (Nomoney e) {
				System.out.println(e.getMessage());
				System.out.println("금액을 다시 투입해주세요");
		}
		catch (ArrayIndexOutOfBoundsException e) { // → 입력받은 숫자가 배열의 인덱스 값이 될 때, 해당 인덱스 값보다 입력받은 숫자가 클 경우 오류 발생
			System.out.print("없는 번호입니다.");
			/// d.length보다 큰 수 입력 시 해당 catch가 받지 못하는 이유? :
				// → try 문의 시작 지점이 d[user.drink].price = d[user.drink].setPrice(user.drink);을 감싸고 있지 않았기에 d.length는 3이기에, 보다 큰 수 입력 시 try catch문에서 잡아내지 못했었음
				// → 즉, 오류가 발생한 부분이 try catch문 안에 있지 않았음
		}
		catch (InputMismatchException e) {
			System.out.print("오류가 발생했습니다. 문의를 부탁드립니다.");
			/// 2147483647보다 큰 수 입력 시 해당 catch가 받지 못하는 이유?
				// → 마찬가지로 try 문의 시작 지점이 user.setMoney(s.nextInt());을 감싸고 있지 않았기에 int의 최대값 보다 큰 수 입력 시 try catch문에서 잡아내지 못했었음
		}		// → 즉, 오류가 발생한 부분이 try catch문 안에 있지 않았음
		catch (Exception e) {
			System.out.print("시스템 장애");
			/// 위에서 발생하는 오류를 Exception에서 catch하지 못하는 이유?
				// → 마찬가지로 try 문의 시작 지점이 위에서 발생하는 오류를 감싸고 있지 않았기에 try catch문에서 잡아내지 못했었음
		}		// → 즉, 오류가 발생한 부분이 try catch문 안에 있지 않았음
		return user;
		
	}
}

enum DrinkList {
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
class Error extends Exception{
	public Error(String message) {
		super(message);
	}
}
class Nomoney extends Exception{
	public Nomoney (String message) {
		super(message);
	}
}
/*
문제 1.
음료를 뽑을 수 있는 자판기 프로그램을 만들어 주세요.
제공되는 음료 외의 번호 입력 시 발생되는 사용자 정의 예외 클래스를 작성해 주세요.
잔액이 부족할 경우 발생되는 사용자 정의 예외 클래스를 작성해 주세요.
각각의 예외 발생에 대해 예외처리하는 코드를 작성해 주세요.
*/