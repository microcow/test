package ch7;

public class Ex14CallByReferencetest {
	public static void main(String[] args) {
		Ex13CallByValuetest2 book2 = new Ex13CallByValuetest2(1000);
		System.out.print("세금 적용 전 책의 가격은 " + book2.bookprice + "원 입니다." + "\n");
		
		Ex13CallByValuetest2.reprice(book2);
		System.out.print("세금 적용 후 책의 가격은 " + book2.bookprice + "원 입니다." + "\n");		
	}

}
/*
문제 1.
call by reference 를 이용해 책의 금액을 수정하는 메소드를 코딩하세요. 
*/