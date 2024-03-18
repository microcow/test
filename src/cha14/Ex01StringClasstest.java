package cha14;

public class Ex01StringClasstest {
	public static void main(String[] args) {
		// a.a == b.b 는 다른가?
		A a = new A();
		B b = new B();
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		
		String aa = new String("ㅎㅇ");
		String bb = new String("ㅎㅇ");
		System.out.println(System.identityHashCode(aa));
		System.out.println(System.identityHashCode(bb));
		System.out.println(System.identityHashCode(aa.intern()));
		System.out.println(System.identityHashCode(bb.intern()));
		System.out.println("---");
		System.out.println(System.identityHashCode(a.aa));
		System.out.println(System.identityHashCode(b.bb));
		System.out.println(System.identityHashCode(a.aa.intern()));
		System.out.println(System.identityHashCode(b.bb.intern()));
		
		System.out.println(a.aa == b.bb);
		// 주소를 비교하기에 다른클래스의 다른인스턴스 변수들이지만 결과는 true
	}

}
class A {
	//int a = 0;
	String aa = "dd";
//	String aa = new String("dd");
}
class B {
	//int b = 0;
	String bb = "dd";
//	String bb = new String("dd");
}
/*
문제 1.
== 과 equals 의 차이를 설명할 수 있는 예제를 작성하세요.
*/
// == 은 주소(문자 풀)을 비교하고 equals는 문자열을 비교한다.
/// 그럼 값은 다른데 주소는 같다면 ==는 false인가? : true 이다.