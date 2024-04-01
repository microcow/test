package cha19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex04Streamtest {
	public static void main(String[] args) {
		
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
		
			
		// 문제 4.
		Car2
		.stream()
		.filter(b -> b.equals(b))
		.peek(b -> System.out.println(b+"!!"))
		.distinct()
		.forEach(System.out::println);
		System.out.println();
		///filter(b -> b.equals(b)) 해당 부분이 있고 없고가 무슨차이길래 distinct에서 중복처리가되지
		
		
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
		.flatMap(s -> Arrays.stream((s.getname().split(""))))
		// .map(s -> s.getName().split(""))
		.sorted() // Stream클래스의 sorted메소드는 오름차순으로 정렬해준다
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