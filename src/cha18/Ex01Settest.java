package cha18;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
public class Ex01Settest {
	public static void main(String[] args) {
		Dooly dooly = new Dooly("국어", "영어");
		Dooly ddochi = new Dooly("영어", "수학");
		Dooly douner = new Dooly("국어", "수학", "과학");
		
		Set<Dooly> list = new HashSet<>();
		
		Collections.addAll(list, dooly, ddochi, douner);

		Dooly.print(list);
		
	}
}
class Dooly {
	String[] title = new String[3];
	
	public Dooly(String title1, String title2){
		this.title[0] = title1;
		this.title[1] = title2;
	}
	
	public Dooly(String title1, String title2, String title3){
		this.title[0] = title1;
		this.title[1] = title2;
		this.title[2] = title3;
	}
	
	public String getTitle() {		
		
			return this.title[0];
	}
	
public static void print(Collection<Dooly> c) {
		
		for (Dooly i : c)
			System.out.print(i.getTitle() + ", ");
		System.out.println();
	}	
}
/*
문제 1.
둘리는 국어, 영어 수업을 듣습니다.
또치는 영어, 수학 수업을 듣습니다.
도우너는 국어, 수학, 과학 수업을 듣습니다.
학생들이 수강하는 모든 과목을 중복 없이 출력하세요.
*/