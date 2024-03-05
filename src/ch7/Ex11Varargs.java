package ch7;
import java.util.Arrays;
public class Ex11Varargs {
	public static void main(String[] args) {
		Book12 book1 = new Book12();
		book1.title = "자바 문법";
		book1.author = "엘컴퓨터학원";
		book1.setTag("컴퓨터", "IT", "프로그램 언어", "자바");
		Book12.printInfo(book1);
		// 인스턴스(참조변수) 자체를 아규먼트로 하여 메소드 호출
		// tip) 참조변수를 던질 땐(클래식 메소드) 메소드 앞에 클래스이름, 그냥 인스턴스 변수를 던질 땐(그냥 메소드) 메소드 앞에 인스턴스 이름
		// tip2) 참조변수를 받을 땐(클래식 메소드) 파라미터 앞에 클래스이름, 그냥 인스턴스 변수를 받을 땐(그냥 메소드) 파라미터 앞에 타입(void, int 등등)
		
		
		Book12 book2 = new Book12();
		book2.title = "C 문법";
		book2.author = "엘코딩";
		book2.setTag("IT", "프로그램 언어");
		Book12.printInfo(book2);
	}

}

class Book12 {
	String title;
	String author;
	String[] tag;
	
	void setTag(String... params) {
		//...은 가변인자이다 (타입 + ... + 파라미터)를 입력하면 아규먼트가 몇개이든 파라미터가 받을 수 있다.
		// 받은 값은 배열로 저장되며, 배열과 동일하게 왼쪽(params[0])부터 저장된다
		// 받은 만큼만 배열(메모리)을 생성  예) 4개를 받았을 경우 params[3]까지만 메모리 생성, 메소드 종료 시 삭제
		System.out.println(Arrays.toString(params));
		// params 파라미터가 받은 내용물 확인
		tag = new String[params.length];
		// params.length의 길이만큼 배열 생성 (선언은 위에서 했고, 메모리 생성은 지금하는 것)
		for (int i=0; i<tag.length; i++) {
			tag[i] = params[i];
		}
	}
	
	static void printInfo(Book12 book) { 
		// 위 클래식 메소드(스태틱 메소드)에서 인스턴스(참조변수)를 통째로 파라미터로 받고있다 // 예를 들어 book1을 받았다면 Book12 book = book1과 동일한 말이다
		// 이 때 주의해야 할 점은 주는 인스턴스와 위에 적힌 받는 클래스(Book12)가 동일해야한다. // 즉, 클래스만 동일하다면 해당 메소드와 다른 클래스의 인스턴스도 받을 수 있다.
		// 인스턴스를 통째로 파라미터로 받을 경우 클래식 메소드(스태틱 메소드)에서도 받은 인스턴스의 개별 변수 사용이 가능하다.
		// 정확히 말하면, 받은 인스턴스와 '동일한 메모리 값과 구조'를 가진 book(지역변수)이기에 book.title과 같은 개별 변수를 사용할 수 있다.
		
		// tip) 참조변수(인스턴스)를 던질 땐(클래식 메소드) 메소드 앞에 클래스이름, 그냥 인스턴스 변수를 던질 땐(그냥 메소드) 메소드 앞에 인스턴스 이름
		// tip2) 참조변수(인스턴스)를 받을 땐(클래식 메소드) 파라미터 앞에 클래스이름, 그냥 인스턴스 변수를 받을 땐(그냥 메소드) 파라미터 앞에 타입(void, int 등등)
		
		System.out.printf("제목: %s%n저자: %s%n", book.title, book.author);
		System.out.printf("카테고리: %s%n%n", Arrays.toString(book.tag));
		//book2라는 인스턴스가 던져졌으나, 클래식 메소드이기에 book2를 사용하지 않고 인스턴스를 받은 book을 사용
		// tag가 class Book12 에서 배열로 선언되었기에 Arrays.toString으로 내용물 확인
	}
}
