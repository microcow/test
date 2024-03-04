package ch08.Ex06;

public class Book {
	private String title;
	private String author;
	private int price;
	protected int dollarPrice; 
	int edition;
	protected float tax;
	
	void setTitle(String title) {
		this.title = title;
	}
	
	public String settitle(String setTitle) {
		return this.title = setTitle;
		
	}
	
	public String gettitle() {
		return title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
		// 메소드가 호출은 다른 패키지에서 받았고(메소드가 public이기에 가능)
		// this.author가 private 접근제한자 이지만 동일 페이지(jira class)내의 메소드에서 접근하기 때문에 사용가능
		/* 즉, 동일한 클래스에서 생성된 인스턴스라도 다른 패키지에 있을 경우 private 접근제한자가 걸려있는 메소드나 변수가 직접적인 접근이 불가하며,
		   이와 같이 public 접근제한자 메소드를 통해 접근하여야 한다. 
		 */
	}
	
	public String getAuthor() {
		return author;
		// 메소드가 호출은 다른 패키지에서 받았고(메소드가 public이기에 가능)
		// this.author가 private 접근제한자 이지만 동일 페이지(jira class)내의 메소드에서 접근하기 때문에 사용가능
	}
	
	public void setPrice(int price) {
		this.price = price;
		setDollarPrice(price);
	}
	
	public int getPrice() {
		return price;
	}
	
	private void setDollarPrice(int price) {
		dollarPrice = (int)(price / 1000f);
	}
	
	public int getDollarPrice() {
		return dollarPrice;
	}
	
	protected void setTax(float tax) {
		this.tax = tax;
	}
	
	protected float getTax() {
		return tax;
	}
}
class Book2{
	String d;
}
