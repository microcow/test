package ch8;

public class Ex09Final {
	public static void main(String[] args) {
		Book7 b1 = new Book7();
		System.out.println(b1.tax);
		//b1.tax = 1.2f;
	}

}

final class Book7 {
// class 앞에 final이 붙을 경우, 해당 클래스는 상속할 수 없다.
	String title;
	String author;
	int price;
	final float tax;
	// final이 붙으면 최초 한번만 값을 부여할 수 있고 그 이후에는 변경이 불가하다(상수).
	
	public Book7() {
		tax = 1.1f; 
		//final 키워드가 붙은 변수인 tax는 최초 값이 부여된 이 이후에 값을 변경할 수 없다
	}
}

/*
class EBook6 extends Book7 { → 상속받고자 하는 부모(super)클래스가 final이기에 오류발생
//문제 2 : Book7 클래스 앞에 있는 final을 지우면 EBook6클래스가 Book7클래스를 상속받을 수 있음
}
*/

class Book8 {
	String title;
	String author;
	
	final public void setTitle(String title) {
	// 메소드 앞에 final이 붙을 경우 해당 메소드는 오버라이딩이 불가하다.
		this.title = title;
	}
	//문제 1
	final void getTitle (String title) {
		this.title = title;
	}
}

class EBook7 extends Book8 {
	String fontColor;
	
	/*
	final public void setTitle(String title) { → EBook7클래스는 Book8클래스를 상속받았지만 setTitle 메소드가 final이기에 오버라이딩할 수 없다.
		this.title = "[E북]" + title;
	}
	*/
}

/*
문제1.
Book8클래스에 getTitle 메소드를 추가하고 EBook7 클래스에서 getTitle 메소드를 오버라이딩 할 수 없도록 코딩하세요.

문제2.
EBook6 클래스가 Book7 클래스를 상속 받을 수 있도록 수정하세요. 
*/
