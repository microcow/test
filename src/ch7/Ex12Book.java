package ch7;

public class Ex12Book {
		String title;
		String author;
		int bookNo;

		Ex12Book(String title, String author) {
			this.title = title;
			this.author = author;
		}
		
		static void generateBookNo(int bookNo) {
			bookNo = (int)(Math.random()*9000)+1000;
			// 파라미터로 아규먼트를 받았지만, 다시 넘겨주는 코드가 없으므로
			// 넘겨준 아규먼트의 수치는 변동이 없을 것이다
		}
		
		static void generateBookNo(Ex12Book book) {
			book.bookNo = (int)(Math.random()*9000)+1000;
			// 파라미터로 아규먼트를 받은 후 다시 넘겨주었으므로
			// 넘겨준 아규먼트의 수치에 변동이 있을 것이다 (콜바이레퍼런스)
			
		}
}
