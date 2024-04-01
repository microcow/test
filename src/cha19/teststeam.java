package cha19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class teststeam {
	public static void main(String[] args) {
		List<List<Integer>> listOfLists = Arrays.asList(
				  Arrays.asList(1, 2),
				  Arrays.asList(3, 4),
				  Arrays.asList(5, 6)
				);
		List<Integer> flattenedList = listOfLists.stream()
				                                  .flatMap(List::stream)
		                                          .collect(Collectors.toList());
		System.out.println(flattenedList);
		// flatMap
		
		List<List<Integer>> listOfLists2 = Arrays.asList(
				  Arrays.asList(1, 2),
				  Arrays.asList(3, 4),
				  Arrays.asList(5, 6)
				);
		List<Integer> flattenedList2 = listOfLists2.stream()
				                                  .flatMap(list -> list.stream())
		                                          .collect(Collectors.toList());
		// flatMap2
		
		
		
		 List<Integer> test2 = new ArrayList<>();
		 test2.add(1);
		 test2.add(2);
		 test2.add(3);
		 
	     Stream<Integer> settest2 = test2.stream()
	    		 						 .flatMap(list -> Arrays.asList(list).stream());
	     
		
		 Set<Integer> test = new HashSet<>();
		 test.add(1);
		 test.add(2);
		 test.add(3);
		 
	     Stream<Integer> settest = test.stream()
	    		 .flatMap(list -> Stream.of(list));
	     
	     
	     
	     
	    
	    
	     

		
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		List<Integer> squaredNumbers = numbers.stream()
		                                       .map(n -> n * n)
		                                       .collect(Collectors.toList());		
		System.out.println(squaredNumbers);
		//map
	
	
		Stream<Integer> aa = Stream.of(1, 3);
		aa
			.flatMap(s -> Arrays.asList(s).stream())
			.forEach(System.out::println);
		
		
		System.out.println("---");
		Stream<String> stream3 = Stream.of("A:90", "B:80", "C:100");
		System.out.println(stream3.toString());
		stream3.forEach(System.out::println);
		System.out.println("------");
		
		Stream<String> stream4 = Stream.of("A:90", "B:80", "C:100");
		System.out.println(stream4);
		stream4
		.flatMap(s -> Arrays.asList(s).stream())		
		.forEach(System.out::println);
		 
		
		// flatMap의 Set사용
	    Set<Integer> originalSet = new HashSet<>();
        originalSet.add(1);
        originalSet.add(2);
        originalSet.add(3);

        // 각 요소를 2배로 만든 새로운 Set 생성
        Set<Integer> doubledSet = originalSet.stream()
                                             .flatMap(element -> {
                                                 Set<Integer> set = new HashSet<>();
                                                 set.add(element * 2);
                                                 return set.stream();
                                             }) // {} 필수
                                             .collect(Collectors.toSet());

        // 결과 출력
        System.out.println("Original Set: " + originalSet);
        System.out.println("Doubled Set: " + doubledSet);
        
        
        
        System.out.println("< flatMap >");
        
        // 예제 1
        Stream<String> stream22 = Stream.of("A:90", "B:80", "C:100"); 
		stream22
		    .flatMap(s -> Arrays.asList(s).stream())
		    .forEach(System.out::println);
		
		// 예제 2
		Stream<String> stream33 = Stream.of("A:90", "B:80", "C:100"); 
		stream33
		//    .flatMap(s -> Arrays.stream(s))
		    .forEach(System.out::println);
		
		// 예제 3
		Stream<String> stream44 = Stream.of("A:90", "B:80", "C:100"); 
		stream44
		    .flatMap(s -> Arrays.stream(s.split("")))
		    .forEach(System.out::println);
		
		/* 각각의 stream 인스턴스에는 문자열들이 '배열'이 아닌 요소들의 시퀀스(흐름)으로 저장되었다
		 * 파라미터 s는 문자열을 받는 String타입이다.
		 * 예제 1의 경우 문자열 흐름(stream)을 배열의 형태로 바꾼 뒤 문자열 흐름(stream)으로 저장하고 있기에 정상동작한다
		 * 예제 2의 경우 문자열 흐름(stream)을 문자열 흐름(stream)으로 바꾸려고 하기에 오류 발생
		 * 예제 3의 경우 문자열 흐름(stream)을 split을 통해 배열로 나눈 뒤 문자열 흐름(stream)으로 저장하고 있기에 정상동작한다
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
		
		
		 List<String> stream55 = Arrays.asList("A:90", "B:80", "C:100"); 
		 stream55
		 		.stream()
			    .flatMap(s -> Arrays.asList(s).stream())
			    .forEach(System.out::println);
			
	
			
		List<String> stream77 = Arrays.asList("A:90", "B:80", "C:100"); 
			stream77
				.stream()
			    .flatMap(s -> Arrays.stream(s.split("")))
			    .forEach(System.out::println);
        
		
		
		a A = new a();
		System.out.println(A.equals(a.Qd.APP));
		
		
	}

}

class a{
	public static int Q = 0;
	public enum Qd {
		LANG, APP
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof a))
			return false;
		else return true;
	}
}

