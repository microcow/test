package cha10;
import java.util.Scanner;
public class Ex03LocalClasstest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("저자이름을 입력하세요");
		String bookauthor = scanner.nextLine();
		EBook10 test = new EBook10();
		test.author(bookauthor);
		test.getname(test.name12);
		

	}
}

class EBook10{
	char name12;
	
	boolean author (String name) {
		
		class Author{			
			char A;
			char setname (String name) {
				A = name.charAt(0);
				return A;
			}	////// 내부클래스에 집어넣기
		}
		Author B = new Author();
		if ((B.setname(name) >='A' && B.setname(name) <='Z')||B.setname(name) == ' ') {
			name12=B.setname(name); //B.setname(name)의 값이 return A;로 치환되는 것임
			return true;
		}
		else return false;
	}
	void getname(char A) {
		this.name12 = A;
		System.out.print(this.name12);
	}
	

			
}
		
		
		


	

/*
문제 1.
로컬 클래스를 사용하여 저자 이름 유효성 검사 메소드를 코딩하세요.
저자 이름은 영문 대문자, 공백만 가능합니다.
*/