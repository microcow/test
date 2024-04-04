package cha19;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
public class Ex07ParallelStream {
	// 병렬스트림은 좋은 성능의 컴퓨터에서 빠른 작업속도를 나타낸다
	public static void main(String[] args) {
		List<EBook2> ebooks = new ArrayList<>();
		ebooks.add(new EBook2("자바 기본문법", 50000, EBook2.Category.LANG));
		ebooks.add(new EBook2("자바 알고리즘", 30000, EBook2.Category.APP));
		ebooks.add(new EBook2("파이썬 기본문법", 35000, EBook2.Category.LANG));
		ebooks.add(new EBook2("파이썬 기본문법", 33000, EBook2.Category.LANG));
		ebooks.add(new EBook2("리눅스", 40000, EBook2.Category.APP));
		
		System.out.println("< parallel stream >");
		int sum =
			ebooks
				.parallelStream()
				// parallelStream 스트림 메소드 사용 시 병렬스트림(멀티쓰레드)이 return된다
				.filter(b -> b.getPrice() < 50000)
				.mapToInt(EBook2::getPrice)
				.sum();
		System.out.println(sum);
		System.out.println();
		
		System.out.println("< groupingByConcurrent >");
		ConcurrentMap<EBook2.Category, List<EBook2>> ebMap =
			ebooks
				.parallelStream()
				.collect(Collectors.groupingByConcurrent(EBook2::getCategory));
		// ★ Collectors.groupingByConcurrent 메소드는 아규먼트를 순회하여 종류별 하나씩을 키값으로 설정하고 해당 키값과 일치하는 인스턴스를 value값으로 설정
		// Collectors.groupingBy랑 차이? : 병렬스트림일땐 groupingByConcurrent를 사용 (병렬스트림은 멀티쓰레드 환경이기에 그냥 groupingBy 사용 시 에러 발생 가능)
		for (Map.Entry<EBook2.Category, List<EBook2>> entry : ebMap.entrySet()) {
			System.out.println("- " + entry.getKey() + " -");
			for (EBook2 eb : entry.getValue()) {
				System.out.println(eb);
			}
			System.out.println();
		}
		// 위 for문은 forEach문(선언형)을 사용하지 않고 명령형으로 내용을 출력하고 있는 코드이다
		
		System.out.println("< sorted >");
		ebooks
			.stream()
			.sorted() 
			// sorted메서드는 스트림의 요소가 자연 순서(Comparable 인터페이스의 compareTo() 메소드에 의해 정의된 순서) 또는 정의된 Comparator에 따라 정렬
			/* sorted는 compareTo 메소드를 호출하는데 Ebook2가 Comparable인터페이스를 구현하고 있고 Comparable인터페이스는 compareTo가 추상클래스로 있기에
			 * Ebook2클래스에서 compareTo메소드를 오버라이딩하고있음
			 */
			/* ★ 만약, 요소 클래스가 Comparable 인터페이스를 구현하지 않은 경우에는 sorted() 메서드를 호출할 때 반드시 정렬 방식이 있는 Comparator 타입을 아규먼트로 전달하여 정렬 방식을 설정해야 합니다.
			 ★ 단, Comparator 타입이 아규먼트로 없더라도 java에서 자동으로 타입추론하기에 오류가 발생하지 않기도 하다*/
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("< parallelStream sorted forEach (정렬 안됨) >");
		ebooks
			.parallelStream()
			.sorted(Comparator.reverseOrder())
			.forEach(System.out::println);
		System.out.println();
		
		System.out.println("< parallelStream sorted forEachOrdered >");
		ebooks
			.parallelStream()
			.sorted()
			.forEachOrdered(System.out::println);
		// parallelStream(병렬스트림)은 sorted 호출 후 forEach로 결과 출력 시 정렬되지 않으며, forEachOrdered 메서드를 통해 출력하여야 정렬된 상태로 출력된다.
		// ★ forEachOrdered메서드는 순서가 보장되지 않는 병렬스트림에서 순서를 보장하며 출력해주기에 일반스트림에서는 forEach와 forEachOdered 메서드의 차이를 명백히 느끼지 못한다
		System.out.println();
		
		// 문제 1.
		System.out.println("< parallelStream sorted forEachOrdered >");
		ebooks
			.parallelStream()
			.sorted(Comparator.reverseOrder())
			.forEachOrdered(System.out::println);
		System.out.println();
	}

}

class EBook2 implements Comparable<EBook2> {
	public enum Category {
		LANG, APP
	}
	private String title;
	private int price;
	private Category category;
	
	public EBook2(String title, int price, Category category) {
		this.title = title;
		this.price = price;
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
	}
	@Override
	public String toString() {
		return "[title=" + title + ", price=" + price + ", category=" + category + "]";
	}
	@Override
	public int compareTo(EBook2 b) {
		return title.compareTo(b.title);
	}
}
/*
문제 1. 
모든 책들의 정보를 책가격 기준 내림차순 정렬하여 출력하세요.
패러렐 스트림을 이용해야 합니다.
힌트) sorted와 Comparator를 사용하세요.
*/