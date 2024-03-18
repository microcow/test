package cha14;

public class Ex04StringBuffertest {
	public static void main(String[] args) {
		String str = "안 녕 하세 요, 자바 기본 문법 엘 컴퓨터 학원 입니다."; // 문자열	
		char[] chArr = str.toCharArray(); // 문자열을 char타입으로 바꾼 후 그걸 담을 배열 생성
		StringBuffer text = new StringBuffer(); // char타입으로 저장된 배열의 문자들을 하나하나 담을(누적시킬) 인스턴스 생성
		// toCharArray 메소드는 호출자의 문자열을 char타입으로 바꾼 후 배열로 return해준다 (문자열 좌측부터 배열 0에 저장)
		for (int j=0; j<chArr.length; j++) {			
			text.append(chArr[j]); // append 메소드를 통해 char타입을 문자열로 저장
			
		}
		text.toString(); // text를 String타입으로 변환
		System.out.println(text);
	
	//문제를 StringBuffer 타입이 아닌 String타입으로도 풀어보았음
	String str2 = "안 녕 하세 요, 자바 기본 문법 엘 컴퓨터 학원 입니다.";
	String str3 = "";
	char[] chArr2 = str2.toCharArray(); 
	for (int j=0; j<chArr.length; j++) {			
		str2 = str2+chArr2[j];	
		str3 = str3+chArr2[j];	
	}
	System.out.println(str2);
	System.out.println(str3);
	}
}
/*
문제 1.
String str = "안 녕 하세 요, 자바 기본 문법 엘 컴퓨터 학원 입니다.";
위 문자열을 char[] 타입으로 변환하세요.
StringBuffer를 이용해 문자열로 만들어 출력하세요. 
*/