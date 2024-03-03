package ch7;

public class Ex03Method {
	public static void main(String[] args) {
		// 변수는 값을 저장하는 것이라면 메소드는 기능을 저장하는 것
		// 저장된 메소드를 호출하면 해당 기능 사용 가능
		Book2 book = new Book2();
		book.title = "자바문법";
		book.author = "엘컴퓨터학원";
		book.price = 50000;
		
		book.printInfo();
		// 메소드를 호출하는 방법
		// 인스턴스name.메소드name();을 입력하면 인스턴스 정보들을 가지고 해당 메소드를 실행
		
		Book2 book2 = new Book2();
		book2.title = "C문법";
		book2.author = "엘컴퓨터학원";
		book2.price = 30000;
		
		book2.printInfo();
		
		book2.setPrice(20000);	// 20000은 아규먼트(인수)라 부른다
		// setPrice 메소드를 호출 후 20000이라는 아규먼트를 넘겨주었으며, parameterPrice 파라미터가 받았음
		book2.printInfo();
		// 이전과 달리 price에 22000이 출력된다.
		
		book2.setPrice(30000, 1.2f);
		// 아규먼트(인수)를 여러개 넘겨줄 수도 있으며 ','로 구분
		book2.printInfo();
		// 이전과 달리 price에 36000이 출력된다.
		
		System.out.print(book2.getDollarPrice() + "\n" );
		float dollar = book2.getDollarPrice();
		System.out.println(dollar);
		// return된 값을 따로 저장하여 사용할 수도 있다.
		
		
		book2.printInfoEng();
	}

}
// class는 변수와 메소드로 이루어져있다
// 같은 패키지 안에는 class 이름이 중복될 수 없다
class Book2 {
	String title;
	String author;
	int price;
	int stock;
	//  인스턴스 변수들
	
	// return타입 메소드name (파라미터) {
	void printInfo() {
	// 메소드 앞에 적는 것(void)은 return 타입이다
	// void는 해당 메소드가 return을 하지 않는다는 뜻의 타입이다.
	// void를 사용하였을 땐, 메소드 내에서 System.out.print와 같이 출력 까지 처리하는 편
		// 메소드는 class 안에 존재해야한다
		// 메소드를 만드는 방법은 class의 {안에서 printInfo() {를 입력
		System.out.println("---------------");
		System.out.println("도서명: " + title);
		System.out.println("저자: " + author);
		System.out.println("가격: \u20a9" + price + "원");
		// 역슬래쉬u+16진수는 유니코드 호출
		System.out.println("---------------");
	}
	
	void setPrice(int parameterPrice) {
		price = (int)(parameterPrice * 1.1f);
		// parameterPrice는 메소드() 내에 선언되었기에 파라미터(매개변수)라고 부르며 입력된 아규먼트(인수)를 받는 변수이다.
		// (타입 + 파라미터) 입력으로 아규먼트를 받을 수 있다. ex)book2.setPrice(20000)
		// 파라미터는 메소드 내에서만 사용 가능한 지역변수이며, 메소드가 종료됨과 동시에 사라진다.
		// parameterPrice는 파라미터이자 지역변수이다.
	}
	
	void setPrice(int parameterPrice, float taxRate) {
		price = (int)(parameterPrice * taxRate);
		// 위와 동일한 메소드 이름이더라도, 파라미터 개수가 다르면 다른 메소드로 인식한다.
		// 즉 아규먼트를 하나만 넘겨주면 위의 setPrice 메소드가 실행되며, 두개를 넘겨주면 해당 메소드가 실행된다.
	}
	
	float getDollarPrice() {
	// float부분(타입)은 return되는 값의 타입을 적어주면 된다.
	// 여기선 36.0이 return되었기 때문에 float 타입을 입력
	// return타입을 사용했을 경우, 반드시 return해주어야 한다. (void타입 제외)
	// float과 같이 void 타입을 사용하지 않았을 땐 메소드 내에서 System.out.print와 같이 출력하지 않고 위에서 return값을 가지고 출력하는 편
		float dollarPrice = price / 1000f;
		// dollarPrice는 메소드() 이후 {}에서 변수 선언이 되었기 때문에 파라미터는 아니지만 지역 변수이다.
		// 파라미터와 동일하게 메소드가 종료됨과 동시에 dollarPrice는 사라진다
		return dollarPrice;				
		// return은 메소드를 호출한 곳으로 값을 돌려준다는 뜻
		// 예를들어 book2.dollarPrice로 해당 메소드를 호출했을 경우 return으로 값을 돌려준다
		// book2.getDollarPrice() 해당 부분이 return값으로 교체되는 것임
		// 즉, System.out.print(book2.getDollarPrice()); 입력 시 return된 값을 출력한다
	}
	
	void printInfoEng() {
		System.out.println("---------------");
		System.out.println("book name: " + title);
		System.out.println("author: " + author);
		System.out.println("price: $" + getDollarPrice());
		// 메소드 안에서 다른 메소드를 호출할 수 있다.
		// 단, 호출할 때 메소드 앞에 인스턴스 이름이 없다면, 해당 메소드를 호출할 때 사용된 인스턴스를 사용한다
		System.out.println("---------------");
	}
}
