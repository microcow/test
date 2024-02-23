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
		int[] lotto = new int[45];
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = i+1;
			int tmp = lotto[i];
			int n = (int)(Math.random()*45);
			lotto[i] = lotto[n];
			lotto[n] = tmp;
			//0이 안나오도록
			//중복이 안나오도록
			//6개만 출력되도록
			}
		System.out.println(Arrays.toString(lotto));
	}
		
}

	

/*
문제 1.
로또번호를 저장하는 배열에 for문을 사용하여 1~45까지의 숫자를 저장한 뒤
shuffle 알고리즘을 사용해 배열에 저장돼 있는 값들의 위치를 모두 섞고 
6개의 번호만 출력하는 코드를 작성하세요. 
*/