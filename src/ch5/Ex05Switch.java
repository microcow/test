package ch5;

public class Ex05Switch {
		public static void main(String[] args) {
			// switch는 elseif와 같은 기능이지만 가독성이 더 좋음
			
			int level = 5;
			String name = ""; 
			
			switch (level) {
				case 2:
					// switch는 case(변수값): 로 구분
				case 3:
				case 4:
					name = "일반회원";
					break;
					// 조건에 만족하는 숫자가 나오게 된 후, break;를 만나면 직전 변경값 적용
					// 즉, 4까지는 "일반회원"
				case 5:
				case 6:
					name = "중간관리자";
					break;
				case 9:
					name = "관리자";
					break;
				default:
					name = "방문자";
				// case에 해당하는 값이 없으면 default값 출력
				// 주의! swhitch 문은 입력받은 값에서 부터 break;를 만나기 전까지의 모든 코드를 실행한다 (case와 관계없이)
			}
			System.out.printf("회원님의 레벨은 %d이며 %s 입니다.%n", level, name);
		}
}
