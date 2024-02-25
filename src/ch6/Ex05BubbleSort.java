package ch6;
import java.util.Arrays;
public class Ex05BubbleSort {
// 버블정렬 : (Shuffle 알고리즘을 응용해 배열을 정렬하는 기법)
	public static void main(String[] args) {
		int[] arr = {9, 7, 2, 20, 5};
		System.out.println(Arrays.toString(arr));
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					System.out.println(j);
					
					
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
/*	2 5 7 9 20
	1 2
	2 4
	4
	4*/