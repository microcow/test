package ch7;

public class Ex05ClassVariabletest {
	public static void main(String[] args) {
		
		woo.book = "문화";
		
		woo a1 = new woo();
		a1.asd();
		
		woo.book = "도서";
		a1.asd();
		
		
	}
}
	class woo {
		static String book;	
		
		void asd () {
			System.out.println(book);
		}
		
}
/*
문제 1.
책 클래스에 카테고리를 저장할 수 있는 속성(변수)을 추가하세요.
카테고리를 "문화" 에서 "도서"로 변경해 주세요.
카테고리 변경 시 모든 인스턴스에 동일하게 적용되도록 코딩 후 적용된 결과를 출력하세요. 
*/