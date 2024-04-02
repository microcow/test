package cha17;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

public class Ex01List {
	
	// ★ Collection은 Collection 인스턴스에 제네릭스 타입과 맞는 인스턴스의 "요소"를 저장하는데(add, addAll, 생성자 등으로 저장할 때) 그 요소는 문자열이나 정수가 될 수도 있고 인스턴스가 될 수 있다
	
	/* 컬렉션 프레임워크 (참고: http://www.tcpschool.com/java/java_collectionFramework_concept)
	- 데이터를 쉽고 효과적으로 처리할 수 있는 표준화된 방법을 제공하는 클래스의 집합이다.
	- 데이터를 저장하는 자료구조 & 데이터를 처리하는 알고리즘을 구조화하여 클래스로 구현해 놓은 것이다.
	- 컬렉션 프레임워크는 인터페이스로 구현되며, 핵심 인터페이스는 List, Set, Map 등이 있다.
	- 컬렉션 프레임워크라고 해서 모두 Collection 인터페이스를 상속받는 것은 아니다. List나 Set은 Collection 인터페이스를 상속받지만 Map은 그렇지 않다.
	- 컬렉션 프레임워크에 속하는 인터페이스를 구현한 클래스를 컬렉션 클래스라고 한다. ArrayList, LinkedLIst, HashSet 이런게 다 컬렉션 클래스다.
	 */
	
	// 개발 시 현재 상황에는 어떤 자료구조 기법을 사용하는 게 가장 효율적인가 (판단하여 기법을 선택할 수 있어야함) (List, set, map 등)
	// 미리 java에서 자주 사용하는 자료구조를 인터페이스나 클래스로 만들어 놓은 것을 Collection(프레임워크)이라고 한다
	
	// 17-1 강의에서는 ArrayList와 LinkedList에 대해 알아보는 시간
	
	/* ArrayList : 배열로 이루어짐
	 * 장점 : 배열의 길이가 가변적이다, 검색이 빠르다(접근이좋다)
	 * 단점 : data 추가와 삭제에 속도가 느리다 (중간에 있는 데이터 삭제 또는 추가 시 그 뒤의 배열이 밀리거나 당겨짐)
	 */
	
	/* LinkedList : 노드 객체로 이루어져있음 
	 * 노드:(data와 nextnode 구조로 이루어져 있음)
	 * nextnode: nextnode에 다음 노드의 주소를 적으면 해당 노드로 이동 (주소를 이용해 노드를 연결)
	 * 장점 : data 추가와 삭제가 용이하다 (nextnode 주소만 수정하면 되기에)
	 * 단점 : 검색이 느리다(찾고자 하는 정보를 찾기위해 링크를 따라가야한다)
	 */
	
