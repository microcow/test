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
		// a 메모리 주소 + 0인 메모리 주소에 저장 (즉, 배열은 0부터 시작)
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
 		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		
		
		arr2 = new int[2];
		System.out.println(arr2[0] + "dkfmfmfm");
		// arr2가 위에서 선언된 후 메모리를 생성하였으나 해당 코드에서 메모리를 재생성 하였다
		// 재생성 시 기존 arr2에 저장되어있던 값은 초기화된다.
		
		System.out.println();
		
		int[] arr3 = {40, 41, 42, 43};
		// 위 방법으로 new int[]도 생략 가능
		System.out.println(arr3[0]);
		System.out.println(arr3[1]);
		System.out.println(arr3[2]);
		System.out.println(arr3[3]);
		
		int[] arr4;
		// 굳이 선언과 동시에 메모리를 생성하지 않아도 된다.
		//arr4[1] = 2; → 선언은 하였지만 메모리를 생성하지 않았기에 오류 발생
		//arr4 = arr3; → 선언은 하였지만 메모리를 생성하지 않았기에 오류 발생
		//arr4[1] = arr2[2]; → 선언은 하였지만 메모리를 생성하지 않았기에 오류 발생
		//즉, 선언과 동시에 메모리를 생성하지 않아도 되지만, 메모리 생성이 되지 않은 배열을 사용하려할 때 오류가 발생한다
	
		arr4 = new int [arr.length];
		// 선언을 먼저 해놓고 나중에 메모리 생성을 저장해도 된다.
		
		int[] arr5 = new int [arr3.length];
		// 다른 배열의 길이만큼 배열을 생성할 수 있다
		// 길이만 같을 뿐, arr3과 메모리 내 정보는 공유하지 않는다
	}


}
