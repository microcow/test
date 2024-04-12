package ch8;

public class Ex03Supertest {
	public static void main(String[] args) {
		son SON = new son();
		System.out.print(SON.title + "\t" + SON.name);
	}

}
class Mom1 {
	String title;
	String name;
	
	Mom1(String A, String B) {
		this.title = A;
		this.name = B;
	}
}
class son extends Mom1 {
	
	son(){
	super ("제목", "이름");
	}
	//d
}
/*
문제 1.
기본 생성자가 없는 Book3의 자식 클래스를 만들고
해당 자식 클래스를 이용해 인스턴스를 생성하세요.
힌트) super를 이용하세요.
*/