package cha15;

public class Ex02Autoboxingtest {
	public static void main(String[] args) {
		// intValue 메소드는 호출자의 값을 int타입으로 바꾸어 return한다.
		// Interger.valueOf 메소드는 아규먼트를 int 타입에서, 해당 값을 인스턴스 변수로 가진 Integer클래스의 참조형(인스턴스)로 return한다.
		Integer intgA = 3;
		Integer intgB = 7;
		int sum = intgA + intgB;
		System.out.println(sum);
		
		Integer intgC = Integer.valueOf(3);
		Integer intgD = Integer.valueOf(7);
		Integer sum2 = Integer.valueOf(intgC.intValue() + intgD.intValue());
		System.out.println(sum2);
	}
}
/*
문제 1.
Integer intgA = 3;
Integer intgB = 7;
int sum = intgA + intgB;
위 내용을 오토박싱과 오토언박싱이 필요 없는 코드로 수정하세요.
*/