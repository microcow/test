package cha19;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ex03MethodReferences {
	public static void main(String[] args) {
		System.out.println("< 메서드 참조 >");
		
		// 메서드 참조는 람다식을 더 줄이는 방법이다
		// ★★ 람다식에서는 파라미터 작성을 생략할 수 있다
		// ★ 메소드 레퍼런스는 참조대상::메소드 형식으로 입력한다. 메소드를 호출하는 것이지만 괄호()는 생략.
		// ★ 호출 메소드가 static이라면 :: 앞에 클래스 명 입력
		// ★ 호출 메소드가 static이 아니라면 :: 앞에 클래스 명이 아닌 인스턴스명 입력
		// ★ 호출 메소드가 static이 아닐 때 :: 앞에 클래스 명을 사용하고 싶다면, Consumer 인터페이스를 사용해야한다 (다만, 파라미터로 호출자 역할을 위한 해당 클래스의 인스턴스를 줘야함)
		
		
		// 예제 0
		Consumer<String> func = text -> System.out.println(text); // 람다식
		func.accept("Hello");
		
		Consumer<String> func2 = System.out::println; // 메서드 참조식
		func2.accept("Hello");
		
		// 예제 1
		Function<String, Integer> f1 = str -> Integer.parseInt(str);
		int i1 = f1.apply("77");
		System.out.println(i1);
		
		Function<String, Integer> f2 = Integer::parseInt;
		// 위의 = str -> Integer.parseInt(str); 코드와 동일하다
		// 파라미터를 넘겨주기만 하는 람다식에서는 파라미터 작성을 생략할 수 있다
		/// 오버라이딩 할때 본인클래스의 메소드도 오버라이딩 되는지 : 안됨 기존에 있는 메소드가 호출됨
		
		int i2 = f2.apply("78");
		System.out.println(i2);
		System.out.println();
		
		
		// 예제 2
		System.out.println("< 메서드 참조를 이용한 배열 생성 >");
		IntFunction<int[]> f3 = i -> new int[i];
		// 제네릭스의 타입에 배열도 사용 가능하다
		// IntFunction은 int(기본형)타입을 파라미터로 던지고 제네릭스타입(int배열)을 retrun받는다
		System.out.println(Arrays.toString(f3.apply(5)));
		// apply의 리턴타입 R은 apply가 리턴하는 타입이 무엇인지 결정되기 전까지 알 수 없으면 리턴하는 타입과 동일한 타입으로 바뀐다
		
		IntFunction<int[]> f4 = int[]::new;
		// 위의 i -> new int[i]; 코드와 동일하다
		// 참조 대상은 생성자를 호출할 클래스(혹은 기본형)
		// 마찬가지로 i가 생략되었다
		/// 그냥 메소드일땐 :: 앞부분엔 메소드의 return타입이 오고 스태틱 메소드일땐 :: 앞에 클래스명이 오는건가
		/// :: 앞에는 리턴타입, 뒤에는 호출 메소드. 새로 생성할 경우 new?
		System.out.println(Arrays.toString(f4.apply(5)));
		System.out.println();
		
		
		// 예제 3
		Store store = new Store();
		String[] titles = {"자바문법", "자바컬렉션프레임워크", "람다", "스트림"};
		
		// static 메소드 호출
		store.addAll(titles, Book::new, Book::validateLength);	
		// Book::new는 str는 new Book(str); 과 동일하다 (람다식)
				/* 정확히 더 풀어보자면 new Function<String, Item>(){ 
				 * 					@Override
				 * 						public R apply (T t){
				 * 							return new Book(t); };
				 */
		// Book::validateLength는 str -> Book.validateLength(str) 과 동일하다 (람다식)
		
		Collections.sort(store.getItems(), Item::compareByTitleAsc);
		Collections.sort(store.getItems(), (item1, item2) -> Item.compareByTitleAsc(item1, item2));
		Collections.sort(store.getItems(), (item1, item2) -> item1.getTitle().compareTo(item2.getTitle()));	
		// sort메소드는 추상메소드가 두개이지만 equals 메소드는 Object메소드에서 오버라이딩 하고 있기에 무시 가능
		// 즉, compare메소드만 실질적인 추상메소드이다 (compare은 파라미터가 두개 필요)
		// 위 세개는 동일한 코드
		// sort메소드는 첫번째 아규먼트의 리스트의 요소2개씩을 반복문으로 compare메소드의 파라미터들로 보낸 후 compare메소드를 동작 후 return받은 결과값에 따라 오름차순으로 정렬하는 메소드이다 
		
		
		// 예제 4
		System.out.println("< '인스턴스::메소드' 방식으로 인스턴스 메소드 호출 >");
		Runnable printItems = store::forEach;
		// () -> store.forEach(); 와 동일코드
		// 호출 메소드가 static이 아니라면 :: 앞에 클래스 명이 아닌 인스턴스명 입력
		printItems.run();
		System.out.println();
		// Runnable인터페이스는 파라미터와 return타입이 없을 때 사용
		
		System.out.println("< '클래스::메소드' 방식으로 인스턴스 메소드 호출 >");
		Consumer<Store> printItems2 = Store::forEach;
		// str -> str.forEach();와 동일 코드 // 이때 str은 forEach를 호출하는데 사용된다
		// 즉, 메소드 참조 방식에서는 넘어오는 아규먼트가 메소드 호출 시 아규먼트로만 사용되는게아닌 호출자로도 사용될 수 있다(컴파일러가 자동으로 치환해줌)
		// 호출 메소드가 static이 아닐 때(인스턴스 메소드일 때) :: 앞에 클래스 명을 사용하고 싶다면, Consumer 인터페이스를 사용해야한다 (파라미터만 주고 retrun은 없는)
		/// 만약 accept의 아규먼트가 두개고 forEach 메소드도 아규먼트 1개를 필요로 한다면 무엇을 호출자로 쓸지 무엇을 아규먼트로 쓸지는? : 컴파일 오류 발생 (accecpt의 아규먼트는 하나로 고정)
		/// 만약 accept의 아규먼트가 한개고 forEach 메소드도 아규먼트 1개를 필요로 한다면 무엇을 호출자로 쓸지 무엇을 아규먼트로 쓸지는? : 컴파일 오류 발생
		/// 만약 accept의 아규먼트가 두개고 forEach 메소드도 아규먼트 두개를 필요로 한다면 무엇을 호출자로 쓸지는? : 컴파일 오류 발생 (accecpt의 아규먼트는 하나로 고정	
		/// 해당 방식은 파라미터가 하나일 때만 사용가능한가 : no 2개여도 사용가능
		printItems2.accept(store);
		System.out.println();
		
		// 문제 1.
		System.out.println("---");
		Collections.sort(store.getItems(), Store::test1); //sort의 추상메소드 compare을 추상메소드로 오버라이딩 한 후 내용에서 test1 메소드 호출
		store.forEach();
		Collections.sort(store.getItems(), (item1, item2) -> Store.test1(item1, item2)); // 람다식
		store.forEach();
		
		// 문제 2.
		Supplier<Item> test2 = store::test2;
		Supplier<Item> test3 = () -> store.test2(); //람다식
		System.out.println(test2.get().getTitle());
		
		
		Consumer<Store> test4 = Store::test2;
		Consumer<Store> test5 = sto -> sto.test2(); //람다식
		test4.accept(store);
		/// 클래스::메소드 방식으로는 Consumer인터페이스처럼 주기만 하고 Predicate인터페이스 등을 사용해서 retrun받지는 못하는가
	}

}

