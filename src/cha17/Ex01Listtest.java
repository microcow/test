package cha17;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ex01Listtest {
	public static void main(String[] args) {
		Book2[] arrBook = {
				new Book2("1", "엘컴퓨터학원"), 
				new Book2("2", "자바"),
				new Book2("3", "엘컴퓨터학원"),
				new Book2("4", "자바"),
				new Book2("5", "자바"),
				new Book2("6", "엘컴퓨터학원"),
				new Book2("7", "자바"),
				new Book2("8", "엘컴퓨터학원"),
				new Book2("9", "엘컴퓨터학원"),
				new Book2("10", "자바"),
			};
		List<Book2> books = new ArrayList<Book2>(Arrays.asList(arrBook));
		//Book2.printAllBooksWithForEach(books);
		Book2.removeWithIterator(books);
	}
}
class Book2 {
	private String title;
	private String author;
	
	public Book2(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}
	public static void printAllBooksWithForEach(List<Book2> books) {
		System.out.println("foreach");
		for (Book2 book : books) {
			System.out.println(book);
			
		}
	}
	public static void removeWithIterator(List<Book2> books) {
		for (Iterator<Book2> it = books.iterator(); it.hasNext(); ) {
			Book2 book = it.next(); 
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