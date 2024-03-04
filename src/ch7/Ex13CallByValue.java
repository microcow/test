package ch7;

public class Ex13CallByValue {
	public static void main(String[] args) {
		Ex12Book book = new Ex12Book("자바문법", "엘컴퓨터학원");
		// 다른 페이지(Ex12)에 있는 생성자를 불러올 수도 있다. (콜바이벨류)
		// 단, 받고자 하는 class 이름을 명확히 적어야한다. (Ex12Book)
		
		// 아규먼트에 인스턴스 변수 값을넣어 불러오는 걸 콜바이벨류라 한다 
		
		System.out.println("책 번호: " + book.bookNo);
		
		Ex12Book.generateBookNo(book.bookNo);
		// 다른 페이지(Ex12)에 있는 메소드도 불러올 수 있다. (콜바이벨류)
		// 단, 받고자 하는 class 이름을 명확히 적어야한다. (Ex12Book)
		
		System.out.println("책 번호: " + book.bookNo);
		
		Ex12Book.generateBookNo(book);
		System.out.println("책 번호: " + book.bookNo);
	}
}
