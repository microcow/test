package cha19;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
public class Ex06Collector {
	public static void main(String[] args) {
		List<EBook> ebooks = new ArrayList<>();
		ebooks.add(new EBook("자바 기본문법", 50000, EBook.Category.LANG));
		ebooks.add(new EBook("자바 알고리즘", 30000, EBook.Category.APP));
		ebooks.add(new EBook("파이썬 기본문법", 35000, EBook.Category.LANG));
		ebooks.add(new EBook("파이썬 기본문법", 33000, EBook.Category.LANG));
		ebooks.add(new EBook("파이썬 기본문법", 33000, EBook.Category.LANG));
		ebooks.add(new EBook("리눅스", 40000, EBook.Category.APP));
		
		System.out.println("*** Collector ***");
		// Collectors는 Collector를 반환하는 메소드들로 이루어진 클래스
		System.out.println("< toList >");
		List<String> ebTitleList =
			ebooks
				.stream()
				.filter(b -> b.getPrice() < 50000)
				.map(EBook::getTitle)
				.collect(Collectors.toList());		// 캡슐화 (supplier, accumulator, combiner)
		//.collect(Collectors.toList()); .collect(Collectors.toSet()); 메소드를 활용해서 stream을 Set이나 List로 변환이 가능하다
		// 즉, Collectors.toList 나 Collectors.toSet 메소드는 collect의 파라미터 supplier, accumulator, combiner를 모두 return한다
		System.out.println(ebTitleList);
		System.out.println();
		
		
		System.out.println("< toSet >");
		Set<String> ebTitleSet =
			ebooks
				.stream()
				.filter(b -> b.getPrice() < 50000)
				.map(EBook::getTitle)
				.collect(Collectors.toSet());
		System.out.println(ebTitleSet);
		System.out.println();
		
		
		System.out.println("< groupingBy >");
		Map<EBook.Category, List<EBook>> ebMap =
			ebooks
				.stream()
				.collect(Collectors.groupingBy(k -> k.getCategory())); // = EBook::getCategory
		// collect 메소드를 통해 Map으로 변환할 때는 Collectors.groupingBy 메소드를 통해 아규먼트에 key값을 입력해주여야 한다. 
		// 중복된 카테고리 값은 각 카테고리에 대해 하나의 키로만 맵에 저장된다. (즉, 인스턴스가 몇개든 카테고리의 종류가 2개라면 key값은 2개고 리턴되는 Map의 요소는 2개이다)
		/* 위 경우 getCategory에는 총 APP과 LANG 두 종류가 있으므로 리턴되는 Map의 key는 APP과 LANG 2개가 되고,
		 *  카테고리가 APP인 인스턴스 모두가 APP key의 value가 되며, 카테고리가 LANG인 인스턴스 모두가 APP key의 value가 된다 (위 코드의 Map<EBook.Category, List<EBook>> ebMap =에서 추측 가능) */
		 		
		
		System.out.println("=--");
		ebMap.forEach((k, v) -> System.out.println(k + "\n" + v));
		// Map의 foreach 메서드
		// 파라미터 2개를 주고 retrun은 없는 BiConsumer 타입 (key, value) 로 입력	
		System.out.println();
		

		
		System.out.println("< maxBy >");
		Map<EBook.Category, Optional<EBook>> ebMaxBy =
			ebooks
				.stream()
				.collect(
					Collectors
						.groupingBy(
							EBook::getCategory, 
							Collectors.maxBy(Comparator.comparingInt(EBook::getPrice))));
		
		ebMaxBy.forEach((k, v) -> System.out.println(k + "\n" + v.get()));
		System.out.println();
		
		System.out.println("< collectingAndThen >");
		Map<EBook.Category, EBook> ebMaxBy2 =
			ebooks
				.stream()
				.collect(
					Collectors
						.groupingBy(
							EBook::getCategory,
							Collectors
								.collectingAndThen(
									Collectors.maxBy(Comparator.comparingInt(EBook::getPrice)),
									Optional::get)));
		
		ebMaxBy2.forEach((k, v) -> System.out.println(k + "\n" + v));
		System.out.println();
		
		System.out.println("< mapping >");
		Set<String> ebSet = 
			ebooks
				.stream()
				.collect(Collectors.mapping(EBook::getTitle, Collectors.toSet()));
		System.out.println(ebSet);
		System.out.println();
		
		System.out.println("< Downstream (multi-level reduction) >");
		Map<EBook.Category, List<String>> ebMap2 = 
			ebooks
				.stream()
				.collect(
					Collectors.groupingBy(
						EBook::getCategory,
						Collectors.mapping(
							EBook::getTitle, 
							Collectors.toList())));	
		
		ebMap2.forEach((k, v) -> System.out.println(k + "\n" + v));
		System.out.println();
		
		System.out.println("< reducing >");
		Map<EBook.Category, Integer> ebMap3 =
			ebooks
				.stream()
				.collect(
					Collectors.groupingBy(
						EBook::getCategory,
						Collectors.reducing(		// identity, mapper, operation
							0,
							EBook::getPrice,
							Integer::sum)));
		System.out.println(ebMap3);
		System.out.println();
	}

}
