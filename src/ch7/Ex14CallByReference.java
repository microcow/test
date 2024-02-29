package ch7;

public class Ex14CallByReference {

		public static void main(String[] args) {
			
			Ex12Book book = new Ex12Book("자바문법", "엘컴퓨터학원");
			System.out.println("책 번호: " + book.bookNo);
			// Ex12Book 생성자가 bookNo의 값을 돌려주지 않았기에 책 번호는 0으로 출력
			
			
			
			Ex12Book.generateBookNo(book);
			System.out.println("책 번호: " + book.bookNo);
			// generateBookNo 메소드에서 bookNo의 값을 돌려주었다. (콜바이레퍼런스)
		} 

}
