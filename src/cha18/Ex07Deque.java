package cha18;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
public class Ex07Deque {
	public static void main(String[] args) {
		// Deque는 양방향 queue이다.
		// Deque는 선입선출과 후입선출 모두 가능하다.
		// 따라서, Deque는 queue와 stack의 기능을 모두 갖추고 있기에 더욱 활용도가 높다 
		Book22 book = new Book22("자바 컬렉션");
		book.addPage(new Page22(0, "표지"));
		book.addPage(new Page22(1, "목차"));
		book.addPage(new Page22(2, "ArrayList"));
		book.addPage(new Page22(3, "LinkedList"));
		book.addPage(new Page22(4, "Queue"));
		book.addPage(new Page22(5, "Stack"));
		
		book.nextPage();
		book.view();
		book.nextPage();
		book.view();
		book.nextPage();
		book.view();
		
		System.out.println();
		
		book.prevPage();
		book.view();
		book.prevPage();
		book.view();
		book.prevPage();
		book.view();
	}

}
class Book22 {
	private String title;
	private Deque<Page22> pageStack;
	private List<Page22> pageList;
	private int currentPageNo;
	
	public Book22(String title) {
		this.title = title;
		this.pageStack = new ArrayDeque<>();
		// ArrayDeque 생성자를 활용해 Deque 구조 생성
		// Stack처럼 사용하고 싶다면 Stack메소드를, Queue처럼 사용하고 싶다면 Qeue메소드를 사용
	
		// Stack 메소드 : push , pop
		// Queue 메소드 : offer , poll
		// 선입 지정 메소드 : offerFirst
		// 후입 지정 메소드 : offerLast
		// 선출 지정 메소드 : pollFirst
		// 후입 지정 메소드 : pillLast
		// 선입 확인 메소드 : peekFirst
		// 후입 확인 메소드 : peekLast
		
		this.pageList = new LinkedList<>();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Page22> getPageList() {
		return pageList;
	}
	public void setPageList(List<Page22> pageList) {
		this.pageList = pageList;
	}
	public void addPage(Page22 page) {
		pageList.add(page);
	}
	public void nextPage() {
		pageStack.push(pageList.get(currentPageNo++));		
	}
	public void prevPage() {
		Page22 page = pageStack.pop();
		currentPageNo = page.getNo();
	}
	public void view() {
		System.out.println(pageList.get(currentPageNo));
	}
	
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
}

class Page22 {
	private int no;
	private String contents;
	
	public Page22(int no, String contents) {
		this.no = no;
		this.contents = contents;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return no + "페이지 - " + contents;
	}

}
