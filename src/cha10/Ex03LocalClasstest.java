package cha10;
import java.util.Scanner;
public class Ex03LocalClasstest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("저자이름을 입력하세요");
		String bookauthor = scanner.nextLine();
		EBook10 test = new EBook10();
		test.author(bookauthor);
		

	}
}

class EBook10{
	
	void author (String name) {
		
		class Author{	 ///name2.charAt(i) 값이 A의 메모리 배열 수인 10보다 작을 경우 오류가 발생하는 이유
			char[] A= new char [10];
			
			boolean checkEng(String name) {
				char[] chs = name.toCharArray(); // 집가서
				for (int i=0; i<chs.length; i++) {
					if (!(chs[i] >= 'A' && chs[i] <='Z')) {
						return false;
					}
				}
				
				return true;
			}
			
			void setname (String name2) {
				for (int i=0; i<this.A.length; i++) {
					if ((name2.charAt(i) >= 'A' && name2.charAt(i) <='Z') || name2.charAt(i) == ' ') {
					this.A[i] = name2.charAt(i);
					continue;
					}
					else
						break;
				}
			}
			void getname () {
				for (int i=0; i<this.A.length; i++)
				System.out.print(this.A[i]);
			}
			
		}
		Author author = new Author();
		author.setname(name);
		author.getname();
		//return author.checkEng(name);
		
	}
}
	

			

		
		
		


	

/*
문제 1.
로컬 클래스를 사용하여 저자 이름 유효성 검사 메소드를 코딩하세요.
저자 이름은 영문 대문자, 공백만 가능합니다.
*/