package cha18;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
public class Ex01Settest2java {
	public static void main(String[] args) {
		// 문제 1
		String[] dool = {"국어", "영어"};
		String[] ddo = {"영어", "수학"};
		String[] dou = {"국어", "수학", "과학"};
						
		Set<String> list = new HashSet<>(Arrays.asList(dool)); // ★★★ Arrays를 set로 저장하는 방법
		Set<String> list2 = new HashSet<>(Arrays.asList(ddo));
		Set<String> list3 = new HashSet<>(Arrays.asList(dou));
		// Set<String> list111 = new HashSet<>(dool);
		// ★★ 배열은 List로 추가할 수 있지만 set으로 추가될 수 없다 List는 Set으로 추가될 수 있기에 배열을 set으로 추가하기 위해선 List를 경유(Arrays.asList)하여야한다.
		// ★★ String배열 타입을 바로 HashSet타입으로 변경할 수 없다
		
		
		list.addAll(list2);
		list.addAll(list3);
		
		List<String> list11 = new ArrayList<>(Arrays.asList(dou));
		System.out.println(list.toString());
		/////////////////////////////////////////////
		
		// 문제 2
		Dooly2 dooly = new Dooly2("국어", "영어");
		Dooly2 ddochi = new Dooly2("영어", "수학");
		Dooly2 douner = new Dooly2("국어", "수학", "과학");
		
		Dooly2[] asd = new Dooly2[2];
		asd[0] = new Dooly2("안녕", "하세요");
		
		Set<Dooly2> list4 = new HashSet<>(Arrays.asList(dooly));
		System.out.println(list4);
		Set<Dooly2> list5 = new HashSet<>(Arrays.asList(ddochi));
		Set<Dooly2> list6 = new HashSet<>(Arrays.asList(asd));
		list4.addAll(list5);
		list4.addAll(list6);
		System.out.println(list4); /// 왜 뒤에서부터 출력? addAll은 추가하는 데이터가 맨앞으로 오고 나머지를 뒤로 밀어내나? set은 순서없이 저장한다
		/// 출력 시 문제 1과 2의 차이점
		// ★★★ 위 String[]의 배열인스턴스는 배열에 "문자열"을 저장했지만 asd는 배열에 "인스턴스"를 저장했기에 인스턴스끼리 비교하므로 중복을 걸러내지 못함
		// ★★ 즉, list는 요소들로 "문자열"들을 저장하고있고 list4는 요소들로 "인스턴스"들을 저장하고있음. 따라서, toSting시 list는 저장하고 있는 문자열을 출력하고 list4는 인스턴스주소를 출력함 
		// ★ Set말고 List(ArraysList)도 마찬가지로 인스턴스의 요소(문자열, 인스턴스 변수 등)를 저장하고 있다면 .toSting을 따로 오버라이딩하지 않았고 문자열을 저장 하고 있다면 문자열이 출력될테지만 인스턴스를 저장하고 있다면 주소가 출력됨 
		// ★ 따라서, List나 Set이 저장하고 있는 인스턴스의 요소(문자열, 인스턴스 변수 등)들을 출력하고 싶다면 출력해주는 메소드를 생성하거나 .toSting을 요소(문자열, 인스턴스 변수 등)들을 출력해주는 기능으로 오버라이딩해서 출력하자
		// ★ 인스턴스A = new 생성자(); 로 저장된 인스턴스A는 new 생성자(); 때 생성되는 인스턴스의 데이터를 복제하는 것 이기에 .toString 시 주소가 출력된다

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
}
/*
문제 1.
둘리는 국어, 영어 수업을 듣습니다.
또치는 영어, 수학 수업을 듣습니다.
도우너는 국어, 수학, 과학 수업을 듣습니다.
학생들이 수강하는 모든 과목을 중복 없이 출력하세요.
*/