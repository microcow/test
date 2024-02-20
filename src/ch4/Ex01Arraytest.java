package ch4;

public class Ex01Arraytest {
	public static void main(String[] args) {
		
		int [] X = {50, 30, 0};
		
		System.out.printf("x[2] = %d%n", X[2]);
		
		System.out.printf("0번 인덱스와 1번 인덱스 중 큰 값은 %s", X[0] > X[1] ? "X[0]" : "X[1]");
	}

}
/*
문제 1.
정수형 변수 3개를 저장 할 수 있는 배열에 
인덱스 0번에 50, 인덱스 1번에 30, 인덱스 2번에 0을 저장하는 코드를 작성하세요.

문제 2.
문제 1에서 만든 배열의 인덱스 2번의 값을 출력하세요.

문제 3.
문제 1에서 만든 배열의 0번 인덱스와 1번 인덱스에 저장된 값 중 더 큰 값을 출력하세요.  
힌트) 삼항연산자를 사용하세요.
*/