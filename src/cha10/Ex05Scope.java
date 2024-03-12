package cha10;

public class Ex05Scope {
	static int iv = 2;//해당 변수는 해당 변수의 중괄호안에 있는 곳에서 사용 가능하다(단, 선언 이후부터 사용 가능)
	static int k;
	
	public static void main(String[] args) {
		System.out.println("메소드 호출 전");
		
		System.out.printf("iv = %d%n", iv);
		//System.out.printf("param = %d%n", param);
		//System.out.printf("local = %d%n", local);
		//System.out.printf("i = %d%n", i);
		//System.out.printf("j = %d%n", j);
		//System.out.printf("k = %d%n", k);
		System.out.println();
		
		testScope(5);
		
		System.out.println("메소드 호출 후");
		
		System.out.printf("iv = %d%n", iv);
		//System.out.printf("param = %d%n", param);
		//System.out.printf("local = %d%n", local);
		//System.out.printf("i = %d%n", i);
		//System.out.printf("j = %d%n", j);
		//System.out.printf("k = %d%n", k);
		//System.out.println();
	}

	public static void testScope(int param) {
		System.out.println("메소드 시작");
		
		int local = 7; // local변수는 testScope 메소드 내에서만 사용 가능한 지역변수이다
		System.out.printf("iv = %d%n", iv);// testScope메소드는 Ex05Scope클래스 내에서 생성되었으므로 iv변수를 사용할 수 있다.
		System.out.printf("param = %d%n", param);
		System.out.printf("local = %d%n", local);
		//System.out.printf("i = %d%n", i);
		//System.out.printf("j = %d%n", j);
		//System.out.printf("k = %d%n", k);
		System.out.println();
		
		for (int i=0; i<1; i++) {
			System.out.println("i for문 시작");
			
			System.out.printf("iv = %d%n", iv);
			System.out.printf("param = %d%n", param);
			System.out.printf("local = %d%n", local);
			System.out.printf("i = %d%n", i);
			//System.out.printf("j = %d%n", j);
			//System.out.printf("k = %d%n", k);
			System.out.println();
			
			for (int j=0; j<1; j++) {
				System.out.println("j for문 시작");
				
				System.out.printf("iv = %d%n", iv);
				System.out.printf("param = %d%n", param);
				System.out.printf("local = %d%n", local);
				System.out.printf("i = %d%n", i);
				System.out.printf("j = %d%n", j);
				//System.out.printf("k = %d%n", k);
				System.out.println();
				
				if (i == 0) {
					System.out.println("if문 시작");
					
					int k = 7; //k는 if문 내에서만 사용가능하다.
					System.out.printf("iv = %d%n", iv);
					System.out.printf("param = %d%n", param);
					System.out.printf("local = %d%n", local);
					System.out.printf("i = %d%n", i);
					System.out.printf("j = %d%n", j);
					System.out.printf("k = %d%n", k);
					System.out.println();
					//문제 1 i = Ex05Scope.k; //→ Ex05Scope클래스에서 선언된 k와 if문에서 생성된 k는 다르며, 클래스에서 선언된 k를 호출하는 방법
					
					System.out.println("if문 종료\n");
				}
				
				System.out.printf("iv = %d%n", iv);
				System.out.printf("param = %d%n", param);
				System.out.printf("local = %d%n", local);
				System.out.printf("i = %d%n", i);
				System.out.printf("j = %d%n", j);
				//System.out.printf("k = %d%n", k);
				System.out.println();
				
				System.out.println("j for문 종료\n");
			}
			
			System.out.printf("iv = %d%n", iv);
			System.out.printf("param = %d%n", param);
			System.out.printf("local = %d%n", local);
			System.out.printf("i = %d%n", i);
			//System.out.printf("j = %d%n", j);
			//System.out.printf("k = %d%n", k);
			System.out.println();
			
			System.out.println("i for문 종료\n");
		}
		
		System.out.printf("iv = %d%n", iv);
		System.out.printf("param = %d%n", param);
		System.out.printf("local = %d%n", local);
		//System.out.printf("i = %d%n", i);
		//System.out.printf("j = %d%n", j);
		//System.out.printf("k = %d%n", k);
		System.out.println();
		
		System.out.println("메소드 종료");
	}
}
