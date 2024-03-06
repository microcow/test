package ch9;

public class Ex03Downcasting {
	public static void main(String[] args) {
		Book3 book = null;
		EBook3 ebook = null;
		AudioBook3 abook;
		
		book = new Book3();
		book.setTitle("자바 기본문법");
		System.out.println(book.getTitle());
		
		book = ebook; // 해당 방법으로도 업캐스팅 가능
		book = new EBook3(); // 업캐스팅
		book.setTitle("자바 알고리즘");
		System.out.println(book.getTitle());
		
		
		//book.setFontColor("블랙"); → book은 EBook3의 인스턴스 변수를 담고있지만 Book3소속이기에 자식클래스의 메소드를 사용할 수 없다.	
		ebook = (EBook3)book;// 다운캐스팅을 하기 위해선 업캐스팅이 선행되어야 하며, 업캐스팅 된 클래스를 다운캐스팅해야한다.
		// ★ 부모타입의 인스턴스를 자식 타입으로 다운캐스팅 한 후 자식클래스의 인스턴스로 넘겨줄 경우 그걸 받은 인스턴스가 자식클래스에 있는 메소드 사용 가능 ★
		// 다운캐스팅 하는 법 = 자식클래스인스턴스 = (자식클래스)부모클래스인스턴스;
		// 질문 - 다운캐스팅을 위해선 업캐스팅이 선행되어야하는가 : yes
		
		ebook.setFontColor("블랙");
		System.out.println(ebook.getFontColor());
		
		// abook = new Book3(); → abook은 이미 Book3를 상속받고 있기 때문에 오류
		
		
		//문제 (3)
		book = new AudioBook3();
		book.setTitle("자바 기초");
		//book.volume(10); → 다운캐스팅하지 않았음으로 오류 발생
		book.vol = 11; // → 자식클래스엔 접근 불가라 Book3의 vol에 저장
		abook = (AudioBook3)book; // 다운캐스팅을 하기 위해선 업캐스팅이 선행되어야 하며, 업캐스팅 된 클래스를 다운캐스팅해야한다.
		abook.vol = 12; // → 자식클래스 인스턴스이므로 AudioBook3의 vol에 저장
		abook.vovo();
		// abook은 book을 다운캐스팅 받았기에 super.vol 출력 시 아까 저장해두었던 11이 출력됨
		System.out.printf(abook.getTitle());
		// 마찬가지로 abook은 book을 다운캐스팅 받았기에 abook의 title출력 시 아까 저장해두었던 "자바 기초"가 출력됨
	}

}

class Book3 {
	int vol;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}

class EBook3 extends Book3{
	private String fontColor;

	public String getFontColor() {
		return fontColor;
	}
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
}

class AudioBook3 extends Book3 {
	int vol;
	
	int volume(int vol) {
		return this.vol = vol;
	}
	
	void vovo() {
		System.out.println(this.vol);
		System.out.println(super.vol);
	}
}

/*
문제 1.
오디오북 클래스를 추가하세요.
볼륨을 저장하는 정수타입의 속성을 추가하세요.
main 메소드에서 다운캐스팅을 사용하여 오디오북의 볼륨을 출력하는 코드를 작성하세요. 
*/