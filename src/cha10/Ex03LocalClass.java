package cha10;

public class Ex03LocalClass {
	public static void main(String[] args) {
		System.out.println(EBook3.validatePrice(45000));
	
		System.out.println();
		
		EBook3 eb = new EBook3();
		eb.setPrice(50000);
		System.out.println(eb.getPrice());
	}

}


class EBook3 {
	private String title;
	private String author;
	private int price;
	public static final float tax = 1.1f;
	
	static boolean validatePrice(int price) {
		float dollar = 1100f;
		
		class Price { // 로컬클래스는 메소드 안에 클래스를 만드는 것이다.
			int taxPrice;
			
			Price(int price) {
				taxPrice = (int)(price * EBook3.tax);
				// dollar = 1200f; → 로컬클래스에서는 메소드내에 있는 지역변수의 값을 수정할 수 없다
				// EBook3.tax = 30; → 메소드 밖의 클래스에 있는 인스턴트 변수는 수정가능(static에 한해서)
			}
			
			int getTaxPrice() {
				return taxPrice;
			}
			
			float getDollarPrice() {
				return taxPrice / dollar;
			}
		}
		
		Price p = new Price(price);
		int taxPrice = p.getTaxPrice();
		System.out.println(taxPrice);
		
		float dollarPrice = p.getDollarPrice();
		System.out.println(dollarPrice);
		
		if (!(taxPrice >= 0 && taxPrice <= 50000)) //0보다 크거나 같고 50000보다 작거나 같지 않을 경우 false를 리턴
			return false;
		else if (!(dollarPrice >= 0 && dollarPrice <= 50))
			return false;
		
		return true;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (!EBook3.validatePrice(price)) //validatePrice이 거짓일 경우 return;
			return;
		this.price = price;
	}
}
