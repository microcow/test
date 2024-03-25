package cha18;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
public class Ex06Stack {
	public static void main(String[] args) {
		
		// 스택은 queue(선입선출)과 다르게 후입 선출이다 (가장 나중에들어온 게 가장 먼저 나감)
		
		Book book = new Book("자바 컬렉션");
		book.addPage(new Page(0, "표지"));
		book.addPage(new Page(1, "목차"));
		book.addPage(new Page(2, "ArrayList"));
		book.addPage(new Page(3, "LinkedList"));
		book.addPage(new Page(4, "Queue"));
		book.addPage(new Page(5, "Stack"));
		
		book.view();
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

class Book {
	private String title;
	private Stack<Page> pageStack;
	private List<Page> pageList;
	private int currentPageNo; // 아무것도 저장안되있으므로 0이다
	
	public Book(String title) {
		this.title = title;
		this.pageStack = new Stack<>();
		this.pageList = new LinkedList<>();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Page> getPageList() {
		return pageList;
	}
	public void setPageList(List<Page> pageList) {
		this.pageList = pageList;
	}
	public void addPage(Page page) {
		pageList.add(page);
	}
	public void nextPage() {
		pageStack.push(pageList.get(currentPageNo++));
		// Stack에 저장하는 법 (List와 set의 add, Queue의 offer와 비슷)
	}
	public void prevPage() {
		Page page = pageStack.pop();
		// Queue의 poll 메소드와 유사하지만, poll메소드와 반대로 가장 나중에 들어온 데이터를 추출한 후 삭제한다.
		currentPageNo = page.getNo();
	}
	public void view() {
		System.out.println(pageList.get(currentPageNo));
	}
	
	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
}

class Page {
	private int no;
	private String contents;
	
	public Page(int no, String contents) {
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
