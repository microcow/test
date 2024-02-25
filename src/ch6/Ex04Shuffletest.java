package ch6;

import java.util.Arrays;

public class Ex04Shuffletest {
	public static void main(String[] args) {
		/*int[] arr;
		arr = new int [45];
		for (int i=0; i<arr.length; i++) {
			int n = (int)(Math.random()*45);
			int tmp = arr[i];
			arr[i] = arr[n];
			arr[n] = tmp;
		}
		System.out.printf("로또 번호는 %d", Arrays.toString(arr));
		*/
		int[] lotto = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		for (int i=0; i<lotto.length; i++) {
			
			//lotto[i] = i+1; // 이거 하나때매 중복이 나오고 안나오고.. 뭐지
			int n = (int)(Math.random()*lotto.length);
			int tmp = lotto[i];
			
			//if (lotto[i]+1 != lotto[n])
			lotto[i] = lotto[n];
			lotto[n] = tmp;
			
		
		/*int[] lotto = new int[45];
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = i+1;
			
			int n = (int)(Math.random()*lotto.length);
			int tmp = lotto[i];
			lotto[i] = lotto[n];
			lotto[n] = tmp;*/
			
			//0이 안나오도록
			//중복이 안나오도록
			//6개만 출력되도록
		}
		System.out.println(Arrays.toString(lotto));
	}
		
}
// 첫 번째 코드는 int[] arr = {10}으로 배열을 선언하고 동시에 첫 번째 인덱스에 10이라는 값을 할당합니다. 즉, 배열은 1개의 요소만 가지고 있으며 첫 번째 요소의 값은 10입니다.
// 두 번째 코드는 int[] arr = new int[10]으로 배열을 선언합니다. 이 경우 배열은 10개의 요소를 가지지만 모든 요소는 기본값인 0으로 초기화됩니다.
	

/*
문제 1.
로또번호를 저장하는 배열에 for문을 사용하여 1~45까지의 숫자를 저장한 뒤
shuffle 알고리즘을 사용해 배열에 저장돼 있는 값들의 위치를 모두 섞고 
6개의 번호만 출력하는 코드를 작성하세요. 
*/