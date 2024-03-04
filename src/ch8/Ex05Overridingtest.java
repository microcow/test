package ch8;

public class Ex05Overridingtest {
	public static void main(String[] args) {
		
		Momtitle momtitle = new Momtitle();
		momtitle.title = "북";
		
		
		Sontitle sontitle = new Sontitle();
		sontitle.settitle();
	}
}

class Momtitle	{
	String title;

	
	void settitle () {
		System.out.println(title);
		// 코드 실행 시 mom.title이 아닌 super.title이 출력되기 때문에 "북"이 아닌 "북2"가 출력된다.
		// 자식클래스에서 인스턴스 생성 시 부모클래스에서도 인스턴스가 생성되기 때문 (*ch8. Ex03)
	}
}


class Sontitle extends Momtitle {
	String title;
	
	@Override
	void settitle () {
		this.title = "이북";
		super.title = "북2";
		System.out.println (title);
		super.settitle();
	}
}

/*
문제 1.
제목 설정 메소드를 부모클래스와 자식클래스에 모두 작성하고 자식클래스의 제목 설정 메소드는 제목에 [이북]이 추가되도록 작성하세요.
부모의 타이틀과 자식의 타이틀 모두 출력하세요. 
*/