package cha15;

public class Ex02Autoboxing {
	public static void main(String[] args) {
		
		// 기본형을 참조형으로 만드는 행위를 박싱이라 한다.
		// 참조형을 기본형으로 만드는 행위를 언박싱이라 한다.
		// 원래 기본형(int, float, double 등)과 인스턴스(클래스 타입)는 서로 연산이 불가하나, 이를 java에서 자동으로 처리해주는 것을 오토박싱이라 한다.
		
		// intValue 메소드는 호출자의 값을 int타입으로 바꾸어 return한다.
		// Interger.valueOf 메소드는 아규먼트를 int 타입에서, 해당 값을 인스턴스 변수로 가진 Integer클래스의 참조형(인스턴스)로 return한다.
		
		Integer intg = 3; 
		//Stinrg클래스와 마찬가지로 Wrapper클래스의 인스턴스를 기본형처럼 생성가능하도록 java가 (valueOf 메소드) 처리해준다
		// 즉, 기본형과 같이 생성하였으나, Interger클래스의 intg는 인스턴스 변수이다.
		System.out.println(intg);
		
		Integer intg2 = Integer.valueOf(3); 
		// Integer intg2 = 3; 입력시 java에서 이와 같이 자동으로 변환해줌
		System.out.println(intg2.intValue());
		
		System.out.println();
		
		Integer intg3 = intg + intg2; 
		/* 인스턴스+인스턴스는 불가하지만, Wrapper클래스에선 java가 intValue 메소드를 통해 값들을 int타입으로 변환 후 계산한 뒤 
		그 값을 valueOf메소드를 통해 다시 인스턴스 타입으로 만들어 return해준다. */
		System.out.println(intg3);
		
		Integer intg4 = Integer.valueOf(intg.intValue() + intg2.intValue()); 
		// intg+intg2 했을때 실제 자바에서 처리하는 코드
		System.out.println(intg4.intValue());
		
		System.out.println();
		
		int i = intg; 
		// 인스턴스를 기본형 변수에 저장하는게 불가능하지만 java에서 intValue메소드를 통해 처리해준다
		System.out.println(i);
		
		int i2 = intg.intValue();
		System.out.println(i2);
		
		System.out.println();
		
		System.out.println(intg + 7);
		// 인스턴스+정수(기본형)는 불가능하지만 ,java에서 intValue 메소드를 통해 처리해준다
		System.out.println(intg.intValue() + 7);
		
		System.out.println();
		
		double d = (Double)3.14; //3.14를 기본형인 3.14로 변환 //다운캐스팅?
		System.out.println(d);
		
		double d2 = Double.valueOf(3.14).doubleValue();
		/* valueOf 메소드로 Double 클래스의 3.14라는 인스턴스 변수를 가진 인스턴스를 생성 → Double.valueOf(3.14)
		doubleValue를 통해 해당 인스턴스의 값을 double타입으로 return → doubleValue(); */
		System.out.println(d2);
		
		System.out.println();
		
		
		Object obj = (Object)3.14;
		System.out.println(obj);
		
		Object obj2 = (Object)Double.valueOf(3.14);
		/// Double 클래스의 3.14라는 인스턴스를 가진 인스턴스 생성 후 Object로 다운캐스팅?
		System.out.println(obj2);
	}
}
