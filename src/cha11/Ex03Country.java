package cha11;

public enum Ex03Country {
	//이넘을 따로 분리해서 생성
	KOREA(82, 1.1f),
	// KOREA라는 인스턴스(이넘 멤버) 생성과 동시에 int타입,float타입 아규먼트로 생성자 호출
	USA(1, 1.2f),
	UK(44, 1.3f),
	ETC(0, 1.5f);
	// 이넘멤버는 클래스와 달리 인스턴스들을 쉼표로 구분하고 마지막에 ;로 종료선언
	
	private final int code;
	private final float tax;
	// 이넘의 인스턴스(이넘 멤버)는 상수이기에 변수들도 상수(final)로 생성하는 편이다(안해도 상관은 없음)
	
	Ex03Country(int code, float tax) {
		this.code = code;
		this.tax = tax;
	}
	
	public float getRefundTax() {
		float refundTax = tax;
		
		if (code != 0)
			refundTax = tax - 0.1f;
		 
		return refundTax;
	}
	
	public float getTax() {
		return tax;
	}
}

enum genre{ // 이넘은 public만 접근제한자만 허용된다.
	무협(1),
	만화(2),
	소설(3);
	int cord;
	
	genre(int cord){
		this.cord = cord;
	}
}
