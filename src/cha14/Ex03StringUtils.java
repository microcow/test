package cha14;
import java.util.Arrays;
import java.util.Locale;
public class Ex03StringUtils {
	public static void main(String[] args) {
		String s1 = "엘컴퓨터학원";
		String s2 = "엘컴퓨터학원";
		System.out.println(s1.compareTo(s2));	// 0
		// compareTo 메소드는 두 인스턴스 중 누구의 첫번째 문자열 유니코드가 더 큰지 return해준다.
		// 호출자가 더 크면 양수를, 아규먼트가 더 크면 음수, 같으면 0을 return한다.
		s2 = "자바 기본문법";
		System.out.println(s1.compareTo(s2));	// 음수
		s2 = "가나다라";
		System.out.println(s1.compareTo(s2));	// 양수
		System.out.println();
		
		s1 = "엘컴퓨터학원";
		System.out.println(s1.contains("컴퓨터"));
		// cintains 메소드는 호출자가 아규먼트를 포함하고 있을 경우 true를 반환한다.
		System.out.println(s1.contains("자바"));
		System.out.println();
		
		s1 = "엘컴";
		s2 = "퓨터학원";
		System.out.println(s1.concat(s2));
		// concat 메소드는 호출자와 아규먼트의 문자열을 합친 값을 return한다
		System.out.println();
		
		s1 = "엘컴퓨터학원 자바 기본문법";
		s2 = "자바 기본문법 엘컴퓨터학원";
		System.out.println(s1.startsWith("엘"));
		// startsWith 메소드는 호출자가 아규먼트의 문자열로 시작한다면 true를 return한다.
		System.out.println(s2.startsWith("엘"));
		System.out.println(s1.endsWith("원"));
		// endsWith 메소드는 호출자가 아규먼트의 문자열로 끝난다면 true를 return한다.
		System.out.println(s2.endsWith("원"));
		System.out.println();
		
		s1 = "Quit";
		System.out.println(s1.equals("quit"));
		// String클래스의 equals 메소드는 호출자와 아규먼트의 문자열이 같다면 true를 반환한다 (대소문자도 비교)
		System.out.println(s1.equalsIgnoreCase("quit"));
		// equalsIgnoreCase 메소드는 대소문자는 비교하지 않고 내용만 확인하여 결과를 return한다.
		System.out.println();
		
		s1 = "안녕하세요!! 엘컴퓨터!!학원!!입니다.!!!";
		System.out.println(s1);
		System.out.println(s1.replace("!", ""));
		// replace 메소드는 호출자의 문자열에서 첫번째 아규먼트를 두번째 아규먼트로 대체하여 retunr한다.
		System.out.println();
		
		s1 = "안녕하세요12 엘컴퓨터34학원56입니다.7890";
		System.out.println(s1);
		System.out.println(s1.replaceAll("[0-9]", ""));		// 정규표현식
		// replaceAll 메소드는 호출자의 문자열에서 첫번째 아규먼트 범위에 해당하는 문자열을 모두 두번째 아규먼트로 대체하여 retunr한다.
		// [0-9](0에서 9까지의 숫자) 등과 같이 범위로 검색가능 (정규표현식)
		
		s1 = "자바 기본문법";
		int i = 75300000;
		double pi = 3.14159265359;
		System.out.println(String.format("%20s", s1));
		//String.format 메소드는 두번째 아규먼트를 첫번째 문자열의 형태로 바꾸어준다
		//%20s는 s1의 문자열을 20글자로 바꾸어주며 20글자가 안되어 부족한 공간은 좌측의 공백으로 만든다
		System.out.println(String.format("%,d", i));
		// %,d 는 정수를 출력할 때 사용하며 두번째 아규먼트의 숫자에 단위마다 ,를 붙여서 출력한다.
		System.out.println(String.format("%#6.3f", pi));
		//%#6.3f는 두번째 아규먼트의 숫자 전체6자리(.포함), 소숫점 아래 3자리까지 출력된다. 부족한 공간은 좌측 공백
		System.out.println(String.format("%06.3f", pi));
		//%06.3는 위와 동일하지만, 부족한 공간을 0으로 채운다.
		System.out.println();
		
		s1 = "ABCDEfghiJKlmN";
		System.out.println(s1.toLowerCase());
		// toLowerCase 메소드는 호출자의 문자열을 전부 소문자로 바꾸어준다.
		System.out.println(s1.toUpperCase());
		// toUpperCase 메소드는 호출자의 문자열을 전부 대문자로 바꾸어준다.
		System.out.println();
		
		s1 = "  A BC def GH I   ";
		System.out.println("[" + s1.trim() + "]");
		// trim 메소드는 호출자 문자열의 좌,우의 공백을 전부 제거해준다.
		System.out.println();
		
		s1 = "자바 기본문법 엘컴퓨터학원알고리즘";
		System.out.println(s1.substring(8));
		// substring(int) 메소드는 호출자의 아규먼트 숫자 인덱스의 문자열부터 출력한다.
		System.out.println(s1.substring(8, 14));
		// substring(int,int) 메소드는 호출자의 아규먼트 숫자 인덱스의 문자열부터 두번째 아규먼트 숫자 인덱스 -1 까지출력한다.
		System.out.println();
		
		s1 = "엘컴퓨터학원";
		char[] chArr = s1.toCharArray();
		// toCharArray 메소드는 호출자의 문자열을 char타입으로 바꾼 후 배열로 return해준다 (문자열 좌측부터 배열 0에 저장)
		for (int j=0; j<chArr.length; j++) {
			System.out.println(chArr[j]);
		}
		System.out.println();
		
		s1 = "자바  기본    문법  엘 컴퓨터 학원 ";
		String[] strArr1 = s1.split(" +");
		// split 메소드는 호출자의 문자열을 아규먼트에 해당하는 부분을 기준으로 잘라서 배열로 return한다.
		// 위 예시는 공백을 기준으로 잘라서 배열에 저장한다. (+의 의미(정규표현식)는 좌측에 있는 문자열(공백)일 경우에 잘라라는 말)
		// 즉, s1.split("  +");와 같이 공백이 2칸이라면, '엘 컴퓨터 학원' 부분은 공백이 한칸이므로 잘리지 않음
		System.out.println(strArr1[0] + strArr1[1]);
		System.out.println(Arrays.toString(strArr1));
		//Arrays.toString 메소드는 아규먼트의 배열에 저장된 값을 모두 ,로 구분하여 []에 감싸서 return한다. (배열만 아규먼트로 가능)
		strArr1 = s1.split(" +", 3);
		// split 메소드의 아규먼트가 두개일 경우, 첫번째 아규먼트를 두번째 아규먼트의 수 만큼만 배열이 되게 잘라라는 의미 (첫번째 아규먼트 부분을 기준으로 잘른 후 배열에 저장하는데, 배열이 3개가 되었다면 더이상 자르지 말라)
		System.out.println(Arrays.toString(strArr1));
		System.out.println();
		
		s1 = "asdfasdf";
		System.out.println(s1.matches("[a-z]"));
		
		System.out.println(s1.matches("[a-z]+"));
		// matches메소드는 호출자의 문자열이 아규먼트 범위 내에 있는지 확인 후 결과를 return한다.
		// 단, 아규먼트 범위에 +가 없다면, 호출자의 문자열이 하나만 존재하는게 아닌 이상 false로 반환된다
		// 즉, 호출자의 문자열이 하나 이상일 경우 범위에 +를 붙여야한다.
		s1 = "12341234";
		System.out.println(s1.matches("[0-9]+"));
		s1 = "12341zz234";
		System.out.println(s1.matches("[0-9]+")); // zz가 섞여있으므로 false
		System.out.println();
		
		String[] strArr2 = {"자바", "기본문법", "엘컴퓨터", "학원"};
		System.out.println(String.join(", ", strArr2));
		//String.join 메소드는 두번째 아규먼트의 배열 사이사이에 첫번째 아규먼트 내용을 넣고, 모든 배열에 저장된 값을 합친 후 return한다.
		System.out.println();
	}
}
