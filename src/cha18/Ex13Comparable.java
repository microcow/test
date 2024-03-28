package cha18;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Ex13Comparable {
	public static void main(String[] args) {
		// Comparable 인터페이스는 Collection의 정렬을 도와주는 인터페이스이다.
		
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "Z", "b", "a", "g", "E");
		Collections.sort(list);
		System.out.println(list);
		// 대문자의 유니코드가 더 낮기에 오름차순으로 정렬할 경우 대문자가 먼저 출력된 후 소문자가 출력된다.
		
		List<Book3> books = new ArrayList<>();
		Collections.addAll(books, new Book3(1, "자바 문법"), new Book3(1, "파이썬 문법"), new Book3(3, "자바 컬렉션"));
		Collections.sort(books);
		// sort메소드는 요소 클래스가 Comparable 인터페이스를 구현하고 있을 경우에만 사용 가능하다.
		// sort메소드는 요소를 Comparable타입으로 업캐스팅 한 다음 compareTo메소드를 호출하는데, compareTo메소드가 오버라이딩 되어 있어야만 사용 가능하기에 요소 클래스가 Compareble 인터페이스를 구현하고 있어야한다.
		// compareTo 메소드를 오버라이딩해서 원하는 방식대로 정렬 방식을 설정할 수 있다.
		/* compareTo 메소드는 Collections클래스 뿐 아니라 String이나 Integer클래스에서도 Comparable 인터페이스를 구현 후 오버라이딩 해 사용하고 있으며,
			차이점은 여기선 요소 클래스가 Comparable인터페이스를 구현하고 있으나 compareTo를 오버라이딩하고 있지 않기에 직접 오버라이딩하였다(String이나 Integer클래스는 기본클래스이기에 오버라이딩 되어있음)
			만약 요소가 Book3가 아닌 String이나 Integer이었다면 이와 같이 직접 오버라이딩 하지 않아도 compareTo 메소드를 사용할 수 있었을 것 */
		// ★ 즉, Comparable인터페이스를 구현 중인 클래스의 인스턴스는 서로 비교(compareTo)가 가능하다 (양수,음수,0을 활용해서 비교 가능)
		// 비교 인스턴스가 Collection타입일 경우, 저장되어있는 요소들이 Comparable인터페이스를 구현하고 있을 경우 비교 가능
		System.out.println(books);
	}

}

class Book3 implements Comparable<Book3> {
	private int no;
	private String title;
	public Book3(int no, String title) {
		this.no = no;
		this.title = title;
	}
	public int getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	@Override
	public int compareTo(Book3 book) {
		int result = Integer.valueOf(no).compareTo(book.getNo()) * -1; 
		// Integer클래스의 compareTo를 호출하고있음 (숫자 비교)(Integer 클래스는 이미 conpareTo를 오버라이딩 하고 있음)
		// 그냥 int result = no - book.getNo로 작성해도 되지만 해당 방법으로도 비교 가능
		// *-1을 하면, 결과값이 반대가 되므로 내림차순으로 정렬된다. (*-1 말고 compareTo의 호출자와 아규먼트를 바꾸어도 내림차순으로 정렬 가능)
		// no는 valueOf를 통해 Interger 클래스의 인스턴스로 바뀌었고 book.getNo는 int 타입인데 둘 다 정수를 가지고 있지만 타입이 다른데 비교 가능? : yes. compareTo 파라미터가 Integer타입임
		if (result == 0)
			result = title.compareTo(book.title); // String클래스의 compareTo를 호출하고있음 (문자열 비교)(Integer 클래스는 이미 conpareTo를 오버라이딩 하고 있음)(0일 경우 no의 값이 동일하기에 문자열을 비교하고 있음)
		return result;
		// 호출자가 더 크면 양수를, 아규먼트가 더 크면 음수, 같으면 0을 return한다.		
		// ★ 오버라이딩 시 byte, char, double, short, long, int, float같은 PrimitiveType의 배열에는 적용이 불가능하니 Integer같은 Wrapper "Class"를 이용해야 한다
		
		// Integer클래스와 String클래스의 compareTo는 오름차순으로 정렬하지 않고 값을 비교만하여 결과를 return하지 않나? : yes 해당 compareTo도 동일하게 결과값(int)을 return함
		/// book에는 Book3타입 인스턴스가 3개가 있는데 반복문도 아닌데 no에는 무슨 값이 오고 book은 어떤 인스턴스인지?
			/// sort호출 시 요소 하나씩 compareTo를 호출하고 그 옆에 인덱스가 아규먼트로 오는건가
		/// return되는 result값이 양수일 경우 서로 위치를 바꾸는건가 (오름차순으로 정렬되기 때문)
		/// sort 호출 -> 오버라이딩한 compareTo로 각 요소들 비교 후 return → return된 값이 양수일 경우 비교한 대상과 위치(인덱스) 변경? 
	}
	@Override
	public String toString() {
		return "(" + no + ", " + title + ")";
	}
}
