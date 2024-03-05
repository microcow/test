package ch7;

public class Ex05ClassVariable {
	public static void main(String[] args) {
		Book4.tax = 1.2f;
		// 클래스 변수는 인스턴스 생성 전 선언 가능하며, 동일 클래스 내에 모든 인스턴스가 공통으로 가지는 값이다
		// 클래스명 + 스태틱 변수명으로 호출 가능
		
		
		Book4 b1 = new Book4(); // 클래스 변수 이후 인스턴스 선언
		b1.title = "자바문법";
		b1.price = 50000; // b1의 price 기본값이 30000이지만 50000으로 변경됨 (30000인 이유는 아래 참고)
		
		Book4 b2 = new Book4();
		b2.title = "C문법";
		b2.price = 40000; // b2의 price 기본값이 30000이지만 50000으로 변경 (30000인 이유는 아래 참고)
		
		b1.printInfo();
		b2.printInfo();
		System.out.println();
		
		Book4.tax = 1.4f;
		b1.printInfo();
		b2.printInfo();
		System.out.println();
		
		b1.tax = 1.5f;
		//클래스 변수를 특정 인스턴스만 변경하려고 한다면 경고표시가 노출되며, java에서 수정해서 실행함
		b1.printInfo();
		b2.printInfo();
	}

}

class Book4 {
	String title;
	int price=30000;
	// price와 같이 클래스 선언과 동시에 인스턴스 변수 값을 설정할 수 있으며, 이는 모든 클래스 내 생성되는 인스턴스들의 기본 값이 된다.
	// 다만, 기본값일 뿐 각각의 인스턴스에서 값 변경이 가능하다.
	// 위 두 변수는 클래스 변수(스태틱 변수)가 아니기에 인스턴스 생성 후 각각의 인스턴스에서 접근 가능하다 예)b1.title = "자바";
	static float tax;
	// 변수 타입 앞에 static이 붙으면 classvariable(스태틱 변수 혹은 클래스 변수)이라고 한다
	// 클래스 변수(스태틱 변수)는 인스턴스 생성과 연관 없이 class 이름으로 접근 가능하다(스태틱 변수는 data메모리 영역에 저장되기 때문에 가능함)
	// 클래스 변수(스태틱 변수)는 동일 클래스 내에 모든 인스턴스가 공통으로 가지는 값이다
	// 클래스 변수(스태틱 변수)또한 일반 인스턴스 변수들과 동일하게 클래스 생성 시 값을 설정해도 된다. 예) static float tax = 1.2f;
	// 클래스 변수(스태틱 변수)는 코드 실행과 동시에 가장 먼저 선언(생성)된다. (변수,메서드 등 모든 static 동일)(저장 공간이 다르기 때문)
	
	
	void printInfo() {
		String message = "책이름: " + title + ", 책가격: " + ((int)(price*tax)) + ", 세율: " + tax;
		System.out.println(message);
		// 클래스 변수(스태틱 변수)는 메소드 내에서 다른 인스턴스 변수와 상호 작용이 사용가능하다.
		// 다만, 메소드가 클래스 메소드(스태틱 메소드)라면 클래스 변수(스태틱 변수)는 사용 가능하지만 인스턴스 변수는 사용이 불가능하다. *ch7 Ex06)
	}

}
