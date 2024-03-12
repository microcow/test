package cha11;

import java.util.Scanner;

public class Ex01Enumtest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Book book = Book.values()[s.nextInt()-1];
		Book book2 = book;
		System.out.println(Book.audoibook);
		
		switch (book2) {
		case book:
			System.out.println(book2.name());
		default:
			break;
		}
		
		
	}
}
enum Book{
	book, ebook, audoibook;
}