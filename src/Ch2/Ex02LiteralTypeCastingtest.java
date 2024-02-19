package Ch2;

public class Ex02LiteralTypeCastingtest {
	public static void main(String[] arg) {
		float f = 3.14f + 2.5f;
		
		System.out.printf("f 값은 %1.2f입니다.\n", f);
		
		double tt = 3.14 + 2.5f;
		
		System.out.printf("t 값은 %1.2f입니다.", tt);
	}
	
}
/*
문제1.
float f = 3.14 + 2.5f;
오류가 나지 않도록 수정해 주세요. 
*/