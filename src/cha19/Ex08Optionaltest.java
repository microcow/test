package cha19;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
public class Ex08Optionaltest {
	public static void main(String[] args) {
		List<Car2> car = new ArrayList<>();
		car.add(new Car2(1000, "A자동차"));
		car.add(new Car2(1300, "B자동차"));
		car.add(new Car2(200, "C자동차"));
		car.add(new Car2(400, "D자동차"));
		car.add(new Car2(1000, "E자동차"));
		
		// 문제 1.
		Scanner scan = new Scanner(System.in);
		System.out.println("자동차 명을 입력하세요");		
		String carname = scan.nextLine();
		Integer i = Car2.checkPrice(carname, car);
		carname = Car2.checkname(carname, car);			
		
		Optional<String> optionalcar = Optional.ofNullable(carname); // Optional에 담기
		 try {
		optionalcar.orElseThrow(() -> new NullPointerException()); // Optional이 null이라면 오류 발생
		System.out.println(optionalcar); // null이 아닐 경우 toString 실행	
		 }catch (NullPointerException e) {
			 System.out.println("미등록 차량");
		 }
		
		 // 문제 2.
		 List<Car2> car2 = new ArrayList<>();		 
		 if (!(i == null)) {
			 car2.add(car.get(i)); // i가 null일 경우 여기서 에러발생
			 
			 int price =
			 Optional
			 	.ofNullable(car2)
			 	.flatMap(a -> a.stream().findFirst())
			 	.map(a -> a.getPrice())
			 	.orElse(1);
			 System.out.println(price);
		 } 
		 else System.out.println(1);
		 /// orElse로 인해 1이 출력되게 하고 싶었으나, 그러지 못했음
		 }
	


}
class Car2 {
	int price;
	String name;
	
	Car2(int price, String name){
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
	public static String checkname(String car, List<Car2> cars) {
		for (int i=0; i<cars.size(); i++) {
			if (car.equals(cars.get(i).getname())) {
				return car;
			}
		// else return "미입력차량"; -> for문 밖에 return이 없으면 오류 발생
		}
		return null;
	}
	public static Integer checkPrice(String car, List<Car2> cars) {
	for (int i=0; i<cars.size(); i++)
		 if (car.equals(cars.get(i).getname()))
			 return i;
	return null;
	// null을 return하고 싶을 때는 return타입이 int가 아닌 Integer를 사용
	}
	
	
}
/*
문제 1.
입력 받은 자동차 정보를 이용해 인스턴스를 생성하세요.
인스턴스의 toString을 이용해 자동차의 정보를 출력하세요.
정보가 미입력 될 경우 참조변수에 null이 저장되어야 합니다.
옵셔널을 사용해 미입력된 자동차일 경우 '미입력차량'을 출력하세요.

문제 2.
옵셔널과 맵을 사용해 자동차의 금액을 출력하되 자동차의 금액이 없을 경우 1이 출력되도록 코딩하세요. 
*/