	public static void main(String[] args) {
		Book b1 = new Book("자바 기본문법", "엘컴퓨터학원");
		Book b2 = new Book("자바 자료구조", "엘컴퓨터학원");
		Book b3 = new Book("자바 알고리즘", "엘코딩연구소");
		
		
		Cart cart = new Cart();
		cart.add(b1);
		cart.add(b3);
		cart.add(1, b2);
		
		System.out.println(cart.checkForDuplicateBook(b1));
		// cart에 b1이 있는지 확인하는 메소드
		Book b4 = new Book("파이썬 기본문법", "엘컴퓨터학원");
		System.out.println(cart.checkForDuplicateBook(b4));
		System.out.println();
		
		System.out.println(cart.getBook(1));
		// ★ 인스턴스만 출력할 경우 .toString()메소드를 자동으로 호출한다.
		System.out.println();
		
		List<Book> books = cart.getAllBooks();
		// 해당 books메소드와 Cart클래스에 있는 인스턴스변수 books는 다른 변수임
		System.out.println(books.toString());
		// List인터페이스의 toString 메소드는 호출자의 List의 요소들의 toString을 호출해 출력한다
		System.out.println();
		
		
		Cart.printAllBooksWithFor(books);
		// 요소들을 출력하는 방법1
		System.out.println();
		
		Cart.printAllBooksWithForEach(books);
		// 요소들을 출력하는 방법2 (읽기 전용 메소드)(메소드 내에서 List에 저장된 값 수정 불가 아래의 removeWithforEach 메소드 참고)
		System.out.println();
		
		Cart.printAllBooksWithIterator(books);
		// 요소들을 출력하는 방법3
		System.out.println();
		
		Cart.printAllBooksWithListIterator(books);
		// 요소들을 출력하는 방법4
		System.out.println();
		
		
		
		
		
		
		Book test = new Book("반갑", "습니다");;
				
		Book[] arrBook = { // arrBook 인스턴스는 Book클래스의 인스턴스를 배열로 저장할 수 있다.
				new Book("파이썬 알고리즘", "엘컴퓨터학원"), 
				new Book("파이썬 크롤링", "엘컴퓨터학원"),
				test
			};
				
		Book[] test2 = new Book[2];
		test2[0] = new Book("안녕", "하세요");	
		
		Book dooly = new Book("국어", "영어");
				
		// ★★ ArrayList<> 생성 방법 ★★ // ※ Integer는 예시 클래스임
		ArrayList<Integer> integers1 = new ArrayList<Integer>(); // 타입 지정 // 코드 해석 : integers1은 Interger타입의 인스턴스를 저장할 수 있는 배열이다. (정확히는 배열과는 다름. 배열 형태로 저장함. integers1[0] 이런식으로 사용 불가)
		ArrayList<Integer> integers2 = new ArrayList<>(); // 타입 생략 가능 (다이아몬드 연산자)
		List<Integer> integers3 = new ArrayList<>(10); // 용량(배열) 설정(가변적임) // ※ Collection타입이 ArrayList에서 List로 변경! : List는 ArrayList클래스가 구현하고있는 인터페이스이므로 업캐스팅 가능
		List<Integer> integers4 = new ArrayList<>(integers1); // 다른 Collection값 저장
		List<Book> integers5 = new ArrayList<>(Arrays.asList(arrBook)); /* Arrays.asList메소드의 아규먼트로 배열인스턴스가 온다면, 배열인스턴스의 요소들을 [0]부터 차곡차곡 integers5에 저장 (배열이 가변적임) 
		★ 만약 해당 방법이 아니라면 List<Book> integers5 = new ArrayList<>();로 생성 후 integers5.add(arrBook[0]);과 같이 배열을 하나하나 따로 저장해줘야하는 번거로움이 있음)
		★★★저장되는 요소는 인스턴스가 될수도 있고 문자열 등이 될수도 있으며★★★, 뭐가됐든 Arrays.asList는 아규먼트에서 요소들을 빼서 저장하는 메소드이다. 
		 */
		List<Book> integers6 = new ArrayList<>(Arrays.asList(test)); // Arrays.asList 메소드에서 꼭 배열타입의 인스턴스만 넘길필요 없음 (단, 선언만 하면 안되고 = null 혹은 = new Book();을 통한 메모리가 있어야함 )
		List<Book> integers7 = new ArrayList<>(Arrays.asList(test2)); // 값이 없는 배열은 null로 저장된다 //System.out.println(integers67.toString()); → null 확인
		List<Integer> integers8 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)); // Arrays.asList() // 요소가 정수로 저장되었음
		List<Book> integers9 = new ArrayList<>();
		Collections.addAll(integers9, test); // Collections.addAll(Collection인스턴스, 제네릭타입인스턴스) 메소드를 사용하여 제네릭타입에 맞는 인스턴스를 List에 저장 가능
		Collections.addAll(integers9, arrBook); // 마찬가지로 제네릭타입인스턴스가 배열일 경우, 요소(인스턴스)들을 List에 순서대로 저장 
		List<Book> integers10 = new ArrayList<>(); 
		integers10.addAll(integers9); // addAll메소드는 호출자(Collection타입)에 아규먼트(Collection타입)를 통으로 더해준다(List타입일 경우 더해진 data는 가장 뒷부분에 저장, Set타입은 중복처리).
		integers9.retainAll(integers10); // retainAll 메소드는 호출자와 아규먼트(Collection타입)가 중복되는 내용만 호출자에 저장한다 (중복되지 않는 내용 삭제),(아규먼트로 사용된 Collection타입 인스턴스의 내용은 비교에만 쓰일뿐 삭제되지 않음.)
		integers9.removeAll(integers10); // removeAll 메소드는 호출자의 내용에서 아규먼트(Collection타입)의 내용을 삭제해여 호출자에 저장한다 (즉, 중복되는 내용만 삭제),(아규먼트로 사용된 Collection타입 인스턴스의 내용은 비교에만 쓰일뿐 삭제되지 않음.)
		List<Book> integers11 = new ArrayList<>(Arrays.asList(dooly));
		

		// List<Book> books2 = Arrays.asList(arrBook); //(이렇게 생성할 경우 List 배열의 길이는 던진 배열인스턴스의 길이로 고정되며 늘릴 수 없음)
		/* ★★ new ArrayList<>() 생성자로 리스트를 만드는 것과는 달리 Arrays.asList()메서드를 통해 리스트를 만들 경우 해당 리스트들은 길이가 고정된다 (배열길이 가변x)
		 	      따라서, 위 코드가 아닌 아래 코드와 같이 생성해야한다.
		 */
		
		
		
		
		
		
		
		List<Book> books2 = new ArrayList<Book>(Arrays.asList(arrBook));
		// ★★ new ArrayList<타입>(List인스턴스) : 생성자는 아규먼트에 Lsit 인스턴스를 입력하게 될 경우(타입 통일필수) 해당 인스턴스의 요소들을 retrun한다.
		// ★★ new ArrayList<타입>() : 생성자는 타입의 인스턴스(요소) 10개를 저장할 수 있는 배열을 return한다. (<타입>은 생략 가능)
		// 따라서, 아규먼트로 Arrays.asList(배열인스턴스) 입력 시 List 배열의 길이가 가변적이다.
			
		/* ★ ArrayList는 생성자이며, Arrays.asList(arrBook)부분은 생성자 아규먼트이다. 아규먼트로 숫자가 올수도 있고 이처럼 콜렉션타입의 인스턴스가 올 수도 있다
		    두 경우 호출되는 생성자는 다르며, 숫자를 입력할 경우 생성하고자 하는 리스트의 길이를 지정하는 생성자가 호출되며, 콜렉션 타입의 인스턴스를 입력할 경우 해당 요소들을 List로 return하는 생성자가 호출된다.
		 */
		
		System.out.println("123122131231");
		System.out.println(books2.toString()); // ★★ 오버라이딩 되지 않은 to.String()은 "요소"를 출력한다 (자세한 설명은 cha17 Ex02 참고)
		
		books2.addAll(books);
		// addAll메소드는 호출자(List타입)에 아규먼트(List타입)를 통으로 더해준다(더해진 data는 가장 뒷부분에 저장). (addAll메소드는 ArrayList에 다른 ArrayList의 데이터를 통째로 붙이기 위한 메서드이다.)
		// add와 차이점 : add는 아규먼트에 List타입이 아닌 일반 제너릭스 타입의 인스턴스를 넣어야함
		Collections.addAll(integers9, arrBook);
		// Collections.addAll(Collection인스턴스, 제네릭타입인스턴스) 메소드(스태틱메소드)를 사용하여 제네릭타입에 맞는 인스턴스를 List에 저장 가능
		
		System.out.println(books2);
		System.out.println();
		
		Cart.removeWithForEach(books2);
		Cart.removeWithIterator(books2);
	}

}

