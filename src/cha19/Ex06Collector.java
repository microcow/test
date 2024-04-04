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
		
		//★★ collect에서 groupingBy 류의 메서드들은 stream을 Map타입으로 변경하는 메서드이다
		
		System.out.println("*** Collector ***");
		// Collectors는 Collector를 반환하는 메소드들로 이루어진 클래스
		System.out.println("< toList >");
		List<String> ebTitleList =
			ebooks
				.stream()
				.filter(b -> b.getPrice() < 50000)
				.map(EBook::getTitle)
				.collect(Collectors.toList());		// 캡슐화 (supplier, accumulator, combiner)
		// ★ .collect(Collectors.toList()); .collect(Collectors.toSet()); 메소드를 활용해서 stream을 Set이나 List로 변환이 가능하다
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
		// ★ .collect.Collectors.groupingBy() 메서드는 stream을 Map으로 변경해주는 메서드이다.
		// ★ collect 메소드를 통해 Map으로 변환할 때는 Collectors.groupingBy 메소드를 통해 아규먼트에 key값을 입력해주여야 한다. 
		// 중복된 카테고리 값은 각 카테고리에 대해 하나의 키로만 맵에 저장된다. (즉, 인스턴스가 몇개든 카테고리의 종류가 2개라면 key값은 2개고, 리턴되는 Map의 요소는 2개이다)
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
					Collectors.groupingBy( // groupingBy의 아규먼트가 2개			
							EBook::getCategory, // 카테고리를 key로 설정 // (첫번째 아규먼트)
							Collectors.maxBy(Comparator.comparingInt(EBook::getPrice)))); // value 설정 // (두번째 아규먼트)
				/* ★ 두번째 아규먼트인 Collectors.maxBy의 경우, 앞서 지정한 첫번째 아규먼트인 key값 중 Collectors.maxBy의 아규먼트의 값이 가장 큰 값 하나를 해당 key값의 value로 설정한다.
				   즉, 카테고리는 2종류 뿐이므로 key값은 2개이며, 해당 key값과 동일한 카테고리를 가진 인스턴스들끼리 비교해 getPrice의 값이 가장 높은 하나의 인스턴스가 해당 key의 value값이 된다 */
				// Comparator.comparingInt 메서드는 아규먼트를 오름차순으로 정렬하는 메서드이다.
		
		ebMaxBy.forEach((k, v) -> System.out.println(k + "\n" + v.get()));
		// maxBy는 Optional로 return하기에 v값을 가져오려면 get메서드를 사용해야한다
		/* 단, Optional클래스에서도 ArrayList와 동일하게 .toString()을 오버라이딩 하고 있으며,
		   호출한 인스턴스의 요소(EBook타입)들의 toString이 출력되도록 변환 후 return하기에 v.toString을 사용해도 된다.*/
		 
		System.out.println();
		
		
		System.out.println("< collectingAndThen >");
		Map<EBook.Category, EBook> ebMaxBy2 =
			ebooks
				.stream()
				.collect(
					Collectors.groupingBy( // Map으로 변경
							EBook::getCategory, // key값 설정
							Collectors.collectingAndThen( // value값 설정 (아규먼트)
									Collectors.maxBy(Comparator.comparingInt(EBook::getPrice)),// collectingAndThen의 첫번째 아규먼트
									Optional::get))); // collectingAndThen의 두번째 아규먼트
		// Collectors.collectingAndThen 메소드는 첫번째 아규먼트(maxBy(~~))의 결과를 가지고 두번째 아규먼트(Optional::get)를 실행한다. 
		// 여기선 원래 maxBy의 value값이 Optional 클래스이지만 그 값을 가지고 두번째 아규먼트인 Optional::get을 실행하여 EBook 타입의으로 가져왔다.
		// 즉, maxBy의 결과로 Optional클래스를 return받았으며, 그 return 값을 가지고 Optional::get을 실행하여 EBook타입으로 바꾼 후 value로 설정.
		
		
		ebMaxBy2.forEach((k, v) -> System.out.println(k + "\n" + v));
		System.out.println();
		
		
		System.out.println("< mapping >");
		Set<String> ebSet = 
			ebooks
				.stream()
				.collect(Collectors.mapping(EBook::getTitle, Collectors.toSet()));
		// Collectors.mapping 메서드는 stream의 map 메서드와 유사하다
		// 위 코드는 stream을 getTitle로만 이루어진 Set으로 변환하여 return한다.
		/* 즉, collect(Collectors.toSet())만 입력했다면 해당 스트림 전체를 set으로 return했겠지만,
		   위 코드는 .collect에 Collectors.mapping메서드를 활용해 stream의 getTitle로만 이루어진 Set으로 변환하여 return하고있다. */		 
		System.out.println(ebSet);
		System.out.println();
		
		
		System.out.println("< Downstream (multi-level reduction) >");
		Map<EBook.Category, List<String>> ebMap2 = 
			ebooks
				.stream()
				.collect(
					Collectors.groupingBy( // Map으로 변경
						EBook::getCategory, // key 값 설정
						Collectors.mapping(
							EBook::getTitle, 
							Collectors.toList())));	
					// Collectors.mapping 메서드를 활용해 같은 카테고리(key값)을 가진 인스턴스들의 제목들만 List로 value값으로 설정 (다운스트림)
		
		ebMap2.forEach((k, v) -> System.out.println(k + "\n" + v));
		System.out.println();
		
		
		System.out.println("< reducing >");
		Map<EBook.Category, Integer> ebMap3 =
			ebooks
				.stream()
				.collect(
					Collectors.groupingBy( // Map으로 변경
						EBook::getCategory, // key 값 설정 (a -> a.getCategory())
						Collectors.reducing( // stream의 reduce와 비슷하게 동작 (하나의 값이 필요할 때 사용)
							0,// Collectors.reducing 메서드의 첫번째 아규먼트를 identity라 하며, 초기값을 입력한다.(최종값에 더해질 값)
							EBook::getPrice,// 두번째 아규먼트에는 어떤 내용을 단일 결과로 만들 것인지 입력한다. (a -> a.getPrice())
							Integer::sum)));// 세번째 아규먼트에는 해당 내용을 어떻게 연산할 것인지 입력한다. ((a,b) -> Integer.sum(a, b))
			
		// 즉, 위의 코드는 같은 카테고리(key값)을 가진 인스턴스들의 getPrice를 모두 합친 금액이 value가 된다.
		
		System.out.println(ebMap3);
		System.out.println();
	}

}
