package cha18;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
public class Ex12Collections {
	public static void main(String[] args) {
		System.out.println("< addAll >");
		List<String> list = new ArrayList<>();
		Collections.addAll(list, "A", "D", "B", "C", "E");
		System.out.println(list);
		System.out.println();
		
		System.out.println("< binarySearch 정렬 전 >");
		System.out.println(Collections.binarySearch(list, "D"));
		// sort로 정렬되지 않았기에 "D"의 인덱스가 이상하게 출력된다.
		System.out.println();
		
		System.out.println("< sort >");
		Collections.sort(list);
		// Collections.sort메소드는 아규먼트(list타입)을 오름차순으로 정렬한다
		System.out.println(list);
		System.out.println();
		
		System.out.println("< binarySearch 정렬 후 >");
		System.out.println(Collections.binarySearch(list, "D"));
		System.out.println();
		
		System.out.println("< max, min >");
		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
		// Collections.max와 min을 통해 최대값과 최소값을 구할 수 있다
		System.out.println();
		
		System.out.println("< replaceAll >");
		Collections.replaceAll(list, "A", "A2");
		// Collections.replaceAll 메소드는 첫번째 아규먼트에 있는 두번째 아규먼트를 세번째 아규먼트로 전부 바꾼다.
		System.out.println(list);
		System.out.println();
		
		System.out.println("< reverse >");
		Collections.reverse(list);
		// Collections.reverse 메소드는 아규먼트(List타입)에 현재 정렬되어있는 내용을 역순으로 정렬한다 (기존 저장된 내용이 반대로 뒤집힘)
		System.out.println(list);
		System.out.println();
		
		System.out.println("< rotate >");
		Collections.rotate(list, 3);
		// Collections.rotate 메소드는 첫번째 아규먼트의 배열 인덱스를 아규먼트 두번째 숫자만큼 우측으로 으로 민다 (끝에 있을 경우 처음인덱스(0)로 온다) 
		System.out.println(list);
		System.out.println();
		
		System.out.println("< shuffle >");
		Collections.shuffle(list);
		// shuffle 메소드는 배열을 무작위로 섞는 메소드이다
		System.out.println(list);
		System.out.println();
		
		System.out.println("< singleton >");
		Set<String> set = Collections.singleton("A");
		System.out.println(set);
		//set.add("B");		// error
		System.out.println();
		// singleton 메소드는 아규먼트 내용을 set타입으로 return하며 내용 수정이 불가하다 (List타입의 singleton은 singletonList 사용)
		// singleton의 값이 저장되어있는 set의 내용 수정 불가
		
		System.out.println("< singletonList >");
		List<String> list2 = Collections.singletonList("B");
		System.out.println(list2);
		//list2.add("C");	// error
		System.out.println();
		// singletonList메소드는 singleton과 동일한 기능이며, List로 반환한다.
		
		System.out.println("< reverseOrder >");
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		System.out.println();
		// sort의 아규먼트가 두개라면 첫번째 아규먼트의 배열 방식을 두번째 아규먼트로 정한다 (Comparator 인스턴스가 return됨)
		// Comparator 타입에 관해선 뒤에 배움
		
		System.out.println("< swap >");
		Collections.swap(list, 0, 1);
		System.out.println(list);
		System.out.println();
		// swap메소드는 list의 0번인덱스(아규먼트첫번째)의 값을 1번(아규먼트두번째) 인덱스로 맞바꾼다
		
		System.out.println("< fill >");
		Collections.fill(list, "Z");
		// fill메소드는 list에 저장되어있는 배열을 모두 Z로 채운다 (내용을 바꿈)
		System.out.println(list);
		System.out.println();
	}
}
