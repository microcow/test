package Ch1;

public class Ex06Printftest {
	public static void main(String[] args) {
		int a = 10;
		System.out.printf("슈퍼에는 %d개의 사탕이 있습니다.\n", a);
		
		int b = 3;
		System.out.printf("철수는 %d개의 사탕을 샀습니다.\n", b);
		
		int c = 2;
		System.out.printf("영희는 %d개의 사탕을 샀습니다.\n", c);
		
		int d = 2;
		System.out.printf("둘리는 예전에 사두었던 사탕 %d개를 환불했습니다.\n", d);
		
		a = a - b - c + d;
		System.out.printf("현재 남아있는 사탕의 재고는 %d개 입니다.", a);
				
	}

}
/* 

문제 1. 슈퍼에는 10개의 사탕이 있습니다. 
철수는 3개의 사탕을 사고 영희는 2개의 사탕을 샀습니다.
둘리는 예전에 사두었던 사탕 2개를 환불했습니다.
슈퍼에 남아 있는 사탕의 재고는 7개입니다.
위 내용을 코드로 작성하세요. 

*/ 




//변수 동시
//변수 변경