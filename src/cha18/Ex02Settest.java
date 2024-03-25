package cha18;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Ex02Settest {
	public static void main(String[] args) {
		String[] menu = {"짜장면", "짬뽕", "된장찌개", "김치찌개", "탕수육"};
		Cos A = new Cos("A손님");
		Cos B = new Cos("B손님");
		Cos C = new Cos("C손님");
		
		A.addMenu("짜장면");
		A.addMenu("짬뽕");
		B.addMenu("짜장면");
		B.addMenu("탕수육");
		C.addMenu("짜장면");
		C.addMenu("김치찌개");
		
		Course2 course2 = new Course2();
		course2.setCos(A, B, C);
		
		System.out.println("주문한 모든 메뉴");
		course2.setMenu(menu); // setMenu메소드를 호출하여 List타입으로 저장한 뒤 Set타입으로 변경하여 중복확인
		System.out.println(course2.getMenu());
		
		System.out.println("모든 사람이 동일하게 주문한 메뉴");
		System.out.println(course2.getSameMenu());
		
		System.out.println("아무도 주문하지 않은 메뉴");
		System.out.println(course2.getNobody());		
		
	}

}
class Course2 {
	private Set<String> menu;
	private List<Cos> customer;

	public void setCos(Cos... arrcustomer) {
		customer = new ArrayList<>();
		Collections.addAll(customer, arrcustomer);
	}
	public void setMenu(String[] arrcustomer) {
		List<String> list = new ArrayList<>();
		Collections.addAll(list, arrcustomer);
		menu = new HashSet<>(list);
	}
	public Set<String> getMenu() {
		return menu;
	}
	public Set<String> getSameMenu() {
		Set<String> rMenu = null;
		for (Cos customer : customer) {
			if (rMenu == null) {
				rMenu = new HashSet<>(customer.getMenu());
			}
			rMenu.retainAll(customer.getMenu());
		}
		return rMenu;
	}
	public Set<String> getAllmenu(){
		Set<String> allmenu = new HashSet<>();
		for (Cos cos : customer) {
			allmenu.addAll(cos.getMenu());
		}
		return allmenu;
	}
	
	public Set<String> getNobody(){
		Set<String> nMenu = menu;
		Set<String> aMenu = this.getAllmenu();
		nMenu.removeAll(aMenu);
		return nMenu;
		
	}
}
	
class Cos {
	private String name;
	private Set<String> menu;
	
	public Cos(String name) {
		this.name = name;
		menu = new HashSet<>();
	}
	public void addMenu(String menu) {
		this.menu.add(menu);
	}
	public Set<String> getMenu() {
		return menu;
	}	
}
/*
엘컴퓨터식당에는 짜장면, 짬뽕, 된장찌개, 김치찌개, 탕수육 식사 메뉴가 있습니다.
A는 짜장면, 짬뽕을 시켰습니다.
B는 짜장면, 탕수육을 시켰습니다.
C는 짜장면, 김치찌개를 시켰습니다. 

문제 1.
주문한 모든 메뉴를 중복 없이 정렬하여 출력하세요.

문제 2.
모든 사람이 주문한 메뉴를 출력하세요.

문제 3.
한 명도 시키지 않은 메뉴들을 출력하세요.
*/