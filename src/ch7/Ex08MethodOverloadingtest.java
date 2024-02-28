package ch7;

public class Ex08MethodOverloadingtest {
	public static void main(String[] args) {
		car fst = new car();
		fst.asd("그렌져", 132); // com 값이 없기 때문에 null로 출력됨
		
		fst.asd("그렌져", 132, "현대");
		
		fst.asd("그렌져", 132); // 바로 위에서 "현대"값이 저장되었으므로, 위위 코드와 달리 com값이 현대로 출력됨
		
	}

}
class car {
	String name;	
	int speed;
	String com;
	
	void asd(String name, int speed, String com) {
		this.name = name;
		this.speed = speed;
		this.com = com;
		System.out.printf("이름:%s 속도:%d 회사:%s%n", this.name, this.speed, this.com);
	}
		
		void asd(String name, int speed) {
			this.name = name;
			this.speed = speed;
			System.out.printf("이름:%s 속도:%d 회사:%s%n", this.name, this.speed, this.com);
	}
	
}
/*
문제 1.
자동차 정보 자동차이름(문자열), 최대속도(정수), 자동차회사(문자열) 를 저장하는 클래스를 만들고
각각의 속성을 설정하는 메소드를 작성 후 출력하세요.

문제 2.
속성을 설정하는 메소드를 오버로딩을 사용하여 작성 후 출력하세요. 
*/