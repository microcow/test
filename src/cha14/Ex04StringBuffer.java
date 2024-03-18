package cha14;

public class Ex04StringBuffer {
	public static void main(String[] args) {
		/* 요약 
		멀티쓰레드환경에서 문자열끼리 더할땐 StringBuffer클래스를, 단일작업 환경에선 StringBuilder 클래스를 활용할 경우 
		단순히 String타입에서 문자열끼리 더할때 보다 속도가 압도적으로 빠르다
		또한, 작업이 끝난경우 toSring메소드를 이용해 String타입으로 문자열을 변환시키자
		*/
		String a = "asd";
		String b = "ddd";
		String c = a+b;
		a = a+b;
		System.out.println(a);
		System.out.println(c);
		// a와b의 문자열을 더할 수 있지만, 더한 문자열이 해당 인스턴스에 새롭게 저장(신규 메모리 생성)되는 방식이다. (기존에 있는 문자열에 더하는 문자열이 누적되어 더해지는게 아님) 
		// 병렬작업(멀티쓰레드환경)일 경우엔 StringBuffer가 작업 속도가 더욱 빠르다.
		
		StringBuffer sb = new StringBuffer("자바");
		//StringBuffer 클래스는 더하는 문자열을 새롭게 인스턴스에 저장하는 것이 아닌 기존에 있는 문자열에 누적시킬 때 사용한다. (String클래스가 아님)
		sb.append(" ").append("문법 ").append("엘컴퓨터학원 ");
		//StringBuffer클래스의 append메소드는 아규먼트의 문자열을 호출자의 문자열에 추가하며, .으로 연결하여 연속적으로 사용할 수 있다.
		sb.append(123);
		// 아규먼트로 숫자,char타입 등을 던지더라도 자동으로 문자열로 저장된다.
		String str = sb.toString();
		//StringBuffer클래스가 오버라이딩하고 있는 toString메소드는 호출자의 값을 String타입으로 바꾸어 return해준다
		// 즉, StringBuffer를 사용 후에 toString메소드를 이용해 최종적으로 String타입으로 바꿔주어야한다.
		System.out.println(str);
		
		StringBuilder sb2 = new StringBuilder("자바");
		//StringBuilder 클래스는 StringBuffer 클래스와 흡사하지만 단일작업일 경우(멀티쓰레드환경이 아닐경우)엔 StringBuffer보다 StringBuilder를 사용한다.
		sb2.append(" ").append("문법 ").append("엘컴퓨터학원 ");
		sb2.append(123);
		String str2 = sb2.toString();
		System.out.println(str2);
		
		
		long startTime = 0;
		long endTime = 0;
		String str3 = "";
		startTime = System.currentTimeMillis();
		// System.currentTimeMillis() 메소드는 현재 시각을 ms(1000분의 1초)단위로 return한다.
		for (int i=0; i<10000; i++) {
			str3 += "a";
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// 단순히 String클래스로 사칙연산을 통해 문자열을 더할때 걸리는 시간
		
		System.out.println();
		
		startTime = 0;
		endTime = 0;
		StringBuffer sb3 = new StringBuffer();
		startTime = System.currentTimeMillis();
		for (int i=0; i<10000; i++) {
			sb3.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		// StringBuffer클래스에서 append메소드를 활용해 문자열을 더할때 걸리는 시간
	}

}
