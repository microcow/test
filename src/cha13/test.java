package cha13;
import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		Book12 book = new Book12();
		test11 test = new test11();
		String[] test2 = {"d"};
		String test3 = "dsㅇ";
		StringBuffer text = new StringBuffer();
		System.out.println(text);
		
		book.title = "1";
		book.author = "1";
		book.edition = 0;
		
		test.a = "1";
		test.title = "1";
		System.out.println(book.title.equals(test.a));
		// 인스턴스간 서로 클래스가 달라도 인스턴스 변수 내용의 문자열이 동일하다면 true가 return
		/// 호출자가 인스턴스 변수이므로 오버라이딩 equals가 호출되지 않은건가
		
		book = test;
		System.out.println(book.equals(test));
		System.out.println(Arrays.toString(test2));
		System.out.println(test3.toString());
		
		
		
		// 현재 now원이 있고 요금 충전 시 plus만큼의 추가 충전 혜택이 있을 때 target금액을 달성하기 까지 필요한 충전 금액 = money
		int now = 1230;
		float plus = 0.05f;
		int target = 40950;
		int money = 0;	
		
		for (int a=0; a<target; a+=100) {
			if ((a+(a*plus)+now) >= target) {
				money = a;
				break;
			}		
		}
		System.out.println(money);
		
	}
	
}
	class Book12 {
		public String title;
		public String author;
		public int edition;

		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Book12)) {
				return false;
			}	
			return true;//title.equals(book.title) && author.equals(book.author) && edition == book.edition;
		}
	}
class test11 extends Book12{
	String a;
	
}