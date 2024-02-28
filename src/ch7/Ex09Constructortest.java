package ch7;

public class Ex09Constructortest {
	public static void main(String[] args) {
		movie fst = new movie();
		System.out.printf("제목 %s, 시간 %d, 장르 %s%n", fst.title, fst.time, fst.aw);
		
	}
}
	class movie {
		String title;
		int time;
		String aw;
		
		movie () {
			title = "서울의 봄";
			time = 150;
			aw = "역사";
			System.out.printf("제목 %s, 시간 %d, 장르 %s%n", title, time, aw);
		}
}
	
/*
문제 1.
영화 제목(문자열), 상영시간(정수), 장르(문자열) 속성을 가진 클래스를 만들고 
생성자를 이용하여 속성을 설정한 뒤 출력하세요.*/
