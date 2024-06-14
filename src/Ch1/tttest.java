package Ch1;

public class tttest extends testtest4 {
	public static void main(String[] args) {
		
		parent A = new parent();
		A.call();
		
		son B = new son();
		B.call();
		
		B = (son)A;
	}
	
}
class parent{
	public void call() {
		System.out.println("dd");
	}
}

class son extends parent{
	@Override
	public void call() {
		System.err.println("zz");
	}
}
