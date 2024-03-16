package cha13;

public class Ex02Equals {
	public static void main(String[] args) {
		Book3 b1 = new Book3("자바 컬렉션", "엘컴퓨터학원", 2);
		Book3 b2 = new Book3("자바 알고리즘", "엘컴퓨터학원", 7);
		Book3 b3 = new Book3("자바 알고리즘", "엘컴퓨터학원", 7);
		
		System.out.println(b1); 
		//인스턴스만 입력 시 toString();이 자동 호출됨
		System.out.println(b2);
		System.out.println(b1.equals(b2));
		// .equals는 b1과 b2의 메모리 주소를 비교해 같다면 true, 다르면 false를 반환하는 메소드이다.
		System.out.println();
		
		System.out.println(b2);
		System.out.println(b3);
		System.out.println(b2.equals(b3));
		System.out.println();
		
		Book4 b4 = new Book4("자바 컬렉션", "엘컴퓨터학원", 2);
		Book4 b5 = new Book4("자바 알고리즘", "엘컴퓨터학원", 7);
		Book4 b6 = new Book4("자바 알고리즘", "엘컴퓨터학원", 7);
		
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b4.equals(b5));
		System.out.println();
		
		System.out.println(b5);
		System.out.println(b6);
		System.out.println(b5.equals(b6));
		// equals를 오버라이딩했기에 true가 반환된다
		// 오버라이딩 하지 않았다면 주소 값을 비교하기에 false가 반환되었을 것이다.
		System.out.println();
		
		String s1 = new String("안녕하세요");
		String s2 = new String("안녕하세요");
		// String 클래스도 int와 같이 Stirng A = "aa"; 이런식(기본형)으로 사용할 수 있도록 java에서 처리하지만 원래는 위처럼 = new String()과 같은 형태로 사용해야한다.
		
		System.out.println(s1 == s2);
		// 주소가 다르므로 false가 출력된다.
		System.out.println(s1.equals(s2));
		// String클래스도 java에서 문자열을 비교하도록 equals 메소드를 오버라이딩 하고 있기에 true가 반환된다.
		// 즉, String 타입의 두 문자열을 비교하려면 ==이 아닌 equals를 사용하자
		
		test111 a = new test111();
		a.a = "";
		System.out.println(b5.equals(a));
		b5 = a;
		System.out.println(b5.equals(b5));
	}

}

class Book3 {
	private String title;
	private String author;
	private int edition;
	
	public Book3(String title, String author, int edition) {
		this.title = title;
		this.author = author;
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "Book3 [title=" + title + ", author=" + author + ", edition=" + edition + "]";
	}
	
}

class Book4 {
	private String title;
	private String author;
	private int edition;
	
	public Book4(String title, String author, int edition) {
		this.title = title;
		this.author = author;
		this.edition = edition;
	}

	@Override
	public boolean equals(Object obj) {
		//Object 클래스는 모든 클래스의 부모클래스이므로 모든 인스턴스를 업캐스팅 받을 수 있다.
		if (!(obj instanceof Book4)) 
			// instanceof 키워드는 왼쪽의 인스턴스가 오른쪽의 클래스로 다운캐스팅이 가능한지 확인한다.
			/* ★★ obj 파라미터가 최상위 클래스인 Object로, 모든 클래스의 인스턴스를 받을 수 있지만, 업캐스팅 받더라도 '업캐스팅 받은 자식클래스로만 다운캐스팅이 가능'하기에,
			    Book4로 다운캐스팅 가능한 조건인 Book4의 '자식클래스'이거나 Book4클래스로 부터 업캐스팅을 받은 것이 아닐 경우엔 Book4 클래스로 다운캐스팅이 불가능하다.*/ 
			return false;
		Book4 book = (Book4)obj;
		// obj는 Object클래스 이므로 Book4클래스의 인스턴스 변수에는 접근이 불가하므로, 다운캐스팅을 해준 것
		
		return title.equals(book.title) && author.equals(book.author) && edition == book.edition;
	}

	@Override
	public String toString() {
		return "Book4 [title=" + title + ", author=" + author + ", edition=" + edition + "]";
	}
}
class test111 extends Book4{
	String a;
	
	public test111(){
		super("", "", 0);
	}
}
