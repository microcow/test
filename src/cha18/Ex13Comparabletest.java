package cha18;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Ex13Comparabletest {
	public static void main(String[] args) {
		
	List<Student2> student = new ArrayList<>();
	Student2 A = new Student2(1, "A");
	student.add(A);
	student.add(new Student2(2, "B"));
	student.add(new Student2(2, "C"));
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
		}
		/// 출력 시 name이 내림차순으로 정렬되지 않는 이유
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