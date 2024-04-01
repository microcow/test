package cha19;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Ex04Stream {
	
	// Stream이란 저장 요소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 반복자이다.
	// 명령형이 아닌 선언형으로 Collection의 내용을 조회하고 수정하게 해주는 클래스가 Stream이다.
	// ★ 내부 반복자를 사용하므로 병렬 처리가 쉽다 (!= 외부 반복자 : 코드로 직접 컬렉션의 요소를 반복해서 가져오는 방식)
	/* ★ 내부 반복자를 사용하므로 요소의 수만큼 하나씩 참조해서 람다식을 실행한다.
	     기본적으로 요소의 수만큼 실행하지만 요소가 없거나 실행 횟수에 제한을 두고 싶을 경우 limit로 실행 횟수를 제한해두어야한다.*/
	
	// Stream의 메소드 중 return 타입이 Stream인 경우 중간연산자(of, limit, generate 등)에 해당한다.
	/* Stream의 메소드 중 return 타입이 void거나 Stream을 return하지 않는 메소드(foreach 등)를 최종연산자라고 하며,
	 *  ★★ 최종연산자 메소드를 호출한 Stream의 인스턴스는 재사용이 불가하다.(★ 하나의 Stream인스턴스를 가지고 최종연산자 두번 호출 불가 ★)
	 *  ★★ 즉, Steam은 일회성 객체이며, 재사용을 하고싶다면 동일한 식으로 재생성해야한다 (단, 최종연산자 호출 전 중간연산자는 반복호출 가능)
	 */
	
	public static void main(String[] args) {
		System.out.println("< of >");
		Stream<String> stream = Stream.of("hi", "hello", "안녕하세요");
		// ★ Stream의 of 메소드는 아규먼트의 내용들이 저장된 Stream 인스턴스를 return한다.
		stream.forEach(str -> System.out.print(str + ", "));
		// ★ Steam의 forEach 메소드는 호출자의 요소를 하나씩 파라미터에 저장한다 (요소의 수만큼 반복)
		// 또한, forEach 메소드는 Consumer 타입과 유사하게, 파라미터를 받지만 return하지 않는다.
		// ★★ stream.forEach(str -> System.out.print(str + ", ")); → 에러. 하나의 Stream인스턴스를 가지고 최종연산자 두번 호출 불가
		System.out.println("\n");
		
		System.out.println("< generate >");
		Stream<Integer> lottoStream = Stream.generate(() -> (int)(Math.random()*45)+1).limit(6);
		// ★ Stream의 generate 메소드는 파라미터는 없고, 실행한 식의 결과를 제네릭타입의 요소로 가지고 있는 Stream인스턴스를 return하는 메소드이다
		// 즉, (int)(Math.random()*45)+1).limit(6)의 결과를 요소로 가지고 있는 Stream을 return한다.
		// ★ Stream은 제한을 두지 않을경우 지속적으로 반복하여 실행한다.
		// ★ limit 메소드는 아규먼트의 수만큼만 반복하도록 한다. ((int)(Math.random()*45)+1))의 결과값이 Stream이기에 .limit메소드 호출 가능
		
		lottoStream.forEach(System.out::println);
		System.out.println();
		
		
		System.out.println("< iterate >");
		Stream // .으로 식을 계속 연결해 나가는 것을 파이프라인이라 한다. 첫번째 .메소드()의 결과 값에 두번째 .메소드() 실행 또 그 결과값에 세번째 .메소드()를 실행하는 방식 
			.iterate(1, i -> i+1) // iterate 메소드는 첫번째 아규먼트를 두번째 아규먼트에 저장 후 Stream에 저장한다. 그 후 오버라이딩 한 식을 실행하고 결과를 Stream에 저장하고 식을 재실행한다.
			.limit(45)
			.forEach(i -> System.out.print(i + ","));		
		/* 위 식을 풀어서 작성해보자면
		 * (Stream.iterate(1, i -> i+1).limit(45)).forEach(i -> System.out.print(i + ",")); 와 동일하다
		 * 식을 위쪽 예시와 같이 더욱 풀어보자면
		 * Stream<Integer> test = Stream.iterate(1, t -> t+1);
		 *	test.forEach(t -> System.out.println(t + ","));
		 * 이런 식이 되지만, 최종연산자를 사용한 인스턴스는 재활용이 불가능한 Stream 특성에 따라 새로운 인스턴스를 생성(형체는 없는)하여 즉시 최종연산자까지 사용 
		 */
		// 즉 첫번째 메소드 실행(중간 연산자)의 결과를 가지고 두번째 메소드 실행(중간 연산자) 후 그 결과를 가지고 세번째 메소드 실행(최종 연산자)

		// forEach는 결과 값에 수정("," 문자열 추가)을 하였기에 메소드 참조형 사용 불가하여 람다식 사용 (만약 수정하지 않았다면 forEach(System.out::print)같이 메소드 참조형 사용 가능)
		
		
		System.out.println("\n");
		
		
		
		System.out.println("< IntStream >");
		// IntStream 예제 1
		IntStream intStream = new Random()
			.ints(1, 45)
			.limit(6);
		intStream.forEach(System.out::println);
		// Random의 ints 메소드는 아규먼트 첫번째 정수에서 두번째 정수(-1)사이의 값을 랜덤하게 누적 후 IntStream타입으로 return한다.
		// IntStream은 Int만을 위한 Stream 인터페이스이다.
		System.out.println();
		
		// IntStream 예제 2
		Random A = new Random();		
		IntStream B;
		B = (A.ints(1, 45)).limit(6);
		B.forEach(System.out::println);
		// 위 식을 풀어쓰면 다음과 같다.
		System.out.println();
			
		// IntStream 예제 3
		((new Random().ints(1, 45)).limit(6)).forEach(System.out::println);
		// 위 식을 한줄로 쓰면 다음과 같다 (위 셋 모두 같은 코드)
		
		
		List<EBook> ebooks = new ArrayList<>();
		ebooks.add(new EBook("자바 기본문법", 50000, EBook.Category.LANG));
		ebooks.add(new EBook("자바 알고리즘", 30000, EBook.Category.APP));
		ebooks.add(new EBook("파이썬 기본문법", 35000, EBook.Category.LANG));
		ebooks.add(new EBook("파이썬 기본문법", 33000, EBook.Category.LANG));
		ebooks.add(new EBook("파이썬 기본문법", 33000, EBook.Category.LANG));
		ebooks.add(new EBook("리눅스", 40000, EBook.Category.APP));
		//ebooks.add(new EBook("데이터베이스", 50000, EBook.Category.APP));
		
		System.out.println("< forEach >");
		ebooks
			.stream() 
			.forEach(System.out::println);
		System.out.println();
		// Collection의 .stream() 메소드는 호출자를 stream타입으로 변환시켜 retrun해준다. (ebooks.stream()의 retrun값이 stream타입인 거지, ebooks 자체는 List타입임)
		Stream<EBook> test = ebooks.stream();
		
		
		System.out.println("< filter >");
		// 파이프라인으로 시퀀스를 정하고 최종연산 시 필터링 및 출력됩니다. 
		ebooks
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))	// 중간연산 (intermediate operation)
			.forEach(System.out::println);		// 최종연산 (terminal operation)
		System.out.println();
		// ★★ filter 메소드는 호출자의 요소를 하나씩 파라미터에 저장 후 식이 ture인 요소만 누적 저장하여 Stream타입으로 return한다.(요소의 수만큼 반복)
		
		(ebooks.stream().filter(b -> b.getCategory().equals(EBook.Category.LANG))).forEach(System.out::println);
		// 위 filter 코드와 동일
		
		
		
		System.out.println("< findFirst >");
		Optional<EBook> findFirstEB = // Optional 클래스는 선언형 프로그래밍방식으로 null 여부를 확인해주는 클래스이다
			ebooks
				.stream()
				.filter(eb -> eb.getTitle().startsWith("자바"))
				.findFirst();
		// findFirst 메소드는 가장 첫번째 저장된 값을 Optional 타입으로 return한다.
		System.out.println(findFirstEB.toString()); // Optional 클래스의 toString
		System.out.println((findFirstEB.get()).toString()); // Ebook 클래스의 toString
		// Optional의 get메소드는 Optional 인스턴스의 요소를 return된다.
		
		System.out.println();
		
		
		System.out.println("< findAny >");
		Optional<EBook> findAnyEB =
			ebooks
				.stream()
				.filter(eb -> eb.getTitle().startsWith("자바"))
				.findAny(); // stream타입을 Optional 타입으로 return한다. (null 여부 체크를 위해 Optional 타입으로 변경)
		/// findAny와 findFirst의 차이는 병렬스트림에서 배운 후 차이점 적기
		System.out.println(findAnyEB.get());
		System.out.println();
		
		
		System.out.println("< anyMatch >");
		boolean isMatched =
			ebooks
				.stream()
				.anyMatch(eb -> eb.getTitle().startsWith("자바"));
		// anyMatch 메소드는 호출자의 요소 중 식의 내용에 하나라도(any) true가 있을 경우 true를 return한다.
		System.out.println(isMatched);
		System.out.println();
		
		
		System.out.println("< allMatch >");
		boolean isMatched2 =
			ebooks
				.stream()
				.allMatch(eb -> eb.getPrice() > 0);
		// anyMatch 메소드는 호출자의 요소 모두(all) 식이 true일 경우 true를 return한다.
		System.out.println(isMatched2);
		System.out.println();
		
		
		
		System.out.println("< noneMatch >");
		boolean isMatched3 =
			ebooks
				.stream()
				.noneMatch(eb -> eb.getTitle().startsWith("데"));
		// anyMatch 메소드는 호출자의 요소 모두 식이 false일 경우 true를 return한다.
		System.out.println(isMatched3);
		System.out.println();
		
		
		
		System.out.println("< limit >");
		// 파이프라인으로 시퀀스를 정하고 최종연산 시 필터링 및 출력됩니다. 
		ebooks
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))
			.limit(2)
			// filter에 limit을 걸 경우 filter가 반복실행하지만, filter 식의 true가 limit 아규먼트 수만큼 나올 경우 까지만 반복한다
			// 즉, EBook.Category가 LANG인 요소를 2개찾았을 경우 filter 반복실행 중지
			.forEach(System.out::println);
		System.out.println();
		
		
		
		System.out.println("< distinct >");
		ebooks
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))
			.distinct()
			// distinct 메소드는 stream의 요소를 중복 처리하는 메소드이다
			// 이 때 equals와 Hashcode 메소드를 오버라이딩 하지 않는다면 주소를 가지고 중복처리한다.
			.forEach(System.out::println);
		System.out.println();
		
		
		
		System.out.println("< map >");
		ebooks
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))
			.map(EBook::getTitle)		// b -> b.getTitle()
			// map 메소드는 Map과는 다름
			// map 메소드는 아규먼트의 값들로 이루어진 Stream이 return된다.
			// 즉, ebooks에는 EBook타입의 인스턴스들이 저장되어있었으나, map으로 인해 filter로 걸러진 요소들의 제목들이 저장되었다
			.forEach(System.out::println);
		System.out.println();

		// 17:00분 파이프라인은 요소를 순서대로 도나?
		System.out.println("< peek >");
		ebooks
			.stream()
			.filter(b -> b.getCategory().equals(EBook.Category.LANG))
			.peek(b -> System.out.println("peek1 -> " + b))
			.map(EBook::getTitle)		// b -> b.getTitle()
			.peek(s -> System.out.println("peek2 -> " + s))
			// peek은 중간연산자이며, 요소를 확인할 수 있다.
			.forEach(System.out::println);
		System.out.println();
		
		
		
		System.out.println("< flatMap >");
		Stream<String> stream2 = Stream.of("A:90", "B:80", "C:100");
		stream2
			.flatMap(s -> Arrays.asList(s.split(":")).stream())
			.forEach(System.out::println);
		System.out.println();
	}

}

class EBook implements Comparable<EBook> {
	public enum Category {
		LANG, APP
	}
	private String title;
	private int price;
	private Category category;
	
	public EBook(String title, int price, Category category) {
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
	public int compareTo(EBook b) {
		return title.compareTo(b.title);
	}
	@Override
	public int hashCode() {
		return Objects.hash(title, price, category);
	}
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof EBook))
			return false;
		EBook eb = (EBook)o;
		return title.equals(eb.getTitle()) && (price == eb.price) && category.equals(eb.getCategory());
	}

}
