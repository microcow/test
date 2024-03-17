package cha13;

import java.lang.reflect.Array;
import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		Book12 book = new Book12();
		test11 test = new test11();
		String[] test2 = {"d"};
		String test3 = "ds";
		StringBuffer text = new StringBuffer();
		System.out.println(text);
		
		book.title = "";
		book.author = "";
		book.edition = 0;
		
		test.a = "";
		test.title = "s";
		System.out.println(book.equals(test));
		
		book = test;
		System.out.println(book.equals(book));
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
			if (!(obj instanceof Book4)) {
				return false;
			}
			else {
				Book4 book = (Book4)obj;
			}
			
			return true;//title.equals(book.title) && author.equals(book.author) && edition == book.edition;
		}
	}
class test11 extends Book12{
	String a;
	
}