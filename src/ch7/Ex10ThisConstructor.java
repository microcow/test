package ch7;
// 생성자 단계에서 this 키워드 사용 시 유지보수 편리
public class Ex10ThisConstructor {
	public static void main(String[] args) {
		Book11 b1 = new Book11();
		Book11.printInfo(b1);
		
		Book11 b2 = new Book11("자바8 문법");
		Book11.printInfo(b2);
		
		Book11 b3 = new Book11("파이썬 문법", 35000);
		Book11.printInfo(b3);
		
		Book11 b4 = new Book11("SQL 문법", 38000, "엘컴퓨터학원");
		Book11.printInfo(b4);
	}

}

class Book11 {
	String title;
	int price;
	String author;
	
	Book11() {
		this("제목입력", 0, "저자입력");
		//Book11 클래스의 this옆에 있는 파라미터의 개수 및 타입과 동일한 생성자를 호출
		
	}
	
	Book11(String title) {
		this(title, 0, "저자입력");
		// 파라미터로 값을 받은 후 그 값들을 this 타입에 맞는 생성자에게 넘겨준다
		// 즉, String title로 title값을 받은 후 this(title, 0, "저자입력")타입의 생성자에게 값을 넘겨주고 실행시킴
		// this + 타입입력 과 동일한 메소드의 타입이 있더라도 this 문으로는 메소드를 호출할 수 없다(생성자만 호출)
		// 메소드 끼리는 this + 타입입력 을 통해 호출할 수 없다 → 확인 필요//  
	}
	
	Book11(String title, int price) {
		this(title, price, "저자입력");
	}
	
	Book11(String title, int price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}
	
	static void printInfo(Book11 book) {
		System.out.printf("제목: %s%n가격: %d%n저자: %s%n%n", book.title, book.price, book.author);
		
	}
}
