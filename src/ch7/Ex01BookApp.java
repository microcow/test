package ch7;
import java.util.Arrays;
import java.util.Scanner;
public class Ex01BookApp {
	public static void main(String[] args) { // 이번 강의에서는 객체지향적이지 않은 방법(인스턴스 미사용)으로 프로그래밍하면 어떤점이 불편한지 알아보는 강의
		Scanner scanner = new Scanner(System.in);
		System.out.println("도서관리 프로그램");
		String[] arrTitle = new String[10];
		String[] arrAuthor = new String[10];
		int[] arrPrice = new int[10];
		
		int bookCount = 0;
		
		boolean run = true;
		while (true) {
			String title = "";
			String author = "";
			int price = 0;
			
			System.out.println("-------------");
			System.out.println("메뉴를 선택하세요. 1:책등록, 2:책목록, 0:종료");
			System.out.print(">>");
			int menu = scanner.nextInt();
			scanner.nextLine();
			//nextInt와 nextLine을 섞어쓰려면 nextInt다음에nextInt가 오도록 사용
			// 둘 다 menu에 귀속
			
			switch (menu) {
				case 1:
					System.out.println("책을 등록하세요.");
					System.out.print("제목:");
					title = scanner.nextLine();
					System.out.print("저자:");
					author = scanner.nextLine();
					System.out.print("가격:");
					price = scanner.nextInt();
					System.out.printf("제목: %s, 저자: %s, 가격: %d%n%n", title, author, price);
					
					arrTitle[bookCount] = title;
					arrAuthor[bookCount] = author;
					arrPrice[bookCount] = price;
					bookCount++;
					break;  // switch에 사용된 break는 switch 문만 빠져나감
							// switch도 반복문이니까 (break;는 가장 가까운 반복문을 빠져나간다)
				case 2:
					System.out.println("책의 목록을 확인합니다.");			 
					for (int a = 0; a < arrTitle.length && a < arrAuthor.length && a < arrPrice.length; a++) {
						if (arrTitle[a] != null) {
						System.out.printf("제목 :" +  arrTitle[a]);
						}
						if (arrAuthor[a] != null) {	
						System.out.printf("저자 :" +  arrAuthor[a]);
						}
						if (arrPrice[a] != 0) { 
						System.out.printf("가격 : %d%n",  arrPrice[a]);
						}
					}
						// 비어있는 문자열(nextLine)은 null 숫자열(nextInt)는 0 으로 표기된다
						// a<=10이 아닌 배열변수.length를 입력
					
					continue;
				case 0:
					run = false;
					break;
			}
			
			if (!run)
				break;
		}
		System.out.println("프로그램이 종료됩니다.");
		//while 문을 빠져나오지 않았기 때문에 0번을 입력하기 전까지 위 스트링은 출력되지않음
	}

}
