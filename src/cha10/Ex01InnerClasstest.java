package cha10;

public class Ex01InnerClasstest {
	public static void main(String[] args) { 
		Outter outter = new Outter();
		outter.setprice(10000);
		outter.settitle("아우터");
		
		Outter.Inner inner = outter.new Inner();
		inner.setprice(5000);
		inner.settitle("이너");
		inner.setname("클래스");
		inner.setage(10);
		inner.print(inner);
		outter.print(outter); /// 이너클래스 인스턴스로 동일한 메소드 명의 아우터클래스 메소드 호출하는 방법? : 불가능
		/// 이너,아우터 모두 동일한 변수 타입과 이름을 가지고 있을 경우 이너에서만 그 변수의 값을 지정했다면 아우터의 변수에도 동일하게 그 값이 저장되는가 : no
	}

}
class Outter{
	int price;
	String title;
	String name;
	int age;
	static int ttt = 3;
	
	void setprice(int para) {
		this.price = para;
	}
	void settitle(String para) {
		this.title = para;
	}
	void print (Outter para) { ///파라미터 타입이 inner인데 outter인스턴스 받을 수 있는지 : 불가능
		System.out.println(this.age); 
	}
	
	class Inner{
		int price;
		String title;
		String name;
		int age;
		
		void setTtt() {
			Outter.ttt = 5;
			System.out.print(ttt);
			System.out.print(Outter.ttt);
			System.out.print(Outter.this.price);
		} // 아우터에 있는 변수타입이 static이라면 이너에서 값 변경가능 (1.8버전에선 불가하며, 값 불러오기만 가능함)
		
		void setprice(int para) {
			this.price = para;
		}
		
		void settitle(String para) {
			this.title = para;
		}
		
		void setname(String para) {
			this.name=para;
		}
		void setage(int age) {
			this.age = age;
		}
		void print (Inner para) { ///파라미터 타입이 inner인데 outter 인스턴스 받을 수 있는지 : 불가능 (반대로 Outter 타입일 땐 inner 인스턴스 받을 수 있음)
			System.out.println(this.price + Outter.this.title + name + Outter.this.age + this.age + age); 
			/// outter age는 정의(값 설정)되지 않았는데 출력가능? : 불가능
			
			// ---- 아우터클래스,이너클래스,지역클래스 모두 동일한 이름의 인스턴스가 존재할 때 우선순위
			// 아우터클래스.this.인스턴스 명 : 아우터클래스의 인스턴스
			// this.인스턴스 명 : 이너클래스의 인스턴스
			// 인스턴스 명 : 지역변수(파라미터)
			
			// 만약, 지역변수에는 동일한 인스턴스 명이 없을 때 인스턴스 명만 입력 시 그다음 우선순위인 이너클래스의 인스턴스 출력
			// 마찬가지로, 지역변수와 이너클래스 모두 동일한 인스턴스 명이 없을 땐 아우터클래스의 인스턴스 출력
		}
		
	}
}
/*
문제 1.
이너 클래스를 사용한 예제를 작성하세요.

문제 2.
아우터 클래스의 인스턴스 변수, 이너 클래스의 인스턴스 변수, 이너 크래스의 메소드내 지역 변수 모두 이름을 같게 설정하고 각각의 값을 출력하는 코드를 작성하세요.  
*/