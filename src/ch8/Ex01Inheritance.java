package ch8;

public class Ex01Inheritance {
	public static void main(String[] args) { 
		Book book = new Book();
		book.price = 50000;
		System.out.println("책의 가격은(세금포함): " + book.getPrice());
		//book.printDevices(); → Book클래스에 없으므로 호출 불가
		//book.printSize(); → Book클래스에 없으므로 호출 불가
		// 즉, 자식클래스는 부모클래스의 변수나 메소드를 불러올 수 있지만(상속받았기 때문)
		// 부모클래스는 자식클래스의 변수나 메소드를 불러올 수 없다
		
		System.out.println();
		
		EBook eBook = new EBook();
		eBook.price = 30000;
		System.out.println("e북의 가격은(세금포함): " + eBook.getPrice());
		// eBook이라는 클래스에는 getPrice라는 메소드가 없으나, 상속받았기 때문 사용 가능하다.
		String[] devices = {"아이패드", "킨들", "갤탭"};
		eBook.supportDevices = devices;
		eBook.printDevices();
		//eBook.printSize(); → EBook 클래스와 상속받은 클래스 모두에서 없으므로 마찬가지로 호출 불가
		
		System.out.println();
		
		PaperBook pBook = new PaperBook(150, 200);
		pBook.price = 40000;
		System.out.println("종이책의 가격은(세금포함): " + pBook.getPrice());
		// PaperBook 클래스가 Ebook 클래스를 상속받게 되면 Book 클래스의 메소드나 변수도 사용가능하다.(Ebook클래스가 Book클래스를 상속받았기 때문)
		pBook.printSize();
		String[] devices1 = {"애플", "삼성", "화웨이"};
		pBook.supportDevices = devices1;
		pBook.printDevices();
	}

}

class Book  {
	String title;
	String author;
	int price;
	
	int getPrice() {
		int taxPrice = (int)(price * 1.1);
		return taxPrice;
	}
}

// IS-A Relationship : 상속을 받을 때 아무클래스나 상속받는 게 아닌 IS - A 관계가 성립이 되었을 때 상속받는다
// 예시)Ebook is a Book과 같이 어떠한 개념이 확장되었을 때(추가되었을 때) 상속이 가능하다.
// 잘못된 예시) Cafe is a Coffee : is a 관계가 성립하지 않았으므로 Coffee클래스에 Cafe클래스를 상속하면 안된다.

class EBook extends Book {
	// class 클래스이름2 + exrends + 클래스이름1 { : 클래스이름2가 클래스이름1를 상속받았다는 뜻
	// 상속받은 클래스(자식클래스)는 상속해준 클래스(부모클래스)의 인스턴스변수 및 메소드를 모두 가지게된다
	// 실제로 코드로는 안적혀있지만 가지고 있는거나 다름없다
	// 많은 클래스에 공통된 부분을 부모 클래스에 저장해둔 후 상속시키면 유지보수에 용이하다
	// 동일 클래스 내에서만 상속 가능
	String[] supportDevices;
	
	void printDevices() {
		System.out.println("호환기기 목록");
		for (int i=0; i<supportDevices.length; i++) {
			System.out.println("기기" + (i+1) + ":" + supportDevices[i]);
	//상속받은 변수 및 메소드 외에도 추가적으로 새롭게 가질 수 있다
		}
	}
}

class PaperBook extends EBook {
	int width;
	int height;
	
	PaperBook(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	void printSize() {
		System.out.println("가로길이 : " + width + "mm, 세로길이 : " + height + "mm");
		
	
	}
}
