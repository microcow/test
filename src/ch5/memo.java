package ch5;

public class memo {
	public static void main(String[] args) {
		for (int i=1; i<=3; i++) { //i+1은 식이며, 증감식은 변수에만 적용될 수 있으므로 i++를 사용
			System.out.println("i는 " + i + "입니다.");
		}
		// i가 1인데(선언), 3보다 작거나 같게 될 때 까지(조건), i++로 반복실행한다(증가) (i는 1에서 3까지 1씩 증가시키며 반복한다)
		// for문이 한 줄일 경우엔 {}로 감싸주지 않아도 괜찮다
		// int로 선언된 변수 i는 for문이 종료되면 다른 코드에서 변수로 사용할 수 없음(for문 안에서만 사용 가능함)	
	}
}
