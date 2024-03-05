package com.test.main;

import com.test.book.Book;
// ch08.Ex06이란 패키지에도 public으로된 Book이란 클래스가 있으나,
//import를 위의 주소로 했기 때문에 해당 패키지에 있는 Book클래스가 import됨

public class BookTest {
	public static void main(String[] args) {
		Book title = new Book();
		System.out.println(title.gettitle());
		// gettitle메소드의 타입이 void였다면 return값이 없기 때문에
		// 위와 같이 메소드로 출력이 불가하다
	}

}
