package cha18;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class Ex14Comparator {
	public static void main(String[] args) {
		List<Book4> books = new ArrayList<>();
		Collections.addAll(books, new Book4(1, "자바 문법"), new Book4(1, "파이썬 문법"), new Book4(3, "자바 컬렉션"));
		
		System.out.println("< 번호 오름차순 정렬, 제목 오름차순 정렬 >");
		Collections.sort(books, new AscendingNo());
		// sort메소드의 아규먼트가 두개 있다면, 첫번째 아규먼트가 두번째 아규먼트에 오버라이딩 되어있는 compare 메소드의 방식으로 정렬된다 (두번째 아규먼트로는 인스턴스가 와야하며, Comparator인터페이스를 구현하고 있어야한다.)
		/* ★★기본 방식으로 정렬을 하고 싶다면, 
		   '요소 클래스'가 'Comparable'인터페이스를 구현하고 있고 compareTo 메소드를 오버라이딩 한 뒤 sort 호출 시 List를 넘겨주면된다. */	
		/* ★★ 기본 방식이 아닌 사용자가 정렬 방식을 설정하고 싶다면, '두번째 아규먼트의 클래스'가 'Comparator'인터페이스를 구현하고 있고 compare 메소드를 오버라이딩 한 뒤
		    sort 호출 시 List와 정렬 방식(compare이 오버라이딩 된)클래스의 인스턴스를 넘겨주면된다. (익명클래스를 사용하고 싶다면 Comparator를 두번째 아규먼트로 입력 후 오버라이딩)*/
		// ★★ sort(아규먼트 하나)와 sort(아규먼트 둘)의 차이점은 sort(아규먼트 하나)는 정해진 기본방식 하나로만 정렬이 가능하고 sort(아규먼트 둘)은 정렬 방식을 매번 새롭게 정할 수 있다  
		// ★ 오버라이딩 시 byte, char, double, short, long, int, float같은 PrimitiveType의 배열에는 적용이 불가능하니 Integer같은 Wrapper "Class"를 이용해야 한다
		
		/// sort의 아규먼트가 하나있다면 compareTo 두개있다면 compare? compareTo는 오름/내림차순으로만 정렬 가능하고 compare은 다른 방식으로도 가능한가
		// ★ Comparator와 Comparable 인터페이스 구분하기 sort의 아규먼트가 하나 있을 경우 Comparable, 두개있을 경우 Comparator을 요소 타입의 클래스가 구현하고 있어야함
				
		
		System.out.println(books);
		System.out.println();
		
		System.out.println("< 번호 내림차순 정렬, 제목 내림차순 정렬 >");
		Collections.sort(books, new Comparator<Book4>() {
			@Override
			public int compare(Book4 b1, Book4 b2) {
				
				int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo()) * -1;
				if (result == 0)
					result = b1.getTitle().compareTo(b2.getTitle()) * -1;
				return result;
			}
		}); 
		// 이처럼 1회성 정렬 방식일 경우 익명클래스를 통해 즉시 오버라이딩해서 사용
		// 이와 같이 익명클래스를 사용하기 위해선 위와 같이 ★ Comparator를 두번째 아규먼트로 입력 ★ (new Comparator<요소타입>)
		
		System.out.println(books);
		System.out.println();
		
		System.out.println("< Comparator.reverseOrder >");
		Collections.sort(books, Comparator.reverseOrder());
		// Comparator.reverseOrder 메소드는 정렬(compareTo)을 반대로 정렬하여 Comparator타입의 인스턴스를 retrun한다
		// Comparator.naturalOrder 메소드는 오름차순
		// 첫번째 아규먼트인 Comparable을 구현하고 있는 클래스에 되어있던 정렬(compareTo)을 반대로 정렬해주는 메소드이다
		/// Comparable을 구현하고 있는 클래스의 인스턴스'만' 첫번째 아규먼트로 사용 가능? (comparator를 구현하고있는 클래스는 사용 불가?)
	
		System.out.println(books);
		System.out.println();
		
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "Z", "e", "a", "c", "b", "D");
		System.out.println(list);
		
		System.out.println("< 알파뱃 내림차순 정렬 >");
		Collections.sort(list, Comparator.reverseOrder());
		/// 반대로 정렬인데 내림차순으로 되는 이유? :
		// reverseOrder는 compareTo를 호출한 후 retrun값에 -1을 곱하는 방식임 즉, compareTo에 의해 오름차순으로 정렬되었다면 -1을 곱해 내림차순으로 정렬됨
		System.out.println(list);
		System.out.println();
		
		Comparator<String> T = Comparator.reverseOrder();
		Collections.sort(list, T);
		// 이처럼 인스턴스에 정렬 방식을 저장하여 사용할 수 있다
		System.out.println(list);
			
		T = Comparator.naturalOrder();
		Collections.sort(list, T);
		System.out.println(list);
		// Comparator.reverseOrder와 반대로 오름차순 정렬 시에는 Comparator.naturalOrder(); 메소드 사용
		// naturalOrder는 compareTo를 호출한 후 오름차순으로 정렬하는 방식 (그냥 compareTo만 호출해도 오름차순으로 정렬되긴 하다)
		
		
		System.out.println("< 대소문자 상관없이 알파뱃 오름차순 정렬 >");
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		// String.CASE_INSENSITIVE_ORDER 는 대소문자 상관없이 알파벳을 오름차순으로 정렬해준다
		System.out.println(list);
	}

}

class AscendingNo implements Comparator<Book4> {
	@Override
	public int compare(Book4 b1, Book4 b2) {
		/// 제네릭스나 파라미터 타입을 변경할 수 없는지
		int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo());
		if (result == 0)
			result = b1.getTitle().compareTo(b2.getTitle());
		return result;
	}
}

class DescendingTitle implements Comparator<Book4> {
	@Override
	public int compare(Book4 b1, Book4 b2) {
		int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo());
		if (result == 0)
			result = b1.getTitle().compareTo(b2.getTitle());
		return result;
	}
}

class Book4 implements Comparable<Book4> {
	private int no;
	private String title;
	public Book4(int no, String title) {
		this.no = no;
		this.title = title;
	}
	public int getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	
	// 번호 내림차순 정렬, 제목 오름차순 정렬
	@Override
	public int compareTo(Book4 book) {
		int result = Integer.valueOf(no).compareTo(book.getNo()) * -1;
		if (result == 0)
			result = title.compareTo(book.title);
		return result;
	}
	@Override
	public String toString() {
		return "(" + no + ", " + title + ")";
	}
	
	// Comparator.comparingInt 메서드는 아규먼트를 기준으로 정렬하는 메서드이다. (여기엔 없는 내용)
}
/* 문제는 Ex13에서 풀었습니다
문제 1.
학생들을 Comparator 를 이용해 정렬하여 출력하세요.
번호 내림차순, 이름 오름차순으로 정렬하여 출력하세요.

문제 2.
번호 내림차순, 이름 내림차순으로 정렬하는 Comparator 를 이용해 출력하세요.
Comparator 는 익명클래스로 작성하세요.

문제 3.
PriorityQueue에 책들을 입력하세요.
Queue에서 책의 가격이 높은 책 부터 제거되도록 코딩하세요.
Comparable을 이용해 가격이 높은 책부터 제거되도록 작성하세요. 
Comparator를 이용해 가격이 낮은 책부터 제거되도록 코딩하세요.
*/