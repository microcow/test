package cha13;
import java.util.Objects;
public class Ex03HashCode {
	public static void main(String[] args) {
		Book5 b1 = new Book5("자바 기본문법", "엘컴퓨터학원");
		Book5 b2 = new Book5("자바 기본문법", "엘컴퓨터학원");
		Book5 b3 = new Book5("자바 객체지향", "엘컴퓨터학원");
		
		System.out.println(b1.hashCode());
		// hashcode 메소드 호출 시 해당 인스턴스의 주소(고유식별자)가 16진수로 return된다.
		System.out.println(b2.hashCode());
		System.out.println(b3.hashCode());
		System.out.println();
		
		Book6 b4 = new Book6("자바 기본문법", "엘컴퓨터학원");
		Book6 b5 = new Book6("자바 기본문법", "엘컴퓨터학원");
		Book6 b6 = new Book6("자바 객체지향", "엘컴퓨터학원");
		Book6 b7 = new Book6("자바 객체지향", "엘컴퓨터학원");
		
		System.out.println(b4.hashCode());
		System.out.println(b5.hashCode());
		System.out.println(b6.hashCode());
		System.out.println(b7.hashCode());
		System.out.println();
		// hashCode 메소드를 오버라이딩 했기에 b4와 b5, b6와 b7이 같은 주소로 출력된다.
		
		String s1 = new String("자바 문법");
		String s2 = new String("자바 문법");
		String s3 = new String("자바 알고리즘");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println();
		
		System.out.println(System.identityHashCode(s1));
		// identityHashCode 메소드는 실질적인 인스턴스의 해시코드를 받아볼 수 있다
		// 해당 메소드는 오버라이딩 할 수 없다.
		// 즉, hashCode 메소드가 오버라이딩 되었더라도 해당 메소드를 통해 주소(고유식별자)를 return받을 수 있다.	
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println();
		
		System.out.println(System.identityHashCode(b1));
		System.out.println(b1.hashCode());
		System.out.println(System.identityHashCode(b2));
		System.out.println(b2.hashCode());
		System.out.println(System.identityHashCode(b3));
		System.out.println(b3.hashCode());
		// ★ hashCode를 오버라이딩해서 사용하지 않았다면, hashCode 메소드와 identityHashCode메소드 호출 시 동일한 값이 출력된다.
		
	}
}

class Book5 {
	private String title;
	private String author;
	
	public Book5(String title, String author) {
		this.title = title;
		this.author = author;
	}	
}

class Book6 {
	private String title;
	private String author;
	
	public Book6(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, title);
		// ★ Objects.hash()는 괄호안의 값에 대해 해쉬코드를 만들어주며, 해당 값과 동일하게 입력하면 같은 해쉬코드를 return해주는 메소드이다.
		/* 즉, author와 title의 값이 ("자바 객체지향", "엘컴퓨터학원")이라면,("자바 객체지향", "엘컴퓨터학원")이라는 해시코드 값을 만들어주며,
		 ("자바 객체지향", "엘컴퓨터학원")을 Objects.hash로 호출할 경우 모두 동일한 해시코드 값을 return한다. */
		// 순서가 Objects.hash(title, author);로 바뀌면 동일한 해시코드 값이 안된다.
		// 클래스, 인스턴스 변수 등이 달라도 Objects.hash에 넘기는 값(내용물)만 같다면, 동일한 해시코드를 return한다
		
	}
}
