package cha19;

/// 부모클래스의 메소드도 익명클래스로 즉시 오버라이딩해서 사용할 수 있나 : 가능
public class testtest {
	public static void main(String[] args) {
		Test2 test = new Test2();
		System.out.println(test); // 부모클래스의 인스턴스도 가지고 있으나, 값을 지정하지 않을 경우 0으로 출력
		System.out.println(test.qqq());
		
		Test2 as = new Test2() {
			@Override
			int qqq() {
				return (int)(Math.random()*10);
			}
		};
		System.out.println(as.qqq());
	}

}
class Test {
	int a=4;
	int b;
	
	int qqq() {
		a = 1;
		b = 4;
		return  a + b;
	}
}
class Test2 extends Test{

	@Override
	public String toString() {
		return ("(" + a + ")" + "(" + b +")");
	}
}


