package ch7;

public class Ex10ThisConstructortest {
	public class Ex10ThisConstructor {
		good a = new good();
		
	}

}

class good {
	String title;
	int price;
	String author;
	

	good (){
		this("", 0, "null");
	}
	
	good (String title, int price, String author){
		System.out.println(title + price + author);
	}
	
	void tell() {
		System.out.println(title + price + author);
	}
}
/*
문제 1.
this생성자를 사용하는 코드가 포함된 임의의 클래스를 작성하고 
각각의 생성자를 이용해 인스턴스 생성후 값들을 출력하는 코드를 작성하세요.
*/