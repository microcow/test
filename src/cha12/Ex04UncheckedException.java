package cha12;
import java.io.File;
import java.io.IOException;
public class Ex04UncheckedException {
	public static void main(String[] args) {
		
		File f = new File("./src/com/lcomputerstudy/books/java/ch12/hello.txt");
						//해당 경로에 있는 파일을 이용해서 인스턴스를 생성한다	
		try {	
			f.createNewFile();
		// createNewFile메소드를 호출함과 동시에 경로의 파일이 생성된다
		// 하지만, 예외처리를 하지 않았기에 컴파일타임에서 에러 발생
		// ★ 에러가 발생할 수 있는 위험 부분을 trycatch로 예외처리를 안해주었을 경우에 java에서 컴파일 오류를 발생시킨다. 이를 Checked Exception이라고 한다.
		// trycatch를 하지 않았을 경우 (Unhandled exception type IOException)이라고 컴파일 오류 발생
		}
		catch (IOException e){
			e.printStackTrace();
		}	//(어떤 오류가 발생하는지 알려주는 메소드)
		
		
		
		int[] arr = {3, 7, 5};
		System.out.println(arr[5]);
		// ★ 이처럼 에러가 발생할 수 있는 부분이지만 굳이 trycatch로 예외처리 하지 않아도 java에서 컴파일 오류를 발생키지 않는 것을 Unchecked Exception라고 한다.
		// 그 이유는 웬만한 경우는 개발자 역량으로 오류를 수정하게 하기때문.
		/*https://docs.oracle.com/javase/8/docs/api/index.html 해당 페이지에서 
		 ★ java.lang-Exceptions-Exception 부분에서 Runtime Exception과 그 자식클래스를 제외하고 모든 Exception은 Checked Exception이다.
		 */
	}
}
/*
문제 1.
f.createNewFile 의 주석을 제거합니다.
발생된 예외를 try catch 를 이용하여 처리하세요.
*/