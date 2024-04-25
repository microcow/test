package ch6;
import java.util.Scanner;
public class Ex06While {
	public static void main(String[] args) {
		//while문의 기능을 for문으로 대체 가능하다
		//하지만 변수++; 혹은 변수--; 등과 같은 반복적인 경우, while문이 더 편리하기도 하다
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("생산할 TV의 수량을 입력하세요:");
		int tvCount = scanner.nextInt();
		
		int i = 0;
		while (i < tvCount) {
			System.out.println("TV 1대를 생산하였습니다.");
			i++;
			//★★ while 문이 참일경우, 반복하게된다 (즉, wile문이 거짓일 경우 반복문 종료)
			//i가 증가하지 않는다면 tvCount보다 항상 작기때문에 출력을 무한히 반복하게된다(무한루프)
		}
	}
}
