package cha15;

public class Ex01WrapperClasstest {
	public static void main(String[] args) {
		int a = 3;
		int b = 7;
		Integer intgA;
		Integer intgB;
		Integer intgC;
		
		// 문제 1.
		intgA = Integer.valueOf(a);
		intgB = Integer.valueOf(b);
		
		// 문제 2.
		intgC = intgA+intgB;
		System.out.println(intgC);
		
		System.out.println(Integer.sum(intgA, intgB));
		
		// 문제 3.
		System.out.println(intgA.compareTo(intgB));
		System.out.println(intgB.compareTo(Integer.valueOf(3)));
		
		// 문제 4.
		System.out.println(Integer.max(intgA, intgB));
		System.out.println(Integer.min(intgA, intgB));
	}

}
/*
문제 1.
int a = 3;
int b = 7;
Integer intgA;
Integer intgB;
a와 b의 값을 갖는 intgA, intgB를 코딩하세요.

문제 2.
intgA와 intgB의 값을 더한 뒤 int로 변환하여 출력하세요.

문제 3.
intgA와 intgB의 값을 compareTo를 이용하여 비교하고 더 큰 값을 출력하세요.

문제 4.
intgA 와 intgB의 최소값과 최대값을 구하세요.
힌트) max, min을 사용하세요.
*/