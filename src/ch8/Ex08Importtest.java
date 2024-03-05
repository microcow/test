package ch8;
import static java.lang.Math.floor; 
// floor() 메소드는 주어진 숫자보다 크거나 같은 가장 작은 정수를 반환합니다. 즉, 소수점 부분을 버리고 정수 부분만 남깁니다.
import static java.lang.Math.PI;


public class Ex08Importtest {
	public static void main(String[] args) {
		
		System.out.println((int)floor(PI));
		
	}

}
/*
문제 1.
Math.floor() 메소드를 사용하여 PI의 정수값만 출력하세요.
Math.floor() 메소드에 import static 을 적용하세요. 
*/