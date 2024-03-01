package ch7;

public class Ex06ClassMethodtest {
	public static void main(String[] args) {
		Bookprice book = new Bookprice();
		System.out.print("1000원은 " + book.price(1000) + " 달러입니다.");
		
		
	}

}

	class Bookprice {
		static double doll = 0.001;
				
		static int price(int won) {
			return won = (int)(won * doll);
		}
		
		
	}

/*문제 2.
책의 가격을 달러로 변환하여 리턴하는 클래스 메소드를 작성하세요.
1달러=1000원으로 가정합니다.*/