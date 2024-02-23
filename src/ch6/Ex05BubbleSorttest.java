package ch6;
import java.util.Arrays;
public class Ex05BubbleSorttest {
	public static void main(String[] args) {
		int[] arr = {10, 5, 7, 25, 37, 8};
			for (int i=0; i<arr.length-1; i++)
				for (int j=i+1; j<arr.length; j++)
					if (arr[i]<arr[j]) {
						int tem = arr[i];
						arr[i]=arr[j];
						arr[j]=tem;
					}
			System.out.println(Arrays.toString(arr));		
	}

}
/*
문제 1.
{10, 5, 7, 25, 37, 8} 배열을 버블정렬을 이용하여 내림차순으로 정렬하세요. 
*/