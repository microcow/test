package ch9;

public class Ex06Interface {
	public static void main(String[] args) {
		Book6 book1 = new Book6();
		book1.setTitle("자바 알고리즘");
		book1.setAuthor("엘컴퓨터학원");
		book1.setPrice(50000);
		
		EBook5 eb = new EBook5();
		eb.setTitle("자바 기본문법");
		eb.setAuthor("엘컴퓨터학원");
		eb.setPrice(30000);
		eb.setFontColor("블루");
		
		Car car = new Car();
		car.setModelName("소나타");
		car.setDoor(2);
		car.setTotalPrice(40000000);
		
		Cart2 cart = new Cart2();
		cart.add(book1);
		cart.add(eb);
		cart.add(car);
		
		OrderService orderService = new OrderService();
		orderService.order(cart); //전혀 연관없는 인스턴스를 던질 수 있다

		PrintService printService = null;
		// 인터페이스도 인스턴스 생성이 가능하다. (추상클래스와 차이점1)
		/// PrintService Print = new PrintService; → null로만 생성가능??
		
		printService = eb;
		// 업캐스팅을 위해선 해당 인터페이스를 implements(구현)하고 있어야한다. (업캐스팅 정리 - 일반 클래스: 부모클래스의 인스턴스가 자식클래스를 품을 수 있다 / 인터페이스: 인터페이스를 구현하고 있는 클래스의 인스턴스를 품을 수 있다)
		// printService가 eb로 업캐스팅되어도 PrintService의 메소드에 한해서만 호출할 수 있다. (printService가)
		printService.printInfo();
		// 따라서, 위 코드 출력시 eb의 클래스인 EBook5의 printInfo 메소드를 호출한다 (오버라이딩 된 메소드가 있다면, 본래 클래스에 있는 메소드가 아닌 업캐스팅 된 클래스의 메소드를 호출한다.)(*ch9 Ex01)
		
		printService = car;
		// car또한 PrintService인터페이스를 implements(구현)하였기 때문에 업캐스팅이 가능하다.
		printService.printInfo();
		// 마찬가지로 위 코드 출력 시 car의 클래스인 Car의 PrintInfo 메소드를 호출한다.
		
		OrderService.orderPrint(eb);
		OrderService.orderPrint(car);
		
		//printService.setting(); → printService 인터페이스에는 setting이라는 메소드가 없으므로 호출 불가
		
		PrintServiceForPrinter pfp = car; // new Car; 은 안되나?
		pfp.setting();
		// PrintServiceForPrinter 인터페이스에는 setting이라는 메소드가 있으므로 호출 가능
		
		PrintServiceForPrinter.getPrinterType();
		// 인터페이스가 메소드를 호출할 수 있다.
		
		pfp.setPrinter();
		pfp.printInfo();
		//pfp 인스턴스는 PrintServiceForPrinter인터페이스의 인스턴스이며 PrintService인스턴스를 상속받고 있기에 printInfo 메소드를 사용할 수 있다.
		
		//printService = book1;	→ book1의 클래스는 printService 인터페이스를 구현하고 있지 않기에 오류
		//printService.printInfo();
		
		//문제 1
		Box box = new Box();
		box.settitle("상품명");
		box.setprice(10000);
		box.setinput("입고일자");
		box.setoutput("출고일자");
		box.save(box);
		box.print(box);
		// 스태틱이 아닌 메소드에도 인스턴스를 아규먼트로 던질 수 있다.(이 때 파라미터는 클래스 타입이나 인터페이스 타입으로 받아야한다.)
		
	}
}

class Cart2 {
	OrderItem[] items; //인스턴스 변수 items는 OrderItem을 implements하고있는 모든 클래스의 인스턴스를 받을 수 있다
	int index;
	
	public Cart2() {
		items = new OrderItem[10]; //업캐스팅
		index = 0;
	}
	
	public void add(OrderItem item) { //업캐스팅
		// 파라미터 items는 OrderItem을 implements하고있는 모든 클래스의 인스턴스를 받을 수 있다
		// 업캐스팅 받은 파라미터 item은 OrderItem이 오버라이딩 된 클래스의 메소드만 호출할 수 있다
		items[index] = item;
		index++;
	}
	
	public OrderItem[] get() {
		return items;
	}
}

interface OrderItem {
	// 부모 자식 관계가 아님에도 다형성을 사용해야 할 때 인터페이스를 사용한다
	// 인터페이스는 특정 기능에 한해서만 다형성을 사용할 수 있다
	// 인터페이스는 추상메소드만 가질 수 있다. (일반 메소드는 가질 수 없다(추상클래스와 차이점2))(다만, 클래스(static)메소드와 디폴트(default)메소드는 가질 수 있다.)
	// 인터페이스를 implements하는 클래스는 인터페이스의 추상메소드를 반드시 모두 오버라이딩 해야한다.
	public abstract String getOrderName();
	public abstract int getOrderPrice(); 
}

class Book6 implements OrderItem {
	// 인터페이스를 구현(상속x)하기 위해선 implements 키워드를 사용한다.
	String title;
	String author;
	int price;
	
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

	public int getPrice() {
		return (int)(price * 1.1f);
	}

	public void setPrice(int price) {
		if (!(price >= 0 && price <= 50000))
			return;
		this.price = price;
	}

	@Override
	public String getOrderName() {
		return getTitle();
	}

	@Override
	public int getOrderPrice() {
		return getPrice();
	}
	
}

class EBook5 extends Book6 implements PrintService {
	// EBook5가 Book6를 상속받고 있다면 Book6가 implements하고있는 인터페이스까지 상속받게된다.
	private String fontColor;
	
