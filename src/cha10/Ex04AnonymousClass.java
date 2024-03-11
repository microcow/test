package cha10;

public interface Ex04AnonymousClass {
	public static void main(String[] args) { 
		Book b1 = new Book();
		b1.setTitle("자바 익명클래스란");
		b1.setAuthor("엘컴퓨터학원");
		
		
		PrintService ps = new PrintServiceForPrinter();
		// PrintService 인터페이스의 인스턴스 ps를 PrintServiceForPrinter로 업캐스팅
		// 업캐스팅되어도 소속은 PrintService인터페이스 소속
		b1.printInfo(ps);
		// 기존 업캐스팅은 부모클래스 인스턴스가 자식클래스를 받을 때 사용 업캐스팅된 부모클래스 인스턴스는 자식클래스 메소드를 사용하지 못하지만, 오버로딩된 메소드는 사용 가능
		// 그와 동일하게 업캐스팅된 인터페이스 인스턴스가 메소드 호출 시 오버로딩된 메소드 호출
		
		b1.printInfo(new PrintService() {
			// 아규먼트로 인스턴스를 새롭게 구현하는 모습 (인스턴스를 생성하는 것이 아님, 업캐스팅하는 것과 비슷한 매커니즘으로, 호출받는 파라미터를 PrintSetvice로 업캐스팅 후 아래에 오버라이딩 한 메소드를 호출)
			// 클래스 이름이 없으므로 익명클래스라 부른다
			// 원래라면 아래의 내용을 새롭게 오버라이딩 하기 위해서는 신규클래스를 생성한 후 PrintService 인터페이스를 abstract해야하지만 그 과정을 아규먼트에서 한 것임)
			// 일회성으로 사용하려면, 클래스를 만들고 인터페이스를 구현하고 오버라이딩 후 호출하는 것 보다, 호출과 동시에 구현 및 오버라이딩할 수 있는 익명클래스를 사용하면 훨씬 간단하다
			@Override
			public void print() {
				System.out.println("- FAX로 전송 -");
				System.out.println(b1.getTitle() + "," + b1.getAuthor());
				System.out.println();
				// 익명클래스 안에서 메인메소드 내에 있는 변수들을 사용할 수 있다 (여기선 b1)
			}
			/// 메소드를 호출할 때 b1을 사용한 이유 : 호출한 메소드와 b1이 동일한 클래스이기 때문, 호출한 메소드가 클래스 메소드가 아니기에 인스턴스의 이름으로 호출
		});
		
		b1.printInfo(new PrintService() {

			@Override
			public void print() {
				System.out.println("- 앱 알림으로 전송 -");
				System.out.println(b1.getTitle() + "," + b1.getAuthor());
				System.out.println();
			}
			
		});
	}

}

interface PrintService {
	public abstract void print();
}

class PrintServiceForPrinter implements PrintService {

	@Override
	public void print() {
		System.out.println("- 프린터로 출력 -");
		// (1)
		System.out.println("책 인스턴스가 필요합니다.");	
		System.out.println();
	}
	
}

class Book {
	String title;
	String author;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void printInfo(PrintService ps) {
		ps.print();
	}
}
