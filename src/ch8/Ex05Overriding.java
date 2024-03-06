package ch8;

public class Ex05Overriding {
	public static void main(String[] args) {
		EBook4 eb = new EBook4();
		eb.setPrice(30000);
		
		eb.printPrice();
		
		eb.printAllPrice();
	}

}

class Book5 {
	String title;
	String author;
	int price;
	
	void setPrice(int price) {
		this.price = price; // 코드 실행 시 이 때 price에는 40000의 값이 저장됨
		
	}
	
	void printPrice() {
		System.out.println("paperbook price: " + price);
		// 자식클래스에 있는 메소드에서 호출을 했더라도 부모클래스는 자식클래스의 메소드 및 인스턴스 변수를 사용할 수 없다.
		// 따라서, 위에서 저장된 40000의 값이 출력된다.
	}
	
	void setPrice() {
		
	}
	
}

class EBook4 extends Book5 {
	int price;
	String fontColor;
	
	@Override
	void setPrice(int price) { // 오버라이딩을 위해선 부모클래스에 있는 메소드와 파라미터 이름(여기선 price)을 제외하고 토씨하나 틀리지 않고 똑같이 적어야함
		// 부모클래스에 존재하는 메소드와 동일한 메소드 이름과 파라미터 구조를 가진 메소드를 자식클래스에서 생성할 수 있다 (이를 메소드 오버라이딩이라 한다.) 
		// 이 때, 부모클래스와 자식클래스에 동일한 이름의 메소드와 동일한 타입의 파라미터가 있을 경우, 호출 인스턴스와 동일한 클래스의 메소드를 불러온다
		// 메소드 이름과 파라미터 타입은 부모클래스와 동일해야하지만 파라미터 이름은 달라도 된다
		super.setPrice(price + 10000);
		// 메소드 내에서 부모클래스의 메소드를 호출하고 싶다면, super을 사용하면된다.
		this.price = price;
		
	}
	
	void printPrice() {
		System.out.println("ebook price: " + price);
	}
	
	void printAllPrice() {
		super.printPrice();
		printPrice();		
		// super을 입력하지 않을 경우 this.printPrice();와 동일하다.
	}
	
	/*
	@Override // @Override는 어노테이션이라고 하며, 아래의 메소드가 부모클래스(super type)에 있는지 확인하고 없다면 에러가 발생한다. (자식클래스는 subtype라 한다) 
	void setprice() {
		// 즉, 오버라이딩을 할 때 @Override 어노테이션을 작성하여 부모클래스와 동일한 이름의 메소드가 존재하고 있는지 검사하여 오버라이딩 할 것
		// @Override 어노테이션을 사용하지 않고 메소드 이름을 잘못 작성하거나, 부모클래스에 존재하지 않는 메소드 이름을 작성할 경우 새로운 메소드가 생성된다  
	}
	*/
}
