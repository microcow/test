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