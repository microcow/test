package cha11;
import java.util.Scanner;
public class Ex02Enum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Book1 b1 = new Book1();
		b1.setTitle("자바 열거형");
		b1.setAuthor("엘컴퓨터학원");
		b1.setPrice(30000);
		b1.setCountry(Country.KOREA); //방법 1. 이넘멤버를 직접 입력하는 방법
		Book1.print(b1);
		
		Book1 b2 = new Book1();
		b2.setTitle("Java Enum");
		b2.setAuthor("lcomputerstudy");
		b2.setPrice(30000);
		b2.setCountry(Country.USA);
		Book1.print(b2);
		
		System.out.print("국가를 입력해 주세요: ");
		Book1 b3 = new Book1();
		b3.setTitle("Java 컬렉션");
		b3.setAuthor("엘컴퓨터학원");
		b3.setPrice(50000);
		b3.setCountry(Country.valueOf(s.nextLine()));
		// 방법 2. 사용자가 입력한 문자와 정확히 일치하는 이넘멤버를 반환한다 (setCountry의 아규먼트로)
		Book1.print(b3);
		
		Country[] countries = Country.values();
		// ★ Contry라는 enum의 countries라는 배열 인스턴스를 생성한 후 Country의 이넘멤버들을 배열로 반환하여 저장한다. ★
		for (int i=0; i<countries.length; i++) {
			System.out.println("name: " + countries[i].name() + ", \tindex: " + countries[i].ordinal());
			//name을 입력하면 인스턴스에 저장된 스트링이 반환된다.
			//ordinal을 입력하면 인스턴스에 저장된 인덱스가 반환된다.
			///eume에 한해서?
		}
		
		Country test = Country.values()[s.nextInt()];
		// 방법 3. enum명.values()[스캐너명.nextInt()];을 사용해 사용자에게 이넘멤버의 인덱스를 입력받을 수도 있다.
		
		System.out.println();
	}

}

class Book1 {
	private String title;
	private String author;
	private int price;
	private Country country;
	
	
	public Country getCountry() {
		return country; // 리턴 타입이 Country 라는 eume타입이다.
	}

	public void setCountry(Country country) { // 받는 타입이 enum이다
		this.country = country;
		// enum타입의 변수에 enum멤버를 저장할 수 있다.
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		float tax = 0f;
		int taxPrice = 0;
		
		switch (country) {
			case KOREA:
				tax = 1.1f;
				break;
			case USA:
				tax = 1.2f;
				break;
			case UK:
				tax = 1.3f;
				break;
			default:
				tax = 1.5f;
		}
		
		taxPrice = (int)(price * tax);
		
		return taxPrice;
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
	
	public static void print(Book1 book) {
		System.out.println("제목: " + book.getTitle());
		System.out.println("저자: " + book.getAuthor());
		System.out.println("가격: " + book.getPrice());
		System.out.println("국가: " + book.getCountry());
	}
}
enum Country {
	KOREA, USA, UK // 이넘 멤버
	
}
