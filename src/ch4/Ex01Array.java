package ch4;
//배열 (배열은 여러개의 변수를 한번에 관리하게함) //많은 데이터관리에 유리
public class Ex01Array {
	public static void main(String[] args) { 
		
		int[] a;
		//배열 선언은 int[] 변수;
		
		a = new int[3];
		// 3개의 int 타입 변수를 저장할 수 있는 배열을 생성 (개수만큼)
		// a에 정수를 저장하는게 아닌 메모리 주소를 저장하는 구조 (개수만큼)
		
		a[0] = 10;
		// a 메모리 주소 + 0인 메모리 주소에 저장 (즉, 배열은 0부터 시
		// []안의 숫자를 index라 부름
		a[1] = 11;
		// a 메모리 주소 + 1인 메모리 주소에 저장
		a[2] = 12;	
		
		
		System.out.printf("%d%n", a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println("배열의 길이: " + a.length);
		//length는 배열의 길이를 알려준다 a.length는 a 변수의 배열 수 
		
		System.out.println();
		
		int[] arr = new int[3];
		// 한줄에 선언과 배열 생성을 동시에도 가능
		arr[0] = 20;
		arr[1] = 21;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		// 생성되어있지만 값이 저장되지 않은 배열은 0으로 표시
		
		System.out.println();
		
		int[] arr2 = new int[] {30, 31, 32};
		// {}를 사용하여, 생성할 배열 수를 적지 않고 바로 배열에 값을 저장
		// 좌측부터 arr2[0] / arr2[1] / arr2[2]로 자동 저장
		// 가장 많이 사용하는 방법
 		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		
		System.out.println();
		
		int[] arr3 = {40, 41, 42, 43};
		// 위 방법으로 new int[]도 생략 가능
		System.out.println(arr3[0]);
		System.out.println(arr3[1]);
		System.out.println(arr3[2]);
		System.out.println(arr3[3]);
	}


}
