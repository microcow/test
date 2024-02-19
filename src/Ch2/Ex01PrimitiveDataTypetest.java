package Ch2;

public class Ex01PrimitiveDataTypetest {
	public static void main(String[] args) {
		double i = 3.14;
		System.out.printf("i의 값은 \t%3.2f입니다. \n\n", i);
		
		float f = 7.77f;
		System.out.printf("f의 값은 \t%3.2f입니다. \n\n", f);
		
		long b = 3000000000L;
		System.out.printf("b의 값은 \t%d입니다. \n", b);
	}
}
/* 
문제1.
int i = 3.14;
float f = 7.77; 
boolean b = 5;
오류가 나지 않도록 수정 후 출력하세요. 
*/ 

// 숫자 + 숫자 = 숫자열 리터럴
// 숫자 + 문자 = 숫자도 문자열 리터럴로 형변환됨