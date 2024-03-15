package cha14;

public class Ex01StringClasstest {
	public static void main(String[] args) {
		// a.a == b.b 는 다른가?
	}

}
class A {
	int a = 0;
}
class B {
	int b = 0;
}
/*
문제 1.
== 과 equals 의 차이를 설명할 수 있는 예제를 작성하세요.
*/
// ==은 주소를 비교하고 equals는 문자열을 비교한다.
/// 그럼 값은 다른데 주소는 같다면 ==는 false인가?