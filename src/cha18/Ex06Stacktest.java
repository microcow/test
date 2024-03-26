package cha18;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class Ex06Stacktest {
	public static void main(String[] args) {
		Book2 book = new Book2();
		book.addPage2(new Page2(0, "첫페이지"));
		book.setStack();
		book.view();
		book.nextPage();
		
		book.addPage2(new Page2(1, "두번째페이지"));
		book.setStack();
		book.view();
		book.nextPage();
		
		try {
		book.addPage2(new Page2(2, "세번째페이지"));
		book.view();
		book.nextPage();
		book.view();
		}catch (IndexOutOfBoundsException e) {
		System.out.println("마지막 페이지입니다.");
		}
		
		
		book.prevView();
		book.prevView();
		
		/*book.prevPage();
		book.view();
		book.prevPage();
		book.view();*/
		
	}
}
class Page2{
	private int no;
	private String content;
	
	public Page2(int no, String content) {
		this.no = no;
		this.content = content;
	}
	@Override
	public String toString() {
		return no + "페이지 - " + content;
	}
}

class Book2{
	private Stack<Page2> pageStack = new Stack<>();
	private List<Page2> pageList = new ArrayList<>(); // new LinkedList<>();
	/// ArrayList를 사용할 때와 LinkedList를 사용할 때 차이?
	private int pageNo;
	
	public void addPage2(Page2 page) {
		this.pageList.add(page);
	}
	public void nextPage() {
		pageNo++;
	}
	public void prevPage() {
		pageNo--;
	}
	public void setStack() {
		pageStack.push(pageList.get(pageNo));
	}
	public void view() {
		System.out.println(pageList.get(pageNo));
	}
	public void prevView() {
		System.out.println(pageStack.pop());
	}
	
	
}
/*
문제 1.
입력한 페이지로 설정되는 메소드를 추가하세요.
view메소드를 이용해 설정된 페이지를 출력하세요.
페이지 설정 후 이전페이지와 다음페이지를 출력하세요.
*/