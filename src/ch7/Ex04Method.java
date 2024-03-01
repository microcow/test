package ch7;

public class Ex04Method {
	public static void main(String[] args) {
		Book3 book = new Book3();
		int bookPrice = book.getPrice();
		System.out.println(book.getPrice()); // 호출 메소드가 void가 아닌 이상 메소드 출력 시 return된 값이 출력된다. 
		System.out.println("세금 포함된 책의 가격: " + bookPrice);
		
		book.price = 50000;
		bookPrice = book.getPrice();
		System.out.println("세금 포함된 책의 가격: " + bookPrice);
		System.out.println();
		
		book.price = 30000;
		book.setPrice(35000);
		System.out.println();
		
		book.setTitle("자바");
		System.out.println("책이름: " + book.title);
		
		book.setTitle("자바문법");
		System.out.println("책이름: " + book.title);
	}
}

class Book3 {
	int price;
	String title;
	
	int getPrice() {
		if (price <= 0)
			return 0;
		// 메소드에서는 return을 만남과 동시에 메소드를 빠져나가게 된다.
		// 인스턴스에서 price 값이 정의되지 않았다면, 0과 null로 표시된다.
		// return + 리턴할 값 입력
		
		float tax = 1.1f;
		price = (int)(price * tax);
		// tax는 해당 메소드에서만 사용 가능한 지역변수
		
		return price;
	}
	
	void setPrice(int price) {
		System.out.println("price -> " + price);
		System.out.println("this.price -> " + this.price);
		// 인스턴스 변수와 파라미터 변수의 이름은 중복이 가능하며, 메소드 내에서 그냥 입력 시 파라미터 변수(지역 변수)를 사용
		// this.price는 메소드 내 파라미터 변수인 price가 아닌 인스턴스 변수 price를 칭함
		// 메소드를 호출할 때 사용한 인스턴스를 this라 칭함
		
		this.price = price;
		System.out.println("this.price = price 적용 후 this.price -> " + this.price);
	}
	
	void setTitle(String title) { // 문자열을 받기 때문에 String 타입
		String[] filter = {"자바", "C", "파이썬"};
		
		for (int i=0; i<filter.length; i++) {
			if (title.equals(filter[i])) {
				// 문자열이 같은지 비교하는 코드		
				// .을 기준으로 왼쪽과 오른쪽이 같은지 비교
				// .기준 왼쪽과 오른쪽이 동일하다면~
				System.out.println("사용할 수 없는 책 이름입니다.");
				return;
				// void는 return값이 없어도 되지만, 사용하는 이유는 반복문의 break;와 동일하게 해당 메소드를 즉시 빠져나갈 수 있다.
			}
		}
		
		this.title = title;
		
	}
}
