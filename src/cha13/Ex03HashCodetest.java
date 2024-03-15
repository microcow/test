package cha13;
import java.util.Objects;
public class Ex03HashCodetest {
	public static void main(String[] args) {
		Book10 hash = new Book10("java", "lcomputer");
		Book11 hash2 = new Book11("java", "lcomputer");
		System.out.println(System.identityHashCode(hash));
		System.out.println(hash.hashCode());
		System.out.println(System.identityHashCode(hash2));
		System.out.println(hash2.hashCode());
	
		
	}

}
class Book10 {
	private String java;
	private String lcomputer;
	
	public Book10(String java, String lcomputer) {
		this.java = java;
		this.lcomputer = lcomputer;
	}
	@Override
	public int hashCode() {
		return Objects.hash(java, lcomputer);
	}
}
class Book11 {
	private String java2;
	private String lcomputer2;
	
	public Book11(String java2, String lcomputer2) {
		this.java2 = java2;
		this.lcomputer2 = lcomputer2;
	}
	@Override
	public int hashCode() {
		return Objects.hash(java2, lcomputer2);
	}
}