class Store {
	private List<Item> items = new ArrayList<>();
	
	public void addAll(String[] titles, Function<String, Item> createItem, Predicate<String> validateItem) {
		for (String title : titles) {
			if (validateItem.test(title))
				items.add(createItem.apply(title));
		}
	}	
	public List<Item> getItems() {		
		return items;
	}
	
	public void forEach() {
		for (Item item : items) {
			System.out.println("[title]" + item.getTitle());
		}
	}
	public static int test1(Item b1, Item b2) {	
		return (b1.getTitle().compareTo(b2.getTitle()))*-1;
	}
	public Item test2() {
		return items.get(1);
	}
}

interface Item {
	public abstract String getTitle();
	
	public static int compareByTitleAsc(Item item1, Item item2) {
		return item1.getTitle().compareTo(item2.getTitle());
	}
}

class Book implements Item {
	public static final int TITLE_MAX_LENGTH = 5;
	private String title;
	public Book(String title) {
		this.title = title;
	}
	@Override
	public String getTitle() {
		return title;
	}

	public static boolean validateLength(String title) {
		return title.length() <= TITLE_MAX_LENGTH;
	}

	public static int compareByTitle(Book b1, Book b2) {
		return b1.getTitle().compareTo(b2.getTitle());
	}
	

}
/*
문제 1.
Store의 Item을 메소드 참조를 이용하여 내림차순으로 정렬하세요.

문제 2.
인스턴스 메소드를 Store에 추가후 메소드 참조를 통해 호출하세요.
메소드 참조를 이용하여 인스턴스 메소드를 호출하는 두 가지 방식 모두 사용하세요. 
*/