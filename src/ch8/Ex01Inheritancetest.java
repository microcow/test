package ch8;

public class Ex01Inheritancetest {
	public static void main(String[] args) {
		
		Is fst = new Is();
		fst.mom();
		//fst.num = 999; → Is라는 클래스에는 num 인스턴스 변수가 없으므로 저장 불가
		
		A scd = new A();
		scd.son(); // → 이 때는 scd.rel값이 없으므로 null 출력 (A라는 클래스에는 rel이란 인스턴스 변수가 없으나 A클래스는 Is클래스를 상속받았기 때문에 scd인스턴스에도 rel이란 인스턴스 변수가 존재)
		scd.mom(); // → 이 때 scd.rel 값이 저장됨 (마찬가지로 A라는 클래스에는 mom이라는 메소드가 없으나 상속받은 Is클래스에 있기때문에 호출이 가능함)
		scd.son(); // → 다시 출력 시 rel값이 null이 아닌 저장된 값으로 출력됨
		
		
	}	
}

class Is {
	String rel;
	
	void mom() {
		rel = "안녕하세요"; // 이 때 인스턴스.rel에 "안녕하세요"를 메모리에 저장한다.
		System.out.println(rel);
		
	}
}

class A extends Is {
	int num;
	
	void son() {
	System.out.println(rel + num);
	}
}
/*
문제 1.
생각나는 개체를 클래스로 만들되 부모 자식 클래스로 나누어 주세요.
자식 클래스는 두 개 이상 만들어 주세요. 
모든 클래스에 속성(인스턴스 변수)과 기능(메소드)을 하나 이상 만들어 주세요.  
*/