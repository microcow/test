package ch7;

public class Ex13CallByValuetest2 {
	int bookprice;
	
	Ex13CallByValuetest2() {
	}
	// 위 생성자는 원래 별도로 생성하지 않아도 jira에서 자동으로 생성해주지만 (보이지는 않음)
	// 아래에 다른 구조의 생성자가 있기에 빈 생성자를 사용하려면 위와 같이 별도로 생성해주어야한다.
	
	Ex13CallByValuetest2(int pricetax)	{
		this.bookprice = pricetax;
		
	}
	
	static float reprice(Ex13CallByValuetest2 taxprice) {
		float tax = 1.1f;
		return taxprice.bookprice = (int)(tax*taxprice.bookprice);
	}							// (int)(A*B);는 A*B의 결과 값을 int값으로 바꿔주는 식이고
								// (int)A*B;는 A값을 int로 바꾼 후 B와 곱하는 식이다
	
	// book 인스턴스를 taxprice 파라미터가 받았고
	// 받은 인스턴스와 동일한 구조를 가진 파라미터의 인스턴스 변수 bookprice부분을 변경하여 return
	// taxprice 파라미터를 return 받은 인스턴스는 변경된 부분을 인스턴스에 적용 (둘이 동일한 메모리 구조이기에 가능) 
}

