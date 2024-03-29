package cha19;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class testtesttest {
	public static void main(String[] args) {
		Store22 store = new Store22();
	System.out.println("< '클래스::메소드' 방식으로 인스턴스 메소드 호출 >");
	Consumer<Store22> printItems2 = Store22::forEach;
	printItems2.accept(store);
	/// 만약 accept의 아규먼트가 한개고 forEach 메소드도 아규먼트 1개를 필요로 한다면 무엇을 호출자로 쓸지 무엇을 아규먼트로 쓸지는? : 컴파일 오류 발생
	System.out.println();

	
	String str = "Dd";
	Function<String, Integer> lengthFinder = String::length;
	System.out.println(lengthFinder.apply(str));
	Function<String, Integer> lengthFinder2 = str2 -> str2.length(); // 람다식
	System.out.println(lengthFinder2.apply(str));
	/// length는 인스턴스 메소드이고 파라미터도 없지만 인스턴스 타입으로 length를 호출하는 게 아닌 클래스 타입으로 호출하는 String::length;인 이유 -> str이 length의 메소드가 아닌 호출자로 사용됨
	
	
	//Function<Integer, Integer> maxFinder = Math::max; /// Math::max를 람다식으로는 사용 가능한데 메소드 호출형으로는 사용하지 못하는 이유 (max는 두개의 값 입력을 필요로한데 apply는 아규먼트로 하나만 입력가능하기 때문) 
	//maxFinder.apply(24);
	Function<Integer, Integer> maxFinder2 = x -> Math.max(x, 10);	// 람다식
	System.out.println(maxFinder2.apply(24));
	
	String str3 = "Hello";
	Function<Integer, String> substringFinder = str::substring;	
	String str4 = "Hello";
	Function<Integer, String> substringFinder2 = index -> str.substring(index);// 람다식
	
	}

}

class Store22 {
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
}


