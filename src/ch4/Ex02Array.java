package ch4;

public class Ex02Array {
	public static void main(String[] args) {

		int arr[][] = new int[3][2];
		arr[0][0] = 70;
		arr[0][1] = 80;
		arr[1][0] = 30;
		arr[1][1] = 90;
		arr[2][0] = 100;
		arr[2][1] = 20;
		// []앞 부분이 2차원 배열 개수 (3, 세로)
		// []뒤 부분이 2차원 배열 메모리 개수 (2, 가로)

		System.out.println("학생별 국어, 영어 점수");
		System.out.print("영희: " + arr[0][0] + "," + arr[0][1] + "\n");
		System.out.print("철수: " + arr[1][0] + "," + arr[1][1] + "\n");
		System.out.print("둘리: " + arr[2][0] + "," + arr[2][1] + "\n");

		System.out.println();

		int[][] arr2 = {
		{80, 95, 90},
		{70, 95, 97}
		// 선언과 배열 생성을 동시에
		// 위와 달리 배열 개수나 메모리 개수를 따로 선언하지 않고 {}를 사용해 배열을 바로 저장
		// 많이 사용하는 방식
		};

		System.out.printf("이름 국어 영어 수학%n");
		System.out.printf("영희 %d, %d, %d%n", arr2[0][0], arr2[0][1], arr2[0][2]);
		System.out.printf("철수 %d, %d, %d%n", arr2[1][0], arr2[1][1], arr2[1][2]);
		System.out.println();

		int[][][] arr3 = {
		 {
		  {90, 95,34},
		  {80, 97}
		 },
		 {
		  {88, 75},
		  {85, 100}
		 }
		};
		//{}를 쉼표 기준으로 맨 앞[]이 3차원 인덱스
		// 즉 첫 번째 []는 반(3차원 배열), 두 번째 []는 국어 점수(2차원 배열), 세 번째 []는 영어 점수(1차원 배열)로 저장됨

		System.out.println("반별 학생별 국어, 영어 점수");
		System.out.print("1반 영희: " + arr3[0][0][0] + "," + arr3[0][0][1] + "\n");
		System.out.print("1반 철수: " + arr3[0][1][0] + "," + arr3[0][1][1] + "\n");
		System.out.print("2반 둘리: " + arr3[1][0][0] + "," + arr3[1][0][1] + "\n");
		System.out.print("2반 길동: " + arr3[1][1][0] + "," + arr3[1][1][1] + "\n");
		System.out.println("2차원 배열의 길이: " + arr3[0][0].length);
		System.out.println();

		int[][] arr4 = {
		 {1, 3, 5},
		 {7, 9},
		 {10, 11, 12, 13}
		};
		// 2차원 배열에서 1차원들의 개수를 상이하게 선언 가능

		System.out.println("2차원 배열의 길이: " + arr4.length);
		System.out.println("1차원 배열의 길이: " + arr4[0].length);
		System.out.println("1차원 배열의 길이: " + arr4[1].length);
		System.out.println("1차원 배열의 길이: " + arr4[2].length);
		// 배열이름.length를 입력하면 배열의 길이를 확인할 수 있음
		// 해당 배열이 다차원일 경우 해당 차원의 길이가 나오게됨 (ex. 2차원일 경우 2차원 배열 길이(세로)/ 3차원일 경우 4차원 배열 길이(,로 구분된 {}길이))
		// 1차원 길이를 알고 싶을 경우, arr4[0].length 또는 arr4[1].length 과 같이 입력하면 됨 (2차원 이상일 경우)
		// 2차원 길이를 알고 싶을 경우, arr3[0][0].length 과 같이 입력하면 됨 (3차원 이상일 경우) (arr3[3차원],[2차원].length로 입력됨)

		  

		}
}
