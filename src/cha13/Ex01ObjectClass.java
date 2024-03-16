package cha13;

public class Ex01ObjectClass {
	public static void main(String[] args) {
		Object o = null;
		// Object는 java에 있는 모든 클래스의 부모 클래스이다(최상위 클래스)
		// 모든 클래스는 내가 상속(extends)받지 않더라도 자동으로 Object클래스를 상속받고 있다
		// 즉, 모든 클래스는 Object클래스의 메소드를 사용할 수 있다.
		// 또한, Object타입은 모든 클래스를 업캐스팅받을 수 있다.
		o = new Object();
		System.out.println(o.toString());
		// toString 메소드는 Object클래스의 메소드이며 해당 인스턴스의 클래스와 메모리 주소(해시코드)가 출력된다.
		// java.lang.Object@49e4cb85 출력됨 @~~~는 해당 인스턴스 메모리 주소를 16진수로 나타냈다고 생각
		// 호출자가 String타입일 경우 String클래스가 toString메소드를 오버라이딩하고 있기에 메모리 주소가 아닌 호출자 내용(문자열)을 return한다.
		
		System.out.println("---");
		
		Book b1 = new Book();
		System.out.println(b1.toString());
		
		System.out.println("---");
		
		System.out.println(b1);
		// 인스턴스만 출력할 경우 .toString()을 자동으로 호출해 출력한다.
		
		System.out.println("---");
		
		Book2 b2 = new Book2("자바 기본문법", "엘컴퓨터학원");
		System.out.println(b2);
		// Book2클래스는 .toString() 메소드를 Overriding하고 있기에 Book2의 .toString() 메소드를 자동으로 호출해 출력한다.
		
		System.out.println("---");
		
		o = b2;
		System.out.println(o);
		// o가 b2를 업캐스팅 받았으나, b2에서 toString 메소드를 업캐스팅하고 있기에 Book2클래스의 toString 메소드 출력
		
		b2.print(o);
	}

}

class Book {
	private String title;
	private String author;
	
	@Override
	public String toString() {
		return "제목: " + title + ", 저자: " + author;
	}
}

class Book2 {
	private String title;
	private String author;
	
	public Book2(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "제목: " + title + ", 저자: " + author;
	}
	
	public static void print(Object o) {
		if (!(o instanceof Book2)) 
			return;
		Book2 book = (Book2)o; // 위에서 o가 Book2 클래스의 인스턴스 구조를 받았기(o=b2)에 다운캐스팅이 가능하다.
		System.out.println("제목: " + book.title + ", 저자: " + book.author);
	}
}

/*
문제 1.
print 메소드의 주석 처리된 부분을 수정하여 오류 없이 출력하도록 수정하세요.
힌트) 다운캐스팅을 사용하세요.

문제 2.
Book 클래스에 toString 메소드를 오버라이딩 하여 해시코드가 아닌 인스턴스 변수의 내용이 출력되도록 코딩하세요.
*/