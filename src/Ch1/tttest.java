package Ch1;

public class tttest extends testtest4 {
	public static void main(String[] args) {
		
		testtest4 test = new tttest();
		
		String a = "%" + "dd" + "%";
		System.out.println(a.toString());
		String b = "a";
		System.out.println(b.toString());
		
		a = "\"" + "%" + "dd" + "%" + "\"";
		b = "a";
		System.out.println(a.toString());
		System.out.println(b.toString());
	}
	
}
