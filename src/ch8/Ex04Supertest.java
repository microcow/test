package ch8;

public class Ex04Supertest {
	public static void main(String[] args) {
		SonClass son = new SonClass();
		
		son.name = "부모 클래스의 name";
		System.out.println(son.setname());
		
		System.out.println(son.setname2());
		
		
		System.out.println(son.setprice());
		
		son.price = 12345;
		System.out.println(son.setprice2());
		
	}

	
}

class MomClass {
	String title;
	String name;
	int price;
}

class SonClass extends MomClass{
	String title;
	int price;
	
	String setname() {
		return name;
			
	}
	
	String setname2() {
		return this.name;
	}
	
	int setprice() {
		super.price = 10000;
		this.price = 20000;
		return price;	
		// 부모클래스와 자식클래스 모두 price라는 인스턴스 변수가 존재할 경우, 호출한 인스턴스와 동일한 클래스의 price 변수 값을 return한다.
	}
	
	
	int setprice2() {
		super.price = 50000;
		return price;	
		// 마찬가지로, 자식클래스의 값이 위에서 12345로 저장되었기 때문에, price를 return 하더라도 50000이 아닌 12345가 출력된다.
	}
		
}

/*
문제 1.
this와 super에 대해 설명할 수 있는 코드를 작성하세요.
*/