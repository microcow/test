package cha17;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Ex04Generics {
	public static void main(String[] args) {
		BoardDefaultService service = null;
		
		Board b1 = new Board();
		b1.setTitle("안녕하세요");
		b1.setContent("글 내용입니다.");
		
		Board b2 = new Board();
		b2.setTitle("안녕하세요");
		b2.setContent("글 내용입니다.");
		
		List<Board> bList = new ArrayList<Board>();
		bList.add(b1);
		bList.add(b2);
		// 위 add 메소드를 통해 b1과 b2를 bList에 저장해도 되지만
		
		List<Board> bList2 = new ArrayList<Board>(Arrays.asList(b1, b2));
		// Arrays.asList 메소드를 통해 한번에 저장할수도 있다.
		
		service = new BoardService();
		// service.printList1(bList);	// error
		service.printList2(bList);
		service.printList3(bList);
		
		System.out.println();
		
		Photo p1 = new Photo();
		p1.setTitle("사진1 제목");
		p1.setContent("사진1 내용");
		p1.setPhoto("a.jpg");
		
		Photo p2 = new Photo();
		p2.setTitle("사진2 제목");
		p2.setContent("사진2 내용");
		p2.setPhoto("b.jpg");
		
		List<Photo> pList = new ArrayList<Photo>();
		pList.add(p1);
		pList.add(p2);
		
		service = new PhotoService();
		// bs.printList1(bList);	// error
		service.printList2(pList);
		service.printList3(pList);
		
		
		
		//문제 1. 
		Diary a = new Diary(); // Diary 클래스 인스턴스 생성
		a.setTitle("다이어리"); // Diart 클래스 인스턴스 a 인스턴스변수 셋팅
		List<Diary> b = new ArrayList<Diary>(); // Diary클래스를 요소로 가지는 List b 생성
		b.add(a); // List b에 Diary클래스 a요소 추가
		DiaryService c = new DiaryService(); // b의 요소사용(출력)을 도와줄 DiaryService 클래스 c 생성
		c.printList3(b); // c 메소드를 활용해 b 요소들 출력
		
		
		
		/// List 인스턴스를 생성할 때 제네릭스에서 와일드카드를 사용하지 않는지?
		List<? extends BoardDefaultService>test = new ArrayList<>();
		// → 빈 인스턴스 생성(선언)은 가능 하지만, 생성자 호출(new ArrayList)할 때에는 사용이 불가한듯 = new ArrayList<? extends BoardDefaultService>(); 오류
		// → 단, 다이아몬드 연산자 (<>) 사용 시 생성자 호출할 때 사용 가능
		test = new ArrayList<DiaryService>();
		
		
	}
}

interface BoardDefaultService {
	
	public default void printList1(List<Object> boardList) {	// only List<Object>
		// 해당 메소드는 Object타입의 인스턴스 변수를 List로 가지고 있는 인스턴스만 받을 수 있다.
		System.out.println("printList1");
		for (Object obj : boardList) {
			System.out.println(obj.toString());
		}
		System.out.println();
	}
	
	public default void printList2(List<?> boardList) {
		// ★ <?>는 언바운디드 와일드카드(그냥 와일드카드)이며, List의 타입과 관계없이 모든 List를 받을 수 있다 (제한되지 않은 제네릭스 또는 무제한 와일드카드)(제한된 제네릭스는 cha17 Ex03 참고)
		// ★ 언바운디드 와일드카드 타입은 파라미터를 받을 때 무조건 <Object>타입으로 형변환이 Object 클래스 내에 있는 메소드만 사용이 가능하다. (즉, Object클래스로 업캐스팅됨)
		System.out.println("printList2");
		for (Object obj : boardList) {
			System.out.println(obj.toString());
			// System.out.println(obj.getTitle()); → Object 클래스 내에 있는 메소드만 사용이 가능하다. (다운캐스팅 시 오버라이딩 된 메소드 사용가능)
		}
		System.out.println();
	}
	
