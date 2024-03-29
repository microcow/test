package cha19;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class Ex01FunctionalInterfacetest {
	public static void main(String[] args) {
		
		System.out.println("문제 1. BiPredicate");
		BiPredicate <String, String> biPredicate = (str1, str2) -> str1.equals(str2);
		  System.out.println(biPredicate.test("ABC", "ABC"));
		  System.out.println(biPredicate.test("abc", "ABC"));
		// ★ BiPredicate 인터페이스는 Predicate 인터페이스와 유사하지만 두개 타입의 파라미터 2개 던지고를 boolean타입으로 return받는다
		// 마찬가지로 or, and, negate 메소드 사용 가능
		  
		  
		  System.out.println("문제 2. BinaryOperator");
		  Comparator<Integer> integerComparator = Comparator.naturalOrder();	          
	      // Comparator.naturalOrder는 compareTo를 호출한 후 오름차순으로 정렬하는 방식(return 타입 Comparator) (*cha18. Ex14)
		  // Comparator<Integer> integerComparator = Comparator.reverseOrder(); 해당 식 사용 시 minBy와 maxby가 반대로 출력됨
		  
		  BinaryOperator<Integer> intBinaryOperator = BinaryOperator.minBy(Comparator.naturalOrder()); // 아규먼트로 integerComparator를 사용해도 되고 Comparator.naturalOrder()를 사용해도 됨
		  // ★ BinaryOperator 메소드는 제네릭 타입과 return타입이 동일하며, BiFunction과 기능이 유사하며 BiFunction 인터페이스를 상속받고 있다(BiFunction 메소드 사용 가능).
		  // BinaryOperator의 minBy() 메서드는 매개변수로 전달된 비교자(Comparator)(오름차순)를 기반으로 apply() 메서드로 전달된 두 매개변수를 비교 후 작은 값을 반환
	      // BinaryOperator.minBy(integerComparator)가 apply() 메서드에서 동작
		  /// 해당 람다식에 파라미터가 없는 이유
		  /// 람다식을 통해 retrun받을 경우 식이 = 인데 인스턴스에 저장되는건가 (retrun타입은 Integer이고 인스턴스는 BinaryOperator 타입인데 = 이 성립?)
		  System.out.println("50, 100 중 최소값: " +
		          intBinaryOperator.apply(50, 100));
		  
		  
		  BinaryOperator<Integer> intBinaryOperator2 =  BinaryOperator.maxBy(integerComparator);
		  System.out.println("50, 100 중 최대값: " +
				  intBinaryOperator2.apply(50, 100));
		// BinaryOperator의 maxBy() 메서드는 minBy() 메서드와 반대로 두 매개변수를 비교 후 큰 값을 반환
		
		         
		
		
	}
}
/*
문제 1.
BiPredicate
BinaryOperator
IntConsumer
IntFunction
IntPredicate
IntUnaryOperator
IntBinaryOperator
IntToDoubleFunction
ToIntFunction
ToIntBiFunction

위 함수형 인터페이스들을 이용해 람다식을 작성하고 출력하세요. 
*/