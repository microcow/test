package ch8;
// 해당 필드가 어느 패키지에 위치하고 있는지는 제일 상단에 위치해야한다.

import ch08.Ex06.Book;
// 폴더 단위를 .으로 구분한다

public class Ex10Package {
	public static void main(String[] args) {
		Book book = new Book();
		book.title = "엘컴퓨터학원";
		System.out.println(book.gettitle());
	}
}
