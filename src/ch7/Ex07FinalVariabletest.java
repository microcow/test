package ch7;

public class Ex07FinalVariabletest {
	public static void main(String[] args) {
		System.out.println(Book111.TAX); // 인스턴스 생성 전임에도 클래스 변수 사용 가능하다
		
		Book111 asd = new Book111();
		asd.asdf();
		
		
	}

}
class Book111 {
	final static float TAX = 1.2f;
	int price = 10000;
	
	void asdf () {
		System.out.print((int)(price*TAX));
		// int가 없으면 12000.0으로 출력됨
		// TAX에 int를 붙이면 1.2에서 1이 되어버림
	}

	
	/*int asd () {
	return (int)(PRICE);
	}*/
}
	

/*
문제 1.
책의 세율을 final로 설정한뒤 세율이 적용된 책의 가격을 출력하는 코드를 작성하세요. 
*/