package cha14;

public class Ex01StringClass {
	public static void main(String[] args) {
		
		/* String 클래스는 원래 String s1 = new Stinrg("안녕"); 이런 식으로 참조형으로 인스턴스를 생성해야하지만
		 java에서 편의를 위해 String s1 = "안녕";과 같이 기본형으로도 생성을 할 수 있게 한다. (String의 S가 대문자인 이유, String이 파랑색인 이유)
		*/
		
		String s1 = "엘컴퓨터학원";
		// s1이 "엘컴퓨터학원"이라는 문자열을 최초로 생성했으며, 해당 문자열을 문자열풀에 저장했다.
		String s2 = "엘컴퓨터학원";
		// String s1=s2;와 동일하게 동작
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		// String 타입을 기본형으로 생성할 경우, 동일한 hashcode 주소를 가진다. 
		// 동일한 문자열이 문자열 풀에 있다면, 해당 문자열 풀 주소를 불러오기 때문 (즉, s2가 s1(동일한 문자열 최초 생성)의 문자열 풀 주소를 불러오게 된 것)
		// 만약, 없다면 새로운 문자열 풀에 문자열을 저장한다.
		System.out.println();
		
		String s3 = new String("엘컴퓨터학원");
		String s4 = new String("엘컴퓨터학원");
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode()); 
		///오버라이딩 안되었는데 주소가 달라야하는 것 아닌가 : java에서 String 클래스가 hashCode 메소드를 오버라이딩 하고있음 (동일 문자열일 경우 같은 해시코드 리턴되게)
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		// 참조형 (new String());을 통해 생성할 경우 동일한 문자열이 있더라도 문자열 풀 주소를 불러오지 않고 새로 메모리를 생성한다.
		// 단, s3와 s4는 새로운 메모리를 생성하였지만 s1(동일한 문자열 최초 생성)과 동일한 문자열을 가지고 있음으로 해당 문자열이 최초에 생성되었을 때 생기는 문자열 풀의 주소는 s1의 동일한 주소를 가지고있다. (메모리 주소 != 문자열 풀 주소)
		System.out.println();
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s3.intern()));
		// intern 메소드는 문자열 풀의 주소를 가져온다.
		/// s3의 값이 바뀌어도 intern의 값이 동일한 이유?
		System.out.println();
		
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		// equals 메소드는 문자열이 같은지 확인 (주소 여부 상관x)
		System.out.println(s1.equals(s2));
		System.out.println();
		
		String s5 = null;
		//System.out.println(s5.length());
		String s6 = "";
		System.out.println(s6.length());
		// null;과 ""; 은 둘 다 비어있지만 다르다. 둘 다 내용은 비었지만 null은 메모리가 없고 ""은 메모리가 있다.
	}
}
