package ch7;
import java.util.Arrays;
public class Ex11Varargstest {
	public static void main(String[] args) {
		Book112 name;
		// 선언만 먼저하였으며, 메모리는 생성하지 않음
		// name.tag[0] = "저자"; → 메모리를 생성하지 않았으므로 오류발생
		
		name = new Book112();
		// 메모리 생성
		// System.out.println(name.tag[1]); → tag가 메모리를 생성하기 전 이기에 오류 발생
		name.bookname("ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ");
		Book112.paramit(name);
	}

}
class Book112 {
	String[] tag;
	
	void bookname(String... para) {
		// System.out.println(para[7]); → 7개 받았으므로 [6]까지만 메모리 생성. 실행 시 오류발생
		tag = new String[para.length];
		// 배열 생성
				for (int i=0; i<para.length; i++)
					tag[i] = para[i];
					
	}
	
	static void paramit(Book112 A) {
		System.out.println(Arrays.toString(A.tag));
		
	}
	
}

/*
문제 1.
가변인자를 사용하여 책의 저자를 여러명 설정할 수 있는 코드를 작성하고 결과를 출력하세요. 
*/