package cha17;
import java.util.ArrayList;
import java.util.List;

public class Ex05MultipleBound {
	public static void main(String[] args) {
		Book3 b1 = new Book3();
		b1.setTitle("자바 제네릭스");
		b1.setAuthor("엘컴퓨터학원");
		b1.setPrice(50000);
		
		Book3 b2 = new Book3();
		b2.setTitle("자바 컬렉션 프레임워크");
		b2.setAuthor("엘컴퓨터학원");
		b2.setPrice(40000);
		
		Store<Book3> bookStore = new Store<>();		
		// 생성자에 굳이 타입을 입력하지 않고 <>만 입력하더라도 동일하게 Book3로 처리된다 (다이아몬드 연산자)
		bookStore.add(b1);
		bookStore.add(b2);
		
		bookStore.printProducts();
		
		Car2 c1 = new Car2();
		c1.setModelName("소나타");
		c1.setDoor(4);
		
		Car2 c2 = new Car2();
		c2.setModelName("아반떼");
		c2.setDoor(2);
		
		// 문제 (1)
		Store<Car2> carStore = new Store<>(); 
		/* → 문제 수정 전)Store클래스는 Product클래스를 상속받고, OderItem 인터페이스를 구현하고 있는 클래스만 제네릭스로 받을 수 있지만
		Car2 클래스는 OderItem 인터페이스를 구현하고있지 않기에 제너릭스로 사용 불가 */ 
		
		Rank<Book3, Car2> rank = new Rank<>();
		Rank<Book3, Car2> rank2 = new Rank<>(); 
		
		rank.setProducts(bookStore.getProducts(), carStore.getProducts());
		
		rank2.setProducts(rank.fList, rank.sList);
		// 아규먼트의 순서 중요
	}

}

abstract class Product {
	String modelNo;
}

interface OrderItem {
	public abstract void setPrice(int price);
	public abstract int getPrice();
}

//class Store<T extends OrderItem & Product> { → 클래스를 왼쪽에, 오른쪽에 인터페이스를 적어야 오류가 나지 않는다.
class Store<T extends Product & OrderItem> {
	// ★ 여러개의 클래스나 인터페이스를 & 묶어 제네릭스를 제한할 수 있다. (멀티플 바운드)
	// 해석 : T 타입은 Product 클래스를 상속받으면서 OrderItem 인터페이스를 구현하고 있어야한다.
	// Product나 orderItem 내에 있는 메소드도 사용 가능하다.
	
	private List<T> products;
	
	public Store() {
		products = new ArrayList<>();
	}
	
	public void add(T product) {
		products.add(product);
	}
	
	public List<T> getProducts() {
		return products;
	}
	
	public void printProducts() {
		System.out.println("- 상품목록 -");
		for (T product : products) {
			System.out.println(product);
		}
		System.out.println();
	}
}

class Book3 extends Product implements OrderItem {
	private String title;
	private String author;
	private int price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book3 [title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
	@Override
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int getPrice() {
		return price;
	}
}

class Car2 extends Product implements OrderItem {
	private String modelName;
	private int door;
	
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	@Override
	public String toString() {
		return "Car2 [modelName=" + modelName + ", door=" + door + "]";
	}
	@Override
	public void setPrice(int price) {
		
	}
	@Override
	public int getPrice(){
		return door;
	}
}

class Rank<T, U> {
	// 타입 파라미터도 여러개로 적을 수 있다 (,로 구분)
	List<T> fList;
	List<U> sList;
	
	public void setProducts(List<T> fList, List<U> sList) {
		this.fList = fList;
		this.sList = sList;
		
		System.out.println("- 1st -");
		for (T first : fList) {
			System.out.println(first);
		}
		System.out.println("- 2nd -");
		for (U second : sList) {
			System.out.println(second);
		}
	}
}
/*
문제 1.
(1) 의 오류를 수정하세요.

문제 2.
Rank 클래스의 fList와 sList를 출력하는 메소드를 작성하세요.
*/
