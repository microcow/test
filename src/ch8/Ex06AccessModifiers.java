package ch8;
import ch08.Ex06.Book;
//ch08.Ex06.Book 클래스와 함께 볼 것
public class Ex06AccessModifiers {
	public static void main(String[] args) {
		
		// private 접근 제한자는 같은 패키지의 같은 클래스의 같은 필드(페이지) 내에서만 접근 가능하다 (상속받은 클래스도 위 조건대로 접근 불가)
		// 기본 접근 제한자(디폴트 접근 제한자)는 같은 패키지 내에서 같은 클래스 내에서만 접근 가능하다 (따로 접근제한자를 안적을 경우 디폴트 접근제한자로 적용)
		// public 접근 제한자는 같은 클래스에서 동일하지 않은 패키지에서도 접근할 수 있게 해주는 접근제한자이다. (상속받은 클래스도 위 조건대로 접근 가능)
		// protected 접근 제한자는 디폴트 접근 제한자처럼 같은 패키지 내에서만 접근 가능하지만(같은 이름의 클래스더라도 패키지가 다르면 접근 불가), 다른 패키지에서 해당 클래스는 상속받고 있을 경우엔 패키지가 달라도 접근 가능하다.
		// 접근 제한자는 클래스나 메소드, 변수 등 앞에 붙을 수 있다. (클래스는 class 앞에 / 메소드는 리턴타입 앞에 / 변수는 변수타입 앞에)
		
		Book b1 = new Book();
		//Book이 다른 패키지에 있지만 Book클래스 앞에 public이 있기에 생성 가능
		
		//b1.setTitle("자바기본문법");
		// 클래스 명이 같더라도, 다른 패키지에 있는 디폴트 접근제한자 메소드에는 접근 불가 (public이 없는 타입의 메소드를 디폴트 접근제한자라 부른다)
		// b1.title = "자바기본문법";
		// title 또한, 타입 앞에 public이 있기에 패키지가 다르더라도 사용 가능 (문제2로 의해 title 접근 제한자를 private로 수정했음)

		b1.settitle("자바기본문법"); /*문제 2
			public title을 private로 변경하자 b1.title을 사용할 수 없게되었으므로
		 	public 메소드를 생성하여 title값을 변경하였다. */
		
		System.out.println(b1.gettitle());
		
		// b1.author = "엘컴퓨터학원";
		// author는 private 접근 제한자 인스턴스 변수기에 불러올 수 없다
		
		b1.setAuthor("엘컴퓨터학원");
		//System.out.println(b1.author); → author가 private라 다른 패키지에서 접근 불가
		System.out.println(b1.getAuthor());
		/* 즉, 동일한 클래스에서 생성된 인스턴스라도 다른 패키지에 있을 경우 private 접근제한자가 걸려있는 메소드나 변수가 직접적인 접근이 불가하며,
		   이와 같이 public 접근제한자 메소드 등을 통해 접근하여야 한다. 
		 */
		// Tip) 값을 셋팅하는 메소드를 세터(setter), 값을 불러오는 메소드를 게터(getter)라 부른다
		
		b1.setPrice(50000);
		//b1.setDollarPrice(50000); → 호출 메소드가 private 접근제한자이다. private 메소드에 접근할 때도 public 메소드를 통해 경유해야한다.
		System.out.println(b1.getPrice());
		System.out.println(b1.getDollarPrice());
		// 위와 마찬가지로, public 메소드를 통해 private 변수에 접근
		
		//b1.edition = 3; → edition이 디폴트 접근제한자이기에 패키지가 달라서 접근 불가
		
		//b1.tax = 1.1f; → tax 인스턴스 변수는 protected 변수이기에 접근 불가
		//b1.setTax(1.1f);
		
		EBook5 eb1 = new EBook5();
		
		eb1.setPrice(30000);
		//eb1.tax = 1.1f;
		eb1.setTax(1.1f);
		System.out.println("세금 적용된 가격: " + eb1.getPrice() * eb1.getTax());
		
		
		eb1.setPrice(200000);
		System.out.println(eb1.getDollarPrice());
	}

}

class EBook5 extends Book {
	String fontColor;
	
	/*
	void setEdition(int edition) {
		this.edition = edition;
	}
	*/
	
	@Override
	protected void setTax(float tax) {
		this.tax = tax+0.1f;
		//tax 인스턴스변수는 protected 접근 제한자이지만 Ebook5가 상속을 받았기 때문에 사용 가능
	}
	
	@Override
	protected float getTax() {
		return tax;
	}
	
	@Override // 문제3 
	public void setPrice(int price) {
		super.setPrice(price);
		this.dollarPrice = super.dollarPrice*1000;
		this.dollarPrice = super.dollarPrice-5000;
		// setDollarPrice에 접근하기 위해선 부모클래스의 setPrice메소드에 접근이 필요하기에 super사용
		
		
	}
			
		
}

/*
문제1.
setEdition 메소드의 오류를 수정하세요.
→ setEdition 메소드의 인스턴스 변수 edition이 default 접근 제한자이므로
 	패키지가 달라서 접근이 불가하다. 따라서, edition 인스턴스 변수를 protected나 public접근 제한자로 변경해주어야 한다.
 


문제2.
Book클래스의 title 변수를 private로 수정 후 발생되는 main메소드의 오류를 수정하세요. 

문제3.
EBook5 클래스에 Book클래스의 setPrice 메소드를 오버라이딩 하세요.
e북은 입력된 가격보다 5000원 낮은 금액으로 price가 설정되어야 합니다.
setPrice 메소드 내에서 setDollarPrice 메소드를 호출하여 dollarPrice를 설정하세요.
setDollarPrice 메소드는 상속관계가 아닌 클래스에서 접근할 수 없어야 합니다.
힌트) setDollarPrice메소드와 dollarPrice 변수의 접근 제한자를 수정하세요.
*/