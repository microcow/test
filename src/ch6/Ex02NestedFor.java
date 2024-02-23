package ch6;

public class Ex02NestedFor {
	public static void main(String[] args) {
		for (int i=1; i<=6; i++) {
			for (int j=1; j<=3; j++) {
				System.out.printf("%d학년 %d반,", i, j);
		//중첩 for문 (아래 for문) 반복실행 완료 시 최초 for문 반복실행
		//최초 for문 (위쪽 for문) 반복실행 시 중첩 for문은 초기화되어서 재실행 
			//즉, 상위 for문이 조건에 따라 반복되어 실행될 경우, 하위 for문은 재실행된다
			}
			System.out.println();
		}
	}
}
/* 시간 만들기
  for (int i=0; i<=23; i++) 
			for (int j=0; j<=59; j++) 
				System.out.printf("현재 시각은 %d시 %d분 입니다.%n", i, j);
*/