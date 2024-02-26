package ch7;
import java.util.Arrays;
import java.util.Scanner;
public class Ex02Classtest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("도서관리 프로그램");
		test[] books = new test[10];
		int count = 0;
		
		boolean run = true;
		while (true) {
			System.out.println("메뉴를 선택하세요. 1:책등록, 2:책목록, 0:종료");
			System.out.print(">>");
			int menu = scanner.nextInt();
			switch (menu) {
			/* if 문을 사용했으면 if {(menu == 1),,,}을 쓰고 else if {(menu ==2),,,}로 진행되어서 앞서 if에서 선언된
			books[count]를 사용하지 못했겠지만, switch문은 case1에서 부터 훑으며 아래로 사용하기 때문에
			case 2에서도 case1에서 선언된 books[count]변수를 사용할 수 있음 */
			
				case 1: {
					books[count] = new test();
					// Book에 books[count]라는 객체 메모리,주소 생성
					// 배열 인스턴스에 메모리,주소 생성
					System.out.printf("책 제목%n");
					books[count].name = scanner.nextLine();
					// 인스턴스 메모리에 scanner로 저장하는법
					System.out.printf("저자%n");
					books[count].author = scanner.nextLine();
					System.out.printf("가격%n");
					books[count].price = scanner.nextInt();
					count++;
					break;
					// 책 제목과 저자가 같이 출력되는 이유
					
				}
				case 2: {
					for ( int a=0; a<books.length; a++)
					System.out.printf("책 제목 : %s%n 저자 : %s%n 가격 %d%n", books[a].name, books[a].author, books[a].price);
					break;
				}
					
			
			
				
			}
			
			
			
		
		}
				
			
	
		}
	}
	
class test { 
	String name;
	String author;
	int price;
}

/*
문제 1.
클래스를 이용하여 도서관리 프로그램 등록과 목록 기능을 개발하세요. 
*/