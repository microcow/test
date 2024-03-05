package ch8;

public class Ex03Super {
	public static void main(String[] args) {
		EBook2 eb = new EBook2();
		// 자식 클래스에서 인스턴스 생성 시 부모클래스에서도 동일하게 인스턴스가 생성된다.
		// 따라서, 위와 같이 자식 클래스에서 인스턴스 생성 후 생성자를 호출할 경우(EBook2();) 부모 클래스에서도 생성자를 호출해야한다.
		// 부모 클래스에서 생성된 인스턴스는 super라는 키워드에 저장된다
		
		System.out.println("책의 제목은 [" + eb.title + "]이고 글자의 색은 [" + eb.fontColor + "]입니다.");
		// EBook2 클래스에는 title이란 인스턴스 변수가 없으므로 부모클래스의 title 인스턴스 변수에 저장된 값을 불러왔다
		// 만약, EBook2 클래스에도 title이란 변수가 있었고, 값이 "야호"라고 저장되어있었다면, 위 코드 출력 시 "야호"가 출력될 것이다.
		
		System.out.println(eb.title);
		System.out.println(eb.author);
	}

}

class Book3 {
	String title;
	String author;
	int price;
	
	Book3(String title, String author) { // 아래의 super에 의해 호출된 부모 클래스 생성자
		this.title = title;
		this.author = author;
		// 이 때, 해당 생성자는 eb의 super에 의해 호출되었기에 this는 eb 인스턴스를 말한다. 
	}
	
	
	/*
	Book3() {
		
	}
	*/
}

class EBook2 extends Book3 {
	String fontColor;

	EBook2() {
		super("언어 문법", "엘컴퓨터학원"); 
		// super();은 부모의 생성자를 호출하는 키워드이다.
		// super(호출하고자 하는 부모 클래스 생성자 파라미터입력); → 다음과 같이 입력하여 생성자를 호출할 수 있다.
		// 이 때 super에는 해당 생성자를 호출한 인스턴스의 정보가 저장되어있다
		
		/* super("언어 문법", "엘컴퓨터학원"); 부분을 주석처리 할 경우 오류가 발생한다. 그 이유는 자식클래스에서 생성자를 만들때 자동으로 부모의 빈 생성자를 호출하게 되는데 (java에서 자동으로 생성해주는 *ch7 Ex13)
		위의 부모클래스(Book3)와 같이 빈 생성자가 없을 경우(Book3에서 다른 생성자를 만들어서 java에서 자동으로 빈 생성자를 만들어주지 않음 *ch7 Ex13)
		부모 클래스에서 빈 생성자를 직접 만들거나 super();을 이용해 이미 생성되어있는 부모 클래스의 생성자를 호출해주어야 한다.*/
		/* 자식클래스와 부모클래스 둘 다 생성자를 직접만들지 않았을 경우에는 java가 자식클래스에서 EBook2() 이란 빈 생성자를 생성한 후 super();란 코드를 자동으로 만들어
		 부모클래스의 빈 생성자를 호출하고 부모클래스에서도 Book3()란 빈 생성자를 자동으로 생성하여 받아준다 (둘 다 실제로 보이진 않는다)*/
		// 즉, 자식클래스에서 인스턴스를 생성할 때, 부모클래스의 생성자를 호출하며, 그 호출을 받아줄 수 있는 생성자가 있는지 확인해야한다.
		
		this.fontColor = "블랙";
		// 해당 코드가 super보다 위쪽에 위치할 수 없다. (super코드는 자식클래스의 생성자에서 처음에 위치해야함)

	}

		
}


