package cha19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04Streamtest {
	public static void main(String[] args) {
		
		// Ex04 Stream Test
		
		//문제 1.
		Stream<String> stream = Stream.of("가", "나", "다");
		stream.forEach(System.out::println);
		System.out.println();
		
		//문제 2.
		IntStream intStream = new Random()
				.ints(1, 100)
				.limit(10);
		intStream.forEach(System.out::println);
		System.out.println();
			
			
		//문제 3.
		List<Car> Car2 = new ArrayList<>();
		Car2.add(new Car(1000, "A자동차"));
		Car2.add(new Car(1300, "B자동차"));
		Car2.add(new Car(200, "A자동차"));
		Car2.add(new Car(400, "D자동차"));
		Car2.add(new Car(1000, "A자동차"));
		
		Car2
			.stream()
			.filter(a -> a.getPrice()>500)
			.forEach(System.out::println);
		System.out.println();
		
			
		System.out.println("---");
		// 문제 4.
		Car2
		.stream()
		//.filter(b -> b.equals(b))
		.distinct()
		.forEach(System.out::println);
		System.out.println();
		//filter(b -> b.equals(b)) 해당 부분이 있고 없고가 무슨차이길래 distinct에서 중복처리가되지 -> 없어도 중복처리 됨
		
		
		// 문제 5.
		Car2
		.stream()	
		.map(Car::getPrice) // d -> d.getPrice() 와 동일코드
		//.flatMap(s -> Arrays.asList(s.getPrice()).stream())-> map이 아닌 flatMap 사용 시 코드
		.limit(3)
		.forEach(System.out::println);
		System.out.println();
		
		
		//문제 6.
		Car2
		.stream()	
		.flatMap( s -> Arrays.stream(s.getname().split("")) )
		// .map(s -> s.getName().split(""))
		.sorted() // Stream클래스의 sorted메소드는 오름차순으로 정렬해준다
		// Car 클래스가 Comparable을 구현하지 않은 경우에도 컴파일러가 오류를 내지 않는 이유는 Java 8에서 도입된 기능 중 하나인 '타입 추론' 때문이다.
		.forEach(System.out::println);
		System.out.println();
		// .sorted() 메소드를 호출하기 위해선 .flatMap()메소드를 통한 평탄화가 선행되어야 한다
			
		
		//문제 7.
		Optional<Car> findAny =
				Car2
					.stream()
					.filter(any -> any.getname().startsWith("A자동차"))
					.findAny();
		System.out.println(findAny.get());
		// A자동차중 하나 찾는 방법
			
		List<Car> filteredCars = 
				Car2
				   .stream()
                   .filter(any -> any.getname().startsWith("A자동차"))
                   .collect(Collectors.toList()); //collect 메소드를 통해 stream을 List로 return
		System.out.println(filteredCars);
		// A자동차 모두 찾는 방법
		
		
		// Ex05 Reduction Test
		
		// 문제 1.
		double average = 
				Car2
			 	  .stream()
				  .mapToInt(a -> a.getPrice())
				  .average()
				  .getAsDouble();
		System.out.println("자동차 가격 평균 : " + average);
		
		// 문제 2.
		int maxPrice =
				Car2
					.stream()
					.mapToInt(Car::getPrice)
					.max()
					// 최대값을 OptionalInt타입으로 return한다.
					.getAsInt();
					// getAsInt은 OptionalDouble 타입의 인스턴스에 저장되어있는 값을 return한다 (기본형을 위한 Optional일 경우 getAs기본형() 으로 요소를 받아와야한다)
			System.out.println("자동차 가격 최고 : " + maxPrice);
			
		// 문제 3.
		int sumPriceTax =
				Car2
					.stream()
					.mapToInt(Car::getPrice)
					.reduce(0, (a, b) -> a+(int)(b*1.1f));
		// a는 이전 단계에서 계산된 결과값을 저장 (최초값 0)
		// b는 현재 처리하는 배열 요소
		// 모든 요소가 한번씩 b가 되어 반복적으로 실행되므로 최종액 합산됨
			System.out.println("자동차 세금 부과 가격 총액 : " + sumPriceTax);			
	
		
		// 문제 4.
			List<Car> Car3 = new ArrayList<>();
			Car3.add(new Car(1000, "A자동차"));
			Car3.add(new Car(1300, "B자동차"));
			
			List<Car> Car4 = new ArrayList<>();
			Car4.add(new Car(400, "D자동차"));
			Car4.add(new Car(1000, "A자동차"));
			
			List<Integer> priceSet =
					Car3
						.stream()
						.map(Car::getPrice)
						.collect(
							() -> new ArrayList<Integer>(),
							(set, i) -> set.add(i),
							(set1, set2) -> set1.addAll(set2));
			
			List<Integer> priceSet2 =
					Car4
						.stream()
						.map(Car::getPrice)
						.collect(
							() -> new ArrayList<Integer>(),
							(set, i) -> set.add(i),
							(set1, set2) -> set1.addAll(set2));
			
			
			priceSet.addAll(priceSet2);
			System.out.println(priceSet);
	
			
	}

}
class Car {
	int price;
	String name;
	
	Car(int price, String name){
		this.price = price;
		this.name = name;
	}
	int getPrice() {
		return price;
	}
	String getname() {
		return name;
	}
	@Override
	public String toString() {
		return "이름 : " + name + " " + "가격 : " + price;	
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Car))
			return false;
		Car car = (Car)o;
		return name.equals(car.getname()) && (price == car.price);
	}
}
/*
문제 1.
스트림에 '가', '나', '다' 를 추가하는 코드를 작성하세요.

문제 2.
스트림을 사용하여 1~100 사이의 숫자 중 난수 10개를 출력하세요.

문제 3.
자동차 인스턴스 5개를 가진 배열을 만들고 스트림으로 변환하세요.
500원 보다 비싼 차량들을 출력하세요.

문제 4.
자동차 이름을 중복 제거 후 출력하세요.

문제 5.
자동차 인스턴스로 이뤄진 스트림을 자동차 금액들로만 이뤈진 스트림으로 변환 후 3개만 출력하세요.

문제 6.
스트림에 저장된 자동차명의 모든 글자를 나누어 한 글자씩 출력하되 오름차순으로 정렬하여 출력하세요.
힌트) flatMap, sorted 를 사용하세요.

문제 7.
스트림에서 특정 차량이름을 검색하여 출력하세요.
*/
/*
문제 1.
자동차 금액의 평균가를 출력하세요.

문제 2.
가장 높은 자동차의 금액을 출력하세요.

문제 3.
세금 10% 부가된 자동차 가격 총액을 출력하세요.
힌트) reduce를 사용하세요.

문제 4.
두 개의 리스트를 생성 후 collect를 사용하여 병합하세요.
병합된 리스트를 출력하세요.
*/