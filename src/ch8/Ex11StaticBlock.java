package ch8;

public class Ex11StaticBlock {
	public static void main(String[] args) {
		Cart2.print();
		
		Book9 b1 = new Book9();
		Book9 b2 = new Book9("자바 초기화 블럭");
		Book9 b3 = new Book9("자바 static에 대하여", "엘컴퓨터학원");
		
		Cart2.add(b1);
		Cart2.add(b2);
		Cart2.add(b3);
		
		Cart2.print();
	}

}

class Cart2 {
	public static Book9[] books = new Book9[5]; // Book9의 인스턴스를 배열로 가지고 있는 Books 인스턴스 선언 동시에 메모리 생성(5개) (*ch08 Ex02)
	private static int index = 0;
	static {
		
		Book9 book = new Book9();
		book.setTitle("비어있음");
		book.setAuthor("비어있음");
		
		for (int i=0; i<books.length; i++) {
			books[i] = book;  
		}
		// 스태틱 블럭
		// 스태틱 블럭은 코드 실행 시 최초 1회만 실행되며, 블럭 안의 내용을 재실행 할 순 없다.
		// 클래스(스태틱)메소드나 변수는 프로그램 실행 시 가장 먼저(메소드 호출 이전에) 스태틱블럭을 통해 작업(셋팅)이 가능하다.
	}
	

	
	public static void print() {
		for (int i=0; i<books.length; i++) {
			books[i].print();
		}
		System.out.println();
	}
	
	public static void add(Book9 book) {
		books[index] = book;
		index++;
	}
}

class Book9 {
	private String title;
	private String author;
	private static int sequence = 0;
	private int bookNo;
	{
		bookNo = ++sequence;
	// 스태틱이 없는 그냥 블럭을 인스턴스 블럭이라 부른다.
	// 스태틱 변수는 인스턴스가 생성될 때 마다 새롭게 생성되는 변수가 아니기 때문에 증가한 sequence 값은 유지된다
	// 인스턴스 블럭은 인스턴스 생성 시에만 발동되며, 생성자 호출 이전에 발동된다.
		//(sequence = 0;)은 최초 선언 당시 값이고 ++sequence;가 발동될 때 마다 값이 증가되어 저장된다. (스태틱 변수이기에 저장됨)
		// 그럼 인스턴스 변수가 생성될 때 마다 인스턴스 블럭에 있는 bookNo = ++sequence; 값이 발동되어 sequence 변수의 값이 1씩 증가하는가? : yes
		// b1이란 인스턴스를 제일 처음 생성했다면 b1.bookNo는 1이 저장될것이고 b2란 인스턴스를 그다음 생성했다면 b2.bookNo는 2가 저장될것이고 이런식
	}
	
	Book9() {
		this("비어있음", "비어있음");
		// sequence = 10;
		// bookNo = ++sequence; → 해당 생성자가 실행될 때 마다 sequence의 값이 1씩 증가
	}
	
	Book9(String title) {
		this(title, "작자미상");
		//bookNo = ++sequence; → 해당 생성자가 실행될 때 마다 sequence의 값이 1씩 증가
	}
	
	Book9(String title, String author) {
		this.title = title;
		this.author = author;
		//bookNo = ++sequence; → 해당 생성자가 실행될 때 마다 sequence의 값이 1씩 증가
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void print() {
		System.out.println(bookNo + ", " + title + ", " + author);
	}
}
/*
문제 1.
정적 초기화 블록과 인스턴스 초기화 블록을 사용한 예제를 작성하세요.

문제 2.
정적 초기화 블럭에서는 인스턴스 변수를 사용할 수 없습니다.
이유를 설명하세요.
→ 특정 인스턴스가 생성되기 이전에 스태틱 블럭이 실행되기 때문에, 특정 인스턴스의 변수를 사용할 수 없다.
*/
