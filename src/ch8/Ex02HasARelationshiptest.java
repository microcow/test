package ch8;

public class Ex02HasARelationshiptest {
	public static void main(String[] args) {
		son1 SON = new son1();
		SON.name = "ABC";
		SON.sum = 123;
		
		System.out.print(SON.print());
		
		System.out.println();
		
		mom MOM = new mom();
		MOM.mommy(SON);
		// 원래 인스턴스 자체를 아규먼트로 던지려면 클래스.메소드.(아규먼트); 와 같은 방식으로 던져야하지만 (호출 메소드가 클래스 메소드일 경우에만)
		// mommy라는 메소드가 클래스 메소드가 아니며, 던지려는 인스턴스(SON)와 클래스가 다르기 때문에 MOM을 클래스 부분에 입력  
		
		MOM.test = SON;
		// 동일한 구조이기에 위의 식도 성립
		//(MOM.test) 자체를 son1 클래스에서 생성된 인스턴스라고 생각하면 됨
		
		System.out.print(MOM.test.print());
		
	}

}
class mom {
	son1 test;
	
	void mommy (son1 para) {
		this.test = para;
	}
	
}

class son1 {
	String name;
	int sum;
	
	
	String print () {
		return "이름:" + name + ", 합계: " + sum;
	}
		
	
}
/*
문제 1.
생각나는 개체를 이용하여 클래스들을 만들고 HAS-A 관계를 표현해주세요. 
*/