	public String getFontColor() {
		return fontColor;
	}

	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}
	
	@Override
	public void setTitle(String title) {
		super.setTitle("[e북]" + title);
	}
	
	@Override
	public int getPrice() {
		return (int)(price * 1.2f);
	}

	@Override
	public String getOrderName() {
		String title = getTitle() + ", 폰트: " + getFontColor(); 
		return title;
	}

	@Override
	public int getOrderPrice() {
		return getPrice();
	}
	
	@Override
	public void printInfo() {
		System.out.println("--- e북 ---");
		System.out.println("책이름: " + getTitle());
		System.out.println("저자: " + getAuthor());
		System.out.println("가격: " + getPrice());
		System.out.println("폰트색상: " + getFontColor());
		System.out.println("감사합니다.");
		System.out.println();
	}

}

class Car implements OrderItem, PrintServiceForPrinter {
	// 인터페이스는 다중 implements(구현)이 가능하다 (추상클래스와 차이점3)
	// implements한 인터페이스의 메소드는 모두 오버라이딩 해주어야하며, OrderItem로 업캐스팅 시 OrderItem의 메소드만 사용 가능하다.(반대로 PrintServiceForPrinter로 업캐스팅 시 PrintServiceForPrinter의 메소드만 사용 가능하다.)
	private String modelName;
	private int totalPrice;
	private int door;	
	
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDoor() {
		return door;
	}

	public void setDoor(int door) {
		this.door = door;
	}

	@Override
	public String getOrderName() {
		return getModelName() + "[" + getDoor() + "도어]";
	}

	@Override
	public int getOrderPrice() {
		return getTotalPrice();
	}

	@Override
	public void printInfo() {
		System.out.println("- 차량정보 -");
		System.out.println("모델명: " + getModelName());
		System.out.println("가격: " + getTotalPrice());
		System.out.println("Door: " + getDoor());
		System.out.println("프린터로 해당 정보가 전송되었습니다.");
		System.out.println();
	}

	@Override
	public void setting() {
		System.out.println("- 프린터 설정 -");
		System.out.println("폰트 사이즈 9pt");
		System.out.println("5매 출력");
	}
	
	/*
	@Override
	public void setPrinter() {
		System.out.println("3번 프린터로 설정");
	}
	*/

}

class OrderService {
	public void order(Cart2 cart) { //전혀 연관없는 클래스의 형태를 파라미터로 받을 수도 있다 
		OrderItem[] items = cart.get(); 
		//클래스 내에서 전혀 연관없는 인터페이스의 형태로 인스턴스를 생성할수도 있다
		//파라미터 cart는 Cart2 클래스와 같은 형태이므로 get메소드를 호출할 수 있다.
		for (int i=0; i<items.length; i++) {
			if (items[i] == null)
				break;
			System.out.println("상품명: " + items[i].getOrderName() + "\n가격: " + items[i].getOrderPrice() + "\n주문 데이터베이스에 저장되었습니다.\n");
		}
	}
	
	public static void orderPrint(PrintService p) { //전혀 연관없는 인터페이스의 형태를 파라미터로 받을 수 있다
		p.printInfo();
	}
}

interface PrintService {
	public abstract void printInfo();
}

interface PrintServiceForPrinter extends PrintService {
	// 인터페이스 끼리는 상속이 가능하다 (즉, 부모인터페이스의 메소드도 호출 가능) (하지만, 부모인터페이스는 자식인터페이스 메소드 호출 불가)
	public abstract void setting();
	
	default public void setPrinter() {
		System.out.println("기본값: 1번 프린터");
	// 인터페이스에서 default는 해당 메소드를 오버라이딩 해도되고 안해도 된다는 의미이다
	} 
	
	public static void getPrinterType() {
		System.out.println("- 프린터 타입 -");
		System.out.println("레이저 프린터입니다.");
		
	}
}
// 문제 1
class Getter  {
	int i=0;
	info[] arr = new info[i+1]; /// 질문 - arr 배열은 무한히 받기 위해선 메모리 선언을 어떻게 해야하는가
	String title;
	int price;
	String input;
	String output;
	
	public void save(info save) {
		//if(arr[i] == null) 항상 거짓이기에 성립불가 해당 식을 사용하고 싶다면 반복문을 사용하자	
		arr[i] = save;
				i++;
	}
	
	public String gettitle() {
		return this.title;
	}
	public int getprice() {
		return this.price;
	}
	public String getinput() {
		return this.input;
	}
	public String getouput() {
		return this.output;
	}
	
	public void print(info para) {
		System.out.print(this.title + this.price + this.input + this.output);
	}
}
interface info{
	public abstract void settitle(String a);
	public abstract void setprice(int a);
	public abstract void setinput(String a);
	public abstract void setoutput(String a);
}

class Box extends Getter implements info{
	
	@Override
	public void settitle(String title) {
		this.title = title;
	}
	@Override
	public void setprice(int price) {
		this.price = price;
	}
	@Override
	public void setinput(String input) {
		this.input = input;
	}
	@Override
	public void setoutput(String output) {
		this.output = output;
	}
		
	
}
/*
문제 1.
상품들을 창고에 저장하고 창고에 저장된 상품들을 출력하세요.
창고에 저장될 재고의 정보는 상품명, 가격, 입고일자(String), 출고일자(String) 입니다.
모든 상품이 재고 정보를 가지고 있지 않고 재고 인터페이스를 구현한 상품은 재고 정보를 가지고 있습니다.
재고 인터페이스를 구현한 상품만 창고에 저장이 가능하도록 구현하세요.
힌트) 창고 클래스, 재고 인터페이스, 재고 인터페이스가 적용된 상품 클래스들, 재고들이 저장될 배열 등이 필요합니다.  
*/