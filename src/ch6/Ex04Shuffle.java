package ch6;

import java.util.Arrays;

public class Ex04Shuffle {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		System.out.println(Arrays.toString(arr));
		//Arrays.toString(배열) == 배열 안의 내용을 모두 출력해준다
		for (int i=0; i<arr.length; i++) {
			int tmp = arr[i];
			int n = (int)(Math.random()*arr.length); //명시적 형변환(int) //int는 정수만 출력
			//Math.random == 0.1 ~ 0.9 사이 무작위로 난수를 반환해준다 (정확히는 0.0000000... ~ 0.9999999... 사이)
			//즉, int n = (int)(Math.random()*arr.length); 는 0~9사이 값 (0.1~0.9 * arr.length값 10)
			arr[i] = arr[n]; 
			// arr[i]와 arr[n]의 값이 같아진거지 n과i가 같아진 것이 아님
			arr[n] = tmp;
		}
		System.out.println(Arrays.toString(arr));
		
	}
}
