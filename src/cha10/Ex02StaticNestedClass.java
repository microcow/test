package cha10;

public class Ex02StaticNestedClass {
	public static void main(String[] args) {
		
		EBook2.TaxCalculator.test2();
		
		System.out.println(EBook2.TaxCalculator.test());
		
		int price = EBook2.TaxCalculator.getTotalDollarPrice(30000, EBook2.TaxCalculator.USA);
		// ★ 스태틱 이너클래스의 메소드or변수에 접근을 위해선 아우터클래스명.이너클래스명.메소드or변수 를 입력
		 /* 이너클래스의 변수는 final+static 형태만 접근이 가능하고 메소드는 static 형태만이더라도 접근 가능?
			: 1.8버전에선 맞음 최신버전에서는 일반적인 이너클래스에서도 static이 생성가능하기에 변수, 메소드 모두 static 형태라면 접근 가능 */
		
		System.out.println(price);
		
		EBook2 eb = new EBook2();
		eb.setTitle("자바 기본문법");
		eb.setAuthor("엘컴퓨터학원");
		eb.setPrice(50000);
		eb.print();
		
		EBook2.TaxCalculator eb2 = new EBook2.TaxCalculator();
		// 스태틱 이너클래스의 인스턴스 생성 시 일반 이너클래스와 다르게 new앞에 아우터 이너클래스명을 적을 필요 없다.
		// ★ 아우터클래스명.이너클래스명 인스턴스명 = new 아우터이너클래스명.이너클래스명();	}

		System.out.println(EBook2.TaxCalculator.testnum);
		
	}
}
class EBook2 {
	private static float tax;
	private String title;
	private String author;
	private int price;
	
	static class TaxCalculator { // 프로그램 구동과 동시에 메모리에 존재한다. 
		// 클래스 앞에 static이 붙은 이너클래스를 static 이너클래스라 부른다. ///원래 클래스(아우터클래스) 생성시에는 static을 사용할 수 없다? : Yes
		// 아우터클래스명.이너클래스명으로 바로 접근이 가능하다.
		// 스태틱 이너클래스에선 스태틱 변수를 가질 수 있다 (일반 이너클래스에선 불가 → 1.8에서 불가)
		private static float tax;
		public static final int KOREA = 1;
		public static final int USA = 2;
		public static final int UK = 3;
		public String calcName;
		// 스태틱 이너클래스에서 일반 인스턴스 변수를 생성할 수 있으나, 이너클래스의 이름으로 바로 접근이 불가하다. (일반 이너클래스와 동일하게 이너클래스의 인스턴스를 생성 후 해당 이너클래스 인스턴스를 통해 접근 가능)
		static int testnum;
		
		static int getTotalDollarPrice(int price, int country) {
			// 스태틱 메소드도 가질 수 있다.
			switch (country) {
				case KOREA:
					tax = 1f;
					break;
				case USA:
					tax = 1.1f;
					break;
				case UK:
					tax = 1.2f;
					break;
				default:
					tax = 1.3f;
			}
			
			// 문제(1)의 코드를 오류가 나지 않도록 수정하세요. System.out.println(EBook2.this.price);
			//System.out.println(EBook2.this.price);
			
			return (int)(price * tax);
		}
		static int test() {
			return testnum;
		}
		static void test2() {
			EBook2.tax = 0; // 아우터 변수가 클래스변수일 경우 클래스.변수명으로 접근이 가능하다 (스태틱 클래스이기에 this 사용 불가)
			tax = 1; // 변수명이 같을 때 그냥 변수명만 적을 경우 이너클래스가 우선이다
			System.out.println(EBook2.tax);
			System.out.println(tax);
		}
		void test3() {
		}
		// 인스턴스와 마찬가지로 스태틱이 아닌 일반메소드를 생성할 수 있지만, 이너클래스의 이름으로 바로 접근이 불가하다. (일반 이너클래스와 동일하게 이너클래스의 인스턴스를 생성 후 해당 이너클래스 인스턴스를 통해 접근 가능)
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
	}
	
	public int getPrice() {
		return price;
	}
	
	public void print() {
		System.out.println("책이름: " + title);
		System.out.println("저자: " + author);
		System.out.println("가격: " + TaxCalculator.getTotalDollarPrice(price, TaxCalculator.KOREA));
								//해당 메소드는 아우터클래스에 위치해있기에 아우터클래스의 이름을 적지 않아도 된다.
	}
}