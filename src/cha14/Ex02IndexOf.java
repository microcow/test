package cha14;

public class Ex02IndexOf {
	public static void main(String[] args) {
		String s1 = "자바 기본문법 엘컴퓨터학원 자바 알고리즘 엘컴퓨터학원 자료구조";
		String target = "엘컴퓨터학원";
		System.out.println(s1.indexOf(target));
		// .indexof() 메소드는 호출자의 내용에서 아규먼트의 내용 부분을 찾아서 retrun한다. ("다음 첫번째 문자열을 시작으로 0부터 카운팅)
		// 해당 내용이 없을 경우 -1을 return한다.
		System.out.println(s1.lastIndexOf(target));
		// .laseIndexOf() 메소드는 호출자의 내용에서 아규먼트의 내용 부분과 일치하는 곳 중 제일 끝에있는 부분을 찾아서 return한다. (" 와 자 사이를 시작으로 0부터 카운팅)
		
		String s2 = "[엘컴퓨터학원] 자바 기본문법!! (자료구조 포함) ";
		String filter = "[]() ";
		String result = "L";
		for (int i=0; i<s2.length(); i++) { // 문자열.length를 입력 시 문자열의 길이를 return한다
			char ch = s2.charAt(i);
			// charAt() 메소드는 괄호내에 있는 숫자의 순서에 맞는 문자열 하나를 캐릭터 타입으로 return한다. 
			
			if (filter.indexOf(ch) == -1) {
				result += String.valueOf(ch); // result = result + String.valueOf(ch); 와 동일한 코드			
				// filter.indexOf(ch) == -1일 경우(ch의 내용이 filter에 없을 때) 해당 내용을 String타입으로 result에 누적시킨다. (valueOf 메소드는 괄호 안에 있는 내용을 String타입으로 변환한다)
				// 단, result += ch;과 같이 String타입에 char타입을 더해도 자동으로 char타입이 String타입으로 저장된다
			}
		}
		System.out.println(result);
		System.out.println();
		
		s2 = "엘,컴, 퓨, 터, 학, 원,  자바 기본, 문, 법,,";
		target = ",";
		int pos = 0;
		int count = 0;
		while ( (pos = s2.indexOf(target, pos)) != -1 ) {
			// indexOf 메소드의 아규먼트가 2개가 있을 경우(String타입, int타입) 두번째 아규먼트 숫자로 부터 target을 찾아라는 메소드이다.
			// s2.indexOf(target, pos)가 -1이 아닐 경우 pos에 그 값을 저장
			pos += target.length();
			// 해당 코드가 없다면 반복문에서 이미 찾은 targer의 동일한 부분을 계속해서 저장할 것이다
			// 최초 ","을 찾았을 때의 indexOf는 1이란 값을 반환하며, pos는 1이 될것이고 해당 코드에서 target.length();만큼 더해주었기에 pos는 2가되고 반복문이 재시작 되면 indexOf는 2부터 카운팅을 할 것이다
			count++;
			/// pos가 0일 경우 while문이 거짓이므로 while문이 멈춰야하지 않나? : 아님. indexOf 메소드는 해당 문자열의 위치를 찾을때까지 훑음
			/// 그럼 끝까지 다 찾은 뒤에 pos가 s2.length보다 클 경우에 멈추는건가? (카운팅을 시작하는 위치인 pos가 s2의 문자열 보다 클 경우에 멈추는가?) : yes. 보다 클 경우 -1 반환함
		}
		System.out.println(count);
		
		pos = 31;
		System.out.println(s2.indexOf(target, pos));
		System.out.println(target.length());
		System.out.println(s2.length());
	}
}
