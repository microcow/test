package cha18;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;
public class Ex09TreeSet {
	public static void main(String[] args) {
		
		// 바이너리 트리(이진트리)에 대한 개념 찾아볼것
		// 바이너리 트리 장점 : 데이터 탐색(검색)에 빠르고 효율적이다
		// 바이너리 트리 단점 : 데이터 추가와 삭제에 있어 비효율적이다
		// 바이너리 트리 특징 : 데이터가 자동 정렬된다. (즉, 추가된 순서와 상관 없이 크기에 따라 정렬된다)
		// ★★ 바이너리 트리 특징 : 모든 노드들이 둘 이하의 자식 노드를 자신 트리이며, 자신보다 작은 값의 노드는 좌측(head)에, 큰 값은 우측(tail)에 정렬한다
		
		// SortedSet<Integer> set = new TreeSet<>();
		// TreeSet 클래스는 Set인터페이스를 구현하고있다.
		// SortedSet은 Set인터페이스를 확장한 인터페이스이다.
		// NavigableSet은 SortedSet을 확장한 인터페이스이다.
		
				NavigableSet<Integer> tvSet = new TreeSet<>();
				// NavigableSet은 SortedSet을 확장한 인터페이스이다.
				tvSet.add(300);
				tvSet.add(700);
				tvSet.add(100);
				tvSet.add(200);
				tvSet.add(200);
				tvSet.add(900);
				tvSet.add(870);
				// TreeSet은 정렬이 필수이기에 데이터 추가(add)시 오름차순으로 정렬된다
				System.out.println(tvSet);
				/// 200을 두번 add했으나 한번밖에 출력되지 않음 (중복처리된 것인가? 출력은 한번 개수가 2개된건가)
				
				System.out.println("< TV 최저가순 >");
				for (Iterator<Integer> it = tvSet.iterator(); it.hasNext(); )
					System.out.println(it.next() + "원");
				
				System.out.println("< TV 최고가순 >");
				for (Iterator<Integer> it = tvSet.descendingIterator(); it.hasNext(); )
					// descendingIterator 메소드는 호출자를 역순(내림차순)으로 정렬 후 Iterator 타입으로 retrun
					System.out.println(it.next() + "원");
				
				System.out.println("< TV 최고가순 >");
				NavigableSet<Integer> reverseSet = tvSet.descendingSet();
				//  descendingSet 메소드는 호출자를 역정렬(오름차순이었다면 내림차순으로, 내림차순이었다면 오름차순으로) 후 Iterator 타입으로 retrun
				for (Iterator<Integer> it = reverseSet.iterator(); it.hasNext(); )
					System.out.println(it.next() + "원");
				
				int money = 300;
				
				System.out.println("< 구매 가능 TV 가격 >");
				SortedSet<Integer> availableSet = tvSet.headSet(money); 
				// TreeSet에선 작은 값을 좌측으로, 큰 값을 우측으로 정렬하는데 좌측을 head라 하고 우측을 tail이라 한다.
				// headSet 메소드는 아규먼트의 값보다 좌측(즉, 더 작은)의 값을 가져온다
				// 해당 메소드의 retrun 타입은 SortedSet인데, NavigableSet인터페이스가 나오기 전 버전에 만들어졌기 때문 (구식 메소드)(아래의 headSet을 사용하자)
				System.out.println(availableSet);
				
				System.out.println("< 구매 가능 TV 가격 >");
				NavigableSet<Integer> availableSet2 = tvSet.headSet(money, true);
				// headSet 메소드는 아규먼트의 값보다 좌측(즉, 더 작은) 값을 가져오며, 두번째 아규먼트가 true일 경우 자신(첫번째 아규먼트)도 포함하여 return한다.
				System.out.println(availableSet2);
				
				System.out.println("< 구매 불가능 TV 가격 >");
				NavigableSet<Integer> notAvailableSet = tvSet.tailSet(money, false);
				// tailSet 메소드는 아규먼트의 값보다 우측(즉, 더 큰) 값을 가져오며, 두번째 아규먼트가 false일 경우 자신(첫번째 아규먼트)은 포함하지 않고 return한다.
				System.out.println(notAvailableSet);

				System.out.println("< 200원 이상 900원 미만인 TV 검색 >");
				NavigableSet<Integer> searchSet = tvSet.subSet(200, true, 900, false);
				/* subSet메소드는 첫번째 아규먼트의 값 부터 세번째 아규먼트 값 사이의 값을 return한다.
				 * 두번째 네번째 아규먼트가 각각 첫번째 세번째 아규먼트를 포함할지 결정한다 (위 코드는 200이상(포함) 900미만(미포함)) */
				/// 자르는건가(tvSet의 값 변동) 단순히 값을 검색하여 retrun하는건가(tvSet의 값 미변동) : 자르지 않고 단순히 값을 검색하여 retrun함 (tvSet의 값 미변동)
				 
				System.out.println(searchSet);
				
				System.out.println("< 750원이거나 조금 더 비싼 TV를 검색 >");
				System.out.println(tvSet.ceiling(750));
				// ceiling메소드(천장함수)는 아규먼트의 값과 '같거나' 보다 큰 값 중 가장 가까운 값을 retrun한다 
				System.out.println("< 300원이거나 조금 더 비싼 TV를 검색 >");
				System.out.println(tvSet.ceiling(300));
				System.out.println();
				
				System.out.println("< 750원이거나 조금 더 싼 TV를 검색 >");
				System.out.println(tvSet.floor(750));
				// floor메소드(천장함수)는 아규먼트의 값과 '같거나' 보다 작은 값 중 가장 가까운 값을 retrun한다 
				System.out.println("< 300원이거나 조금 더 싼 TV를 검색 >");
				System.out.println(tvSet.floor(300));
				System.out.println();
				
				System.out.println("< 750원 보다 조금 더 비싼 TV를 검색 >");
				System.out.println(tvSet.higher(750));
				// higher 메소드는 아규먼트의 값을 포함하지 않고 보다 큰 값 중 가장 가까운 값을 retrun한다
				System.out.println("< 750원 보다 조금 더 싼 TV를 검색 >");
				System.out.println(tvSet.lower(750));
				// lower 메소드는 아규먼트의 값을 포함하지 않고 보다 작은 값 중 가장 가까운 값을 retrun한다
				System.out.println();
				
				System.out.println("< 제일 비싼 TV와 싼 TV 판매 >");
				System.out.println(tvSet.pollFirst());	
				// pollFirst는 가장 좌측(가장 작은)의 값을 추출 후 retrun하고 그 값을 '삭제'한다.
				System.out.println(tvSet.pollLast());
				// pollLas는 가장 우측(가장 큰)의 값을 추출 후 retrun하고 그 값을 '삭제'한다.
				
				System.out.println("< 870원 TV 판매>");
				System.out.println(tvSet.remove(870));
				System.out.println("< 550원 TV 재고 없음>");
				System.out.println(tvSet.remove(550));
				/* remove메소드를 사용해 아규먼트와 동일한 값을 '삭제'하며, 동일한 값이 삭제 되었을 경우 true를 return하고,
				   아규먼트와 동일한 값이 호출자에 없어 삭제 하지 못했을 경우 false를 retrun한다. */
				
				System.out.println("< 판매중인 TV >");
				for (Iterator<Integer> it = tvSet.iterator(); it.hasNext(); )
					System.out.println(it.next() + "원");
				
	}

}
