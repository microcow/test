package cha18;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Ex01Settest2java {
	public static void main(String[] args) {
		Dooly2 dooly = new Dooly2("국어", "영어");
		Dooly2 ddochi = new Dooly2("영어", "수학");
		Dooly2 douner = new Dooly2("국어", "수학", "과학");
		
		String[] dool = {"국어", "영어"};
		String[] ddo = {"영어", "수학"};
		
		
		
		Set<String> list = new HashSet<>(Arrays.asList(dool));
		Set<String> list2 = new HashSet<>(Arrays.asList(ddo));
		// list2.add(ddochi); 
		// ★★ 배열은 List로 추가할 수 있지만 set으로 추가될 수 없다 List는 Set으로 추가될 수 있기에 배열을 set으로 추가하기 위해선 List를 경유하여야한다.
		Set<Dooly2> list3 = new HashSet<>();
		list3.add(douner);
		
		
		// Collections.addAll(list, dooly, ddochi, douner);
		
		Set<Dooly2> list4 = new HashSet<>(list);
		// list4.addAll(list2, list3);
		list4.addAll(list2);
		list4.addAll(list3);
		
		Dooly2.print2(list4);

	}
}
class Dooly2 {
	String title1;
	String title2;
	String title3;
	
	public Dooly2(String title1, String title2){
		this.title1 = title1;
		this.title2 = title2;
	}
	
	public Dooly2(String title1, String title2, String title3){
		this.title1 = title1;
		this.title2 = title2;
		this.title3 = title3;
	}
	public String getTitle() {		
		
		return this.toString();
	}
	
	public static void print2(Collection<Dooly2> c) {
	
		for (Dooly2 i : c)
			System.out.print(i.getTitle() + ", ");
		System.out.println();
	}
	
	@Override
	public String toString() {
		return title1 + title2 + title3;
	}
}
