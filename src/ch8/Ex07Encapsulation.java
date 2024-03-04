package ch8;

public class Ex07Encapsulation {
	public static void main(String[] args) {
		Book6 book = new Book6();
		// book은 Book6와 다른 클래스에 있기 때문에 private에 직접적으로 접근이 불가하다.
		book.setTitle("자바 기본문법");
		book.setAuthor("엘컴퓨터학원");
		book.setPrice(120000);
		Book6.printInfo(book);
		
		// tip) 참조변수를 던질 땐(클래식 메소드) 메소드 앞에 클래스이름, 그냥 인스턴스 변수를 던질 땐(그냥 메소드) 메소드 앞에 인스턴스 이름
		// tip2) 참조변수를 받을 땐(클래식 메소드) 파라미터 앞에 클래스이름, 그냥 인스턴스 변수를 받을 땐(그냥 메소드) 파라미터 앞에 타입(void, int 등등)
		
		Book6 book2 = new Book6();
		book2.setTitle("자바 자료구조");
		book2.setAuthor("엘컴퓨터학원");
		book2.setPrice(30000);
		Book6.printInfo(book2);
	}

}

class Book6 {
	private String title;
	private String author;
	private int price;
	
	// setter → 값을 세팅하는 것을 세터라고 한다
	public void setTitle(String title) {
		this.title = "[종이책]" + title;
		// public 메소드를 통해서만 prvate에 접근할 수 있도록 만드는 것을 캡슐화라고 한다.
		
	}
	// getter → 값을 보내주는 것을 게터라고 한다
	public String getTitle() {
		return title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	
	public void setPrice(int price) {
		if (price < 0 || price > 60000)
			return;
			// void 메소드에서는 return;값을 만날 경우 아래 코드가 실행되지 않음 (* ch07 Ex04)
			// 해당 return;값은 if문이 있기에 if가 참일 경우에만 return;코드가 동작한다
		this.price = price;
		//즉, if문이 참일경우 해당 코드는 실행되지 않음
		
	
	}
	public int getPrice() {
		return price;
	}
	
	public static void printInfo(Book6 book) {
		System.out.println(book.title + ", " + book.author + ", " + book.price + "원");
	}
}
