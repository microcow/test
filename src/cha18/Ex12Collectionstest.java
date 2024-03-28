package cha18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex12Collectionstest {
	public static void main(String[] args) {
		List<String> list2 = new ArrayList<>();
		Collections.addAll(list2, "A", "D", "B", "C", "E");
		
		// 문제1.
		System.out.println(Collections.binarySearch(list2, "B"));
		Collections.sort(list2);
		System.out.println(list2);
		System.out.println(Collections.binarySearch(list2, "B"));
		Collections.reverse(list2);
		System.out.println(list2);
			
		// 문제2.
		List<String> list3 = new ArrayList<>();
		list3.add("F");
		Collections.addAll(list3, "B");
		
		// 문제3.
	}
}
/*
문제 1.
addAll 을 이용해 리스트에 임의의 값들을 입력 후
binarySearch 를 이용해 검색하세요.
오름차순과 내림차순을 적용 후 출력하세요.

문제 2.
Arrays.asList를 이용해 리스트 생성 후 해당 리스트에 임의의 값을 추가하세요.

문제 3.
Arrays.equals 와 Arrays.deepEquals 를 사용하여 1차원 배열과 2차원 배열의 값을 비교하는 코드를 작성하세요. 검색해서 풀어보기
*/