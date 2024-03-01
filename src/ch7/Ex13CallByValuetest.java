package ch7;

public class Ex13CallByValuetest {
	public static void main(String[] args) {
		Ex13CallByValuetest2 Book = new Ex13CallByValuetest2();
		
		Book.bookprice = 10000;
		
		Ex13CallByValuetest2.reprice(Book);
		
		System.out.print(Book.bookprice);	
		
		// 호출 클래스는 Ex13의test2 페이지
	}

}
/*
문제 1.
call by value 를 이용해 책의 금액을 수정하는 메소드를 작성하세요.
힌트) 수정된 금액을 return 하세요. 
*/