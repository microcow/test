package ch7;

public class Ex08MethodOverloading {
	public static void main(String[] args) {
		Book7 book = new Book7();
		book.setInfo("자바8.0문법");
		System.out.println(book.getInfo());
		
		book.setInfo("C문법", 35000);
		System.out.println(book.getInfo());
		
		book.setInfo("파이썬문법", 30000, "엘컴퓨터학원");
		System.out.println(book.getInfo());
		
		System.out.println(book.setInfo());
		System.out.println(book.getInfo());
		
		//위와 같이 메소드 이름은 모두 동일하지만, 아규먼트(파라미터)타입이 다르기에 호출하는 메소드가 다 다르며 이를 메소드 오버로딩이라 한다.
		//오버로딩을 할 때 파라미터를 기준(파라미터 개수, 타입)으로 하기때문에 리턴타입은 관련없다
	}

}

class Book7 {
	String title;	
	int price;
	String author;
	
	void setInfo(String title) {
		this.title = title;
	}
	
	void setInfo(String title, int price) {
		this.title = title;
		this.price = price;
	}
	
	void setInfo(String title, int price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}
	
	String setInfo() {
		this.title = "";
		this.price = 0;
		this.author = "";
		
		return "책의 정보가 초기화 되었습니다.";
		// return 할때 문자열을 return할 경우, printf println 등을 사용하지 않아도 출력된다.
	}
	
	String getInfo() {
		return "제목: " + title + "\n가격: " + price + "\n저자: " + author + "\n";
	}
}
