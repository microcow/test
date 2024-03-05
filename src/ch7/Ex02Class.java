/*
 * Copyright 2022. 이신만 <rngooqw@gmail.com> All rights reserved.
 */

package ch7;

public class Ex02Class {
	public static void main(String[] args) {
		Book book1 = new Book();
		// Book book1 : Book 타입의 인스턴스 book1 생성
		// new Book(); : book1의 인스턴스(객체)메모리와 주소를 생성함과 동시에 Book이라는 생성자 호출
		// 이때 변수인 book1은 참조변수 혹은 인스턴스(객체)라 부른다 (값을 저장하지 않고 주소를 저장하고 있기 때문)
		book1.title = "자바문법책";
		book1.author = "엘컴퓨터학원";
		book1.price = 50000;
		// 각각의 변수는 구분할 수 있지만 하나의 객체(모두 book1에 포함)로서 book1에 저장된다
		// 인스턴스.변수이름 : book1의 한 변수의 주소 (즉, book1.price = 50000; 은 book1인스턴스의 price변수 주소에 50000이라 저장
		System.out.println(book1.title);
		System.out.println(book1.author);
		System.out.println(book1.price);
		
		System.out.println();
		
		Book book2 = new Book();
		book2.title = "C문법책";
		book2.author = "엘컴퓨터학원";
		book2.price = 35000;
		System.out.println(book2.title);
		System.out.println(book2.author);
		System.out.println(book2.price);
		
		System.out.println();
		
		Book[] arrBook = new Book[2];
		// Book[]으로 생성된 Book타입의 배열 arrBook은 Book타입의 인스턴스를 저장할 수 있는 배열이다
		arrBook[0] = book1;
		arrBook[1] = book2;
		
		for (int i=0; i<arrBook.length; i++) {
			System.out.printf("제목: %s, 저자: %s, 가격: %d%n", arrBook[i].title, arrBook[i].author, arrBook[i].price);
		}
	}

}

//class는 객체를 만드는 설계도이다
//class 타입은 대부분 실제 존재하는 사물을 기준으로 둔다
class Book { 
	String title;
	String author;
	int price;
	// Book이라는 변수는 위 3가지의 변수를 가진 class가 된다
	// 위 세개의 변수는 따로가 아닌 하나의 객체로서 저장된다
	
}
