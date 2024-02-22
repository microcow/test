package ch6;

public class Ex01Fortest {
	public static void main(String[] args) {
		
		//문제 1
		int sum = 1;
		for (int t=2; t<=18; t += 2)
			System.out.printf("구구단 2단 2x%d=%d%n", sum++, t);
		
		//문제 2
		int[][] arg ={
			{30, 60, 90},
			{40, 50, 70},
			{10, 20, 80}
		};
		for (int A=arg[2][1]; A<=30; A += 2) {
			System.out.printf("영희의 수학 점수는 %d이다%n", A);
		}
			// arg에 직접 영향을 준 것이 아닌 변수 A에 영향을 주었으므로, arg[0][0]은 20을 유지한다.
		
		
		//문제 3
		
		int[] score = {30, 55, 61, 71, 60};
		for (int i=0; i<score.length; i++)
			if (score[i]>60) 
				System.out.printf("점수는 %d%n", score[i]);
				else System.out.printf("재시험%n");
			//i는 0이고 i가 score(배열)length(길이)보다 짧을때 +1씩 반복
		
		/*
		for (int i=0; i<score.length; i++) {
			if (score[i] >= 60) {
				System.out.println("점수는 " + score[i]);
			} else {
				System.out.println("재시험");
			}
		}*/
		
		////////////////////////////////////////////
		////////////////////////////////////////////아래는 중첩for문임
		
		/*
		int[][] arg3 ={
				{30, 60, 90, 35},
				{40, 50, 70, 85},
				{10, 20, 80, 25}
		};
		
		for (int i=0; i<arg3.length; i++) {
			System.out.println(i+1 + "반");
			System.out.println("---------");
			for (int j=0; j<arg3[i].length; j++) {
				if (arg3[i][j] >= 60)
					System.out.println("점수: " + arg3[i][j]);
				else
					System.out.println("재시험");
			}
			System.out.println();
		}*/
	}
}
	
/*
문제 1.
구구단 중 2단만 출력하세요.
예) 
2x1=2 2x2=4 ... 2x9=18

문제 2.
학생 3명의 중간고사 점수가 저장된 배열을 만들고 임의의 점수를 저장한 뒤
for 문을 사용하여 출력하세요.

문제 3.
중간고사 점수가 저장된 배열의 점수를 출력하되 점수가 60점 이상일 경우에만 출력하고 60점 미만일 경우 "재시험"을 출력하는 코드를 작성하세요. 
*/