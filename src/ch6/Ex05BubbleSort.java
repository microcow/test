package ch6;
import java.util.Arrays;
public class Ex05BubbleSort {
	public static void main(String[] args) {
		int[] arr = {9, 7, 2, 20, 5};
		System.out.println(Arrays.toString(arr));
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
				// 버블정렬(Shuffle 알고리즘을 응용해 배열을 정렬하는 기법)
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
