package ch9;

public class Ex02Polymorphism {
	public static void main(String[] args) {
		Book2 book = new Book2();
		book.setTitle("자바 기본문법");
		
		EBook2 ebook = new EBook2();
		ebook.setTitle("자바 알고리즘");
		
		ComicBook cbook = new ComicBook();
		cbook.setTitle("만화로 배우는 자바");
		
		AudioBook2 abook = new AudioBook2();
		abook.setTitle("자바 기초");
		
		Cart cart = new Cart();
		cart.add(book); // 아규먼트로 다른 클래스의 인스턴스를 던질수도 있다
		cart.add(ebook);
		cart.add(cbook);
		cart.add(abook);
		
		cart.printList();
		// abook이 null로 출력되는 이유는 AudoiBook2클래스에도 title이란 인스턴스 변수가 있기 때문,
		// 위에서 setTitle을 통해 title값을 "자바 기초"로 설정하였지만 부모클래스는 자식클래스의 인스턴스 변수를 사용할 수 없기에
		// abook.title에 저장된 것이 아닌 abook의 super.title에 값이 저장됨
		// 그래서 getTitle로 title값을 return받을 경우 abook의 title값이 null이 return된 것
		// title값에 "자바 기초"를 return받고싶다면 AudioBook2의 인스턴스 변수인 title의 이름을 변경하거나 제거하거나 super.title을 부여해야함

	}

}

class Book2 {
	protected String title;
	private String fontColor;

	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}

class EBook2 extends Book2 {
	
	@Override
	public String getTitle() {
		return "[e북]" + title;
	}
	
}

class ComicBook extends Book2 {
	private boolean color;

	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	
	@Override
	public String getTitle() {
		return "[만화책]" + title;
	}
	
	
}

class Cart{
	private Book2[] books = new Book2[10];
	private int index = 0;
	
	public void add(Book2 book) {	// 다형성
		books[index] = book;
		index++;
		//index는 지역변수가 아니기 때문에 1씩 증가한 값이 유지됨
		//만약 해당 add 메소드 내에서 int a = 0; 변수를 생성한 후 index자리에 a를 넣고 a++를 한다면 a값은 메소드를 불러올 때마다 생성되게 되므로 a값은 계속 초기화될 것 
	}
	
	public void printList() {
		for (int i=0; i<books.length; i++) {
			if (books[i] == null)
				break;
			System.out.println(books[i].getTitle());
			
			// 문제 (1)  
			// System.out.println(books[i].getFontColor());
			// Book2타입을 받은 books에는 Book2,EBook,CBook 타입이 저장되어 있으나,
			// getFountColor가 자식클래스인 EBook에 있었으므로, 배열에 저장된 CBook타입과 Book타입은 EBook타입에 있는 메소드를 사용하지 못하므로 오류가 발생했었다
			// 따라서, EBook클래스에 있는 gerFountColor메소드와 인스턴스 변수를 부모클래스인 Book2로 옮겨 오류를 수정하였다.
		}
	}

}

class AudioBook2 extends Book2{
	String title;
		
	@Override
	public String getTitle() { // 오버라이딩을 위해선 부모클래스와 리턴타입도 동일해야한다.
		return "[오디오북]" + title; //return "[오디오북]" + super.title;
	}
	
}
/*
문제 1.
(1) 컴파일 에러가 발생하지 않도록 수정하세요.

문제 2.
AudioBook 클래스를 추가하세요.
카트에 오디오북을 담으세요.
카트의 리스트 출력 시 오디오북은 [오디오북]책제목의 형식으로 출력되도록 코딩하세요. 
*/