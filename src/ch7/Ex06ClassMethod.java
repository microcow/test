package ch7;
//클래스 메서드는 인스턴스 변수를 사용하지 않거나 인스턴스 변수를 생성할 필요가 없을 때 사용한다. 
public class Ex06ClassMethod {
	public static void main(String[] args) {
		
		System.out.println(Book5.generateBookNo());
		// 클래스 메서드는 클래스 변수와 동일하게 인스턴스 생성 전 사용 가능하다.
		// 클래스 메서드는 클래스이름.메서드로 호출
		
		System.out.println();
		
		Book5 b1 = new Book5();
		b1.bookNo = Book5.generateBookNo();
		System.out.println(b1.bookNo);
		
		System.out.println();
		
		Book5 b2 = new Book5();
		b2.bookNo = Book5.generateBookNo();
		System.out.println(b2.bookNo);
		
	}

}

class Book5 {
	String title;
	int bookNo;
	
	static int generateBookNo() {
		return (int)(Math.random()*9000)+1000;
		// 클래스 메서드(스태틱 메서드)는 코드 실행과 동시에 가장 먼저 생성된다.
		/*  클래스 메서드(스태틱 메서드)는 클래스 변수(스태틱 변수)와 동일하게 타입 앞에 static이 붙으며,
		 	클래스 메서드(스태틱 메서드) 내에서 인스턴스 변수사용하려면 인스턴스 자체를 파라미터로 받아야한다.
		 	즉, 인스턴스 자체를 파라미터로 받지 않는 이상 특정 인스턴스의 개별 인스턴스 변수는 사용이 불가하다. 
		 	but, 클래스 메서드(스태틱 메서드)에서는 클래스 변수(스태틱 변수)는 사용 가능하며, 메서드 내에서만 생성하는 지역변수도 사용 가능	*/
		 // 추가적으로, 클래스 메서드(스태틱 메서드)에서는 this.title 등 this.변수이름 을 사용할 수 없다
		 
	}
	
	// 문제 1. 주석처리된 코드의 오류를 수정하세요.
	
	/*static int genBookNo() {
		bookNo = (int)(Math.random()*9000)+1000;
		return bookNo;
	}*/
	
	// genBookNo는 클래스 메소드이기에 인스턴스 변수인 bookNo를 사용할 수 없다.
	// bookNo를 사용하기 위해선 인스턴스 변수인 bookNo를 클래스 변수로 변경해주어야 한다.
}	

