package cha13;

public class test {
	public static void main(String[] args) {
		Book12 book = new Book12();
		test11 test = new test11();
		
		book.title = "";
		book.author = "";
		book.edition = 0;
		
		test.a = "";
		test.title = "s";
		System.out.println(book.equals(test));
		
		book = test;
		System.out.println(book.equals(book));
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