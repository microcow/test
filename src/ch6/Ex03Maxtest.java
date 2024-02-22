package ch6;

public class Ex03Maxtest {
	public static void main(String[] args) {
		
		int[] arr = 
			{14, 57, 31, 64, 32};
		
		int max = arr[0], min = arr[0];
			for (int i=1; i<arr.length; i++) {
				if (arr[i] > max) {
					max = arr[i];
					}
				if (arr[i] < min) {
					min = arr[i];
				}
		}
		System.out.printf("최고점수는 %d%n", max);
		System.out.printf("최소점수는 %d%n", min);
		
		
		
	

	}
}
/*
문제 1.
학생 5명의 점수를 저장하는 배열을 작성 한 뒤 
최저점수와 최고점수를 찾아 출력하세요. 
*/