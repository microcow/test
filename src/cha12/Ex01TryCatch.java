package cha12;
import java.util.Scanner;
public class Ex01TryCatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try { // 예외가 발생될만한 코드를 try 블럭안에 입력한다 (외부에 의한 오류가 발생할 것 같을 때 사용)
				// try 블럭 내에서 예외 발생 시 아래의 코드를 실행하지 않고 즉시 catch 블럭으로 이동한다
			System.out.print("문자열을 입력하여 예외를 발생시키세요:");
			int num = scanner.nextInt(); 
			// num은 int값이므로 nextInt에 문자열 입력 시 예외발생(아래 코드 미실행 후 catch 블럭으로 이동한다.)
			// 정상적으로 숫자 입력 시 catch문을 실행하지 않는다
			System.out.println(num);
			
		} catch (Exception e) {
			//→ 오류 발생 시 인스턴스 속성들이 메모리에 올라가고(인스턴스생성) catch는 그 메모리(인스턴스)를 형체화시킴 (Exception e로 받고있음)
			System.out.println("숫자만 입력 가능 합니다.");
			
			//e.printStackTrace();
			
			
			
		}
		
		System.out.println("프로그램이 종료됩니다.");
	}
}
