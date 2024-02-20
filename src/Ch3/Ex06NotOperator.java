package Ch3;

public class Ex06NotOperator {
	public static void main(String[] args) {
		boolean result = true;
		System.out.printf("result = %b%n", result);
		System.out.printf("!result = %b%n", !result);
		// !를 통해 결과 값(true)을 변경할 수 있다. 
		System.out.printf("!!result = %b%n", !!result);
		// !result 값이 (false)였기에 !!result는 true
		System.out.printf("!!!result = %b%n", !!!result);
	}
}
