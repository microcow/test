package ch8;

public class Ex02HasARelationship {
	public static void main(String[] args) {
		Book2 b1 = new Book2();
		b1.title = "자바 문법";
		b1.author = "엘컴퓨터학원";
		b1.price = 50000;
		
		Book2 b2 = new Book2();
		b2.title = "C 문법";
		b2.author = "엘컴퓨터학원";
		b2.price = 45000;
		
		Cart cart = new Cart();
		
		cart.putBook(b1); 
		// cart.book이라는 인스턴스변수에는 b1의 '모든' 인스턴스 변수 정보가 저장되었다
		// book은 Cart 클래스의 인스턴스 변수이지만 Book2의 모든 인스턴스 변수를 가지고 있기 때문에 출력 시 (인스턴스.인스턴스변수.인스턴스변수 속 인스턴스변수) 이렇게 입력해야한다.
		//(cart.book.title); 혹은 (cart.book.author); 혹은 /(cart.book.price);을 출력해서 b1과 값이 동일한지 확인해보자
		
		
		Cart.print(b1);
		
		cart.putBooks(b1, b2);
		Cart.print(cart.books);
		
		User user = new User();
		user.name = "둘리";
		user.age = 20;
		
		cart.owner = user;
		
		Cart.printCartInfo(cart);
		
		
	}

}

class Cart {
	Book2 book;		// book이라는 인스턴스 변수는 Book2가 가지고 있는 인스턴스 변수의 타입들을 모두 가지고 있음 (String title;, String author;, int price;) // HAS-A Relationship
					// 그냥 Book2 클래스의 인스턴스 변수 타입 모두 book이 상속받았다고 생각
	Book2[] books;	// books라는 인스턴스 변수는 Book2가 가지는 인스턴스 변수들을 모두 '배열'로 가지고 있음 // HAS-A Relationship
	User owner;		// owner라는 인스턴스 변수는 User이 가지고 있는 인스턴스 변수들을 모두 가지고 있음 // HAS-A Relationship
	int count;
	
	void putBook(Book2 book) {
		this.book = book;
		// Book2클래스에 동일한 이름과 파라미터의 형태를 가진 메소드가 있더라도 호출자의 클래스가 Cart라면 Book2클래스가 아닌 Cart 클래스가 받게된다.
		// 파라미터 book은 Book2의 인스턴스 변수 타입들을가지고 있다 (Book2클래스의 형태를 가진 book파라미터)
	}
	
	void putBooks(Book2... books) {
		this.books = books;
	}
	
	static void print(Book2 book) {
		System.out.println("- 소형 카트 -");
		System.out.println(book.print());
	
	}
	
	static void print(Book2[] books) {
		System.out.println("- 대형 카트 -");
		if (books != null) {
			for (int i=0; i<books.length; i++) {
				System.out.println(books[i].print());
			}
		}
	}
	
	static void printCartInfo(Cart cart) {
		System.out.println("카트의 주인은 " + cart.owner.name + "입니다.");
		// 위와 같이 Has A 관계인 owner는 User클래스의 인스턴스 타입들을 모두 가지고 있기 때문에
		// 출력 시 cart.owner.name과 같이 해야한다 (예시: cart.owner.age)
		// 기존과 같이 cart.owner로 출력하게 되면 owner의 인스턴스 변수가 여러개여서 메모리 주소가 출력되어버린다.
	}
}

class Book2 {
	String title;
	String author;
	int price;

	void putBook(Book2 test) {
		System.out.println("hello");
		// 호출자(cart)와 클래스가 달라서 cart.putBook(b1);를 받지못함
	}
	
	
	String print() {
		return "제목:"+title+", 저자:"+author+", 금액:"+price;
	}
}

class User {
	String name;
	int age;
}
