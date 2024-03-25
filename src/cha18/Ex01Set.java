package cha18;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Ex01Set {
	
	/* HashSet 특징 
	 * ▶ 장점 : 저장되는 데이터는 자동으로 중복처리가 된다 (List와 차이점)
	 * ▶ 단점 : HashSet에 저장되는 데이터는 연속적이지 않다. 즉, 정렬이 되지 않음(List와 차이점)
	 * ▶ set도 List와 같이 배열을 이용한다 (배열이 가변적)
	 * ▶ HashSet은 메소드를 활용해 return된 인스턴스(객체)의 Hash코드를 사용해 배열인덱스를 만든 후 배열(버킷)에 데이터를 저장한다 
	 *		즉, 중복된 인스턴스나 Hash코드를 return받게 될 경우 기존에 있던 배열인덱스와 일치하기에 중복처리가 된다 (따라서, 순서에따른 정렬이 되지 않음)
	 * ▶ Set에는 get() 메소드가 없다. 데이터가 중복으로 처리된 후 저장되고 정렬되지 않기에 get()메소드의 의미가 없다
	 */
	
	public static void main(String[] args) {
		Integer[] intg1 = {1, 2, 3, 4, 5, 6, 7, 8};
		/// 인스턴스라 하면 노란색으로 알고있었는데., 인스턴스는 인스턴스 변수도 가지고 있을텐데 → Interger 클래스의 특수성 
		/// Integer 1 = new Integer(); → 불가
		
		List<Integer> list1 = new ArrayList<>();
		Collections.addAll(list1, intg1);
		// Collections.addAll(Collection인스턴스, 제네릭타입(Integer)인스턴스) 메소드를 사용하여 제네릭타입에 맞는 인스턴스를 List에 저장 가능
		print(list1);
		System.out.println();
		
		
		Set<Integer> s1 = new HashSet<>();
		// HashSet 생성자로 Collection생성
		s1.add(6);
		s1.add(7);
		s1.add(8);
		s1.add(9);
		s1.add(10);
		print(s1);
		Collection<Integer> c1 = s1; // 업캐스팅 (오버라이딩 되지 않은 Set의 메소드 사용 불가(업캐스팅 참고)
		print(c1);
		System.out.println();
		
		Set<Integer> s2 = new HashSet<>(list1);
		// List와 동일하게 생성자 아규먼트에 타입 인스턴스가 온다면, s2의 요소로 저장하지만, 중복되는 내용(Hashcode)이 있다면 중복처리한다.
		// ★★ HashSet 생성자의 아규먼트로는 Collection타입만 올 수 있다
		
		print(s2);
		s2.remove(2);
		s2.remove(8);
		s2.remove(intg1[2]);
		// 인스턴스 값을 입력하여 remove도 가능하며, 인스턴스를 직접 입력하여 remove도 가능
		// Iterator의 remove와 구분
		print(s2);
		
		System.out.println();
		
		s2.add(6);
		s2.add(7);
		// ★ s2에 6과 7을 추가하였음에도, 이미 있는 요소들이기에 중복처리되어 print(s2) 출력 시 6과 7은 한번씩만 출력된다ㅏ. 
		print(s2);
		
		System.out.println();
		
		print(s1);
		print(s2);
		s1.addAll(s2);
		/* ★ addAll메소드는 호출자(Collection타입)에 아규먼트(Collection타입)를 통으로 더해준다
		(호출자가 set타입일 경우 자동으로 중복처리된다) (List타입일 경우엔 배열의 빈자리부터 데이터가 저장됨) */
		System.out.println("addAll");
		print(s1);
		System.out.println();
		
		print(s1);
		print(s2);
		s1.retainAll(s2);
		/* ★ retainAll 메소드는 호출자와 아규먼트(Collection타입)가 중복되는 내용만 호출자에 저장한다 
		   (즉, 중복되지 않는 내용 삭제),(아규먼트로 사용된 Collection타입 인스턴스의 내용은 비교에만 쓰일뿐 삭제되지 않음.)
		 */
		
		System.out.println("retainAll");
		print(s1);
		print(s2);
		System.out.println();
		
		print(s1);
		print(s2);
		s1.removeAll(s2);
		/* ★ removeAll 메소드는 호출자의 내용에서 아규먼트(Collection타입)의 내용을 삭제해여 호출자에 저장한다 
		   (즉, 중복되는 내용만 삭제),(아규먼트로 사용된 Collection타입 인스턴스의 내용은 비교에만 쓰일뿐 삭제되지 않음.)
		 */
		System.out.println("removeAll");
		print(s1);
		print(s2);
		
	}
	
	public static void print(Collection<Integer> c) {
		// ★ Collection 인터페이스는 set과 List의 상위 클래스이므로 둘 다 받을 수 있다
		for (Integer i : c)
			System.out.print(i + ", ");
		System.out.println();
	}
}
