package cha17;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex01Listtest {
	public static void main(String[] args) {
		Book22[] arrBook = {
				new Book22("1", "엘컴퓨터학원"), 
				new Book22("2", "자바"),
				new Book22("3", "엘컴퓨터학원"),
				new Book22("4", "자바"),
				new Book22("5", "자바"),
				new Book22("6", "엘컴퓨터학원"),
				new Book22("7", "자바"),
				new Book22("8", "엘컴퓨터학원"),
				new Book22("9", "엘컴퓨터학원"),
				new Book22("10", "자바"),
			};
		List<Book22> books = new ArrayList<Book22>(Arrays.asList(arrBook));
		
		//Book22.printAllBooksWithForEach(books);
		Book22.removeWithIterator(books);
		
		System.out.println(books);
		// Set말고 List(ArraysList)도 마찬가지로 인스턴스의 요소(문자열, 인스턴스 변수 등)를 저장하고 있다면 .toSting을 따로 오버라이딩하지 않았고 문자열을 저장 하고 있다면 문자열이 출력될테지만 인스턴스를 저장하고 있다면 주소가 출력됨 
		// 따라서, List나 Set이 저장하고 있는 인스턴스의 요소(문자열, 인스턴스 변수 등)들을 출력하고 싶다면 출력해주는 메소드를 생성하거나 .toSting을 오버라이딩 해 요소(문자열, 인스턴스 변수 등)들을 출력하자

		String d [] = {"d", "s"};
		List<String> aa = new ArrayList<String>(Arrays.asList(d));
		System.out.println(aa);
	}
}
class Book22 {
	private String title;
	private String author;
	
	public Book22(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	/*@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}*/
	public static void printAllBooksWithForEach(List<Book22> books) {
		System.out.println("foreach");
		for (Book22 book : books) {
			System.out.println(book);
			
		}
	}
	public static void removeWithIterator(List<Book22> books) {
		for (Iterator<Book22> it = books.iterator(); it.hasNext(); ) {
			Book22 book = it.next(); 
			if 
				(!(book.getAuthor().equals("엘컴퓨터학원"))) 
				it.remove(); 
				/// 이 때의 remove는 it에만 영향을 주는 게 아닌 it의 값에 대응하는 books의 값도 삭제하는가 : yes (기본 컬렉션에서 제거한다)
		}
		System.out.println(books.toString());
	}
}
/*
문제 1.
Book 타입 인스턴스 10개를 생성하여 배열에 저장합니다.
배열을 ArrayList로 변경합니다.
foreach 문을 사용하여 리스트에 저장된 모든 책들을 출력합니다.
Book의 저자가 엘컴퓨터학원인 것을 제외한 나머지 책은 모두 삭제합니다.
리스트에 남아 있는 책들을 출력합니다.
힌트) 삭제 시 foreach문은 예외가 발생될 수 있습니다.
*/