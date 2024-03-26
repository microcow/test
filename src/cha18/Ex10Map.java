package cha18;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class Ex10Map {
	public static void main(String[] args) {
		
		// HashMap은 '키' 를 가지고 데이터들을 정렬을 할 수 있다.
		// HashMap은 검색 속도가 매우 빠르다 (단, 넉넉한 버킷(저장공간)을 마련해놓지 않았을 경우 저장공간을 넘어 새로운 데이터를 저장하려 할 때, 버킷을 확장(리사이징)하기에 느려질 수 있다)
		
		System.out.println("< 팀A >");
		Map<String, String> teamA = new HashMap<>();
		// HashMap은 Map인터페이스를 구현하고 있기에 업캐스팅 가능하다.
		// HashMap은 키와 값으로 구성되어 있다 <키, 값>
		teamA.put("A", "자바");
		// put 메소드를 활용해 데이터를 추가할 수 있다
		// 키인 앞쪽 아규먼트(A)를 인덱스로 사용하고(정확히는 A의 해시코드), 값인 뒤쪽 아규먼트(자바)가 저장된다
		teamA.put("B", "C");
		teamA.put("C", "파이썬");
		teamA.put("D", "자바");
		teamA.put("E", "자바");
		teamA.put("E", "DB");		
		// ★ 키 중복 불가 (마지막에 저장된 DB만 저장됨)
		// 값은 중복 가능 (키만 중복 불가)
		
		
		for (Map.Entry<String, String> e : teamA.entrySet()) { // Hashset의 값을 가져오는 방법
			// map으로 부터 값을 가져오기 위해선 해당 map을 enrtySet 메소드를 활용해 요소들을 set으로 바꾸어주어야한다.
			// Map.Entry<키, 값>으로 //// 강의 4분 25초부터
			System.out.println("이름: " + e.getKey() + "\t스킬: " + e.getValue());
		}
		System.out.println();
		
		System.out.println("< 팀B >");
		Map<String, String> teamB = new HashMap<>();
		teamB.put("A", "자바");
		teamB.put("C", "파이썬");
		teamB.put("F", "자바");
		teamB.put("G", "안드로이드");
		teamB.put("H", "IOS");
		teamB.put("I", "안드로이드");
		for (Iterator<String> it = teamB.keySet().iterator(); it.hasNext(); ) {
			String key = it.next();
			System.out.println("이름: " + key + "\t스킬: " + teamB.get(key));
		}
		System.out.println();
		
		System.out.println("< A + B 통합 팀 >");
		Map<String, String> employee = new HashMap<>();
		employee.putAll(teamA);
		employee.putAll(teamB);
		for (Map.Entry<String, String> e : employee.entrySet()) {
			System.out.println("이름: " + e.getKey() + "\t스킬: " + e.getValue());
		}
		System.out.println();
		
		System.out.println("< 안드로이드 개발자 부서 이동 후 팀원 목록 >");
		Set<String> skill = Collections.singleton("안드로이드");		// 수정 불가능 
		employee.values().removeAll(skill);
		System.out.println(employee.keySet());
		
		System.out.println("< C, F PL이 소속돼 있는 지 확인 >");
		Map<String, String> pl = new HashMap<>();
		pl.put("C", "파이썬");
		pl.put("F", "자바");
		System.out.println( employee.entrySet().containsAll(pl.entrySet()) );
		System.out.println();
		
		System.out.println("< 팀A와 B의 팀원이 모두 같은 지 확인 >");
		System.out.println(teamA.keySet().equals(teamB.keySet()));
		System.out.println();
		
		System.out.println("< 통합팀 자바, 자바스크립트 스킬 보유 여부 >");
		System.out.println(employee.containsValue("자바"));
		System.out.println(employee.containsValue("자바스크립트"));
		
		//LinkedHashMap, TreeMap
	}

}
