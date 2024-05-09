package cha13;

public class Ex02Equalstest {
	public static void main(String[] args) {
		Book02 book2 = new Book02("java", "equals", "lcoumputer");
		Book02 book3 = new Book02("java", "equals", "lcoumputer");
	
		System.out.println(book2);
		System.out.println(book3);
		System.out.println(book2.equals(book3));
	}
	

}
class Book02{
	private String title;
	private String name;
	private String edition;
	
	public Book02(String title, String author, String edition) {
		this.title = title;
		this.name = author;
		this.edition = edition;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book02)) 
			return false;
		Book02 book = (Book02)obj;
		
		return title.equals(book.title) && name.equals(book.name) && edition == book.edition;
	}
	@Override
	public String toString() {
		return "Book3 [title=" + title + ", author=" + name + ", edition=" + edition + "]";
	}
}
class Book03{
	private String title;
	private String name;
	private String edition;
	
	public Book03(String title, String author, String edition) {
		this.title = title;
		this.name = author;
		this.edition = edition;
	}
	@Override
	public String toString() {
		return "Book3 [title=" + title + ", author=" + name + ", edition=" + edition + "]";
	}
} //
/*
문제 1.
원하는 클래스를 만드세요.
인스턴스 두 개를 생성하세요.
equals 메소드를 오버라이딩하여 인스턴스 변수들의 값이 모두 같을 시 true 를 반환하도록 코딩하세요. 
*/