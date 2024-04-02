package cha19;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
public class Ex05Reduction {
	public static void main(String[] args) {
		
		// 리덕션이란 스트림에 저장되어있는 요소를 단일 결과로 반환하는 것이다
		
		List<EBook> ebooks = new ArrayList<>();
		ebooks.add(new EBook("자바 기본문법", 50000, EBook.Category.LANG));
		ebooks.add(new EBook("자바 알고리즘", 30000, EBook.Category.APP));
		ebooks.add(new EBook("파이썬 기본문법", 35000, EBook.Category.LANG));
		ebooks.add(new EBook("파이썬 기본문법", 33000, EBook.Category.LANG));
		ebooks.add(new EBook("파이썬 기본문법", 33000, EBook.Category.LANG));
		ebooks.add(new EBook("리눅스", 40000, EBook.Category.APP));
		
		System.out.println("*** Reduction ***");
		System.out.println("< average >");
		double avgPrice =
			ebooks
				.stream()
				.filter(b -> b.getCategory().equals(EBook.Category.LANG))
				.mapToInt(EBook::getPrice) // = .mapToInt(st -> st.getPrice())
				// mapToInt 메소드는 Stream을 intStream 타입으로 return한다. (즉, 문자열은 return불가)
				.average()
				// average 메소드는 Stream이나 intStream의 요소 평균 값을 OptionalDouble클래스로 return한다 (Optional은 null을 확인하기 위한 클래스)
				.getAsDouble();
				// getAsDouble은 OptionalDouble 타입의 인스턴스에 저장되어있는 값을 return한다 (기본형을 위한 Optional일 경우 getAs기본형() 으로 요소를 받아와야한다)
		System.out.printf("%,.0f원%n", avgPrice);
		System.out.println();
		
		System.out.println("< sum >");
		int sumPrice =
			ebooks
				.stream()
				.filter(b -> b.getCategory().equals(EBook.Category.LANG))
				.mapToInt(EBook::getPrice)
				.sum();
				// sum 메소드는 Stream의 요소를 합산하여 Int타입으로 return한다.
		System.out.println(sumPrice);
		System.out.println();
		
		System.out.println("< count >");
		long countPrice =
			ebooks
				.stream()
				.filter(b -> b.getCategory().equals(EBook.Category.LANG))
				.mapToInt(EBook::getPrice)
				.count();
				// count 메소드는 stream의 요소가 몇개인지 return한다.
		System.out.println(countPrice);
		System.out.println();
		
		System.out.println("< max >");
		long maxPrice =
			ebooks
				.stream()
				.filter(b -> b.getCategory().equals(EBook.Category.LANG))
				.mapToInt(EBook::getPrice)
				.max()
				// 최대값을 OptionalInt타입으로 return한다.
				.getAsInt();
				// getAsInt은 OptionalDouble 타입의 인스턴스에 저장되어있는 값을 return한다 (기본형을 위한 Optional일 경우 getAs기본형() 으로 요소를 받아와야한다)
		System.out.println(maxPrice);
		System.out.println();
		
		System.out.println("< reduce >");
		int sumPriceTax =
			ebooks
				.stream()
				.filter(b -> b.getCategory().equals(EBook.Category.LANG))
				.mapToInt(EBook::getPrice)
				.reduce(0, (a, b) -> a+(int)(b*1.1f));
		// 여기서의 reduce메소드는 int타입과 IntBinaryOperator타입을 파라미터로 받고있다
		// 0은 최종결과값에 더해지는듯
		// BinaryOperator는 파라미터가 2개고 리턴이 필요할 때 사용 (단, 2개의 파라미터와 리턴타입이 일치해야한다)
		System.out.println(sumPriceTax);
		System.out.println();
		
		System.out.println("< reduce >");
		int minPrice =
			ebooks
				.stream()
				.filter(b -> b.getCategory().equals(EBook.Category.LANG))
				.mapToInt(EBook::getPrice)
				.reduce(Integer::min)
				.getAsInt();
		System.out.println(minPrice);
		System.out.println();
		
		System.out.println("< reduce >");
		EBook maxEBook =
			ebooks
				.stream()
				// 컬렉션 사용 시 accumulator(누산기) 실행 횟수 만큼 컬렉션을 생성하므로 성능이 좋지 않음.
				.reduce((a,b) -> a.getPrice() > b.getPrice() ? a : b)
				// 여기서의 reduce메소드는 IntBinaryOperator타입을 파라미터로 받고있다 retrun타입은 Optional				
				// BinaryOperator는 파라미터가 2개고 리턴이 필요할 때 사용 (단, 2개의 파라미터와 리턴타입이 일치해야한다)
				// a에는 stream에 저장되어있는 첫번째 요소가, b에는 두번째 요소가 오게된다
				// ★ 모든 요소들을 상대로 람다식이 실행된 후 최종적으로 ★하나의 값★을 return한다.
				.get(); // 참조형을 위한 Optional일 경우 get() 으로 요소를 받아와야한다
		
		/// reduce 메소드가 여러개? sumPriceTax 부분과 해당 부분의 reduce는 다르게 동작?
		
		System.out.println(maxEBook);
		System.out.println();
		
		System.out.println("< collect >");
		// collect 메소드는 stream을 collect 타입으로 변경할 때 사용한다.
		Set<Integer> priceSet =
			ebooks
				.stream()
				.map(EBook::getPrice)
				.collect(
					() -> new HashSet<Integer>(), // ★ 첫번째 아규먼트는 생성하고 싶은 collection을 작성 (첫번째 아규먼트를 서플라이어라고도 부른다)
					(set, i) -> set.add(i), 	// ★ set은 생성한 HashSet의 인스턴스가 오고 i에는 .map에서 분류했던 getPrice가 오게된다 (stream의 반복 특성에 따라 하나의 인스턴스에 하나의 값이 저장되는거임) (두번째 아규먼트를 accumulator(누산기)라고도 부른다)
					(set1, set2) -> set1.addAll(set2)); // ★ set1과 set2는 HashSet의 각각 다른 인스턴스이며 stream의 반복 특성에 따라 결국 모든 인스턴스가 addAll에 의해 하나의 인스턴스로 합쳐짐 (세번째 아규먼트를 컴바이너라 부른다)					
				
				//.collect(HashSet::new, HashSet::add, HashSet::addAll); //(위 collect 식을 메서드 참조형으로 입력)
		
		/* 위 처럼 collect메서드 내에서 데이터를 정렬하지 않고 stream타입을 collection타입으로 바로 변경하려면
		   .collect(Collectors.to컬렉션명());을 입력 (위 .collection과 다른 메소드임) (* cha19. teststream 참조)*/
		 
		
		System.out.println(priceSet);
		System.out.println();
		
		System.out.println("< ParallelStream collect >");
		// 병렬스트림
		Set<Integer> priceSet2 =
			ebooks
				.parallelStream()
				//parallelStream 메서드는 병렬 스트림을 return받는다
				.map(EBook::getPrice)
				.collect(HashSet::new, HashSet::add, HashSet::addAll);
		System.out.println(priceSet2);
		System.out.println();
	}

}
