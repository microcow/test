package cha18;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Ex13Comparabletest {
	public static void main(String[] args) {
	// Ex13 문제1.
	List<Student2> student = new ArrayList<>();
	Student2 A = new Student2(1, "A");
	student.add(A);
	student.add(new Student2(2, "B"));
	student.add(new Student2(2, "C"));
	student.add(new Student2(3, "D"));
	student.add(new Student2(4, "E"));
	student.add(new Student2(5, "F"));
	student.add(new Student2(5, "G"));
	Collections.sort(student);
	System.out.println(student);
	
	
	
	// Ex14 문제1.
	Collections.sort(student, new Comparator<Student2>() {
		@Override
		public int compare(Student2 b1, Student2 b2) {
			
			int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo()) * -1;
			if (result == 0)
				result = b1.name.compareTo(b2.name);
			return result;
		}
	});
	System.out.println(student);
	
	// Ex14 문제2.
	Collections.sort(student, new Comparator<Student2>() {
		@Override
		public int compare(Student2 b1, Student2 b2) {
			
			int result = Integer.valueOf(b1.getNo()).compareTo(b2.getNo()) * -1;
			if (result == 0)
				result = b1.name.compareTo(b2.name)* -1;
			return result;
		}
	});
	System.out.println(student);
	}
}

class Student2 implements Comparable<Student2>{
	int no;
	String name;
	
	Student2(int no, String name){
		this.no = no;
		this.name = name;
	}
	
	public int getNo() {
		return no;
	}
	
	@Override
	public int compareTo(Student2 stu) {
		int result = Integer.valueOf(this.no).compareTo(stu.getNo());
		if (result == 0) {
			result = (this.name.compareTo(stu.name) * -1);
			// result = (stu.name.compareTo(this.name));
		}
		return result;
		
	}
	@Override
	public String toString() {
		return "(" + no + ", " + name + ")";
	}
}
/*
문제 1.
번호와 이름을 가진 학생 클래스를 만드세요.
학생의 번호를 오름차순으로 정렬하여 출력하세요.
번호가 같을 경우 이름을 내림차순으로 정렬하여 출력하세요.
*/