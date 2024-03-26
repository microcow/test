package cha18;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
public class Ex09TreeSettest {
	public static void main(String[] args) {
		NavigableSet<Integer> point = new TreeSet<>();
		
		
		point.add(10);
		point.add(20);
		point.add(30);
		point.add(40);
		point.add(50);
		point.add(60);
		point.add(70);
		point.add(80);
		point.add(85);
		point.add(90);
		point.add(100);
		
		// 문제 1.
		System.out.println(point.tailSet(60, true));
		
		// 문제 2.
		System.out.println(point.pollLast());
		/// poll은 값을 삭제하는데 peekLast처럼 검색만 할 순 없는지
		
		// 문제 3.
		System.out.println(point.higher(80));
		
		// 문제 4.
		System.out.println(point.floor(75));
	}

}
/*
문제 1.
60점 이상인 학생들의 점수를 출력하세요. 60점을 포함합니다.

문제 2.
학생들의 시험 점수 중 가장 높은 학생의 점수를 출력하세요.

문제 3.
80점 보다 가장 근접하게 높은 점수를 출력하세요.

문제 4.
75점을 찾아 출력하세요. 없다면 75점 보다 가장 근접하게 낮은 점수를 출력하세요.
*/