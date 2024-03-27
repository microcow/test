package cha18;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex11Maptest {
	public static void main(String[] args) {
		Students a1 = new Students("A 학생");
		a1.addPoint(new Point("3월 모의고사", 50));
		a1.addPoint(new Point("6월 모의고사", 66));
		
		Students b1 = new Students("B 학생");
		b1.addPoint(new Point("3월 모의고사", 30));
		b1.addPoint(new Point("6월 모의고사", 70));
		
		Students c1 = new Students("C 학생");
		c1.addPoint(new Point("3월 모의고사", 47));
		c1.addPoint(new Point("6월 모의고사", 73));
		c1.addPoint(new Point("9월 모의고사", 82));
		 
		List<Students> class1= new ArrayList<>();
		class1.add(a1);
		class1.add(b1);
		class1.add(c1);
		
		School school = new School();
		school.addStudents("1반", class1);
		school.printAllStudents();
		
		
		
		List<Point> tete = new ArrayList<>();
		tete.add(new Point("asd", 1));
		System.out.println(tete.toString());
		// ★ collection이나 Map타입에서 메소드 호출 시 요소타입클래스(제네릭스)에서 해당 메소드를 오버라이딩 하고 있을 경우 요소타입클래스에 오버라이딩된 메소드를 호출한다 
		// 출력은 []괄호 안으로 된다
		tete.add(new Point("sdf", 123));
		System.out.println(tete.toString());
		// ★ 저장하고 있는 인스턴스가 두개 이상 있을 때 호출 시 모두 toString을 출력한다 (,로 구분)
		
		Map<Point, Students> tetete = new HashMap<>();
		tetete.put(new Point("zzz", 111), new Students("xxx"));
		System.out.println(tetete.toString());
		/// map처럼 제네릭스가 2개있는 경우는?
		// ★ 각각의 타입에서 오버라이딩 된 메소드를 각각 호출한다
		// 출력은 {}괄호 안으로 되지만 =으로 구분된다
	}
}
class School {
	Map<String, List<Students>> StudentMap = new HashMap<>();

	void addStudents(String name, List<Students> students) {
		StudentMap.put(name, students);
	}
	void printAllStudents() {
		for (Map.Entry<String, List<Students>> test : this.StudentMap.entrySet()) {
			/// 그냥 Entry라고 입력했을땐 왜 안되지
			for (Students test2 : test.getValue()) {
				System.out.println(test2.toString());
				for (Point test3 : test2.getPoint()) {
					System.out.println(test3.getName() + ", " + test3.getPoint());
				}
			}
		}
	}
}


class Students {
	private String name;
	List<Point> point = new ArrayList<>();
	
	Students(String name){
		this.name = name;
	}
	public void addPoint(Point point2) {
		this.point.add(point2);
	}
	public String getName() {
		return name;
	}
	public List<Point> getPoint() {
		return point;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
class Point{
	String mon;
	int point;
	Point (String mon, int point){
		this.mon = mon;
		this.point = point;
	}
	public String getName() {
		return mon;
	}
	public int getPoint() {
		return point;
	}
	@Override
	public String toString() {
		return mon + "포인트클래스";
		
	}
}
/*
문제 1.
반별 학생 목록을 저장하는 맵을 작성하세요.
학생들은 자신의 모의고사 점수들을 리스트로 갖습니다. 
학생마다 치른 모의고사 횟수는 다를 수 있습니다.
모든 반의 학생과 각 학생이 치른 모의고사들의 점수를 출력하세요.
위의 예제와 같이 클래스를 사용하여 코딩하세요.
*/