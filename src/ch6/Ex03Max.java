package ch6;

public class Ex03Max {
		public static void main(String[] args) {
			int[] arr = {3, 7, 2, 15, 9};
			
			int max = arr[0];
			for (int i=1; i<arr.length; i++) {
				if (arr[i] > max) {
					max = arr[i];
				}
			}
			
			System.out.println("최댓값은 " + max + " 입니다.");
		}
}