class Book {
	private String title;
	private String author;
	
	public Book(String title, String author) {
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

class Cart {
	/* 다양한 기능의 메소드가 있는 Cart클래스 이지만, 일반 메소드 호출 시에는 cart의 인스턴스로 호출하고 아규먼트로 다른 클래스나 List를 넘겨주고,
	 	스태틱 메소드 호출 시에는 Cart클래스의 이름으로 호출하고 아규먼트로 다른 클래스나 List를 넘겨주고 있다. 즉, 다른 클래스의 인스턴스나 List를 위한 메소드이더라도 호출은 해당 클래스와 관련해서 하자*/
	
	private List<Book> books; // Book타입의 인스턴스를 받을 수 있는 List로서의 역할을하는 books이다
	// ★★ books는 List소속이지만 그 요소들은 Book소속이다 라는 뜻
	// ★★★ 저장되는 요소는 인스턴스가 될수도 있고 문자열 등이 될수도 있다 ★★★
	// ★ ArrayList 클래스는 List인터페이스를 구현 중이기에, List로 업캐스팅이 가능하다
		// tip. 받는 타입으로는 클래스보다 인터페이스로 받을 때가 더욱 확장성이 뛰어나다
	/// ★ books는 Book타입의 자식 클래스도 저장할 수 있는가? : 가능. 단, List생성 할 때의 제네릭스 타입과 ArrayList의 제네릭스 타입은 일치해야함
		
	public Cart() {
		books = new ArrayList<Book>(2); // 업캐스팅
		// ★ 어떤 클래스를 어떤 스타일의 Collection으로 저장할건지 제네릭스(<Book>)을 통해 표현해주어야한다. (여기선 배열타입 선택)
		// ★ 해당 ArrayList는 Book타입의 인스턴스만 저장할 수있다
		// ★ Book타입 인스턴스를 2개 저장할 수 있는 ArratList 배열을 생성하였지만, 2개 이상으로 늘어나더라도 가변적으로 배열이 증가한다 (2를 안적어도 됨)
		
		/// ★★ 배열로 생성하였지만 books[0] 이런 식으로 따로 빼서 쓸순 없나봄 (get 메소드를 통해 빼서 써야하나봄)
	}
	
	public void add(Book book) {
		books.add(book);
		// ★ List인터페이스의 아규먼트가 하나있는 add메소드는 파라미터로 받은 인스턴스 타입이 제네릭스(<Book>)과 일치하다면, 리스트(books)에 추가한다.
		/// 그냥 books라고 적혀있는데 호출자.books인가? == this.books? = yes
	}
	public void add(int index, Book book) {
		books.add(index, book);
		/* ★ List인터페이스의 아규먼트가 두개있는 add메소드는 파라미터로 받은 인스턴스가 제네릭스(<Book>)과 일치하다면,
		첫번째 아규먼트의 인덱스에 두번째 아규먼트를 리스트(books)에 추가한다.(해당 인덱스에 이미 데이터가 있다면 뒤로 밀어낸 후 저장함) */
	}
	public boolean checkForDuplicateBook(Book book) {
		return books.contains(book);
		// ★ List인터페이스의 contain 메소드는 호출자 아규먼트로 보낸 인스턴스가 List(Books)에 존재하는지를 return한다.
		// 이는 파라미터의 값 주소가 List에 있는지 확인하는 방식이므로, 만약 인스턴스의 일부 정보만 일치하더라도 true를 return받고 싶다면 equals나 hashcode 메소드를 오버라이딩해서 사용해야함
		// eqauls 메소드에서 특정 부분만 같다면 ture를 반환하도록 오버라이딩 해주고 hashcode에서도 특정 부분만 같다면 같은 주소를 return(Objects.hash 메소드)하도록 오버라이딩
	}
	public List<Book> getAllBooks() {
		// Collection을 리턴할 때는 리턴타입에 제네릭스까지 적어주어야한다.
		return books;
	}
	public Book getBook(int index) {
		return books.get(index);
		// ★ List인터페이스의 get메소드는 List의 index번호에 있는 요소를 return한다. (return타입은 List의 제네릭스(<Book>) 타입과 일치해야한다)
	}
	
	public static void printAllBooksWithFor(List<Book> books) {
		// ★ List<Book> 타입의 인스턴스로 호출가능 (Book타입의 인스턴스로 호출 불가)
		// List타입을 받을때도 제네릭스까지 적어주어야한다.
		System.out.println("for");
		for (int i=0; i<books.size(); i++) {
			// ★ List타입의 size메소드는 배열의 .length와 동일하다 (길이)
			Book book = books.get(i);
			System.out.println(book);
		}
	}
	
	public static void printAllBooksWithIterator(List<Book> books) {
		System.out.println("Iterator");
		for (Iterator<Book> it = books.iterator(); it.hasNext(); ) { // for문의 조건(it.hasNext)이 참일 경우에 반복
			// ★★ iterator 메소드는 호출자에 저장된 값을 그대로 Iterator인터페이스 타입으로 return한다.
			// hasNext메소드는 호출자 배열에 현재 가르키고있는 커서에 값이 저장되어있다면 true를 return한다.
			/// 커서위치는 무조건 호출자 배열의 첫번째? : yes
			/* set Collection을 제외한 Collection에서 get(인덱스) 메소드를 사용하지 않고 반복문을 사용하기 위해
			   .iterator() 메소드를 통한 후 Iterator의 메소드를 사용하여 반복문 활용 */
			System.out.println(it.next());
			// next 메소드는 현재 커서가 가르키고있는 위치의 data값을 String 타입으로 return한 후 커서를 한칸 옆으로 옮긴다.
		}
	}
	
	public static void printAllBooksWithListIterator(List<Book> books) {
		System.out.println("ListIterator");
		System.out.println("next");
		ListIterator<Book> it = books.listIterator();
		// listIterator는 양방향 검색이 가능하다. (hasNext 메소드로 정방향으로 커서 옮김 → hasPrevious 메소드로 역방향으로 커서 옮김)
		
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("previous");
		while (it.hasPrevious()) {
			System.out.println(it.previous());
		}
	}
	
	public static void printAllBooksWithForEach(List<Book> books) {
		System.out.println("foreach");
		for (Book book : books) {		// 바이트 코드 변환 시 보일러 플레이트 최소화
			// ★★★ books의 요소를 book에 저장하고 println후 그 다음 요소를 다시 book에 저장하는 방법 (forEach)
			// ★ 요소들은 book에 누적되는게 아닌 갱신된다.
			// ★★ books에 있는 Book클래스의 요소를 빼서 book 인스턴스에 저장하는 것이지 books 자체를 저장하는게 아님 (books != book)
			System.out.println(book);
		}
	}
	
	public static void removeWithForEach(List<Book> books) { 
				// forEach문을 통해 내용 수정(삭제)을 못하는 이유 (삭제하려는 메소드 호출자 타입이 List이기에 불가능) 
		try {
			for (Book book : books) {
				books.remove(book);
				System.out.println("삭제: " + book);
			}
		} catch (ConcurrentModificationException e) {
			System.out.println("Iterable은 삭제 기능을 지원하지 않습니다.\n");
		}
		
		System.out.println(books.toString());
	}
	
	
	public static void removeWithIterator(List<Book> books) {
		// Iterator문은 메소드 내에서 내용 삭제가 가능하다 (삭제하려는 메소드 호출자 타입이 Iterator이기에 가능) 
		// Iterator는 컬렉션을 내재하고 있다	
		/* ★★ Iterator은 콜렉션(List, set, map 등)으로서의 역할이 아니라 콜렉션들의 요소들을 불러오거나 편집하는데 
			용이하도록 메소드를 모아놓은 인터페이스이다. (콜렉션의 요소를 가르키는 커서라고 생각)★ (검색어 iterator)*/
		for (Iterator<Book> it = books.iterator(); it.hasNext(); ) {
			Book book = it.next(); // remove를 하려면 .next가 선행되어야한다.
			it.remove();
			/* 이 때의 remove는 it에만 영향을 주는 게 아닌 it의 값에 대응하는 books의 값도 삭제하는가 : yes (기본 컬렉션에서 제거한다)
			 	ArrayList 컬렉션을 Iterator로 읽고자 했고, Iterator 객체는 컬렉션을 내재하고 있기 때문에 iterator.remove() 할 때 기존 컬렉션에서 지워지는 것
			 	(Removes from the underlying collection)
			 */
			System.out.println("삭제: " + book);
		}
		
		System.out.println(books.toString());
	}
}
