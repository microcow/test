package ch6;
import java.util.Scanner;
public class Ex06Whiletest {
	public static void main(String[] args) {
	int i = 2;
	while (i < 10) {
		int n = 1;
			while (n < 10) {
				System.out.printf("%d%n", i*n);
				n++;
			}
	}
	i++;
//다시해보기
	}
}

/*
문제 1.
while문도 for문처럼 중첩시킬 수 있습니다. 
중첩 while문을 이용해 구구단을 출력하세요. 
*/