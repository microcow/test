package cha15;
import java.util.Scanner; 
public class Ex01WrapperClass {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		// WrapperClass클래스는 기본형(int double float 등)을 위한 클래스이다.
		
		// ★★ Integer 클래스는 간단한 정수 값을 나타내며 하나의 int 값을 저장할 수 있다.
		
		System.out.print("숫자 7을 입력하세요:");
		//int i = s.nextLine();
		String str = s.nextLine();
		// nextLine으로 입력받고 있기에 숫자 7을 입력받을 경우 문자로 인식한다
		String str2 = str + 10;
		System.out.println(str2);
		
		int i = Integer.parseInt(str); //Integer클래스는 int 타입을 위한 클래스이다.
		// ★ Integer.parseInt 메소드는 아규먼트의 문자열(String타입)이 숫자형태로 변환이 가능할 경우 숫자형태(int타입)로 return해준다.
		// 숫자형태로 변환이 불가할 경우 예외(NumberFormatException)발생
		int i2 = i+10;
		System.out.println(i2);
		System.out.println();
		
		// Integer intg1 = new Integer(i); → 기본형을 참조형(인스턴스)로 바꿀때 new Integer을 사용하면 오류 발생 (Integer.valueOf 메소드를 사용하자)
		Integer intg1 = Integer.valueOf(i);
		// ★ Interger.valueOf 메소드는 아규먼트를 int 타입에서, 해당 값을 인스턴스 변수로 가진 Integer클래스의 참조형(인스턴스)로 return한다.
		// 즉, intg1 인스턴스는 i(int 타입 변수)의 값(7)을 인스턴스 변수로 가지고 있는 인스턴스이다.(int 타입의 인스턴스 변수로 가지고있다)
		System.out.println(intg1.intValue());
		// ★ intValue 메소드는 호출자의 값을 int타입으로 바꾸어 return한다. (메소드가 return한 값만 int타입이지, intg1인스턴스 자체가 int 타입으로 변하는게 아님)
		System.out.println( intg1.compareTo(Integer.valueOf(5)) );
		// compareTo 메소드는 두 인스턴스 중 누구가 더 큰지 return해준다.
		// 호출자가 더 크면 양수를, 아규먼트가 더 크면 음수, 같으면 0을 return한다.
		System.out.println( intg1.compareTo(Integer.valueOf(20)) );
		System.out.println( intg1.compareTo(Integer.valueOf(7)) );
		System.out.println();
		
		Integer intg2 = Integer.valueOf(22);
		System.out.println(intg1.intValue());
		System.out.println(intg1.hashCode());
		//Integer 클래스는 Object클래스의 hashCode메소드를 오버라이딩 하고 있으며, 메소드 호출 시 호출자의 값이 return된다.
		System.out.println(System.identityHashCode(intg1));
		System.out.println(intg2.intValue());
		System.out.println(intg2.hashCode());
		System.out.println(System.identityHashCode(intg2));
		System.out.println();
		
		System.out.println(intg1.equals(intg2));
		//Integer 클래스는 Object클래스의 equals메소드를 오버라이딩 하고 있으며, 두 값이 같을 경우 true를 반환한다.
		System.out.println(intg1.equals(Integer.valueOf(7)));
		System.out.println();
		
		System.out.println(Integer.max(intg1, intg2));
		//max 메소드는 둘 중 큰 값을 반환한다.
		System.out.println(Integer.min(intg1, intg2));
		//max 메소드는 둘 중 작은 값을 반환한다.
		System.out.println(Integer.sum(intg1, intg2));
		//max 메소드는 둘을 더한 값을 반환한다.
		System.out.println();
		
		//int i3 = intg1.toString();
		System.out.println(intg2.intValue() + 777);
		System.out.println(intg2.toString() + 777);
		//Integer 클래스는 Object클래스의 toString메소드를 오버라이딩 하고 있으며, 호출자를 문자열로 변환해 return한다.
		System.out.println();
		
		String str3 = "3.14";
		System.out.println(str3 + 0.01); // 문자열과 숫자를 더할경우 결과값이 문자열로 변환된다.
		System.out.println(Double.parseDouble(str3) + 0.01); //Double클래스는 double 타입을 위한 클래스이다.
		// Double.parseDouble 메소드는 아규먼트의 문자열이 소수형태로 변환이 가능할 경우 소수형태(double타입)로 return해준다.
		Double objPi = Double.valueOf(3.14);
		// ★ Double.valueOf 메소드는 아규먼트를 double타입에서, 해당 값을 인스턴스 변수로 가진 Double클래스의 참조형(인스턴스)로 return한다.
		double pi = objPi.doubleValue();
		// ★ doubleValue 메소드는 호출자의 값을 double타입으로 바꾸어 return한다. (메소드가 return한 값만 double타입이지, objPi인스턴스 자체가 double 타입으로 변하는게 아님)
		System.out.println(pi);
		System.out.println();
	}
}