	public abstract void printList3(List<?> boardList);
	
}

class BoardService implements BoardDefaultService {
	
	@Override
	public void printList3(List<?> boardList) { // Object 클래스로 업캐스팅
		System.out.println("printList3");
		for (Object obj : boardList) {
			/* ★★ board에 일일히 저장하는 이유는 for:(for each)문에서 boardList는 파라미터 타입(와일드카드)에 의해 Object클래스로 업캐스팅 되긴 했지만,
			   속에 저장되어있는 요소들은 Board클래스이기에, 해당 작업은 boardList의 요소하나를 obj라는 인스턴스에 복사하는 방식(obj = boardList 와는 다름) */
			// ★ 예를 들자면, boardList의 요소에 Board클래스의 인스턴스 b1과 b2가 있다면 해당 작업을 통해 for문이 첫번째 실행될때는 obj = b1이 될테고, for문이 두번째 실행되게 되면 obj = b2가 된다
			// ★ 즉, boardList는 List소속이지만 안의 요소들은 제너릭스(<?>)소속이다.
			if (!(obj instanceof Board)) return;
			
			Board board = (Board)obj; // ★ Board 클래스에 오버라이딩된 메소드를 사용하기 위해 다운캐스팅
			/// for문으로 obj에 boardList를 옮겨담지 않고 바로 Board board = (Board)boardList; 해버릴 경우 내용이 출력되지 않는 이유 → 바로 위 내용 참고
			/* // for:(for each)문은 boardList의 첫번째 요소를 obj에 담고 obj를 Board클래스로 다운캐스팅 한 후 board에 저장 그리고 반복 
			 (이 때, for문을 통해 요소를 저장 할 때 갱신되는게 아닌 obj에 요소들이 누적되는 형태?) : 요소가 누적되는게 아닌 갱신된다.  */
			
			
			System.out.println(board.getTitle());
			System.out.println(board.getContent());
			System.out.println("-----");
		}
		
		
		System.out.println();
	}
	public void printList4(List<?> boardList) { //바로 위 코드에서 boardList를 obj로 담지 않고 바로 다운캐스팅 해서 사용해보았을 때 출력되지 않음
		System.out.println("printList4");
		for (int i=0; i<boardList.size(); i++) {
			if (!(boardList instanceof Board)) {
				break;
			}
			else {
			Board board = (Board)boardList;
			System.out.println(board.getTitle());
			System.out.println(board.getContent());
			System.out.println("asdasd");
			}
		}
	}
}

class PhotoService implements BoardDefaultService {
	
	@Override
	public void printList3(List<?> photoList) {
		System.out.println("printList3");
		for (Object obj : photoList) {
			if (!(obj instanceof Photo)) return;
			
			Photo photo = (Photo)obj;
			
			System.out.println(photo.getTitle());
			System.out.println(photo.getContent());
			System.out.println(photo.getPhoto());
			System.out.println("-----");
		}
		System.out.println();
	}
}

class Board {
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + "]";
	}
}

class Photo extends Board {
	private String photo;

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Photo [title=" + getTitle() + ", content=" + getContent() + "photo=" + photo + "]";
	}
}


// 문제 1.
class Diary {
	private String title;
	
	public void setTitle(String a) {
		this.title = a;
	}
	
	public String getDiary() {
		return this.title;
	}
}
class DiaryService implements BoardDefaultService {
	
	public void printList3(List<?> diaryList) {
		System.out.println("printList3");
		for (Object obj : diaryList) {
	
			if (!(obj instanceof Diary)) return;
			
			Diary board = (Diary)obj; 	
			
			System.out.println(board.getDiary());
			System.out.println("-----");
		}
	}
}

/*
문제 1.
다이어리 클래스와 다이어리 서비스 클래스를 추가하세요. 
다이어리 서비스를 사용해 printList2 와 printList3를 호출하는 코드를 작성하세요.
*/ 