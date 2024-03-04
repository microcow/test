package ch8;

public class Ex07Encapsulationtest {
	public static void main(String[] args) {

	Price book = new Price();
	
	book.setprice(1000);
	
	System.out.print(book.getprice());

	
	}
}

class Price {
	private int price;
	
	// setter
	public void setprice(int price) {
		this.price = price;
	}
	
	// getter
	public int getprice() {
		return this.price;
	}

}
/*
문제 1.
특정 개체에 대한 클래스를 만들고 getter/setter 를 이용하여 캡슐화된 클래스를 작성한 뒤 출력하세요. 
*/