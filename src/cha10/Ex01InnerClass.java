package cha10;

public class Ex01InnerClass {
	public static void main(String[] args) { 
		EBook book = new EBook();
		book.setTitle("자바 알고리즘");
		book.setAuthor("엘컴퓨터학원");
		book.setTax(1.1f);
		book.setCountry(EBook.TaxCalculator.USA);
		// ★ 스태틱(static)+상수(final)에 한해 아우터클래스명.이너클래스명.변수명으로 이너클래스의 변수에 접근이 가능하다 
		/// 이너클래스에서 이너클래스에 있는 static 메소드는 접근가능? : 불가
		/// 아우터 인스턴스 혹은 아우터 클래스가 바로 이너클래스로 접근하진 못하는가? : yes
		book.setPrice(50000);
		book.print();
		System.out.println();
		
		// EBook.TaxCalculator calc = new TaxCalculator();
		EBook.TaxCalculator calc1 = book.new TaxCalculator();
		// ★ 이너클래스 인스턴스 생성방법 : 아우터클래스.이너클래스 인스턴스명 = 아우터클래스인스턴스명.new 이너클래스명();
		EBook.TaxCalculator calc2 = book.new TaxCalculator();
		// ★ calc1과 calc2는 book이라는 아우터클래스의 인스턴스에 의해 생성되었기에 아우터클래스에만 있는 변수 출력 시 book의 값이 출력된다.
		// 이너클래스 인스턴스는 아우터클래스의 인스턴스변수와 성격이 같다.
		// 하나의 아우터인스턴스는 여러개의 이너인스턴스를 가질 수 있다.
		calc1.calcName = "계산기1";
		calc2.calcName = "계산기2";
		// 아우터클래스에도 calcName 인스턴스 변수가 있었더라도 이너클래스가 우선순위를 가진다. (메소드 호출도 마찬가지) 
		System.out.println(calc1.calcName);
		System.out.println(calc2.calcName);
		
		calc1.setTotalPrice(); //★ 이너클래스에서 아우터클래스 메소드 호출이 가능하다.
		System.out.println(book.getAmount());
		
	
		
	}

}

class EBook {
	private String title;
	private String author;
	private int price;
	private float tax;
	private int country;
	private int amount;
	
	class TaxCalculator { 
		// 클래스 내에 클래스가 있는 것을 이너클래스라 한다
		// 상위 클래스의 객체와는 거리가 있고 굳이 따로 클래스를 생성하기도 애매할 때 이너클래스를 사용
		// 안쪽에 위치한 클래스를 이너클래스(인스턴스 이너클래스), 바깥에 위치한 상위 클래스를 아우터클래스라 한다
		// 이너클래스의 성격은 인스턴스 변수와 같기 때문에 아우터클래스에서 인스턴스 생성을 하지 않으면 사용이 불가하다.
		// ★ 이너클래스에서 아우터클래스의 private접근제한자에 접근이 가능하다
		public String calcName;
		private float tax;
		static int a; /// static 변수 생성가능 이유? : (버전이 올라가서그럼 1.8에선 불가능)
		public static final int KOREA = 1;
		public static final int USA = 2;
		public static final int UK = 3;
		// 이너클래스에 접근하기 위해선 아우터클래스의 인스턴스를 생성 후 이너클래스의 인스턴스를 생성하여, 해당 이너클래스 인스턴스를 통해 접근해야한다.
		// 예외)스태틱(static)+상수(final)에 한해 아우터클래스명.이너클래스명.변수명으로 접근이 가능하다
		/* 이너클래스는 static 변수를 생성할 수 없다(static은 프로그램 구동과 동시에 메모리에 저장되나, 그땐 이너클래스가 생성되지 않았기 때문)
			단, 이너클래스가 static 클래스일 경우 static 변수 생성이 가능하다.*/
		
			void setTotalPrice() { // 메소드도 마찬가지로, 아우터클래스 인스턴스 생성 후 이너클래스 인스턴스를 생성한 다음 이너클래스 인스턴스로 접근이 가능하다
			switch (country) {
				case KOREA:
					tax = 0f;
					// 이너클래스의 변수가 아우터클래스에도 있을 경우, 이너클래스의 변수가 우선순위를 가지게 된다.
					// 마찬가지로 동일한 메소드이름이 있을 경우 이너클래스가 우선순위를 가진다.
					break;
				case USA:
					tax = 0.1f;
					break;
				case UK:
					tax = 0.2f;
					break;
				default:
					tax = 0.3f;
			}
			EBook.this.amount = (int)(price * (EBook.this.tax + tax));//= 아우터클래스 tax + 이너클래스 tax
			// this.amount라고 했다면 이너클래스의 amount를 나타내지만 아우터클래스.this.amount이기에 아우터클래스의 amount변수를 나타낸다
			// 다만, 해당 이너클래스에는 amount변수가 없기에 그냥 this.amount라고 적었어도 아우터클래스의 amount를 나타냈을 것이다
			// 그 예로 price는 아우터클래스에만 존재하는 변수이기에 해당 price는 아우터클래스에 있는 price를 나타낸다	
		}
			static void test() { ///static 메소드는 생성가능한 이유 : (버전이 올라가서그럼 1.8에선 불가능)
				
			}
		
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

	public void setPrice(int price) {
		this.price = price;
		EBook.TaxCalculator calc = this.new TaxCalculator();
		calc.setTotalPrice();
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public int getCountry() {
		return country;
	}
	
	public String getCountryString() {
		String str;
		
		switch (country) {
			case TaxCalculator.KOREA:
				str = "KOREA";
				break;
			case TaxCalculator.USA:
				str = "USA";
				break;
			case TaxCalculator.UK:
				str = "UK";
				break;
			default:
				str = "기타";
		}
		return str;
	}

	public void setCountry(int country) {
		this.country = country;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void print() {
		System.out.println("책이름: " + title);
		System.out.println("저자: " + author);
		System.out.println("가격: " + amount);
		System.out.println("판매국가: " + getCountryString());
	}
}
