package cha12;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex02MultipleCatchBlock {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = {3, 5, 7};
		
		try {
			
			System.out.print("0~2 숫자를 입력하세요: ");
			int i = scanner.nextInt();
			// 메소드 클릭 시 노출되는 툴팁(api문서)의 Throws 부분에 오류가 발생할 수 있는 부분을 알려준다
			
			System.out.print("0 이외의 숫자를 입력하세요: ");
			int num = scanner.nextInt();
			
			System.out.println(arr[i] / num);
			// jvm(자바 가상 머신)에서 발생한 오류를 런타임익셉션(실행오류)이라 한다
			
		} catch (InputMismatchException e) {
			// 입력값이 미스매치일 때 예외 클래스
			System.out.println("숫자만 입력 가능 합니다.");
			
		} catch (ArithmeticException e) {
			// 산술이 오류났을 때 예외 클래스
			System.out.println("산술 예외가 발생되었습니다.");	
		} 
		// 문제 1
		// java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
		catch (ArrayIndexOutOfBoundsException e) { // 해당 catch문이 Exception catch문보다 아래에 있을 경우 컴파일에러 발생
			System.out.println("0~2를 초과하는 숫자를 입력하셨습니다.");
		}
		catch (Exception e) { 
			// ★ Exception 클래스는 모든 예외 클래스의 부모클래스이다(모든 ~~Exception 클래스는 Exception 클래스를 상속받고 있다.)
			// ★ 즉, Exception으로는 어떤 예외든 업캐스팅해서 받을 수 있다. (catch (클래스명 파라미터)라고 생각)
			// ★ 따라서, 다른 catch블럭에서 예외처리가 되지 않을경우 해당 Exception클래스의 catch 블럭으로 이동한다.
			// ★ 또한, catch 문은 위에서 부터 순서대로 훑기때문에 Exception클래스의 catch문 보다 아래에 다른 클래스의 catch문이 있다면, 해당 catch문은 컴파일에러가 발생할 수 있다.
			System.out.println("예외 발생!!!");
			e.printStackTrace();
			// ★ printStackTrace() 메소드로 예외를 받은 e로 호출해보면 어떤 오류가 발생했는지 알 수 있다.
		}
		// ★ 예외가 발생할 경우엔 catch블럭 중 하나만 실행된다.
		
		System.out.println("프로그램이 종료됩니다.");
	}


}
/*
문제 1.
i에 0~2 이외의 숫자를 입력하여 예외를 발생 시키세요.

문제 2.
문자열을 입력하여 예외를 발생 시키세요.

문제 3.
num에 0을 입력하여 예외를 발생 시키세요.

문제 4.
예외가 발생되지 않도록 값을 입력한 뒤 실행하세요.
*/
