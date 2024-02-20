package Ch3;
//삼항 연산자
public class Ex07ConditionalOperators {
	public static void main(String[] args) {
		int score = 75;
		
		String result = score >= 60 ? "합격" : "불합격";
		// score >= 60 ? 값이 참일 경우 : 기준 앞의 값이 result에 반환되며, 거짓일 경우 뒤의 값이 반환된다.
		System.out.println(result);
		
		score = 48;
		System.out.printf("%s", score >= 60 ? "합격" : "불합격");
		//문자열(String)출력은 %s를 사용해야함
	}

}
