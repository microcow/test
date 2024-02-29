package ch6;

import java.util.Scanner;

public class Ex09DoWhiletest {
	public static void main(String[] args) {
		char ch = 'A'; //따옴표 사이 빈공백 필수
		do {
			System.out.println(ch);
			ch++;
		}	
		
		while (ch != 'Z');
			System.out.print(ch + "\n" + "프로그램 종료");
		
		
				
	}
}
/*
문제 1.
do while문을 사용하여 대문자 Z가 입력될 때까지 입력된 문자를 출력하는 코드를 작성하세요.
Z가 입력되면 프로그램을 종료한다는 문구를 출력 후 프로그램을 종료하세요. 
*/