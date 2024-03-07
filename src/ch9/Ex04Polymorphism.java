package ch9;

public class Ex04Polymorphism {
	public static void main(String[] args) {
		Product p = new Product();
		Product p2 = p;
		System.out.println(p.equalsProduct(p2));
		
		Book4 b1 = new Book4();
		b1.setTitle("자바 자료구조");
		b1.setAuthor("엘컴퓨터학원");
		
		Book4 b2 = new Book4();
		b2.setTitle("자바 자료구조");
		b2.setAuthor("엘컴퓨터학원");
		
		Book4 b3 = new Book4();
		b3.setTitle("자바 자료구조");
		b3.setAuthor("엘코딩랩");
		
		System.out.println(b1.equalsProduct(b2)); //b1이 호출자이며, 아규먼트로 b2를 투척
		System.out.println(b1.equalsProduct(b3));
		
		Book4 b4 = new Book4();
		b4.price = 10000;
		
		Book4 b5 = new Book4();
		b5.price = 9000;
		
		System.out.println(b4.compareProduct(b5));
		
	}

}

class Product {
	public boolean equalsProduct(Product p) {
		return this == p;
	}
	
	/*
	public Product compareProduct(Product p) {
		return null;
	}*/
	// 질문 - return 타입에 클래스가 오는 경우 : 해당 클래스 타입의 인스턴스를 넘겨주어야 할 때
	
	public int compareProduct(Product a) {
		return 0;
	}
}

class Book4 extends Product {
	private String title;
	private String author;
	int price;
	
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
	
	@Override
	public boolean equalsProduct(Product p) { //오버라이딩 때문에 p의 타입은 Book4클래스가 아닌 Product 클래스이다. //Product가 부모클래스 이기에 자식클래스 인스턴스를 받을 수 있다
		if (!(p instanceof Book4))
			// instanceof 연산자는 형변환이 가능한지 물어보는 키워드이다 (p가 Book4타입으로 형변환이 가능한가? 라는 뜻)
			// p 파라미터가 받은 인스턴스가 Book4타입이라면 형변환 가능 // 받음과 동시에 업캐스팅? = yes(*ch9 Ex03)
			return false;
		
		Book4 book = (Book4)p; //다운캐스팅
		boolean result = title.equals(book.title) && author.equals(book.author);
		//문자열은 ==으로 비교불가이기에 equals 키워드를 통해 비교해야함
		
		return result;
	}
	
	//문제 1.
	@Override
	public int compareProduct(Product a) { // Book4타입을 파라미터로 받을 경우 a는 받는 순간 업캐스팅 (업캐스팅 하였지만 a는 부모클래스 소속이기에 다운캐스팅 하기 전까지 자식클래스 메소드 사용 불가) 
		if (!(a instanceof Book4))
			return 0;				
		Book4 price1 = (Book4)a; // a의 Book4클래스로 다운캐스팅을 받아줄 Book4 클래스 인스턴스 price1 생성
		
		if (this.price > price1.price) {
			return this.price;
		}
		else if (this.price < price1.price) {
			return price1.price;
		}
		else
			return 0; //else는 괄호(조건)을 쓰면 안된다 괄호(조건)을 쓰고싶다면 else if를 사용하자
		
				
	}
		
}

/*
문제 1.
Product 클래스에 두 인스턴스간의 크기를 비교하는 메소드인 compareProduct 메소드를 추가하세요.
Book4 클래스에 compareProduct 메소드를 오버라이딩 후 가격이 높은 책의 인스턴스를 반환하도록 코딩하세요.
반환된 인스턴스의 title을 출력하세요. 
*/