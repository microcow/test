package ch9;

public class Ex01Upcasting {
	public static void main(String[] args) {
		Book book = null; // 인스턴스를 빈 값으로 만들려면 null을 이용하자 
		// Book book = null; : 인스턴스는 생성되었으나 어떠한 클래스의 객체(인스턴스 변수)도 참조하지 않고 있음을 나타냄 (즉, = new Book(); 혹은 = new EBook();을 통해 해당 클래스를 참조시키거나 자식클래스(업캐스팅)를 참조시켜주어야 사용 가능)
		book = new Book();
		book.setTitle("자바 기본문법");
		System.out.println(book.getTitle());
		
		book = new EBook();			// 업캐스팅
		// book인스턴스는 부모 클래스인 Book클래스에서 생성되었으나 EBook이란 자식 클래스의 인스턴스 변수 구조들을 가지고 재생성 되었다. (인스턴스 구조는 바뀌었으나 여전히 Book클래스 소속)
		// 위와 같이, ★부모 클래스에서 생성된 인스턴스는 자식 클래스를 받을 수 있다.★
		// 부모 타입에 자식 타입의 인스턴스를 저장하는 것을 업캐스팅이라 한다. (자식을 부모에 저장한다)
		// ★ book(부모클래스의 인스턴스)은 EBook클래스(자식클래스)의 인스턴스 변수 구조를 가지고 있지만, 부모클래스 소속이므로 자식 클래스의 메소드나 인스턴스 변수를 사용할 수 없다. ★ (* ch8 Ex01)
		// 질문 1 - 자식클래스의 인스턴스 변수도 사용 불가한가? (EBook 클래스 구조를 가지고있는데?) = yes 사용 불가
		
		/* 문제 1. book.setFontColor("블랙") 코드에서 컴파일 오류가 나지 않도록 수정해 주세요.
		book.setFontColor("블랙");
		System.out.println(book.getFontColor()); */
		// → book클래스는 EBook클래스의 구조를 가지고 있으나 부모클래스이기에 자식클래스의 메소드인 setFontColor를 사용할 수 없다 따라서, setFountColor 메소드를 부모클래스에서 생성하고 자식클래스에 있는 메소드는 오버라이딩 시켜야한다
		
		book.setTitle("자바 자료구조");
		System.out.println(book.getTitle());
		/* ★ 위에서 얘기한 것처럼 book은 부모클래스(Book) 소속이지만 자식클래스(EBook)타입을 가지고 있으므로 부모 클래스에 있는 메소드만 호출할 수 있으나,
		오버라이딩 된 메소드가 있다면, 부모 클래스에 있는 메소드가 아닌 오버라이딩 된 자식클래스의 메소드를 호출한다. ★ */
		
		Book mom = new Book();
		EBook son = new EBook();
		AudioBook son2 = new AudioBook();
		
		mom.initTitle(new Book());
		System.out.println(mom.getTitle());
		
		son.initTitle(new EBook());
		System.out.println(son.getTitle());
		
		son2.initTitle(new AudioBook());
		System.out.println(son2.getTitle());
		System.out.println(son2.title);
		// AudioBook 클래스에는 title값이 다르게 저장되어 있으나, getTitle은 부모 클래스의 메소드 이기에 자식클래스인 AudioBook의 title 값을 가져올 수 없다(*ch8 Ex01) 따라서, son2의 super에 저장된 title 값을 가져온다
		// 따라서, System.out.println(son2.title); 입력 시에는 AudioBook의 title 값이 출력된다
		
		// 아규먼트에 new 생성자();(메모리 생성)을 입력하게 되면 파라미터가 해당 클래스의 메모리를 가지게 된다 (즉, 클래스명 파라미터 = new 클래스명();과 동일)
		
	}

}

class Book {
	public String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title; // this는 항상 호출자를 말한다 (파라미터.setTitle로 호출할 경우 this는 파라미터이다)
							// 메소드가 어떤 인스턴스의 super에 의해 호출되었다면, this는 해당 인스턴스를 말한다.
		
		// 질문 2 - 이 때 super을 통해 해당 메소드를 호출했다면 this는 super인가 파라미터인가????
		 		// 답 : super이다.
		
	}
	
	void initTitle(Book book) { 
		// 이 때, book 파라미터는 Book클래스를 포함해 Book클래스를 상속받은 모든 자식 클래스의 인스턴스를 받을 수 있다 (★부모는 자식을 받을 수 있다★)
		// book 파라미터가 new EBook();이란 아규먼트를 받았을 경우 Book book=new EBook();과 동일하게 작동한다
		book.setTitle("엘컴퓨터학원"); 
		// 또한 book파라미터가 new EBook();이란 아규먼트를 받았다면, EBook클래스의 구조를 갖게 되므로, setTitle 메소드 호출 시 오버라이딩 된 자식 메소드를 호출한다(오버라이딩 안되어있으면 부모 클래스에 있는 메소드 호출함)
		this.title = book.title;
		// 즉, 한가지의 파라미터 형태이지만 무엇을 받느냐에 따라 다른 메소드를 호출할 수 있다 이를 다형성이라고한다.
	}
}

class EBook extends Book{
	private String fontColor;
	
	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	
	@Override
	public void setTitle(String title) {
		title = "[EBOOK]" + title;
		super.setTitle(title);
		// 부모클래스의 메소드 호출 시 super은 붙여야한다.
		// 오버라이딩에서 부모클래스 메소드 호출 시 super은 해당 메소드를 호출한 인스턴스를 말한다.
	}
}

class AudioBook extends Book{
	String title="자식클래스";
	
	@Override
	public void setTitle(String title) { //부모 클래스의 접근제한자가 public이라면 오버라이딩 시 자식 클래스도 public이 되어야한다.
		title = "audio" + title;
		super.setTitle(title);
	}
	
}
/*
문제 1.
book.setFontColor("블랙") 코드에서 컴파일 오류가 나지 않도록 수정해 주세요.

문제 2.
Book의 자식 클래스인 AudioBook 클래스를 추가해 주세요.
업캐스팅을 이용해 AudioBook 클래스의 특정 메소드를 호출하는 코드를 작성하세요. 
*/
