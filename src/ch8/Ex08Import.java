package ch8;

import java.util.Calendar; //import java.패키지명.클래스
// 다른 패키지에 있는 클래스를 사용하고 싶을 경우 위와 같이 import를 해야한다
//import java.util.*; → 다음과 같이 import할 경우 util패키지 밑의 모든 클래스들을 사용할 수 있게 된다. (해당 방법보다는 클래스 명을 직접 적는 것을 권장)


import static java.lang.Math.PI; // PI는 3.14 값을 final(상수)로 가지고 있는 클래스 변수이다.
import static java.lang.Math.random;  
import static java.lang.Math.round;
// 클래스변수와 클래스메소드에 한해 import static 구문으로 import할 경우, 해당 변수와 메소드는 class명을 적지 않고도 사용할 수 있다.
// 클래스 메소드는 import 시 () 제외 메소드 이름만 적으면 된다


//import static java.lang.Math.*; → 다음과 같이 import할 경우 Math클래스 내의 모든 클래스변수와 클래스메소드를 class명을 적지 않고 사용할 수 있다.


// import java.lang.*; → lang 패키지는 java에서 자동으로 제공해주기에 import해주지 않아도 된다.
// java.lang 패키지와 같이 java에서 제공해주어 굳이 import를 하지 않아도 되는 패키지도 있다
// int, boolean, float, String 등 전부 각각의 클래스들이지만 lang패키지에 속해있음으로 굳이 import를 하지 않아도 된다
// 해당 패키지들은 https://docs.oracle.com/javase/8/docs/api/index.html 참고


public class Ex08Import {
	public static void main(String[] args) {
		java.util.Date d = new java.util.Date();
		// import를 하지 않았기에 Date클래스는 패키지 명을 전부 작성함
		System.out.println(d.toString());
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(Calendar.DATE));
		
		System.out.println(PI);
		// PI를 위에서 import static하지 않았다면, Math.PI라고 적었어야 함
		System.out.println(random());
		System.out.println(round(3.14));
	}
}
