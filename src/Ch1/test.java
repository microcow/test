package Ch1;

public class test { // https://school.programmers.co.kr/learn/courses/30/lessons/120808?language=java
	public static void main(String[] arg) {
		Solution a = new Solution();
		int[] asd = a.solution(1,2,3,4);
		System.out.println(asd[0]);
		System.out.println(asd[1]);
	}

}
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int numer = numer1 * denom2 + numer2 * denom1;
        int denom = denom1 * denom2;

        // 최대공약수 구하기
        int gcd = gcd(numer, denom);

        numer /= gcd; //numer = numer/gcd;
        denom /= gcd;

        return new int[]{numer, denom};
    }

    // 최대공약수 계산
    public int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b; // %는 a를 b로 나눈 나머지를 구할 때 사용
            a = b;
            b = r;
            // (입력 값이 1,2,3,4일 경우) 최초 반복문 실행 시 a는 8 b는 2 
            // 두번째 반복문 실행 시 a는 2 b는 0
            // 반복문 종료
        }
        return a;
    }
  
        
}
