package cha11;

public class Ex04Enum {
	public static void main(String[] args) {
		Book2 b1 = new Book2();
		b1.setTitle("자바 열거형");
		b1.setAuthor("엘컴퓨터학원");
		b1.setPrice(30000);
		b1.setCountry(Ex03Country.KOREA);
		// ex03 필드에 있는 KOREA라는 이넘멤버 사용
		// 이넘멤버를 사용하기 위해선 이넘이름.이넘멤버이름으로 접근
		// System.out.println(county.KOREA); 동일한 이넘멤버 이름이나, 이넘이 다름
		Book2.print(b1);
		/*print 메소드가 static이라 클래스 이름으로 호출하지만
		static이 아닐 경우 b1.print(b1)으로 호출해야하는데 결과는 같음 (print메소드가 아규먼트 정보만 가지고 출력을하기 때문)
		본문과 관련없는 리마인드 및 소소한 팁임 */
		
		Book2 b2 = new Book2();
		b2.setTitle("Java Enum");
		b2.setAuthor("lcomputerstudy");
		b2.setPrice(30000);
		b2.setCountry(Ex03Country.USA);
		Book2.print(b2);
		
		Book2 b3 = new Book2();
		b3.setTitle("Java Enum");
		b3.setAuthor("lcomputerstudy");
		b3.setPrice(30000);
		b3.setCountry(Ex03Country.ETC);
		Book2.print(b3);
		
		b3.setGenre(genre.무협);
		b3.print();
		
	}

}

class Book2 {
	public String title;
	private String author;
	private int price;
	private Ex03Country country;
	private genre genre;
	
	public Ex03Country getCountry() {
		return country;
	}

	public void setCountry(Ex03Country country) {
		this.country = country;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return (int)(price * country.getRefundTax());
				//county 변수 타입이 Ex03Country이므로 public 메소드인 getRefundTax 사용가능 
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
	
	void setGenre(genre genre) {
		this.genre = genre;
	}
	
	genre getGenre() {
		if (genre.cord != 0)
		return genre;
		else return genre;
	}
	genre getGenre2(genre genre) {
		return this.genre; // 변수와 파라미터가 동일 이름일 경우 this를 사용해서 구분 (본문과 관련없는 소소한 팁)
	}
	void print() {
		System.out.print(getGenre()); // this가 없더라도 호출자받은 인스턴스 정보로 메소드 호출 (본문과 관련없는 소소한 팁)
	}

	
	public static void print(Book2 book) {
		System.out.println("제목: " + book.getTitle());
		System.out.println("저자: " + book.getAuthor());
		System.out.println("가격: " + book.getPrice());
		System.out.println("국가: " + book.getCountry());
		System.out.println();
	}
}

enum county{
	KOREA;
}
