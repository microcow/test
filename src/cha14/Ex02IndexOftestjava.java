package cha14;

public class Ex02IndexOftestjava {
	public static void main(String[] args) {
		String test = "안녕하세요, 엘컴#퓨터@@학원 입니다.!~%";
		String filter = ",@!~%#";
		String result = "";
		for (int i=0; i<test.length(); i++) {
			char ch = test.charAt(i);
	
			if (filter.indexOf(ch) == -1) {
				result += String.valueOf(ch);		
			}
		}
		System.out.println(result);
		String target = " ";
		int pos = 0;
		int count = 0;
		while ( (pos = test.indexOf(target, pos)) != -1 ) {
			pos += target.length();
			count++;
		}
		System.out.println(count);
	}

}
/*
문제 1.
"안녕하세요, 엘컴#퓨터@@학원 입니다.!~%"
위 문자열에서 ,@!~%# 문자를 제거한 뒤 출력하는 프로그램을 코딩하세요.

문제 2.
위 문자열에서 공백의 수를 카운팅하여 출력하세요.
*/