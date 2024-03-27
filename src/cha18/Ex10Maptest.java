package cha18;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class Ex10Maptest {
	public static void main(String[] args) {
		Map<String, Integer> class1 = new HashMap<>();
		/// Map의 제네릭스에는 String String 타입만 올 수 있는지 : Integer타입도 가능
		class1.put("A ", 10);
		class1.put("B ", 30);
		class1.put("C ", 55);
		class1.put("D ", 70);
		class1.put("E ", 90);
		
		Map<String, Integer> class2 = new HashMap<>();
		class2.put("F ", 20);
		class2.put("G ", 40);
		class2.put("H ", 55);
		class2.put("I ", 80);
		class2.put("J ", 100);
		
		// 문제 1.
		System.out.println("1반 점수");
		for (Map.Entry<String, Integer> e : class1.entrySet()) {
			System.out.println("이름 : " + e.getKey() + "점수 : " + e.getValue());
		}
		System.out.println("2반 점수");
		for (Map.Entry<String, Integer> e : class2.entrySet()) {
			System.out.println("이름 : " + e.getKey() + "점수 : " + e.getValue());
		}
		
		//문제 2.
		/* 
		for (Map.Entry<String, Integer> e : class1.entrySet()) {
			if (e.getValue() >= 90) {
				class1.remove(e.getKey());
				// ★★ 삭제 시에는 key값을 활용해 삭제해야함 (value값은 중복이 가능하기 때문)
				// foreach문에서는 삭제가 불가능하기에 Iterlator문으로 바꾼 뒤 삭제해야함 (위에 코드는 컴파일엔 문제가 없지만 런타임에서 오류 발생)
			}		
		}
		*/
		System.out.println("90점 이상인 학생 삭제");	
		for(Iterator<Integer> it = class1.values().iterator(); it.hasNext();) {
			while (it.hasNext()) {
			    if (it.next() >= 90) {
			        it.remove();
			    }
			}
				
		}
		System.out.println(class1);
		// ★★ 삭제 시에는 key값을 활용해 삭제해야함 (value값은 중복이 가능하기 때문)
		// foreach문에서는 삭제가 불가능하기에 Iterlator문으로 바꾼 뒤 삭제해야함
		/// 위 구조 한번 더 보기
		
		
		//문제 3.
		System.out.println("55점인 학생 삭제");
		Set<Integer> num = Collections.singleton(55);
		class1.values().removeAll(num); // removeAll을 활용한 삭제 (아규먼트로 Collection타입이 와야함)
		System.out.println(class1);
		class2.values().remove(55); // remove를 활용한 삭제 (아규먼트로 Object타입이 와야함)
		System.out.println(class2);
		
		//문제 4.
		System.out.println("100점인 학생 출력");
		Map<String, Integer> hun = new HashMap<>();
		class1.putAll(class2);
		hun.put("J ", 100);
		// 다양한 contains 방법 (아규먼트가 호출자에 포함되어있는지를 매칭 후 결과값 return)
		System.out.println(class1.entrySet().containsAll(hun.entrySet())); // entrySet으로 변환하여 값 포함 여부 확인 (key, value 모두(All) 비교 완료 시 true)
		System.out.println(class1.keySet().containsAll(hun.keySet())); // key값만 포함 여부 확인
		System.out.println(class1.values().containsAll(hun.values())); // value 값만 포함 여부 확인
		System.out.println(class1.values().contains(100)); // class1의 value 값과 아규먼트(정수) 값 포함 여부 확인 (class1의 value 값으로 contains 호출)
		System.out.println(class1.containsValue(100)); // class1의 value 값과 아규먼트(정수) 값 포함 여부 확인 (class1으로 containsValue 호출)
		System.out.println(class1.containsValue(hun)); /// class1과 hun의 value 값을 서로 확인하는게 아닌 class1의 value값과 hun(key, value)모두를 비교하는건가
		System.out.println(class1.containsKey("J ")); // class1의 key값 포함 여부 확인
		System.out.println(class1.containsKey(hun));
		
		
		
		System.out.println("100점 학생 이름");
		for (Map.Entry<String, Integer> e : class1.entrySet()) {
			if (e.getValue() == 100) {
				System.out.println(e.getKey());
			}
			
				
		}
		// System.out.println(class1.containsAll(hun)); key나 value값 없이 containsAll이나 contain 호출 불가
	}
}
/*
문제 1.
1반 학생들의 이름, 점수가 저장된 맵과 2반 학생들의 이름, 점수가 저장된 맵을 만드세요.
두 반의 모든 학생들을 중복 없이 출력하세요.

문제 2.
점수가 90점 이상인 학생들을 맵에서 삭제 후 출력하세요.

문제 3.
55점인 학생 모두 맵에서 삭제하세요.

문제 4.
100점인 학생이 존재하는 지 출력하세요.
*/