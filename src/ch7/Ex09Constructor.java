package ch7;

public class Ex09Constructor {
	public static void main(String[] args) {
		Book8 b1 = new Book8(); // b1라는 인스턴스 생성(메모리주소 생성)과 동시에 Book8() 생성자 호출
		b1.title = "자바문법";
		b1.price = 35000;
		b1.author = "엘컴퓨터학원";
		b1.printInfo();
		
		Book9 b2 = new Book9(); // b2라는 인스턴스 생성(메모리주소 생성)과 동시에 Book9() 생성자 호출
		b2.printInfo();
		
		Book10 b3 = new Book10("파이썬문법");
		b3.printInfo();
		
		Book10 b4 = new Book10("C문법", 50000);
		b4.printInfo();
		
		Book10 b5 = new Book10("자바8문법", 40000, "엘컴퓨터학원");
		b5.printInfo();
		
		// Book10 b6 = new Book10();
		// ㄴ Book10(); 생성자는 없기에 에러 발생
		// 생성된 Book10 생성자가 있기 때문에 컴파일러에서 빈 생성자를 새로 만들어주지 않음
		
	}
}

class Book8 {
	String title;
	int price;
	String author;
	
	Book8(){
		System.out.println("생성자 호출");
	}
	// 생성자는 메소드와 흡사하지만 인스턴스 생성과 동시에 호출된다
	// 생성자는 클래스 이름과 동일하며, 파라미터는 있을수도 있고 없을 수도 있다
	// 생성자는 메소드와 달리 return타입이 없다
	// 위와 같이 생성자를 따로 생성하지 않아도 컴파일러에서 자동으로 생성(내용이 없고 보이지 않는)해주기 때문에, 생성자를 따로 생성하지 않아도 된다.
	// 단, 해당 클래스 내 생성된 생성자가 하나도 없을 경우에만 자동으로 생성해준다.
	
	
	void printInfo() {
		System.out.printf("제목: %s%n가격: %d%n저자: %s%n%n", title, price, author);
	}
}

class Book9 {
	String title;
	int price;
	String author;
	
	Book9() {
		System.out.println("new Book9() -> 생성자가 호출되었습니다.");
		this.title = "제목입력";
		this.price = 0;
		this.author = "저자입력";
	// 생성자는 return타입이 없음
	// 인스턴스 생성과 동시에 호출된다.
	}
	
	void printInfo() {
		System.out.printf("제목: %s%n가격: %d%n저자: %s%n%n", title, price, author);
	}
}

class Book10 {
	String title;
	int price;
	String author;
	// 메소드에서도 오버로딩이 있듯 생성자에서도 오버로딩이 가능하다
	Book10(String title) {
		this.title = title;
		this.price = 30000;
		this.author = "엘컴퓨터학원";
	}
	
	Book10(String title, int price) {
		this.title = title;
		this.price = price;
		this.author = "엘컴퓨터학원";
	}
	
	Book10(String title, int price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
		
		
	}
	void printInfo() {
		System.out.printf("제목: %s%n가격: %d%n저자: %s%n%n", title, price, author);
	}
}
