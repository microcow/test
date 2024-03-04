package ch8;

public class Ex04Super {
	public static void main(String[] args) {
		EBook3 eb = new EBook3();
		eb.setPrice(30000);
		
		System.out.println("e북 가격: " + eb.price);
		
		eb.title = "자바 기본 문법";
		// eb인스턴스의 클래스에는 title이 없지만 Book4를 상속받았기에 사용가능하다.
		System.out.println(eb.getTitle());
		
		eb.author = "엘컴퓨터학원";
		System.out.println(eb.getAuthor());
		
	}
	//질문 - 메인에서 부모클래스에 있는 price 값을 불러올 수 없는지 (40000이란 값을)
}

class Book4 {
	String title;
	String author;
	int price;
	
}

class EBook3 extends Book4 {
	int price;
	String fontColor;
	
	void setPrice(int price) {
		this.price = price;
		super.price = price + 10000;
		// super은 자식 클래스에서 생성한 인스턴스가 부모 클래스에서도 생성될 때 저장되는 키워드이다. (*ch8. Ex03)
		// 즉, super.price는 부모클래스에 있는 인스턴스의 변수 price를 말한다.
		// super키워드는 자식 클래스의 메소드 내에서만 사용가능하다 (부모클래스, main클래스에서는 super키워드 사용 불가)
		System.out.println("종이책 가격: " + super.price);
		System.out.println("e북 가격: " + this.price);
	}
	
	String getTitle() {
		return title;
		// EBook3에는 title변수가 없으므로, 부모클래스에 있는 title 변수를 반환한다.(만약, EBook3에도 동일한 변수가 있었다면 부모 클래스가 아닌 EBook3의 인스턴스 변수를 반환했을 것)
	}
	
	String getAuthor() {
		return this.author;
		// 마찬가지로 EBook3에는 author변수가 없으므로, this.author더라도 부모클래스에 있는 author 변수를 반환한다.(만약, EBook3에도 동일한 변수가 있었다면 부모 클래스가 아닌 EBook3의 인스턴스 변수를 반환했을 것)
	}
}
