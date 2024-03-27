package cha18;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class Ex10Map {
	public static void main(String[] args) {
		
		// HashMap은 'key' 를 가지고 데이터들을 정렬을 할 수 있다.
		// HashMap은 검색 속도가 매우 빠르다 (단, 넉넉한 버킷(저장공간)을 마련해놓지 않았을 경우 저장공간을 넘어 새로운 데이터를 저장하려 할 때, 버킷을 확장(리사이징)하기에 느려질 수 있다)
		// Map과 Collection은 서로 구현이나 상속관계가 아닌 관련없는 인터페이스들이다.

		
// ★★ Map타입을 사용(데이터 추출, 삭제, 포함 여부 등)을 하기 위해선 Map타입을 Set타입으로 변경한 후 key나 value, containsAll과 같은 메소드를 통해 사용할 수 있다
// Map타입에 요소를 추가할때는 Set타입으로 변경하지 않고 put이나 putAll을 사용하면 된다. (당연히 타입이 동일해야 가능)
		
		
		
		System.out.println("< 팀A >");
		Map<String, String> teamA = new HashMap<>();
		// HashMap은 Map인터페이스를 구현하고 있기에 업캐스팅 가능하다.
		// HashMap은 key와 value으로 구성되어 있다 <key, value>
		// HashMap은 Set과 유사하게 내용 정렬이 되지 않는다
		// 내용 정렬을 위해선 LinkedHashMap이나 TreeMap을 사용해야한다. (기능 차이 찾아보기)
		
		teamA.put("A", "자바");
		// put 메소드를 활용해 데이터를 추가할 수 있다
		// 키(key)인 앞쪽 아규먼트(A)를 인덱스로 사용하고(정확히는 A의 해시코드), 값(value)인 뒤쪽 아규먼트(자바)가 저장된다
		teamA.put("B", "C");
		teamA.put("C", "파이썬");
		teamA.put("D", "자바");
		teamA.put("E", "자바");
		teamA.put("E", "DB");		
		// ★ key 값 중복 불가 (마지막에 저장된 DB만 저장됨)
		// value는 중복 가능 (키만 중복 불가)
		
		
		for (Map.Entry<String, String> e : teamA.entrySet()) { // for each로 값을 가져오는 방법
			// ★★★ entrySet메소드는 Map타입을 Set타입으로 retrun해준다(key와 value 모두 return). ★ 그 Set의 요소는 Entry타입이다
			// ★ Map으로 부터 데이터를 가져오기 위해선 해당 map을 enrtySet 메소드를 활용해 set으로 바꾸어 요소들을 Entry타입으로 바꿔주어야한다.
			// ★ Map의 key와 value를 다루기 위해서(메소드를 사용하기 위해) Entry타입으로 바꿔주는거다
			// ★ Map타입 인스턴스를 entrySet메소드로 Set타입으로 바꾼 뒤 Map.Entry<키, 값>으로 Map타입 인스턴스를 Entry객체로 바꾸어 키와 값을 갖고 있는 하나의 객체로 얻는다
			// Entry타입으로 바꾸기 위해 Set으로 변경이 선행되기에 ★정렬되지 않음 (어떤 요소가 처음으로 올 지 모름)
			/// Map.Entry 구조? Map.Entry로 생성한 인스턴스 e는 어떻게 Set타입을 저장할 수 있는지 (Map인터페이스 안에 있는 Entry인터페이스)
			//	 ㄴ> teamA.entrySet의 return타입이 Set이고 그 Set의 요소가 Entry<String, String> 타입임
			System.out.println("이름: " + e.getKey() + "\t스킬: " + e.getValue());
			// getKey 메소드 : Map의 key 값을 가져온다 (Entry 타입만 사용 가능한 메소드)
			// getValue 메소드 : Map의 value 값을 가져온다 (Entry 타입만 사용 가능한 메소드)
			/* Map.Entry 인터페이스란?
				- Map 인터페이스의 내부 인터페이스(inner interface) 이다.
				- Map에 저장되는 key-value 쌍을 다루기 위해 내부적으로 Entry 인터페이스를 정의해 놓았다.
				- Map인터페이스를 구현하는 클래스 에서는 Map.Entry 인터페이스도 함께 구현해야 한다.
				- 맵에 저장되는 엔트리의 조작을 위한 메소드가 정의되어있다.*/
			/// Map은 Collection이 아니지만 Map의 Entry 인터페이스는 Collection인가?? : no
			System.out.println("ㄴㅇㄹㄴㅇㄹ");
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
		for (Iterator<String> it = teamB.keySet().iterator(); it.hasNext(); ) { // iterator로 값을 가져오는 방법
			// ★ keySet메소드는 Map을 Set으로 반환해주는 메소드이다. (entrySet()과 달리 keySet은 Key값만 저장되어있는 Set으로 return해준다)
			String key = it.next();
			System.out.println("이름: " + key + "\t스킬: " + teamB.get(key));
			// ★ get(key값) 메소드는 해당 key값에 저장되어있는 value를 가져온다
		}
		System.out.println();
		
		System.out.println("< A + B 통합 팀 >");
		Map<String, String> employee = new HashMap<>();
		employee.putAll(teamA);
		// ★ putAll메소드는 Map에서 addAll메소드와 동일하게 동작한다
		employee.putAll(teamB);
		// ★ 앞서 저장한 teamA와 지금 저장한 teamB에서 동일한 key값이 있다면 중복처리된다(나중에 저장된 teamB의 value로 저장됨)
		for (Map.Entry<String, String> e : employee.entrySet()) {
			System.out.println("이름: " + e.getKey() + "\t스킬: " + e.getValue());
		}
		System.out.println();
		
		System.out.println("< 안드로이드 개발자 부서 이동 후 팀원 목록 >");
		Set<String> skill = Collections.singleton("안드로이드");		// 수정 불가능
		// ★ Collections.singleton 메소드는 아규먼트를 Set타입에 저장하여 return하는 메소드이며, 해당 set은 내용 수정(추가, 삭제)이 불가하다
		employee.values().removeAll(skill);
		// ★ values 메소드는 value(값)만 저장되어있는 리스트를 retrun한다.
		// ★ removeAll 메소드는 아규먼트에 저장되어있는 값을 삭제한다. (아규먼트로는 Collection타입이 와야한다.)
		// 즉, skill값인 "안드로이드"라고 저장되어 있는 데이터는 employee에서 삭제되었다 (물론, 해당 key와 value 모두 삭제된다)
		// ★ remove 메소드는 아규먼트에 저장되어있는 값을 호출자에서 삭제한다 (아규먼트로는 Object타입이 와야한다.)
		System.out.println(employee.keySet());
		// ★ keySet 메소드는 key값만 저장되어있는 리스트를 Set으로 retrun한다.
		
		System.out.println("< C, F PL이 소속돼 있는 지 확인 >");
		Map<String, String> pl = new HashMap<>();
		pl.put("C", "파이썬");
		pl.put("F", "자바");
		System.out.println(employee.entrySet().containsAll(pl.entrySet()) );
		// containsAll 메소드는 아규먼트의 값이 호출자에 있다면 true를 retrun한다. (아규먼트로는 Collection타입이 와야한다.)
		// 호출자 Map이 entrySet을 통해 Entry타입이 되었으므로 비교를 위해 아규먼트 또한 모두 Entry타입으로 바꿔주어야한다.
		/// containsAll 메소드는 아규먼트에 저장된 key와 value 모두 일치하는게 호출자에 있을 때 true를 retrun하는가. (All이니까 모두 일치)
		
		System.out.println();
		
		System.out.println("< 팀A와 B의 팀원이 모두 같은 지 확인 >");
		System.out.println(teamA.keySet().equals(teamB.keySet()));
		// equals 메소드는 호출자와 아규먼트의 문자열을 비교하는 메소드이다(여기선 teamA와 teamB의 key값이 비교된다)
		System.out.println();
		
		System.out.println("< 통합팀 자바, 자바스크립트 스킬 보유 여부 >");
		System.out.println(employee.containsValue("자바"));
		System.out.println(employee.containsValue("자바스크립트"));
		// containsAll 메소드는 아규먼트의 값이 호출자에 있다면 true를 retrun한다. (아규먼트로는 Object타입이 와야한다.)
		/// containsValue니까 Value만 일치? = yes
		
		// contain 메소드는 아규먼트의 값이 호출자에 있다면 true를 retrun한다. (단, class1.values().contain()과 같이 호출자를 명확히 해야한다)(key값을 비교할건지 value값을 비교할건지)
		
		System.out.println(employee.entrySet());
		System.out.println(employee);
		// 출력 결과는 동일하나 위에는 Set타입이고 아래는 Map타입임
		
	}

}
