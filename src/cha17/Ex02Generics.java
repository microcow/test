package cha17;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex02Generics {
	
	public static void main(String[] args) {
		Book2 b1 = new Book2("자바 기본문법", "엘컴퓨터학원");
		Book2 b2 = new Book2("자바 자료구조", "엘컴퓨터학원");
		Book2 b3 = new Book2("자바 알고리즘", "엘코딩연구소");
		
		Cart2<Book2> cart = new Cart2<Book2>();		
		// 클래스 옆의 <> 를 '제네릭스'라 부르고 제네릭스를 생성할 때 적는 타입, 즉 <> 안에 있는 걸 '타입 아규먼트'라 부른다
		// ★ cart는 Book2 인스턴스를 저장하는 컬렉션임을 선언
		
		cart.add(b1);
		cart.add(b2);
		cart.add(b3);
		cart.printAllItems();
		System.out.println();
		
		Car[] cars = {
				new Car("소나타", 2),
				new Car("K5", 4),
				new Car("아반떼", 5)
			};
		Cart2<Car> cart2 = new Cart2<Car>(cars);
		cart2.printAllItems();
		System.out.println();
		
		System.out.println(cart2.get(1));
	}

}

class Book2 {
	private String title;
	private String author;
	
	public Book2(String title, String author) {
		this.title = title;
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + "]";
	}
}

class Car {
	private String modelName;
	private int door;
	
	public Car(String modelName, int door) {
		this.modelName = modelName;
		this.door = door;
	}
	public String getModelName() {
		return modelName;
	}
	public int getDoor() {
		return door;
	}
	@Override
	public String toString() {
		return "Car [modelName=" + modelName + ", door=" + door + "]";
	}
}

class Cart2<T> {	
	// 받을땐 타입 파라미터라고 한다 (타입 파라미터이자 타입 변수이다)
	// 여기선 <T>가 <Book2>를 받을 수 있다
	// 자바에서 제공하는 Collection(List)이 아닌 새로 Coollection역할을 할 수 있는 클래스를 생성하고 있다.  
	
	private List<T> items;
	
	public Cart2() {
		items = new ArrayList<T>();
	}
	public Cart2(T[] arr) {
		items = new ArrayList<T>(Arrays.asList(arr));
	}
	
	public void add(T item) {
		items.add(item);
	}
	
	public T get(int index) {
		return items.get(index);
	}
	
	public void printAllItems() {
		// ★ 제네릭스를 사용하면 다운캐스팅을 생략할 수 있는 장점이 있다
		for (T item : items) {		// 바이트 코드 변환 시 보일러 플레이트 최소화
			System.out.println(item);
		}
	}
}
