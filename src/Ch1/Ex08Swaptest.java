package Ch1;

public class Ex08Swaptest {
	public static void main(String[] arg) {
		int a = 50;
		int b = 30;
		int c = 70;
		
		System.out.printf("a의 값은 %d입니다.\n", a);
		System.out.printf("b의 값은 %d입니다.\n", b);
		System.out.printf("c의 값은 %d입니다.\n\n", c);
		
		int tmp = a;
		a = b;
	    b = c;
	    c = tmp;
	   
		System.out.printf("a의 값은 %d입니다.\n", a);
		System.out.printf("b의 값은 %d입니다.\n", b);
		System.out.printf("c의 값은 %d입니다.\n", c);		
	}

}
/*
문제 1.
int a = 50;
int b = 30;
int c = 70;
swap알고리즘을 사용하여 세 변수의 값을 바꿔 주세요. 
*/